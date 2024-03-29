package com.raulfm.drinkit.screens.drink_info;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.raulfm.drinkit.R;
import com.raulfm.drinkit.api_request.RetrofitAPI;
import com.raulfm.drinkit.constants.ColorConstant;
import com.raulfm.drinkit.model.Drink;
import com.raulfm.drinkit.model.Drinks;
import com.raulfm.drinkit.util.Erro;
import com.raulfm.drinkit.util.StatusBar;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DrinkInfoActivity extends AppCompatActivity {
    private Drink drink;
    private Long drinkId;
    private Boolean favoriteState;
    private FloatingActionButton fabFavorite;
    private ImageView drinkThumb;
    private TextView strDrinkName;
    private TextView strIngredients;
    private TextView strInstructions;
    private TextView strGlass;
    private TextView errorMsg;
    private TextView strAlcoholic;
    private ProgressBar apiLoadProgress;
    private ScrollView contentScrollView;
    private final DatabaseReference userDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
    private String googleId;
    private String googleName;

    private void carregaDrink() {
        RetrofitAPI retrofit = new RetrofitAPI();
        Call<Drinks> call = retrofit.retrofitController.getDrinkById(drinkId);
        call.enqueue(new Callback<Drinks>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(Call<Drinks> call, Response<Drinks> response) {
                if (!response.isSuccessful())
                    Erro.drinkNotFound(getApplicationContext(), errorMsg, apiLoadProgress);
                else {
                    Drinks drinks = response.body();
                    if (drinks != null)
                        drink = drinks.primeiroDrink();
                    atualizaTela();
                }
            }

            @Override
            public void onFailure(Call<Drinks> call, Throwable t) {
                Erro.drinkNotFound(getApplicationContext(), errorMsg, apiLoadProgress);

            }
        });
    }

    private void setContentVisible() {
        apiLoadProgress.setVisibility(View.GONE);
        contentScrollView.setVisibility(View.VISIBLE);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void atualizaTela() {
        Picasso.get()
                .load(drink.getstrDrinkThumb())
                .transform(new CircleTransformImage())
                .into(drinkThumb);

        strDrinkName.setText(drink.getstrDrink());

        StringBuilder ingredientListBuilder = new StringBuilder();

        int size = drink.getAllIngredients().size();
        for (int i = 0; i < size - 1; i++)
            ingredientListBuilder.append("<font color='" + ColorConstant.PRIMARY_COLOR + "'> • </font><font color='" + ColorConstant.TEXT_COLOR + "'>").append(drink.getAllIngredients().get(i)).append(";</font><br/>");
        ingredientListBuilder.append("<font color='" + ColorConstant.PRIMARY_COLOR + "'> • </font><font color='" + ColorConstant.TEXT_COLOR + "'>").append(drink.getAllIngredients().get(size - 1)).append(";</font>");

        String ingredientList = ingredientListBuilder.toString();

        strIngredients.setText(Html.fromHtml(ingredientList), TextView.BufferType.SPANNABLE);

        strInstructions.setText(drink.getstrInstructions());
        strGlass.setText(drink.getstrGlass());
        strAlcoholic.setText(drink.getstrAlcoholic());
        setContentVisible();
    }

    private void setStar() {
        if (favoriteState)
            fabFavorite.setImageResource(R.drawable.ic_star);
        else
            fabFavorite.setImageResource(R.drawable.ic_star_border);
    }

    private void initFavorito() {
        userDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String path = googleId + "/favorites/" + drinkId;
                favoriteState = dataSnapshot.hasChild(path);
                setStar();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Erro.databaseError(getApplicationContext());
            }
        });
    }

    private void toggleFavorito() {
        userDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String path = googleId + "/favorites/" + drink.getidDrink();
                favoriteState = !(dataSnapshot.hasChild(path));
                setStar();
                if (favoriteState){
                    userDatabaseReference.child(googleId)
                            .child("name")
                            .setValue(googleName);

                    userDatabaseReference.child(googleId)
                            .child("favorites")
                            .child(drink.getidDrink()).child("name").setValue(drink.getstrDrink());

                    userDatabaseReference.child(googleId)
                            .child("favorites")
                            .child(drink.getidDrink()).child("id").setValue(drink.getidDrink());
                }
                else
                    userDatabaseReference.child(googleId).child("favorites").child(drink.getidDrink()).removeValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Erro.databaseError(getApplicationContext());
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_info);
        Intent intent = getIntent();
        drinkId = Long.parseLong(Objects.requireNonNull(intent.getStringExtra("drinkId")));
        googleId = Objects.requireNonNull(intent.getStringExtra("GOOGLE_ID"));
        googleName = Objects.requireNonNull(intent.getStringExtra("GOOGLE_NAME"));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            StatusBar.SetColor(getWindow());

        errorMsg = findViewById(R.id.errorMsgInfo);
        apiLoadProgress = findViewById(R.id.apiLoadProgress);
        contentScrollView = findViewById(R.id.contentScrollView);
        drinkThumb = findViewById(R.id.drinkThumb);
        strDrinkName = findViewById(R.id.strDrinkName);
        strIngredients = findViewById(R.id.strIngredients);
        strInstructions = findViewById(R.id.strInstructions);
        strGlass = findViewById(R.id.strGlass);
        strAlcoholic = findViewById(R.id.strAlcoholic);

        fabFavorite = findViewById(R.id.fabFavorito);
        initFavorito();
        fabFavorite.setOnClickListener(view -> toggleFavorito());

        carregaDrink();
    }
}

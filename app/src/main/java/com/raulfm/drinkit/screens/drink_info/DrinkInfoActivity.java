package com.raulfm.drinkit.screens.drink_info;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.raulfm.drinkit.R;
import com.raulfm.drinkit.api_request.RetrofitAPI;
import com.raulfm.drinkit.constants.ColorConstant;
import com.raulfm.drinkit.model.Drink;
import com.raulfm.drinkit.model.Drinks;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DrinkInfoActivity extends AppCompatActivity {
    private Long drinkId;
    private Drink drink;
    private boolean favoritoState;
    private FloatingActionButton fabFavorito;
    private ImageView drinkThumb;
    private TextView strDrinkName;
    private TextView strIngredients;
    private TextView strInstructions;
    private TextView strGlass;
    private TextView errorMsg;
    private TextView strAlcoholic;
    private ProgressBar apiLoadProgress;
    private ScrollView contentScrollView;

    public void mostrarErro() {
        Log.d("erro", "Não foi possível carregar o drink");
        errorMsg.setVisibility(View.VISIBLE);
        apiLoadProgress.setVisibility(View.GONE);
    }

    public void carregaDrink() {
        RetrofitAPI retrofit = new RetrofitAPI();
        Call<Drinks> call = retrofit.retrofitController.getDrinkById(drinkId);

        call.enqueue(new Callback<Drinks>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(Call<Drinks> call, Response<Drinks> response) {
                if (!response.isSuccessful())
                    mostrarErro();
                else {
                    Drinks drinks = response.body();
                    drink = drinks.primeiroDrink();
                    atualizaTela();
                }
            }

            @Override
            public void onFailure(Call<Drinks> call, Throwable t) {
                mostrarErro();
            }
        });
    }

    public void setContentVisible() {
        apiLoadProgress.setVisibility(View.GONE);
        contentScrollView.setVisibility(View.VISIBLE);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void atualizaTela() {
        Picasso.get()
                .load(drink.getstrDrinkThumb())
                .transform(new CircleTransformImage())
                .into(drinkThumb);

        strDrinkName.setText(drink.getstrDrink());

        StringBuilder ingredientListBuilder = new StringBuilder();

        int size = drink.getAllIngredients().size();
        for (int i = 0; i < size - 1; i++)
            ingredientListBuilder.append("<font color='" + ColorConstant.PRIMARY_COLOR + "'> • </font><font color='" + ColorConstant.TEXT_COLOR + "'>" + drink.getAllIngredients().get(i) + ";</font><br/>");
        ingredientListBuilder.append("<font color='" + ColorConstant.PRIMARY_COLOR + "'> • </font><font color='" + ColorConstant.TEXT_COLOR+ "'>" + drink.getAllIngredients().get(size - 1) + ";</font>");

        String ingredientList = ingredientListBuilder.toString();

        strIngredients.setText(Html.fromHtml(ingredientList), TextView.BufferType.SPANNABLE);

        strInstructions.setText(drink.getstrInstructions());
        strGlass.setText(drink.getstrGlass());
        strAlcoholic.setText(drink.getstrAlcoholic());
        setContentVisible();
    }

    public void initFavorito(){
        favoritoState = false;
        if(favoritoState)
            fabFavorito.setImageResource(R.drawable.ic_star);
        else
            fabFavorito.setImageResource(R.drawable.ic_star_border);
    }

    public void toggleFavorito(){
        favoritoState = !favoritoState;
        if(favoritoState)
            fabFavorito.setImageResource(R.drawable.ic_star);
        else
            fabFavorito.setImageResource(R.drawable.ic_star_border);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setStatusBarColor(){
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor(ColorConstant.PRIMARY_DARK_COLOR));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_info);
        Intent intent = getIntent();
        drinkId = Long.parseLong(intent.getStringExtra("drinkId"));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            setStatusBarColor();

        apiLoadProgress = findViewById(R.id.apiLoadProgress);
        contentScrollView = findViewById(R.id.contentScrollView);
        drinkThumb = findViewById(R.id.drinkThumb);
        strDrinkName = findViewById(R.id.strDrinkName);
        strIngredients = findViewById(R.id.strIngredients);
        strInstructions = findViewById(R.id.strInstructions);
        strGlass = findViewById(R.id.strGlass);
        strAlcoholic = findViewById(R.id.strAlcoholic);

        fabFavorito = findViewById(R.id.fabFavorito);
        initFavorito();
        fabFavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleFavorito();
            }
        });

        carregaDrink();
    }
}

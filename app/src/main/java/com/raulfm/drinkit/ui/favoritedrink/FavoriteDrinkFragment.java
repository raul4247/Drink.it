package com.raulfm.drinkit.ui.favoritedrink;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.raulfm.drinkit.R;
import com.raulfm.drinkit.adapters.DrinksListAdapter;
import com.raulfm.drinkit.api_request.RetrofitAPI;
import com.raulfm.drinkit.model.Drink;
import com.raulfm.drinkit.model.DrinkReference;
import com.raulfm.drinkit.model.Drinks;
import com.raulfm.drinkit.util.Erro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FavoriteDrinkFragment extends Fragment {
    private Drinks drinks;
    private ProgressBar FavoriteLoadProgress;
    private TextView FavoriteErrorMsg;
    private View root;
    private DatabaseReference userDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
    private DatabaseReference favoriteReference;
    private RecyclerView recyclerView;
    private DrinksListAdapter adapter;
    private String googleId;

    public void setContentVisible() {
        FavoriteLoadProgress.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    public void carregaFavoritos() {
        favoriteReference = userDatabaseReference.child(googleId).child("favorites");
        favoriteReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                    List<DataSnapshot> snapshot = new ArrayList<>();
                    for (Iterator<DataSnapshot> it = singleSnapshot.getChildren().iterator(); it.hasNext(); )
                        snapshot.add(it.next());

                    String id = (String) snapshot.get(0).getValue();
                    String name = (String) snapshot.get(1).getValue();
                    Drink d = new Drink(id, name);
                    drinks.getDrinks().add(d);
                }
                if(drinks.getDrinks().size() > 0)
                    initRecyclerView();
                else
                    Erro.noDrinks(getContext(), FavoriteErrorMsg, FavoriteLoadProgress);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Erro.databaseError(getContext());
            }
        });
    }

    private void initRecyclerView() {
        recyclerView = root.findViewById(R.id.recyclerViewFavorites);
        adapter = new DrinksListAdapter(drinks, googleId, this.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }

    private void findViews() {
        FavoriteLoadProgress = root.findViewById(R.id.FavoriteLoadProgress);
        FavoriteErrorMsg = root.findViewById(R.id.FavoriteErrorMsg);
        recyclerView = root.findViewById(R.id.recyclerViewFavorites);
    }

    @Override
    public void onResume() {
        super.onResume();
        carregaFavoritos();
        setContentVisible();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_favorite_drink, container, false);

        Bundle args = this.getArguments();
        if (args != null)
            googleId = args.getString("GOOGLE_ID");

        this.drinks = new Drinks();

        findViews();
        return root;
    }
}
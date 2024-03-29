package com.raulfm.drinkit.ui.favoritedrink;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
import com.raulfm.drinkit.model.Drink;
import com.raulfm.drinkit.model.Drinks;
import com.raulfm.drinkit.util.Erro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


public class FavoriteDrinkFragment extends Fragment {
    private Drinks drinks;
    private ProgressBar FavoriteLoadProgress;
    private TextView FavoriteErrorMsg;
    private View root;
    private final DatabaseReference userDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
    private RecyclerView recyclerView;
    private String googleId;
    private String googleName;

    private void setContentVisible() {
        FavoriteLoadProgress.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    private void carregaFavoritos() {
        DatabaseReference favoriteReference = userDatabaseReference.child(googleId).child("favorites");
        favoriteReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                    List<DataSnapshot> snapshot = new ArrayList<>();
                    for (DataSnapshot value : singleSnapshot.getChildren()) snapshot.add(value);

                    String id = (String) snapshot.get(0).getValue();
                    String name = (String) snapshot.get(1).getValue();
                    Drink d = new Drink(id, name);
                    drinks.getDrinks().add(d);
                }
                if(drinks.getDrinks().size() > 0)
                    initRecyclerView();
                else
                    Erro.noDrinks(Objects.requireNonNull(getContext()), FavoriteErrorMsg, FavoriteLoadProgress);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Erro.databaseError(Objects.requireNonNull(getContext()));
            }
        });
    }

    private void initRecyclerView() {
        recyclerView = root.findViewById(R.id.recyclerViewFavorites);
        DrinksListAdapter adapter = new DrinksListAdapter(drinks, googleId, googleName, this.getContext());
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
        drinks.getDrinks().clear();
        carregaFavoritos();
        setContentVisible();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_favorite_drink, container, false);

        Bundle args = this.getArguments();
        if (args != null){
            googleId = args.getString("GOOGLE_ID");
            googleName = args.getString("GOOGLE_NAME");
        }

        this.drinks = new Drinks();

        findViews();
        return root;
    }
}
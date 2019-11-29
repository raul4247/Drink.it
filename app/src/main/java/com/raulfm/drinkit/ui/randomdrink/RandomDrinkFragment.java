package com.raulfm.drinkit.ui.randomdrink;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.raulfm.drinkit.R;
import com.raulfm.drinkit.adapters.DrinksThumbsAdapter;
import com.raulfm.drinkit.api_request.RetrofitAPI;
import com.raulfm.drinkit.model.Drinks;
import com.raulfm.drinkit.util.Erro;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RandomDrinkFragment extends Fragment {
    private Drinks drinks;
    private ProgressBar randomApiLoadProgress;
    private TextView randomErrorMsg;
    private RecyclerView recyclerView;
    private DrinksThumbsAdapter adapter;
    private View root;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView randomTitle;
    private String googleId;
    private String googleName;

    public void setContentVisible() {
        randomApiLoadProgress.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    public void carregaAleatorios() {
        RetrofitAPI retrofit = new RetrofitAPI();
        Call<Drinks> call;
        for (int i = 0; i < 5; i++) {
            call = retrofit.retrofitController.getRandomDrink();
            call.enqueue(new Callback<Drinks>() {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void onResponse(Call<Drinks> call, Response<Drinks> response) {
                    if (!response.isSuccessful())
                        Erro.drinksNotLoaded(root.getContext(), randomErrorMsg, randomTitle, randomApiLoadProgress);
                    else {
                        Drinks d = response.body();
                        if (d != null)
                            drinks.getDrinks().add(d.primeiroDrink());
                        adapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Call<Drinks> call, Throwable t) {
                    Erro.drinksNotLoaded(root.getContext(), randomErrorMsg, randomTitle, randomApiLoadProgress);
                }
            });
        }
        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView = root.findViewById(R.id.recyclerView);
        adapter = new DrinksThumbsAdapter(drinks, googleId, googleName, this.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_random_drink, container, false);

        Bundle args = this.getArguments();
        if(args != null){
            googleId = args.getString("GOOGLE_ID");
            googleName = args.getString("GOOGLE_NAME");
        }

        this.drinks = new Drinks();
        randomApiLoadProgress = root.findViewById(R.id.RandomApiLoadProgress);
        randomErrorMsg = root.findViewById(R.id.RandomErrorMsg);
        recyclerView = root.findViewById(R.id.recyclerView);
        randomTitle = root.findViewById(R.id.randomTitle);
        swipeRefreshLayout = root.findViewById(R.id.swipe_cotainer);
        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            drinks.getDrinks().clear();
            carregaAleatorios();
        });
        carregaAleatorios();
        setContentVisible();
        swipeRefreshLayout.setOnRefreshListener(
                () -> {
                    Log.i("Swipe", "onRefresh called from SwipeRefreshLayout");
                    drinks.getDrinks().clear();
                    carregaAleatorios();
                    swipeRefreshLayout.setRefreshing(false);
                }
        );
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimaryDark));
        return root;
    }
}
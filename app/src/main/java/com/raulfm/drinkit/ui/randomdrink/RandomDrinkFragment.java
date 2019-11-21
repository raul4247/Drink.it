package com.raulfm.drinkit.ui.randomdrink;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.raulfm.drinkit.R;
import com.raulfm.drinkit.adapters.RecyclerViewAdapter;
import com.raulfm.drinkit.api_request.RetrofitAPI;
import com.raulfm.drinkit.model.Drink;
import com.raulfm.drinkit.model.Drinks;
import com.raulfm.drinkit.screens.drink_info.CircleTransformImage;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RandomDrinkFragment extends Fragment {
    private Drinks drinks;
    private ProgressBar randomApiLoadProgress;
    private TextView randomErrorMsg;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private View root;

    public void setContentVisible() {
        randomApiLoadProgress.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    public void mostrarErro() {
        Log.d("erro", "Não foi possível carregar o drink");
        randomErrorMsg.setVisibility(View.VISIBLE);
        randomApiLoadProgress.setVisibility(View.GONE);
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
                    if (!response.isSuccessful()) {
                        mostrarErro();
                    } else {
                        Drinks d = response.body();
                        if (d != null)
                            drinks.getDrinks().add(d.primeiroDrink());
                        Log.d("asd", d.primeiroDrink().toString());
                        adapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Call<Drinks> call, Throwable t) {
                    mostrarErro();
                }
            });
        }
        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView = root.findViewById(R.id.recyclerView);
        adapter = new RecyclerViewAdapter(drinks, this.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_random_drink, container, false);

        this.drinks = new Drinks();
        randomApiLoadProgress = root.findViewById(R.id.RandomApiLoadProgress);
        randomErrorMsg = root.findViewById(R.id.RandomErrorMsg);
        recyclerView = root.findViewById(R.id.recyclerView);

        carregaAleatorios();
        setContentVisible();
        return root;
    }
}
package com.raulfm.drinkit.ui.searchdrink;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.raulfm.drinkit.R;
import com.raulfm.drinkit.adapters.DrinksListAdapter;
import com.raulfm.drinkit.api_request.RetrofitAPI;
import com.raulfm.drinkit.model.Drinks;
import com.raulfm.drinkit.util.Erro;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchDrinkFragment extends Fragment {
    private View root;
    private EditText edtsearch;
    private Button btnbuscar;
    private TextView errorMsg;
    private ProgressBar apiLoadProgress;
    private String googleId;
    private String googleName;

    private void buildList(Drinks drinks){
        RecyclerView recyclerView = root.findViewById(R.id.recyclerViewSearch);
        DrinksListAdapter adapter = new DrinksListAdapter(drinks, googleId, googleName, this.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        apiLoadProgress.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    private void initViews(){
        edtsearch = root.findViewById(R.id.edt_search);
        errorMsg = root.findViewById(R.id.errorMsg);
        apiLoadProgress = root.findViewById(R.id.apiLoadProgress);
        apiLoadProgress.setVisibility(View.GONE);
        btnbuscar = root.findViewById(R.id.btn_buscar);
    }

    private boolean isNameValid(String name){
        if (name == null || name.equals("")) {
            Erro.drinkNotFound(root.getContext(), errorMsg, apiLoadProgress);
            return false;
        }
        return true;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_search_drink, container, false);

        Bundle args = this.getArguments();
        if(args != null){
            googleId = args.getString("GOOGLE_ID");
            googleName = args.getString("GOOGLE_NAME");
        }

        initViews();

        btnbuscar.setOnClickListener(v -> {
            apiLoadProgress.setVisibility(View.VISIBLE);
            errorMsg.setVisibility(View.GONE);
            String drinkSearchName = edtsearch.getText().toString();
            if(isNameValid(drinkSearchName)){
                RetrofitAPI retrofit = new RetrofitAPI();
                Call<Drinks> call = retrofit.retrofitController.getDrinkByName(drinkSearchName);

                call.enqueue(new Callback<Drinks>() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onResponse(Call<Drinks> call, Response<Drinks> response) {
                        if (!response.isSuccessful())
                            Erro.drinkNotFound(root.getContext(), errorMsg, apiLoadProgress);
                        else {
                            Drinks drinks = response.body();
                            if (drinks != null) {
                                if (drinks.getDrinks() == null)
                                    Erro.drinkNotFound(root.getContext(), errorMsg, apiLoadProgress);
                                else{
                                    Drinks d = response.body();
                                    if (d != null)
                                        drinks.setDrinks(d.getDrinks());
                                    buildList(d);
                                }
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<Drinks> call, Throwable t) {
                        Erro.drinkNotFound(root.getContext(), errorMsg, apiLoadProgress);
                    }
                });
            }
        });
        return root;
    }
}
package com.raulfm.drinkit.ui.searchdrink;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.raulfm.drinkit.R;
import com.raulfm.drinkit.adapters.DrinksListAdapter;
import com.raulfm.drinkit.adapters.DrinksThumbsAdapter;
import com.raulfm.drinkit.api_request.RetrofitAPI;
import com.raulfm.drinkit.model.Drink;
import com.raulfm.drinkit.model.Drinks;
import com.raulfm.drinkit.screens.drink_info.DrinkInfoActivity;
import com.raulfm.drinkit.util.Erro;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchDrinkFragment extends Fragment {
    private View root;
    private Drinks drinks;
    private EditText edtsearch;
    private ListView lvselect;
    private Button btnbuscar;
    private RecyclerView recyclerView;
    private DrinksListAdapter adapter;
    private TextView errorMsg;
    private ProgressBar apiLoadProgress;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public ArrayList<String> atualizaTela(Drinks drinks) {
        ArrayList<String> idList = new ArrayList<>();
        ArrayList<String> stringList = new ArrayList<>();
        ArrayAdapter drinksAdapter;
        if (drinks.getDrinks() != null) {
            for (Drink drink : drinks.getDrinks()) {
                stringList.add(drink.getstrDrink());
                idList.add(drink.getidDrink());
            }
        }

        drinksAdapter = new ArrayAdapter(root.getContext(), android.R.layout.simple_list_item_1, stringList);

        lvselect.setAdapter(drinksAdapter);

        apiLoadProgress.setVisibility(View.GONE);
        errorMsg.setVisibility(View.GONE);
        return idList;
    }

    public void buildList(Drinks drinks){
        recyclerView = root.findViewById(R.id.recyclerViewSearch);
        adapter = new DrinksListAdapter(drinks, this.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        apiLoadProgress.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    private void initViews(){
        edtsearch = root.findViewById(R.id.edt_search);
//        lvselect = root.findViewById(R.id.lv_select);
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
        initViews();
        this.drinks = new Drinks();
        
        final ArrayList<String>[] idList = new ArrayList[]{new ArrayList<>()};

        btnbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiLoadProgress.setVisibility(View.VISIBLE);

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
                                if (drinks.getDrinks() == null)
                                    Erro.drinkNotFound(root.getContext(), errorMsg, apiLoadProgress);
                                else{
                                    Drinks d = response.body();
                                    if (d != null)
                                        drinks.setDrinks(d.getDrinks());
                                    buildList(d);
                                }
//                                    idList[0] = atualizaTela(drinks, root);
                            }
                        }
                        @Override
                        public void onFailure(Call<Drinks> call, Throwable t) {
                            Erro.drinkNotFound(root.getContext(), errorMsg, apiLoadProgress);
                        }
                    });
                }
            }
        });
        /*
        lvselect.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(root.getContext(), DrinkInfoActivity.class);
                intent.putExtra("drinkId", idList[0].get(i));
                startActivity(intent);
            }
        });
    */
        return root;
    }
}
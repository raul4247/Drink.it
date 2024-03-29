package com.raulfm.drinkit.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.raulfm.drinkit.R;
import com.raulfm.drinkit.model.Drinks;
import com.raulfm.drinkit.screens.drink_info.DrinkInfoActivity;

public class DrinksListAdapter extends RecyclerView.Adapter<DrinksListAdapter.ViewHolder> {
    private final Drinks mDrinks;
    private final String googleId;
    private final String googleName;
    private final Context mContext;

    public DrinksListAdapter(Drinks mDrinks, String googleId, String googleName, Context mContext) {
        this.mDrinks = mDrinks;
        this.googleId = googleId;
        this.googleName = googleName;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_drink, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(mDrinks.getDrinks().get(position).getstrDrink());
        holder.name.setOnClickListener(v -> {
            Intent myIntent = new Intent(mContext, DrinkInfoActivity.class);
            myIntent.putExtra("drinkId", mDrinks.getDrinks().get(position).getidDrink());
            myIntent.putExtra("GOOGLE_ID", googleId);
            myIntent.putExtra("GOOGLE_NAME", googleName);
            mContext.startActivity(myIntent);
        });
    }

    @Override
    public int getItemCount() {
        return mDrinks.getSize();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView name;
        final LinearLayout parentLayout;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}

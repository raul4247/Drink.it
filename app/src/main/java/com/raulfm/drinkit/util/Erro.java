package com.raulfm.drinkit.util;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.raulfm.drinkit.R;

public final class Erro {
    private Erro() {
    }

    public static void drinkNotFound(Context context, TextView msg, ProgressBar progressBar) {
        Log.d("erro", context.getString(R.string.drink_not_found_error_msg));
        msg.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    public static void drinksNotLoaded(Context context, TextView msg, TextView title, ProgressBar progressBar) {
        Log.d("erro", context.getString(R.string.drinks_not_loaded_error_msg));
        title.setVisibility(View.GONE);
        msg.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    public static void databaseError(Context context) {
        Log.d("erro", context.getString(R.string.database_error_msg));
    }

    public static void noDrinks(Context context, TextView msg, ProgressBar progressBar) {
        Log.d("erro", context.getString(R.string.no_drinks));
        msg.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }
}

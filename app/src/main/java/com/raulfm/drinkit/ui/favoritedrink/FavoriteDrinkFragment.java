package com.raulfm.drinkit.ui.favoritedrink;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.raulfm.drinkit.R;

public class FavoriteDrinkFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_favorite_drink, container, false);

        // FAVORITE DRINK SCREEN CODE HERE

        return root;
    }
}
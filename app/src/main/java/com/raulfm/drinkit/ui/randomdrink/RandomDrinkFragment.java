package com.raulfm.drinkit.ui.randomdrink;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.raulfm.drinkit.R;

public class RandomDrinkFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_random_drink, container, false);

        // RANDOM DRINK SCREEN CODE HERE

        return root;
    }
}
package com.raulfm.drinkit.ui.drinkinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.raulfm.drinkit.R;

public class DrinkInfoFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_drink_info, container, false);

        // DRINK INFO SCREEN CODE HERE

        return root;
    }
}
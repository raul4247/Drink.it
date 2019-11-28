package com.raulfm.drinkit;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.navigation.NavigationView;
import com.raulfm.drinkit.screens.drink_info.CircleTransformImage;
import com.raulfm.drinkit.ui.favoritedrink.FavoriteDrinkFragment;
import com.raulfm.drinkit.ui.randomdrink.RandomDrinkFragment;
import com.raulfm.drinkit.ui.searchdrink.SearchDrinkFragment;
import com.squareup.picasso.Picasso;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    private NavigationView navigationView;
    private GoogleSignInAccount googleSignInAccount;
    private DrawerLayout drawer;
    private Bundle args;

    private void loadProfile() {
        googleSignInAccount = getIntent().getParcelableExtra("GOOGLE_ACCOUNT");

        View hView = navigationView.getHeaderView(0);
        TextView profileName = hView.findViewById(R.id.profileName);
        TextView profileEmail = hView.findViewById(R.id.profileEmail);
        ImageView profileImage = hView.findViewById(R.id.profileImage);

        if (googleSignInAccount != null) {
            if (googleSignInAccount.getPhotoUrl() != null)
                Picasso.get()
                        .load(googleSignInAccount.getPhotoUrl())
                        .transform(new CircleTransformImage())
                        .into(profileImage);
            profileName.setText(googleSignInAccount.getDisplayName());
            profileEmail.setText(googleSignInAccount.getEmail());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        loadProfile();

        args = new Bundle();
        args.putString("GOOGLE_ID", googleSignInAccount.getId());

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_random, R.id.nav_favorite, R.id.nav_search)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
        setDefaultFragment();
    }

    private void setDefaultFragment(){
        Fragment fragment = null;
        Class fragmentClass;
        fragmentClass = RandomDrinkFragment.class;
        try {
            fragment = ((Fragment) fragmentClass.newInstance());
            fragment.setArguments(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragment != null)
            fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment).commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void selectDrawerItem(MenuItem menuItem) {
        Fragment fragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId()) {
            case R.id.nav_random:
                fragmentClass = RandomDrinkFragment.class;
                break;
            case R.id.nav_favorite:
                fragmentClass = FavoriteDrinkFragment.class;
                break;
            case R.id.nav_search:
                fragmentClass = SearchDrinkFragment.class;
                break;
            default:
                fragmentClass = RandomDrinkFragment.class;
        }

        try {
            fragment = ((Fragment) fragmentClass.newInstance());
            fragment.setArguments(args);
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragment != null)
            fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment).commit();

        FrameLayout nav_host_fragment = findViewById(R.id.nav_host_fragment);
        nav_host_fragment.removeAllViews();

        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        drawer.closeDrawers();
    }

}

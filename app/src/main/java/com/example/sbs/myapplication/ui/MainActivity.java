package com.example.sbs.myapplication.ui;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.sbs.myapplication.R;
import com.example.sbs.myapplication.databinding.ActivityMainBinding;
import com.example.sbs.myapplication.databinding.NavHeaderMainBinding;
import com.example.sbs.myapplication.util.Util;
import com.google.android.material.snackbar.Snackbar;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.setLifecycleOwner(this);

        MainViewModel vm = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setMainVm(vm);
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        binding.appBarMain.fab.setOnClickListener(view -> {
            Util.getNavController().navigate(R.id.nav_article_write);
        });

        /*
        binding.appBarMain.fab.setOnClickListener(view -> Snackbar.make(view, "로그인 후 이용해주세요.", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
         */

        NavHeaderMainBinding navHeaderMainBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.nav_header_main, binding.navView, false);
        navHeaderMainBinding.setLifecycleOwner(this);
        navHeaderMainBinding.setMainVm(vm);
        binding.navView.addHeaderView(navHeaderMainBinding.getRoot());

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home_main, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_article_write)
                .setDrawerLayout(binding.drawerLayout)
                .build();
        NavController navController = Util.getNavController();
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
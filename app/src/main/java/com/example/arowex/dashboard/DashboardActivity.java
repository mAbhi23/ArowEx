package com.example.arowex.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.example.arowex.R;
import com.example.arowex.dashboard.ui.BalanceFragment;
import com.example.arowex.dashboard.ui.HomeFragment;
import com.example.arowex.dashboard.ui.MarketFragment;
import com.example.arowex.dashboard.ui.TradeFragment;
import com.example.arowex.login.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fragmentManager;
    private Fragment homeFragment, marketFragment, tradeFragment, balanceFragment, activeFragment;
    private BottomNavigationView bottomNavigationView;
    private boolean doubleBackToExitPressedOnce = false;
    private DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        inUi();
      /*  findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "dasdas", Toast.LENGTH_SHORT).show();
                setTheme(R.style.LightTheme);
                recreate();
            }
        });
*/
    }

    private void inUi() {
        mDrawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        addFragments();
        settingNavgationSlider();

    }

    private void settingNavgationSlider() {
        LinearLayout userLoginNav = (LinearLayout)findViewById(R.id.userLoginNav);
        userLoginNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, MainActivity.class));
                closeDrawer();
            }
        });
    }


    private void addFragments() {
        fragmentManager = getSupportFragmentManager();
        homeFragment = new HomeFragment();
        marketFragment = new MarketFragment();
        tradeFragment = new TradeFragment();
        balanceFragment = new BalanceFragment();
        activeFragment = homeFragment;

        try {
            fragmentManager.beginTransaction().add(R.id.frame_container, homeFragment, "home").commitAllowingStateLoss();
            fragmentManager.beginTransaction().add(R.id.frame_container, marketFragment, "market").hide(marketFragment).commitAllowingStateLoss();
            fragmentManager.beginTransaction().add(R.id.frame_container, tradeFragment, "trade").hide(tradeFragment).commitAllowingStateLoss();
            fragmentManager.beginTransaction().add(R.id.frame_container, balanceFragment, "balance").hide(balanceFragment).commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                if (!(activeFragment instanceof HomeFragment)) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.hide(activeFragment).show(homeFragment).commit();
                    activeFragment = homeFragment;
                }

                return true;

            case R.id.navigation_market:
                if (!(activeFragment instanceof MarketFragment)) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.hide(activeFragment).show(marketFragment).commit();
                    activeFragment = marketFragment;
                }
                return true;

            case R.id.navigation_trade:
                if (!(activeFragment instanceof TradeFragment)) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.hide(activeFragment).show(tradeFragment).commit();
                    activeFragment = tradeFragment;
                }
                return true;

            case R.id.navigation_balance:
                if (!(activeFragment instanceof BalanceFragment)) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.hide(activeFragment).show(balanceFragment).commit();
                    activeFragment = balanceFragment;
                }
                return true;

        }
        return false;
    }

    @Override
    public void onBackPressed() {
        if (activeFragment == null || activeFragment instanceof HomeFragment) {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Tap again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 3000);
        } else {
            bottomNavigationView.getMenu().getItem(0).setChecked(true);
            fragmentManager.beginTransaction().hide(activeFragment).show(homeFragment).commit();
            activeFragment = homeFragment;
        }
    }
    public void openDrawer() {
        mDrawer.openDrawer(GravityCompat.START);
    }

    public void closeDrawer() {
        mDrawer.closeDrawer(GravityCompat.START);
    }
}
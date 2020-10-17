package com.example.arowex.home.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.arowex.home.ui.NewestFragment;
import com.example.arowex.home.ui.TopGainersFragment;
import com.example.arowex.home.ui.VolLeadersFragment;


public class HomePaggerSetup extends FragmentPagerAdapter {
    Context context;
    int totalTabs;

    public HomePaggerSetup(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                TopGainersFragment topGainersFragment = new TopGainersFragment();
                return topGainersFragment;
            case 1:
                VolLeadersFragment volLeadersFragment = new VolLeadersFragment();
                return volLeadersFragment;
            case 2:
                NewestFragment newestFragment = new NewestFragment();
                return newestFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}

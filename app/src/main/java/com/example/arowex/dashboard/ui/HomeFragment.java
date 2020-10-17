package com.example.arowex.dashboard.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import com.example.arowex.R;
import com.example.arowex.dashboard.DashboardActivity;
import com.example.arowex.home.adapter.HomePaggerSetup;
import com.example.arowex.home.adapter.SliderAdapter;
import com.google.android.material.tabs.TabLayout;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;


import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class HomeFragment extends Fragment {

    List<String> strings = new ArrayList<>();
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        CircleImageView humburger = (CircleImageView) view.findViewById(R.id.humburger);
        humburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((DashboardActivity) getActivity()).openDrawer();
            }
        });

        settingTabbedLayout(view);
        settingSlider(view);


        return view;
    }

    private void settingSlider(View view) {
        strings.add("https://i.pinimg.com/736x/42/11/83/421183ad16ad430a9c6ee3e91b72974e.jpg");
        strings.add("https://cdn.pixabay.com/photo/2016/11/29/05/45/astronomy-1867616__340.jpg");
        strings.add("https://i.pinimg.com/736x/42/11/83/421183ad16ad430a9c6ee3e91b72974e.jpg");
        strings.add("https://cdn.pixabay.com/photo/2016/11/29/05/45/astronomy-1867616__340.jpg");
        strings.add("https://i.pinimg.com/736x/42/11/83/421183ad16ad430a9c6ee3e91b72974e.jpg");
        strings.add("https://cdn.pixabay.com/photo/2016/11/29/05/45/astronomy-1867616__340.jpg");
        SliderView sliderView = view.findViewById(R.id.imageSlider);

        SliderAdapter adapter = new SliderAdapter(getContext());
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        adapter.renewItems(strings);
    }


    private void settingTabbedLayout(View view) {
        tabLayout = view.findViewById(R.id.homeTabL);
        viewPager = view.findViewById(R.id.viewPager);
        tabLayout.addTab(tabLayout.newTab().setText("Top Gainers"));
        tabLayout.addTab(tabLayout.newTab().setText("VOL Leaders"));
        tabLayout.addTab(tabLayout.newTab().setText("Newest"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        HomePaggerSetup adapter = new HomePaggerSetup(getContext(), getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}


package com.example.arowex.home.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arowex.R;
import com.example.arowex.home.adapter.TopGainersAdapter;
import com.example.arowex.util.SpacesItemDecoration;


public class TopGainersFragment extends Fragment {

    private  RecyclerView topGainerRecyclerView;
    private TopGainersAdapter topGainersAdapter;

    public TopGainersFragment() {
    }


    public static TopGainersFragment newInstance() {
        TopGainersFragment fragment = new TopGainersFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_gainers, container, false);
        topGainerRecyclerView = (RecyclerView) view.findViewById(R.id.topGainerRecyclerView);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        topGainerRecyclerView.setHasFixedSize(true);
        topGainerRecyclerView.setLayoutManager(mLayoutManager);
        topGainerRecyclerView.setItemAnimator(new DefaultItemAnimator());
        topGainerRecyclerView.addItemDecoration(new SpacesItemDecoration(20));

        topGainersAdapter = new TopGainersAdapter(getActivity());
        topGainerRecyclerView.setAdapter(topGainersAdapter);

        return view;
    }
}
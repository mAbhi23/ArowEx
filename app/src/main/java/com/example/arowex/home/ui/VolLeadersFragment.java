package com.example.arowex.home.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arowex.R;
import com.example.arowex.home.adapter.VolLeadersAdapter;
import com.example.arowex.util.SpacesItemDecoration;


public class VolLeadersFragment extends Fragment {

    private RecyclerView volLeadersRecyclerView;
    private VolLeadersAdapter volLeadersAdapter;

    public VolLeadersFragment() {
    }

    public static VolLeadersFragment newInstance(String param1, String param2) {
        VolLeadersFragment fragment = new VolLeadersFragment();
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
        View view = inflater.inflate(R.layout.fragment_vol_leaders, container, false);
        volLeadersRecyclerView = (RecyclerView) view.findViewById(R.id.volLeadersRecyclerView);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        volLeadersRecyclerView.setHasFixedSize(true);
        volLeadersRecyclerView.setLayoutManager(mLayoutManager);
        volLeadersRecyclerView.setItemAnimator(new DefaultItemAnimator());
        volLeadersRecyclerView.addItemDecoration(new SpacesItemDecoration(20));

        volLeadersAdapter = new VolLeadersAdapter(getActivity());
        volLeadersRecyclerView.setAdapter(volLeadersAdapter);

        return view;
    }
}
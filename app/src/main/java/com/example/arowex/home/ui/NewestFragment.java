package com.example.arowex.home.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arowex.R;
import com.example.arowex.home.adapter.NewestAdapter;
import com.example.arowex.util.SpacesItemDecoration;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewestFragment extends Fragment {

    private RecyclerView newestRecyclerView;
    private NewestAdapter newestAdapter;


    public NewestFragment() {
        // Required empty public constructor
    }
   public static NewestFragment newInstance(String param1, String param2) {
        NewestFragment fragment = new NewestFragment();
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
        View view= inflater.inflate(R.layout.fragment_newest, container, false);
        newestRecyclerView = (RecyclerView) view.findViewById(R.id.newestRecyclerView);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        newestRecyclerView.setHasFixedSize(true);
        newestRecyclerView.setLayoutManager(mLayoutManager);
        newestRecyclerView.setItemAnimator(new DefaultItemAnimator());
        newestRecyclerView.addItemDecoration(new SpacesItemDecoration(20));

        newestAdapter = new NewestAdapter(getActivity());
        newestRecyclerView.setAdapter(newestAdapter);

        return view;
    }
}
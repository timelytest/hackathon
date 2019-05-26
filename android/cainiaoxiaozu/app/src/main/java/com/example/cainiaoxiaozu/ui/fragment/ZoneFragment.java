package com.example.cainiaoxiaozu.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import com.example.cainiaoxiaozu.R;

public class ZoneFragment extends Fragment {

    private static final String TAG = "fragment_zone";
    private LinearLayout linearLayout;
    private RecyclerView scrollView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zone, container, false);

        scrollView = view.findViewById(R.id.zone_recycler);
        scrollView.setLayoutManager(new LinearLayoutManager(getActivity()));



        return view;
    }
}

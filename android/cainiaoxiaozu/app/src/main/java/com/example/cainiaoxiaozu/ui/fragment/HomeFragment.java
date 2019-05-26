package com.example.cainiaoxiaozu.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import com.example.cainiaoxiaozu.R;

import cn.bingoogolapple.bgabanner.BGABanner;

public class HomeFragment extends Fragment {

    private static final String TAG = "fragment_home";
    private FrameLayout frameLayout;
    private BGABanner bgaBanner;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        frameLayout = view.findViewById(R.id.fragment_home);
        bgaBanner = view.findViewById(R.id.banner_guide_content);
        return view;
    }
}

package com.example.cainiaoxiaozu.ui.fragment.me;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cainiaoxiaozu.R;

public class MeFragment extends Fragment {
    private static final String TAG = "fragment_me";
    private LinearLayout linearLayout;
    private HorizontalScrollView mScrollView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        linearLayout = view.findViewById(R.id.fragment_me);

        return view;
    }
}

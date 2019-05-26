package com.example.cainiaoxiaozu.ui.activity.home;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.example.cainiaoxiaozu.R;
import com.example.cainiaoxiaozu.ui.fragment.AddFragment;
import com.example.cainiaoxiaozu.ui.fragment.BulbFragment;
import com.example.cainiaoxiaozu.ui.fragment.HomeFragment;
import com.example.cainiaoxiaozu.ui.fragment.MeFragment;
import com.example.cainiaoxiaozu.ui.fragment.ZoneFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private List<Fragment> mFragments;
    private int lastIndex = 0;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setFragment(0);
                    return true;
                case R.id.navigation_lightbulb:
                    setFragment(1);
                    return true;
                case R.id.navigation_add:
                    setFragment(2);
                    return true;
                case R.id.navigation_zone:
                    setFragment(3);
                    return true;
                default:
                    setFragment(4);
                    return true;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setItemTextAppearanceActive(R.style.bottom_selected_text);
        navView.setItemTextAppearanceInactive(R.style.bottom_normal_text);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        initFragment();
    }

    private void initFragment(){
        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new BulbFragment());
        mFragments.add(new AddFragment());
        mFragments.add(new MeFragment());
        mFragments.add(new ZoneFragment());
    }

    private void setFragment(int position) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment currentFragment = mFragments.get(position);
        Fragment lastFragment = mFragments.get(lastIndex);
        lastIndex = position;
        ft.hide(lastFragment);
        if (!currentFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
            ft.add(R.id.home_container, currentFragment);
        }
        ft.show(currentFragment);
        ft.commitAllowingStateLoss();
    }

}

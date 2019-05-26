package com.example.cainiaoxiaozu.ui.activity.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.cainiaoxiaozu.R;
import com.example.cainiaoxiaozu.ui.activity.login.LoginActivity;
import com.example.cainiaoxiaozu.util.http.HttpUtil;
import com.example.cainiaoxiaozu.util.http.command.login.LoginCommand;
import com.example.cainiaoxiaozu.util.http.services.LoginService;
import com.example.cainiaoxiaozu.util.http.services.QuestionService;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity{

    private SearchView mSearchView;
    private ListView listView;
    ArrayAdapter<String> adapter;
    List<String> mAllList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mSearchView = (SearchView) findViewById(R.id.searchView);
        mSearchView.setIconifiedByDefault(false);


        listView = (ListView) findViewById(R.id.listView);

        String[]arr_data= {""};
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1 , arr_data);

        listView.setAdapter(adapter);

//        FragmentManager fm = getSupportFragmentManager();
//        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
//
//        if (fragment == null) {
//            fragment = createFragment();
//            fm.beginTransaction()
//                    .add(R.id.fragment_container, fragment)
//                    .commit();
//        }

        //搜索图标是否显示在搜索框内
        mSearchView.setIconifiedByDefault(true);
        //设置搜索框展开时是否显示提交按钮，可不显示
        mSearchView.setSubmitButtonEnabled(true);
        //搜索框是否展开，false表示展开
        mSearchView.setIconified(false);

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                QuestionService questionService = (QuestionService) HttpUtil.getService(QuestionService.class);
                HttpUtil.dealCall((questionService.listQuestionListByKeyword(query)), new LoginCommand(SearchActivity.this, listView));
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {





                return false;
            }
        });

    }

}

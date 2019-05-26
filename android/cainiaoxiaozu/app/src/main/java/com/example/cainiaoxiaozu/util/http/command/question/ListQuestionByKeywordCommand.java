package com.example.cainiaoxiaozu.util.http.command.question;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cainiaoxiaozu.util.http.command.BaseCommand;

public class ListQuestionByKeywordCommand extends BaseCommand {

    private Context context;
    private ListView listView;
    private ArrayAdapter<String> adapter;

    public ListQuestionByKeywordCommand(Object... objects){
        super(objects);
        //需要操作的组件
        context = (Context) objects[0];
        listView = (ListView) objects[1];
        adapter = (ArrayAdapter<String>) objects[2];
    }

    @Override
    public void success(String body) {
        //具体操作

    }

    @Override
    public void failure(Throwable t) {

    }
}

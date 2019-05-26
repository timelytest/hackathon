package com.example.cainiaoxiaozu.util.http.command.question;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cainiaoxiaozu.util.http.command.BaseCommand;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        JSONObject Jobject = null;

        try {
            Jobject = new JSONObject(body);

        JSONArray Jarray = Jobject.getJSONArray("employees");

            for (int i = 0; i < Jarray.length(); i++) {
                JSONObject object     = Jarray.getJSONObject(i);
                adapter.add(object.getString("title"));
            }

            listView.setAdapter(adapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void failure(Throwable t) {

    }
}

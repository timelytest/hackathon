package com.example.cainiaoxiaozu.ui.fragment.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cainiaoxiaozu.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;

public class HomeFragment extends Fragment {

    private static final String TAG = "fragment_home";
    private FrameLayout frameLayout;
    private BGABanner bgaBanner;

    private HorizontalScrollView hsf;
    private GridView gv;

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

        bgaBanner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
                Picasso.get()
                        .load(model)
                        .placeholder(R.drawable.ic_broken_image_white_48dp)
                        .fit()
                        .centerCrop()
                        .into(itemView);
            }
        });
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1558865930399&di=ad70d16290ebd93dc3451308004e9f29&imgtype=0&src=http%3A%2F%2Fimg.sccnn.com%2Fbimg%2F337%2F31452.jpg";
        bgaBanner.setData(Arrays.asList(url, url, url), Arrays.asList());

        initHorizontal(view);

        return view;
    }

    private void initHorizontal(View view){
        hsf = view.findViewById(R.id.home_1_view);
        gv = view.findViewById(R.id.home_1_grid);

        List<DataItem> list = new ArrayList<>();
        list.add(new DataItem("1"));
        list.add(new DataItem("2"));
        list.add(new DataItem("3"));
        list.add(new DataItem("4"));

        int size = list.size();
        int length = 140;
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
        int gridviewWidth = (int) (size * (length + 4) * density);
        int itemWidth = (int) (length * density);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                gridviewWidth, LinearLayout.LayoutParams.FILL_PARENT);
        gv.setLayoutParams(params); // 设置GirdView布局参数,横向布局的关键
        gv.setColumnWidth(itemWidth); // 设置列表项宽
        gv.setHorizontalSpacing(40); // 设置列表项水平间距
        gv.setStretchMode(GridView.NO_STRETCH);
        gv.setNumColumns(size); // 设置列数量=列表集合数

        GridViewAdapter adapter = new GridViewAdapter(getActivity(),
                list);
        gv.setAdapter(adapter);
    }

    private class GridViewAdapter extends BaseAdapter{
        Context context;
        List<DataItem> list;
        public GridViewAdapter(Context _context, List<DataItem> _list) {
            this.list = _list;
            this.context = _context;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
            TextView tvCity = convertView.findViewById(R.id.text_view);
            DataItem city = list.get(position);

            //tvCity.setText(city.getAction());
            return convertView;
        }
    }
}

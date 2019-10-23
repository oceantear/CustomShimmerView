package com.koca.rlistviewdemo;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.koca.rlistviewdemo.adapter.RecyclerViewAdapter;
import com.koca.shimmer.ShimmerRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecyclerViewDemoActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerViewAdapter mDemoAdapter;
    private ShimmerRecyclerView shimmerRecycler;
    private SwipeRefreshLayout refresh_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_demo);

        shimmerRecycler = findViewById(R.id.shimmer_recycler_view);
        refresh_layout = findViewById(R.id.reflash_layout);
        refresh_layout.setOnRefreshListener(this);

        mDemoAdapter = new RecyclerViewAdapter(null);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        shimmerRecycler.setLayoutManager(layoutManager);// 假layout
        shimmerRecycler.setAdapter(mDemoAdapter);
        //可在此設定或在xml設定
        shimmerRecycler.setDemoLayoutReference(R.layout.layout_sample_view_2);
        shimmerRecycler.showShimmerAdapter();

        shimmerRecycler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadData();
            }
        }, 10000);
    }

    private void loadData() {
        List<HashMap<String, String>> items = new ArrayList<>();
        HashMap<String, String> item = new HashMap<>();
        item.put("name", "明德高中");
        item.put("address", "中正路二段");
        item.put("about", "可停：14, 可借：20");
        items.add(item);
        item = new HashMap<>();
        item.put("name", "國中二甲路口");
        item.put("address", "國中街175號前");
        item.put("about", "可停：17, 可借：23");
        items.add(item);
        item = new HashMap<>();
        item.put("name", "尖三國中");
        item.put("address", "鶯歌區國中街一號");
        item.put("about", "可停：20, 可借：12");
        items.add(item);
        item = new HashMap<>();
        item.put("name", "中原國小");
        item.put("address", "三峽區鴻源街55號對面的行人道");
        item.put("about", "可停：31, 可借：5");
        items.add(item);
        item = new HashMap<>();
        item.put("name", "永吉國小");
        item.put("address", "鶯歌區德二街三十九奧");
        item.put("about", "可停：17, 可借：19");
        items.add(item);
        item = new HashMap<>();
        item.put("name", "安西國中");
        item.put("address", "三峽區中正路一段大同路人行道旁");
        item.put("about", "可停：18, 可借：14");
        items.add(item);
        item = new HashMap<>();
        item.put("name", "鳳翔公園");
        item.put("address", "櫻桃路413巷65弄4號對面");
        item.put("about", "可停：14, 可借：9");
        items.add(item);
        mDemoAdapter.setItems(items);
        shimmerRecycler.hideShimmerAdapter();
        refresh_layout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        shimmerRecycler.showShimmerAdapter();
        shimmerRecycler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadData();
            }
        }, 10000);
    }
}

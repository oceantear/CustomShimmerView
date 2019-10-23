package com.koca.rlistviewdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.koca.shimmer.ShimmerView;

public class ViewDemoActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {


    private ShimmerView skeletonScreen;
    private SwipeRefreshLayout refresh_layout;
    private Button bt;

    Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_demo);

        /*refresh_layout = findViewById(R.id.reflash_layout);
        refresh_layout.setOnRefreshListener(this);*/

        bt = findViewById(R.id.refresh_bt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skeletonScreen.show();
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        skeletonScreen.hide();
                    }
                },5000);
            }
        });

        View rootView = findViewById(R.id.rootView);
        skeletonScreen = new ShimmerView(this , rootView);
        skeletonScreen.setSkeletonLayout(R.layout.activity_fake_view);
        skeletonScreen.show();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                skeletonScreen.hide();
            }
        },5000);
    }


    @Override
    public void onRefresh() {
        skeletonScreen.show();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                skeletonScreen.hide();
            }
        },5000);
    }
}

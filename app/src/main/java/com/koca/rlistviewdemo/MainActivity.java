package com.koca.rlistviewdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity = this;
        findViewById(R.id.bt_01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mActivity, RecyclerViewDemoActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.bt_02).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mActivity, GridViewDemoActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.bt_03).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mActivity, AnimActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.bt_04).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mActivity, AnimLayoutActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.bt_05).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mActivity, ViewDemoActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.bt_06).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mActivity, ImageViewDemoActivity.class);
                startActivity(intent);
            }
        });
    }

}

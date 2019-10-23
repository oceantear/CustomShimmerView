package com.koca.rlistviewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.koca.shimmer.ShimmerImageView;

public class ImageViewDemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_demo_layout);

        ShimmerImageView ac = findViewById(R.id.img);
        View fakeVw = findViewById(R.id.fake_img);
        //final ShimmerImageView shig = new ShimmerImageView(this, ac);
        ac.setSkeletonImageView((ImageView)fakeVw);
        ac.showImage(0 ,null , null);
        ac.postDelayed(new Runnable() {
            @Override
            public void run() {
                //shig.hide();
            }
        },3000);

    }
}

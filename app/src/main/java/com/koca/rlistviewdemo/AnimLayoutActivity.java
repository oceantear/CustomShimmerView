package com.koca.rlistviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.koca.surface_anim.Animation;
import com.koca.surface_anim.SurfaceAnim;

public class AnimLayoutActivity extends AppCompatActivity {

    private LinearLayout anim_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_layout);

        anim_layout = findViewById(R.id.anim_layout);
        animAction();
    }

    private void animAction() {
        SurfaceAnim.origin(anim_layout).delay(0).anim(getApplicationContext(), R.anim.overshoot).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.animation1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_1:
                animAction();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

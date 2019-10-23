package com.koca.rlistviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.koca.surface_anim.Animation;
import com.koca.surface_anim.SurfaceAnim;

public class AnimActivity extends AppCompatActivity {

    private LinearLayout anim_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        anim_layout = findViewById(R.id.anim_layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.animation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_1:
                SurfaceAnim.origin(anim_layout).delay(0).anim(getApplicationContext(), Animation.BOUNCE_IN).start();
                break;
            case R.id.action_2:
                SurfaceAnim.origin(anim_layout).delay(0).anim(getApplicationContext(), Animation.FADE_IN).start();
                break;
            case R.id.action_3:
                SurfaceAnim.origin(anim_layout).delay(0).anim(getApplicationContext(), Animation.FADE_IN_DOWN).start();
                break;
            case R.id.action_4:
                SurfaceAnim.origin(anim_layout).delay(0).anim(getApplicationContext(), Animation.FADE_IN_LEFT).start();
                break;
            case R.id.action_5:
                SurfaceAnim.origin(anim_layout).delay(0).anim(getApplicationContext(), Animation.FADE_IN_RIGHT).start();
                break;
            case R.id.action_6:
                SurfaceAnim.origin(anim_layout).delay(0).anim(getApplicationContext(), Animation.FADE_IN_UP).start();
                break;
            case R.id.action_7:
                SurfaceAnim.origin(anim_layout).delay(0).anim(getApplicationContext(), Animation.ROTATE_IN).start();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

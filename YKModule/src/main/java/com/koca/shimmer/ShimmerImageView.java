package com.koca.shimmer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import com.koca.shimmer_library.R;

public class ShimmerImageView extends android.support.v7.widget.AppCompatImageView {


    private int mShimmerColor;
    private int mShimmerDuration = 1000;
    private int mShimmerAngle = 20;
    private View mActualView;
    private View mSekeltonImageView;

    public ShimmerImageView(Context context , ImageView ImgVw) {
        super(context);
        init(ImgVw);
    }

    public ShimmerImageView(Context context, AttributeSet attrs, ImageView ImgVw) {
        super(context, attrs);
        init(ImgVw);
    }

    public ShimmerImageView(Context context, AttributeSet attrs, int defStyleAttr ,ImageView ImgVw) {
        super(context, attrs, defStyleAttr);
        init(ImgVw);
    }

    void init(ImageView ig){
        mShimmerColor = ContextCompat.getColor(ig.getContext(), R.color.shimmer_color);
        mActualView = ig;
    }

    public void setBitmap(Bitmap bm){
        setImageBitmap(bm);
    }

    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);
    }

    public void setResource(int resId){
        setImageResource(resId);
    }

    @Override
    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
    }

    public void setSkeletonImageView(ImageView ig){
        mSekeltonImageView = ig;
    }

    public void showImage(int resId , Bitmap bm , Drawable dw){

        //if(resId == 0 && bm == null && dw ==null)
        //    return;

        showshimmer();

        /*if(resId != 0)
            setImageResource(resId);
        else if(bm != null)
            setImageBitmap(bm);
        else if(dw != null)
            setImageDrawable(dw);*/
    }

    public void hide(int resId , Bitmap bm , Drawable dw){
        if(resId == 0 && bm == null && dw ==null)
            return;

        /*if(resId != 0)
            setImageResource(resId);
        else if(bm != null)
            setImageBitmap(bm);
        else if(dw != null)
            setImageDrawable(dw);*/
    }

    void showshimmer(){

        ViewParent viewParent = mActualView.getParent();
        ViewGroup parentView = (ViewGroup) viewParent;

        final ShimmerLayout shimmerLayout = (ShimmerLayout) LayoutInflater.from(mActualView.getContext()).inflate(R.layout.layout_shimmer, parentView, false);
        shimmerLayout.setShimmerColor(mShimmerColor);
        shimmerLayout.setShimmerAngle(mShimmerAngle);
        shimmerLayout.setShimmerAnimationDuration(mShimmerDuration);
        //View innerView = LayoutInflater.from(mActualView.getContext()).inflate(mSkeletonLayoutResID, shimmerLayout, false);
        ViewGroup.LayoutParams lp = mSekeltonImageView.getLayoutParams();
        if (lp != null) {
            shimmerLayout.setLayoutParams(lp);
        }
        shimmerLayout.addView(mSekeltonImageView);
        shimmerLayout.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {
                shimmerLayout.startShimmerAnimation();
            }

            @Override
            public void onViewDetachedFromWindow(View v) {
                shimmerLayout.stopShimmerAnimation();
            }
        });
        shimmerLayout.startShimmerAnimation();
    }

    void hideshimmer(){

    }
}

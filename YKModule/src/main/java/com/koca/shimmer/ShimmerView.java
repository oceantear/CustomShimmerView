package com.koca.shimmer;

import android.content.Context;
import android.os.Build;
import android.support.annotation.LayoutRes;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.koca.shimmer_library.R;

public class ShimmerView {

    private final ViewReplacer mViewReplacer;
    private final View mActualView;
    private final int mShimmerColor;
    private final boolean mShimmer = true;
    private int mShimmerDuration = 1000;
    private int mShimmerAngle = 20;
    private int mSkeletonLayoutResID;
    private final Context mCtx;

    public ShimmerView(Context ctx , View v){
        mActualView = v;
        //mSkeletonResID = builder.mSkeletonLayoutResID;
        //mShimmer = builder.mShimmer;
        //mShimmerDuration = builder.mShimmerDuration;
        //mShimmerAngle = builder.mShimmerAngle;
        mShimmerColor = ContextCompat.getColor(v.getContext(), R.color.shimmer_color);
        mViewReplacer = new ViewReplacer(mActualView);
        mCtx = ctx;
    }


    public void setSkeletonLayout(@LayoutRes int skeletonLayoutResID){
        mSkeletonLayoutResID = skeletonLayoutResID;
    }

    private ShimmerLayout generateShimmerContainerLayout(ViewGroup parentView) {
        final ShimmerLayout shimmerLayout = (ShimmerLayout) LayoutInflater.from(mActualView.getContext()).inflate(R.layout.layout_shimmer, parentView, false);
        shimmerLayout.setShimmerColor(mShimmerColor);
        shimmerLayout.setShimmerAngle(mShimmerAngle);
        shimmerLayout.setShimmerAnimationDuration(mShimmerDuration);
        View innerView = LayoutInflater.from(mActualView.getContext()).inflate(mSkeletonLayoutResID, shimmerLayout, false);
        ViewGroup.LayoutParams lp = innerView.getLayoutParams();
        if (lp != null) {
            shimmerLayout.setLayoutParams(lp);
        }
        shimmerLayout.addView(innerView);
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
        return shimmerLayout;
    }

    private View generateSkeletonLoadingView() {
        ViewParent viewParent = mActualView.getParent();
        if (viewParent == null) {
            Log.e("jimmy", "the source view have not attach to any view");
            return null;
        }
        ViewGroup parentView = (ViewGroup) viewParent;
        if (mShimmer) {
            return generateShimmerContainerLayout(parentView);
        }
        return LayoutInflater.from(mActualView.getContext()).inflate(mSkeletonLayoutResID, parentView, false);
    }

    /*private View generateSkeletonLoadingView() {
        //ViewParent viewParent = mActualView.getParent();
        if (mActualView == null) {
            Log.e("jimmy", "the source view have not attach to any view");
            return null;
        }
        ViewGroup parentView = (ViewGroup) mActualView;
        if (mShimmer) {
            return generateShimmerContainerLayout(parentView);
        }
        return LayoutInflater.from(mActualView.getContext()).inflate(mSkeletonLayoutResID, parentView, false);
    }*/

    public void show(){
        View skeletonLoadingView = generateSkeletonLoadingView();
        if (skeletonLoadingView != null) {
            mViewReplacer.replace(skeletonLoadingView);
        }
    }

    public void hide(){
        if (mViewReplacer.getTargetView() instanceof ShimmerLayout) {
            ((ShimmerLayout) mViewReplacer.getTargetView()).stopShimmerAnimation();
        }
        mViewReplacer.restore();
    }

    public void setShimmerDuration(int duration){
        mShimmerDuration = duration;
    }

    public void setShimmerAngle(int angle){
        mShimmerAngle = angle;
    }

    private int getColor(int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return mCtx.getColor(id);
        } else {
            return mCtx.getColor(id);
        }
    }
}

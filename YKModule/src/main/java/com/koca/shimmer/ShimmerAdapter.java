package com.koca.shimmer;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.koca.shimmer_library.R;

public class ShimmerAdapter extends RecyclerView.Adapter<ShimmerAdapter.ShimmerViewHolder> {

    private int mItemCount;
    private int mLayoutReference;
    private int mShimmerAngle;
    private int mShimmerColor;
    private int mShimmerDuration;
    private float mShimmerMaskWidth;
    private boolean isAnimationReversed;
    private Drawable mShimmerItemBackground;

    @Override
    public ShimmerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        ShimmerViewHolder shimmerViewHolder = new ShimmerViewHolder(inflater, parent, mLayoutReference);
        shimmerViewHolder.setShimmerColor(mShimmerColor);
        shimmerViewHolder.setShimmerAngle(mShimmerAngle);
        shimmerViewHolder.setShimmerMaskWidth(mShimmerMaskWidth);
        shimmerViewHolder.setShimmerViewHolderBackground(mShimmerItemBackground);
        shimmerViewHolder.setShimmerAnimationDuration(mShimmerDuration);
        shimmerViewHolder.setAnimationReversed(isAnimationReversed);

        return shimmerViewHolder;
    }

    @Override
    public void onBindViewHolder(ShimmerViewHolder holder, int position) {
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return mItemCount;
    }

    public void setMinItemCount(int itemCount) {
        mItemCount = itemCount;
    }

    public void setShimmerAngle(int shimmerAngle) {
        this.mShimmerAngle = shimmerAngle;
    }

    public void setShimmerColor(int shimmerColor) {
        this.mShimmerColor = shimmerColor;
    }

    public void setShimmerMaskWidth(float maskWidth) {
        this.mShimmerMaskWidth = maskWidth;
    }

    public void setShimmerItemBackground(Drawable shimmerItemBackground) {
        this.mShimmerItemBackground = shimmerItemBackground;
    }

    public void setShimmerDuration(int mShimmerDuration) {
        this.mShimmerDuration = mShimmerDuration;
    }

    public void setLayoutReference(int layoutReference) {
        this.mLayoutReference = layoutReference;
    }

    public void setAnimationReversed(boolean animationReversed) {
        this.isAnimationReversed = animationReversed;
    }

    public class ShimmerViewHolder extends RecyclerView.ViewHolder {

        private ShimmerLayout mShimmerLayout;

        public ShimmerViewHolder(LayoutInflater inflater, ViewGroup parent, int innerViewResId) {
            super(inflater.inflate(R.layout.viewholder_shimmer, parent, false));
            mShimmerLayout = (ShimmerLayout) itemView;

            inflater.inflate(innerViewResId, mShimmerLayout, true);
        }

        public void setShimmerAngle(int angle) {
            mShimmerLayout.setShimmerAngle(angle);
        }

        public void setShimmerColor(int color) {
            mShimmerLayout.setShimmerColor(color);
        }

        public void setShimmerMaskWidth(float maskWidth) {
            mShimmerLayout.setMaskWidth(maskWidth);
        }

        public void setShimmerViewHolderBackground(Drawable viewHolderBackground) {
            if (viewHolderBackground != null) {
                setBackground(viewHolderBackground);
            }
        }

        public void setShimmerAnimationDuration(int duration) {
            mShimmerLayout.setShimmerAnimationDuration(duration);
        }

        public void setAnimationReversed(boolean animationReversed) {
            mShimmerLayout.setAnimationReversed(animationReversed);
        }

        public void bind() {
            mShimmerLayout.startShimmerAnimation();
        }

        private void setBackground(Drawable background) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
                mShimmerLayout.setBackground(background);
            } else {
                mShimmerLayout.setBackgroundDrawable(background);
            }
        }
    }
}

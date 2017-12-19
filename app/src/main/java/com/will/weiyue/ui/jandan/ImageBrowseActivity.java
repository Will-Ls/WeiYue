package com.will.weiyue.ui.jandan;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.will.weiyue.R;
import com.will.weiyue.component.ApplicationComponent;
import com.will.weiyue.ui.base.BaseActivity;
import com.will.weiyue.utils.ImageLoaderUtil;
import com.will.weiyue.utils.StatusBarUtil;
import com.will.weiyue.widget.HackyViewPager;
import com.will.weiyue.widget.SwipeBackLayout;

import butterknife.BindView;

public class ImageBrowseActivity extends BaseActivity {
    private static final String TAG = "ImageBrowseActivity";
    @BindView(R.id.view_pager)
    HackyViewPager mViewPager;
    @BindView(R.id.page_text)
    TextView mTvImageSize;
    @BindView(R.id.swipe_layout)
    SwipeBackLayout mSwipeBackLayout;
    @BindView(R.id.rl_imagebrowse)
    RelativeLayout mRlImageBrowse;

    private int selectedIndex;
    private String[] imageUrls;

    @Override
    public int getContentLayout() {
        return R.layout.activity_image_browse;
    }

    public static void launch(Activity context, String[] urls, int selectedIndex) {
        Intent intent = new Intent(context, ImageBrowseActivity.class);
        intent.putExtra("urls", urls);
        intent.putExtra("selectedIndex", selectedIndex);
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public void initInjector(ApplicationComponent appComponent) {

    }



    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        //setStatusBarColor(ContextCompat.getColor(this, android.R.color.black),150);
        StatusBarUtil.setColor(this,ContextCompat.getColor(this, android.R.color.black));
        mRlImageBrowse.getBackground().setAlpha(255);
        mSwipeBackLayout.setDragDirectMode(SwipeBackLayout.DragDirectMode.VERTICAL);
        mSwipeBackLayout.setOnSwipeBackListener(new SwipeBackLayout.SwipeBackListener() {
            @Override
            public void onViewPositionChanged(float fractionAnchor, float fractionScreen) {
                mRlImageBrowse.getBackground().setAlpha(255 - (int) Math.ceil(255 * fractionAnchor));
            }
        });

    }

    @Override
    public void initData() {
        if (getIntent().getExtras() == null) return;
        imageUrls = getIntent().getExtras().getStringArray("urls");
        selectedIndex = getIntent().getExtras().getInt("selectedIndex");
        if (imageUrls == null) return;

        mViewPager.setAdapter(new ViewPagerAdapter(imageUrls));
        mViewPager.setCurrentItem(selectedIndex);
        if (selectedIndex == 0){
            mSwipeBackHelper.setSwipeBackEnable(true);
        }else {
            mSwipeBackHelper.setSwipeBackEnable(false);
        }

        if (imageUrls.length > 1) {
            mTvImageSize.setText(selectedIndex + 1 + " / " + imageUrls.length);
            mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    mTvImageSize.setText(position + 1 + " / " + imageUrls.length);
                    if (position == 0){
                        mSwipeBackHelper.setSwipeBackEnable(true);
                    }else {
                        mSwipeBackHelper.setSwipeBackEnable(false);
                    }

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
    }


    private class ViewPagerAdapter extends PagerAdapter {
        private PhotoView mPhotoView;
        private ProgressBar mProgressBar;
        private String[] imageUrls;

        private ViewPagerAdapter(String[] imageUrls) {
            this.imageUrls = imageUrls;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View view = LayoutInflater.from(ImageBrowseActivity.this).inflate(
                    R.layout.loadimage, null);
            mPhotoView = (PhotoView) view.findViewById(R.id.photoview);
            mProgressBar = (ProgressBar) view.findViewById(R.id.loading);
            mProgressBar.setVisibility(View.GONE);
            mPhotoView.setOnPhotoTapListener(new OnPhotoTapListener() {
                @Override
                public void onPhotoTap(ImageView imageView, float v, float v1) {
                   finish();
                }
            });
            ImageLoaderUtil.LoadImage(ImageBrowseActivity.this, imageUrls[position],
                    new DrawableImageViewTarget(mPhotoView) {
                        @Override
                        public void setDrawable(Drawable drawable) {
                            super.setDrawable(drawable);
                            Log.i(TAG, "setDrawable: ");
                           // mProgressBar.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onLoadStarted(@Nullable Drawable placeholder) {
                            super.onLoadStarted(placeholder);
                            Log.i(TAG, "onLoadStarted: ");
                            mProgressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onLoadFailed(@Nullable Drawable errorDrawable) {
                            super.onLoadFailed(errorDrawable);
                            Log.i(TAG, "onLoadFailed: ");
                            mProgressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onLoadCleared(@Nullable Drawable placeholder) {
                            super.onLoadCleared(placeholder);
                            Log.i(TAG, "onLoadCleared: ");
                            mProgressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onResourceReady(Drawable resource, @Nullable Transition<? super Drawable> transition) {
                            super.onResourceReady(resource, transition);
                            Log.i(TAG, "onResourceReady: ");
                            mProgressBar.setVisibility(View.GONE);

                        }
                    });
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return imageUrls.length > 0 ? imageUrls.length : 0;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }

    }

    @Override
    public void onRetry() {

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}

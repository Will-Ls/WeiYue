package com.will.weiyue.ui.news;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.will.weiyue.R;
import com.will.weiyue.bean.NewsArticleBean;
import com.will.weiyue.bean.NewsDetail;
import com.will.weiyue.component.ApplicationComponent;
import com.will.weiyue.component.DaggerHttpComponent;
import com.will.weiyue.net.ApiConstants;
import com.will.weiyue.ui.base.BaseActivity;
import com.will.weiyue.ui.news.contract.ArticleReadContract;
import com.will.weiyue.ui.news.presenter.ArticleReadPresenter;
import com.will.weiyue.utils.ImageLoaderUtil;
import com.will.weiyue.utils.StatusBarUtil;
import com.will.weiyue.widget.HackyViewPager;
import com.will.weiyue.widget.MyScrollView;
import com.will.weiyue.widget.SwipeBackLayout;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.will.weiyue.R.id.scrollview;

/**
 * desc: 图片新闻浏览页面.
 * author: Will .
 * date: 2017/9/24 .
 */
public class ImageBrowseActivity extends BaseActivity<ArticleReadPresenter> implements ArticleReadContract.View {
    private static final String AID = "aid";
    private static final String ISCMPP = "isCmpp";
    private boolean isShow = true;
    private NewsArticleBean newsArticleBean;
    @BindView(R.id.btn_titlebar_left)
    ImageView mBtnTitlebarLeft;
    @BindView(R.id.tv_titlebar_name)
    TextView mTvTitlebarName;
    @BindView(R.id.rl_top)
    RelativeLayout mRlTop;
    @BindView(R.id.tv_info)
    TextView mTvInfo;
    @BindView(scrollview)
    MyScrollView mScrollview;
    @BindView(R.id.relativeLayout)
    RelativeLayout mRelativeLayout;
    @BindView(R.id.view_pager)
    HackyViewPager mViewPager;
    @BindView(R.id.swipe_layout)
    SwipeBackLayout mSwipeBackLayout;

    public static void launch(Activity context, NewsDetail.ItemBean bodyBean) {
        Intent intent = new Intent(context, ImageBrowseActivity.class);
        if (bodyBean.getId().contains(ApiConstants.sGetNewsArticleCmppApi)
                || bodyBean.getDocumentId().startsWith("cmpp")) {
            intent.putExtra(ISCMPP, true);
        } else {
            intent.putExtra(ISCMPP, false);
        }
        intent.putExtra(AID, bodyBean.getDocumentId());
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_imagebrowse;
    }

    @Override
    public void initInjector(ApplicationComponent appComponent) {
        DaggerHttpComponent.builder()
                .applicationComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, android.R.color.black));
        mRelativeLayout.getBackground().setAlpha(255);
        mSwipeBackHelper.setSwipeBackEnable(true);
        mSwipeBackLayout.setDragDirectMode(SwipeBackLayout.DragDirectMode.VERTICAL);
        mSwipeBackLayout.setOnSwipeBackListener(new SwipeBackLayout.SwipeBackListener() {
            @Override
            public void onViewPositionChanged(float fractionAnchor, float fractionScreen) {
                mRelativeLayout.getBackground().setAlpha(255 - (int) Math.ceil(255 * fractionAnchor));
                DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
                df.setMaximumFractionDigits(1);
                df.setRoundingMode(RoundingMode.HALF_UP);
                String dd = df.format(fractionAnchor);
                double alpha = 1 - (Float.valueOf(dd) + 0.8);
                if (fractionAnchor == 0 && isShow) {
                    mScrollview.setAlpha(1f);
                    mRlTop.setAlpha(1f);
                    mRlTop.setVisibility(View.VISIBLE);
                    mScrollview.setVisibility(View.VISIBLE);
                } else {
                    if (alpha == 0) {
                        mRlTop.setVisibility(View.GONE);
                        mScrollview.setVisibility(View.GONE);
                        mScrollview.setAlpha(1f);
                        mRlTop.setAlpha(1f);
                    } else {
                        if (mRlTop.getVisibility() != View.GONE) {
                            mRlTop.setAlpha((float) alpha);
                            mScrollview.setAlpha((float) alpha);
                        }
                    }
                }
            }
        });
        mScrollview.getBackground().mutate().setAlpha(100);
        mRlTop.getBackground().mutate().setAlpha(100);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mTvInfo.setText((position + 1) + " / " + newsArticleBean.getBody().getSlides().size() + " " + newsArticleBean.getBody().getSlides().get(position).getDescription());
                if (position == 0) {
                    mSwipeBackHelper.setSwipeBackEnable(true);
                } else {
                    mSwipeBackHelper.setSwipeBackEnable(false);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() == null) return;
        String aid = getIntent().getStringExtra(AID);
        boolean isCmpp = getIntent().getBooleanExtra(ISCMPP, false);
        mPresenter.getData(aid);
    }

    @Override
    public void onRetry() {
        initData();
    }

    @Override
    public void loadData(NewsArticleBean newsArticleBean) {
        try {
            this.newsArticleBean = newsArticleBean;
            mTvInfo.setText("1 / " + newsArticleBean.getBody().getSlides().size() + " " + newsArticleBean.getBody().getSlides().get(0).getDescription());
            mViewPager.setAdapter(new ViewPagerAdapter(newsArticleBean.getBody().getSlides()));
            mTvTitlebarName.setText(newsArticleBean.getBody().getTitle());
            //showSuccess();
        } catch (Exception e) {
            // showFaild();
            e.printStackTrace();
        }
    }


    @OnClick(R.id.btn_titlebar_left)
    public void onViewClicked() {
        finish();
    }

    private class ViewPagerAdapter extends PagerAdapter {
        private List<NewsArticleBean.BodyBean.SlidesBean> slidesBeanList;
        private PhotoView mPhotoView;
        private ProgressBar mProgressBar;

        private ViewPagerAdapter(List<NewsArticleBean.BodyBean.SlidesBean> slidesBeanList) {
            this.slidesBeanList = slidesBeanList;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = LayoutInflater.from(ImageBrowseActivity.this).inflate(
                    R.layout.loadimage, null);
            mPhotoView = (PhotoView) view.findViewById(R.id.photoview);
            mProgressBar = (ProgressBar) view
                    .findViewById(R.id.loading);
            mPhotoView.setOnPhotoTapListener(new OnPhotoTapListener() {
                @Override
                public void onPhotoTap(ImageView imageView, float v, float v1) {
                    if (isShow) {
                        isShow = false;
                        setView(mRlTop, false);
                        setView(mScrollview, false);
                    } else {
                        isShow = true;
                        setView(mRlTop, true);
                        setView(mScrollview, true);
                    }
                }
            });
            mProgressBar.setVisibility(View.GONE);

            ImageLoaderUtil.LoadImage(ImageBrowseActivity.this, slidesBeanList.get(position).getImage(),
                    new DrawableImageViewTarget(mPhotoView) {
                        @Override
                        public void setDrawable(Drawable drawable) {
                            super.setDrawable(drawable);
                            //mProgressBar.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onLoadStarted(@Nullable Drawable placeholder) {
                            super.onLoadStarted(placeholder);
                            // mProgressBar.setVisibility(View.VISIBLE);

                        }

                        @Override
                        public void onLoadFailed(@Nullable Drawable errorDrawable) {
                            super.onLoadFailed(errorDrawable);
                            mProgressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onLoadCleared(@Nullable Drawable placeholder) {
                            super.onLoadCleared(placeholder);
                            mProgressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onResourceReady(Drawable resource, @Nullable Transition<? super Drawable> transition) {
                            super.onResourceReady(resource, transition);
                            mProgressBar.setVisibility(View.GONE);

                        }
                    });

            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return slidesBeanList == null ? 0 : slidesBeanList.size();
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

    private void setView(final View view, final boolean isShow) {
        AlphaAnimation alphaAnimation;
        if (isShow) {
            alphaAnimation = new AlphaAnimation(0, 1);
        } else {
            alphaAnimation = new AlphaAnimation(1, 0);
        }
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(500);
        view.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(isShow ? View.VISIBLE : View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}

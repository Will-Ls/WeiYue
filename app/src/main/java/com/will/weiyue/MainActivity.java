package com.will.weiyue;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.will.weiyue.component.ApplicationComponent;
import com.will.weiyue.ui.base.BaseActivity;
import com.will.weiyue.ui.base.SupportFragment;
import com.will.weiyue.ui.jandan.JanDanFragment;
import com.will.weiyue.ui.personal.PersonalFragment;
import com.will.weiyue.ui.news.NewsFragment;
import com.will.weiyue.ui.video.VideoFragment;
import com.will.weiyue.utils.StatusBarUtil;
import com.will.weiyue.widget.BottomBar;
import com.will.weiyue.widget.BottomBarTab;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.contentContainer)
    FrameLayout mContentContainer;
    @BindView(R.id.bottomBar)
    BottomBar mBottomBar;

    private SupportFragment[] mFragments = new SupportFragment[4];


    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initInjector(ApplicationComponent appComponent) {

    }

    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }


    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        StatusBarUtil.setTranslucentForImageViewInFragment(MainActivity.this, 0, null);
        if (savedInstanceState == null) {
            mFragments[0] = NewsFragment.newInstance();
            mFragments[1] = VideoFragment.newInstance();
            mFragments[2] = JanDanFragment.newInstance();
            mFragments[3] = PersonalFragment.newInstance();

            getSupportDelegate().loadMultipleRootFragment(R.id.contentContainer, 0,
                    mFragments[0],
                    mFragments[1],
                    mFragments[2],
                    mFragments[3]);
        } else {
            mFragments[0] = findFragment(NewsFragment.class);
            mFragments[1] = findFragment(VideoFragment.class);
            mFragments[2] = findFragment(JanDanFragment.class);
            mFragments[3] = findFragment(PersonalFragment.class);
        }

        mBottomBar.addItem(new BottomBarTab(this, R.drawable.ic_news, "新闻"))
                .addItem(new BottomBarTab(this, R.drawable.ic_video, "视频"))
                .addItem(new BottomBarTab(this, R.drawable.ic_jiandan, "煎蛋"))
                .addItem(new BottomBarTab(this, R.drawable.ic_my, "我的"));
        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                getSupportDelegate().showHideFragment(mFragments[position], mFragments[prePosition]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });

    }

    @Override
    public void initData() {

    }

    @Override
    public void onRetry() {

    }

    @Override
    public void onBackPressedSupport() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressedSupport();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

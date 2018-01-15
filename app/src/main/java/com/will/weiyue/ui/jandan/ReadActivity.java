package com.will.weiyue.ui.jandan;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.will.weiyue.R;
import com.will.weiyue.bean.FreshNewsArticleBean;
import com.will.weiyue.bean.FreshNewsBean;
import com.will.weiyue.component.ApplicationComponent;
import com.will.weiyue.net.BaseObserver;
import com.will.weiyue.net.JanDanApi;
import com.will.weiyue.net.RxSchedulers;
import com.will.weiyue.ui.base.BaseActivity;
import com.will.weiyue.utils.DateUtil;
import com.will.weiyue.utils.ImageLoaderUtil;
import com.will.weiyue.utils.StatusBarUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class ReadActivity extends BaseActivity {
    private static final String DATA = "data";
    @BindView(R.id.iv_logo)
    ImageView mIvTop;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_author)
    TextView mTvAuthor;
    @BindView(R.id.tv_excerpt)
    TextView mTvExcerpt;
    @BindView(R.id.wv_contnet)
    WebView mWebView;
    @BindView(R.id.progress_wheel)
    ProgressBar progressWheel;
    @BindView(R.id.ll_content)
    LinearLayout llContent;
    JanDanApi mJanDanApi;
    FreshNewsBean.PostsBean postsBean;
    FreshNewsArticleBean newsArticleBean;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.iv_share)
    ImageView mIvShare;
    @BindView(R.id.iv_comment)
    ImageView mIvComment;


    public static void launch(Context context, FreshNewsBean.PostsBean postsBean, View view) {
        Intent intent = new Intent(context, ReadActivity.class);
        intent.putExtra(DATA, postsBean);
        context.startActivity(intent);
//        context.startActivity(intent,
//                ActivityOptions.makeSceneTransitionAnimation((Activity) context, view, "topview").toBundle());
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_read;
    }

    @Override
    public void initInjector(ApplicationComponent appComponent) {
        mJanDanApi = appComponent.getJanDanApi();
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        StatusBarUtil.setTranslucentForImageView(this, StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA, getStateView());
        if (getIntent().getExtras() == null) return;
        postsBean = (FreshNewsBean.PostsBean) getIntent().getSerializableExtra(DATA);
        if (postsBean == null) return;

        mTvTitle.setText(postsBean.getTitle());
        mTvAuthor.setText(postsBean.getAuthor().getName()
                + "  "
                + DateUtil.getTimestampString(DateUtil.string2Date(postsBean.getDate(), "yyyy-MM-dd HH:mm:ss")));
        mTvExcerpt.setText(postsBean.getExcerpt());
        ImageLoaderUtil.LoadImage(this, postsBean.getCustom_fields().getThumb_c().get(0), mIvTop);
        showSuccess();
        setWebViewSetting();
    }

    @Override
    public void initData() {

    }

    @Override
    public void onRetry() {
        getData(postsBean.getId());
    }

    private void setWebViewSetting() {
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setAppCacheEnabled(true);
        mWebView.getSettings().setAllowFileAccessFromFileURLs(true);
        mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setVerticalScrollbarOverlay(false);
        mWebView.setHorizontalScrollBarEnabled(false);
        mWebView.setHorizontalScrollbarOverlay(false);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.loadUrl("file:///android_asset/jd/post_detail.html");
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                getData(postsBean.getId());
            }
        });
    }

    private void getData(int id) {
        mJanDanApi.getFreshNewsArticle(id)
                .compose(RxSchedulers.<FreshNewsArticleBean>applySchedulers())
                .compose(this.<FreshNewsArticleBean>bindToLifecycle())
                .subscribe(new BaseObserver<FreshNewsArticleBean>() {
                    @Override
                    public void onSuccess(final FreshNewsArticleBean articleBean) {
                        if (articleBean == null) {
                            showFaild();
                        } else {
                            newsArticleBean = articleBean;
                            mWebView.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressWheel.setVisibility(View.GONE);
                                    final String content = articleBean.getPost().getContent();
                                    String url = "javascript:show_content(\'" + content + "\')";
                                    mWebView.loadUrl(url);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(Throwable e) {
                        showFaild();
                    }
                });
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
    }


    @OnClick({R.id.iv_back, R.id.iv_share, R.id.iv_comment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_share:
                break;
            case R.id.iv_comment:
                break;
        }
    }
}

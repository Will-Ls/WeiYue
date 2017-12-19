package com.will.weiyue.ui.video.presenter;

import com.will.weiyue.bean.VideoChannelBean;
import com.will.weiyue.bean.VideoDetailBean;
import com.will.weiyue.net.NewsApi;
import com.will.weiyue.net.RxSchedulers;
import com.will.weiyue.ui.base.BasePresenter;
import com.will.weiyue.ui.video.contract.VideoContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/10 .
 */
public class VideoPresenter extends BasePresenter<VideoContract.View> implements VideoContract.Presenter {
    private NewsApi mNewsApi;

    @Inject
    VideoPresenter(NewsApi newsApi) {
        this.mNewsApi = newsApi;
    }

    @Override
    public void getVideoChannel() {
        mNewsApi.getVideoChannel()
                .compose(RxSchedulers.<List<VideoChannelBean>>applySchedulers())
                .compose(mView.<List<VideoChannelBean>>bindToLife())
                .subscribe(new Observer<List<VideoChannelBean>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<VideoChannelBean> channelBean) {
                        mView.loadVideoChannel(channelBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void getVideoDetails(final int page, String listType, String typeId) {
        mNewsApi.getVideoDetail(page, listType, typeId)
                .compose(RxSchedulers.<List<VideoDetailBean>>applySchedulers())
                .compose(mView.<List<VideoDetailBean>>bindToLife())
                .subscribe(new Observer<List<VideoDetailBean>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<VideoDetailBean> videoDetailBean) {
                        if (page > 1) {
                            mView.loadMoreVideoDetails(videoDetailBean);
                        } else {
                            mView.loadVideoDetails(videoDetailBean);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        // Log.i(TAG, "onError: "+e.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

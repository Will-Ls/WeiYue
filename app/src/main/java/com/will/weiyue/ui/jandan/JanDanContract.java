package com.will.weiyue.ui.jandan;

import com.will.weiyue.bean.FreshNewsBean;
import com.will.weiyue.bean.JdDetailBean;
import com.will.weiyue.ui.base.BaseContract;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public interface JanDanContract {

    interface View extends BaseContract.BaseView {

        void loadFreshNews(FreshNewsBean freshNewsBean);

        void loadMoreFreshNews(FreshNewsBean freshNewsBean);

        void loadDetailData(String type, JdDetailBean jdDetailBean);

        void loadMoreDetailData(String type, JdDetailBean jdDetailBean);

    }

    interface Presenter extends BaseContract.BasePresenter<View> {

        void getData(String type, int page);

        void getFreshNews(int page);

        void getDetailData(String type, int page);

    }
}

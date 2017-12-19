package com.will.weiyue.ui.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.will.weiyue.R;
import com.will.weiyue.bean.FreshNewsBean;
import com.will.weiyue.ui.jandan.ReadActivity;
import com.will.weiyue.utils.ImageLoaderUtil;

import java.util.List;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class FreshNewsAdapter extends BaseQuickAdapter<FreshNewsBean.PostsBean, BaseViewHolder> implements BaseQuickAdapter.OnItemClickListener {
    private Context mContext;

    public FreshNewsAdapter(Context context, @Nullable List<FreshNewsBean.PostsBean> data) {
        super(R.layout.item_freshnews, data);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, FreshNewsBean.PostsBean postsBean) {
        viewHolder.setText(R.id.tv_title, postsBean.getTitle());
        viewHolder.setText(R.id.tv_info, postsBean.getAuthor().getName());
        viewHolder.setText(R.id.tv_commnetsize, postsBean.getComment_count() + "评论");
        ImageLoaderUtil.LoadImage(mContext, postsBean.getCustom_fields().getThumb_c().get(0), (ImageView) viewHolder.getView(R.id.iv_logo));
        setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        View view1 = baseQuickAdapter.getViewByPosition(i,R.id.iv_logo);
        ReadActivity.launch(mContext, (FreshNewsBean.PostsBean) baseQuickAdapter.getItem(i),view1);
    }
}

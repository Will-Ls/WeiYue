package com.will.weiyue.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.will.weiyue.R;
import com.will.weiyue.bean.JdDetailBean;
import com.will.weiyue.utils.DateUtil;
import com.will.weiyue.utils.ShareUtils;

import java.util.List;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/31 .
 */
public class JokesAdapter extends BaseQuickAdapter<JdDetailBean.CommentsBean, BaseViewHolder> {

    public JokesAdapter(@Nullable List<JdDetailBean.CommentsBean> data) {
        super(R.layout.item_joke, data);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final JdDetailBean.CommentsBean commentsBean) {
        viewHolder.setText(R.id.tv_author, commentsBean.getComment_author())
                .setText(R.id.tv_time, DateUtil.getTimestampString(DateUtil.string2Date(commentsBean.getComment_date(), "yyyy-MM-dd HH:mm:ss")))
                .setText(R.id.tv_content, commentsBean.getText_content())
                .setText(R.id.tv_like, commentsBean.getVote_negative())
                .setText(R.id.tv_unlike, commentsBean.getVote_positive())
                .setText(R.id.tv_comment_count, commentsBean.getSub_comment_count());

        viewHolder.getView(R.id.img_share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareUtils.shareText(mContext, commentsBean.getText_content());
            }
        });
    }
}

package com.will.weiyue.ui.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.will.weiyue.MyApp;
import com.will.weiyue.R;
import com.will.weiyue.bean.JdDetailBean;
import com.will.weiyue.ui.jandan.ImageBrowseActivity;
import com.will.weiyue.utils.ContextUtils;
import com.will.weiyue.utils.DateUtil;
import com.will.weiyue.utils.ImageLoaderUtil;
import com.will.weiyue.utils.ShareUtils;
import com.will.weiyue.widget.MultiImageView;
import com.will.weiyue.widget.ShowMaxImageView;

import java.util.List;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class BoredPicAdapter extends BaseMultiItemQuickAdapter<JdDetailBean.CommentsBean, BaseViewHolder> {
    private static final String TAG = "BoredPicAdapter";
    private Activity mContext;

    public BoredPicAdapter(Activity context, @Nullable List<JdDetailBean.CommentsBean> data) {
        super(data);
        addItemType(JdDetailBean.CommentsBean.TYPE_MULTIPLE, R.layout.item_jandan_pic);
        addItemType(JdDetailBean.CommentsBean.TYPE_SINGLE, R.layout.item_jandan_pic_single);
        this.mContext = context;
    }

    @Override
    protected void convert(final BaseViewHolder viewHolder, final JdDetailBean.CommentsBean commentsBean) {
        viewHolder.setText(R.id.tv_author, commentsBean.getComment_author());

        if (!TextUtils.isEmpty(commentsBean.getComment_agent())){
            if (commentsBean.getComment_agent().contains("Android")) {
                viewHolder.setText(R.id.tv_from, "来自 Android 客户端");
                viewHolder.setVisible(R.id.tv_from, true);
            } else {
                viewHolder.setVisible(R.id.tv_from, false);
            }
        }else {
            viewHolder.setVisible(R.id.tv_from, false);
        }

        viewHolder.setText(R.id.tv_time, DateUtil.getTimestampString(DateUtil.string2Date(commentsBean.getComment_date(), "yyyy-MM-dd HH:mm:ss")));

        if (TextUtils.isEmpty(commentsBean.getText_content())) {
            viewHolder.setVisible(R.id.tv_content, false);
        } else {
            viewHolder.setVisible(R.id.tv_content, true);
            String content = commentsBean.getText_content().replace(" ", "").replace("\r", "").replace("\n", "");
            viewHolder.setText(R.id.tv_content, content);
            Log.i(TAG, "convert: author=" + commentsBean.getComment_author() + " content= " + commentsBean.getText_content());
        }

        viewHolder.setVisible(R.id.img_gif, commentsBean.getPics().get(0).contains("gif"));
        viewHolder.setVisible(R.id.progress, commentsBean.getPics().get(0).contains("gif"));
        viewHolder.setText(R.id.tv_like, commentsBean.getVote_negative());
        viewHolder.setText(R.id.tv_unlike, commentsBean.getVote_positive());
        viewHolder.setText(R.id.tv_comment_count, commentsBean.getSub_comment_count());
        viewHolder.addOnClickListener(R.id.img_share);

        switch (viewHolder.getItemViewType()) {
            case JdDetailBean.CommentsBean.TYPE_MULTIPLE:
                MultiImageView multiImageView = viewHolder.getView(R.id.img);
                viewHolder.setVisible(R.id.img_gif, false);
                multiImageView.setList(commentsBean.getPics());
                multiImageView.setOnItemClickListener(new MultiImageView.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String[] imageUrls = new String[commentsBean.getPics().size()];
                        for (int i = 0; i < commentsBean.getPics().size(); i++) {
                            imageUrls[i] = commentsBean.getPics().get(i);
                        }
                        ImageBrowseActivity.launch(mContext, imageUrls, position);
                    }
                });
                viewHolder.getView(R.id.img_share).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShareUtils.shareSingleImage(mContext, commentsBean.getPics().get(0));

                    }
                });
                break;
            case JdDetailBean.CommentsBean.TYPE_SINGLE:
                ShowMaxImageView imageView = viewHolder.getView(R.id.img);
                imageView.getLayoutParams().height = ContextUtils.dip2px(MyApp.getContext(), 250);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String[] imageUrls = new String[commentsBean.getPics().size()];
                        imageUrls[0] = commentsBean.getPics().get(0);
                        ImageBrowseActivity.launch(mContext, imageUrls, 0);
                    }
                });
                ImageLoaderUtil.LoadImage(mContext, commentsBean.getPics().get(0),
                        new DrawableImageViewTarget((ImageView) viewHolder.getView(R.id.img)) {
                            @Override
                            public void onResourceReady(Drawable resource, @Nullable Transition<? super Drawable> transition) {
                                super.onResourceReady(resource, transition);
                                int pmWidth = ContextUtils.getSreenWidth(MyApp.getContext());
                                int pmHeight = ContextUtils.getSreenHeight(MyApp.getContext());
                                float sal = (float) pmHeight / pmWidth;
                                int actualHeight = (int) Math.ceil(sal * resource.getIntrinsicWidth());
                                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, actualHeight);
                                viewHolder.getView(R.id.img).setLayoutParams(params);
                                viewHolder.setVisible(R.id.img_gif, false);
                            }
                        });
                viewHolder.getView(R.id.img_share).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShareUtils.shareText(mContext, "http://jandan.net/pic/");
                    }
                });
                break;
        }

    }

}

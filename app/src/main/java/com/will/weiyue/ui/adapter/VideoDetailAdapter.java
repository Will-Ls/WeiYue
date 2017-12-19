package com.will.weiyue.ui.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.will.weiyue.R;
import com.will.weiyue.bean.VideoDetailBean;
import com.will.weiyue.utils.ImageLoaderUtil;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCUserAction;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/10 .
 */
public class VideoDetailAdapter extends BaseQuickAdapter<VideoDetailBean.ItemBean, BaseViewHolder> {
    Context mContext;

    public VideoDetailAdapter(Context context, @LayoutRes int layoutResId, @Nullable List<VideoDetailBean.ItemBean> data) {
        super(layoutResId, data);
        this.mContext = context;
    }

    @Override
    protected void convert(final BaseViewHolder viewHolder, VideoDetailBean.ItemBean itemBean) {
        // viewHolder.setText(R.id.tv_title, itemBean.getTitle());
        JCVideoPlayerStandard jcVideoPlayerStandard = viewHolder.getView(R.id.videoplayer);
        jcVideoPlayerStandard.setUp(itemBean.getVideo_url()
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, itemBean.getTitle());
        JCVideoPlayer.setJcUserAction(new JCUserAction() {
            @Override
            public void onEvent(int type, String s, int i1, Object... objects) {
                switch (type) {
                    case JCUserAction.ON_CLICK_START_ICON:
                        viewHolder.getView(R.id.tv_videoduration).setVisibility(View.GONE);
                        break;
                }
            }
        });
        ImageLoaderUtil.LoadImage(mContext, itemBean.getImage(), jcVideoPlayerStandard.thumbImageView);

        viewHolder.setText(R.id.tv_videoduration, conversionTime(itemBean.getDuration()));
        if (!TextUtils.isEmpty(itemBean.getPlayTime())) {
            viewHolder.setText(R.id.tv_playtime, conversionPlayTime(Integer.valueOf(itemBean.getPlayTime())));
        }
    }

    private String conversionTime(int duration) {
        int minutes = duration / 60;
        int seconds = duration - minutes * 60;
        String m = sizeOf(minutes) > 1 ? String.valueOf(minutes) : "0" + minutes;
        String s = sizeOf(seconds) > 1 ? String.valueOf(seconds) : "0" + seconds;
        return m + ":" + s;
    }

    private String conversionPlayTime(int playtime) {
        if (sizeOf(playtime) > 4) {
            return accuracy(playtime, 10000, 1) + "万";
        } else {
            return String.valueOf(playtime);
        }
    }

    public static String accuracy(double num, double total, int digit) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        //可以设置精确几位小数
        df.setMaximumFractionDigits(digit);
        //模式 例如四舍五入
        df.setRoundingMode(RoundingMode.HALF_UP);
        double accuracy_num = num / total;
        return df.format(accuracy_num);
    }

    /**
     * 判断是几位数字
     *
     * @param size
     * @return
     */
    private int sizeOf(int size) {
        final int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999,
                99999999, 999999999, Integer.MAX_VALUE};
        for (int i = 0; ; i++)
            if (size <= sizeTable[i])
                return i + 1;
    }
}

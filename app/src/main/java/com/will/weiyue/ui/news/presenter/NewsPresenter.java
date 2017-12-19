package com.will.weiyue.ui.news.presenter;

import com.will.weiyue.MyApp;
import com.will.weiyue.R;
import com.will.weiyue.bean.Channel;
import com.will.weiyue.database.ChannelDao;
import com.will.weiyue.ui.base.BasePresenter;
import com.will.weiyue.ui.news.contract.NewsContract;

import org.litepal.crud.DataSupport;
import org.litepal.crud.callback.SaveCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/7 .
 */
public class NewsPresenter extends BasePresenter<NewsContract.View> implements NewsContract.Presenter {

    @Inject
    public NewsPresenter() {
    }

    @Override
    public void getChannel() {
        List<Channel> channelList;
        List<Channel> myChannels = new ArrayList<>();
        List<Channel> otherChannels = new ArrayList<>();
        channelList = ChannelDao.getChannels();
        if (channelList.size() < 1) {
            List<String> channelName = Arrays.asList(MyApp.getContext().getResources()
                    .getStringArray(R.array.news_channel));
            List<String> channelId = Arrays.asList(MyApp.getContext().getResources()
                    .getStringArray(R.array.news_channel_id));
            List<Channel> channels = new ArrayList<>();

            for (int i = 0; i < channelName.size(); i++) {
                Channel channel = new Channel();
                channel.setChannelId(channelId.get(i));
                channel.setChannelName(channelName.get(i));
                channel.setChannelType(i < 1 ? 1 : 0);
                channel.setChannelSelect(i < channelId.size() - 3);
                if (i < channelId.size() - 3) {
                    myChannels.add(channel);
                } else {
                    otherChannels.add(channel);
                }
                channels.add(channel);
            }

            DataSupport.saveAllAsync(channels).listen(new SaveCallback() {
                @Override
                public void onFinish(boolean success) {
                }
            });

            channelList = new ArrayList<>();
            channelList.addAll(channels);
        } else {
            channelList = ChannelDao.getChannels();
            Iterator<Channel> iterator = channelList.iterator();
            while (iterator.hasNext()) {
                Channel channel = iterator.next();
                if (!channel.isChannelSelect()) {
                    otherChannels.add(channel);
                    iterator.remove();
                }
            }
            myChannels.addAll(channelList);
        }
        mView.loadData(myChannels, otherChannels);
    }
}

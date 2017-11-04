package com.will.weiyue.database;

import com.will.weiyue.bean.Channel;

import org.litepal.crud.DataSupport;
import org.litepal.crud.callback.SaveCallback;
import org.litepal.crud.callback.UpdateOrDeleteCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/7 .
 */
public class ChannelDao {

    /**
     * 获取所有频道
     *
     * @return
     */
    public static List<Channel> getChannels() {
        return DataSupport.findAll(Channel.class);
    }


    /**
     * 保存所有频道
     *
     * @param channels
     */
    public static void saveChannels(final List<Channel> channels) {
        if (channels == null) return;
        if (channels.size() > 0) {
            final List<Channel> channelList = new ArrayList<>();
            channelList.addAll(channels);
            DataSupport.deleteAllAsync(Channel.class).listen(new UpdateOrDeleteCallback() {
                @Override
                public void onFinish(int rowsAffected) {
                    /**
                     * 因为model之前被存储过了，再次存储就存不进去了。
                     * 单个model调用一下clearSavedState方法就可以了，
                     * 集合的话调用markAsDeleted方法。
                     */
                    DataSupport.markAsDeleted(channelList);
                    DataSupport.saveAllAsync(channelList).listen(new SaveCallback() {
                        @Override
                        public void onFinish(boolean success) {

                        }
                    });
                }
            });
        }
    }

    /**
     * 清空所有频道
     */
    public static void cleanChanels() {
        DataSupport.deleteAll(Channel.class);
    }
}

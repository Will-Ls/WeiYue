package com.will.weiyue.bean;

import java.util.List;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/21 .
 */
public class NewsCmppVideoBean {

    private List<SingleVideoInfoBean> singleVideoInfo;

    public List<SingleVideoInfoBean> getSingleVideoInfo() {
        return singleVideoInfo;
    }

    public void setSingleVideoInfo(List<SingleVideoInfoBean> singleVideoInfo) {
        this.singleVideoInfo = singleVideoInfo;
    }

    public static class SingleVideoInfoBean {
        /**
         * videoURLLow : http://ips.ifeng.com/video19.ifeng.com/video09/2017/04/27/3373150-280-068-072537.mp4
         * videoURLMid : http://ips.ifeng.com/video19.ifeng.com/video09/2017/04/27/3373150-280-068-072537.mp4
         * videoSizeLow : 278
         * videoSizeMid : 278
         * videoURLHigh : http://ips.ifeng.com/video19.ifeng.com/video09/2017/04/27/3373150-102-009-072537.mp4
         * videoSizeHigh : 444
         * audioURL : http://ips.ifeng.com/video19.ifeng.com/video09/2017/04/27/3373150-535-066-072537.mp3
         * GUID : 01dfe20b-35ac-4c25-85e4-7ef16c291595
         * praise : 0
         * tread : 0
         * playTime : 5939
         * imgURL : http://d.ifengimg.com/w200_h150/p2.ifengimg.com/a/2017_29/49853f88e91c6c7.jpg
         * smallImgURL : http://d.ifengimg.com/w120_h90/p2.ifengimg.com/a/2017_29/49853f88e91c6c7.jpg
         * largeImgURL : http://d.ifengimg.com/w480_h360/p2.ifengimg.com/a/2017_29/49853f88e91c6c7.jpg
         * richText :
         * videoPublishTime : 2017-04-14 09:08:29
         * shareURL : http://share.iclient.ifeng.com/sharenews.f?guid=01dfe20b-35ac-4c25-85e4-7ef16c291595
         * commentsUrl : http://share.iclient.ifeng.com/sharenews.f?guid=01dfe20b-35ac-4c25-85e4-7ef16c291595
         * type : phvideo
         * id :
         * statisticID : 81-84
         * title : 健身达人演示腹肌最强训练
         * videoLength : 00:00:07
         * longTitle : 健身达人演示腹肌最强训练
         * columnName : 好身材练出来
         * CP : 今日头条
         * collect :
         * lastPlayedTime :
         * status : 1
         * columnId : 8421
         * weMedia : {"headPic":"http://p2.ifengimg.com/ifengimcp/pic/20160804/5e302c40fd343f6915c5_size32_w200_h200.jpg","name":"好身材练出来","desc":"腹肌，人鱼线，马甲线统统都是这样练出来的","id":"8421","type":"normal"}
         * newStatus : 0
         */

        private String videoURLLow;
        private String videoURLMid;
        private int videoSizeLow;
        private int videoSizeMid;
        private String videoURLHigh;
        private int videoSizeHigh;
        private String audioURL;
        private String GUID;
        private String praise;
        private String tread;
        private String playTime;
        private String imgURL;
        private String smallImgURL;
        private String largeImgURL;
        private String richText;
        private String videoPublishTime;
        private String shareURL;
        private String commentsUrl;
        private String type;
        private String id;
        private String statisticID;
        private String title;
        private String videoLength;
        private String longTitle;
        private String columnName;
        private String CP;
        private String collect;
        private String lastPlayedTime;
        private int status;
        private String columnId;
        private WeMediaBean weMedia;
        private String newStatus;

        public String getVideoURLLow() {
            return videoURLLow;
        }

        public void setVideoURLLow(String videoURLLow) {
            this.videoURLLow = videoURLLow;
        }

        public String getVideoURLMid() {
            return videoURLMid;
        }

        public void setVideoURLMid(String videoURLMid) {
            this.videoURLMid = videoURLMid;
        }

        public int getVideoSizeLow() {
            return videoSizeLow;
        }

        public void setVideoSizeLow(int videoSizeLow) {
            this.videoSizeLow = videoSizeLow;
        }

        public int getVideoSizeMid() {
            return videoSizeMid;
        }

        public void setVideoSizeMid(int videoSizeMid) {
            this.videoSizeMid = videoSizeMid;
        }

        public String getVideoURLHigh() {
            return videoURLHigh;
        }

        public void setVideoURLHigh(String videoURLHigh) {
            this.videoURLHigh = videoURLHigh;
        }

        public int getVideoSizeHigh() {
            return videoSizeHigh;
        }

        public void setVideoSizeHigh(int videoSizeHigh) {
            this.videoSizeHigh = videoSizeHigh;
        }

        public String getAudioURL() {
            return audioURL;
        }

        public void setAudioURL(String audioURL) {
            this.audioURL = audioURL;
        }

        public String getGUID() {
            return GUID;
        }

        public void setGUID(String GUID) {
            this.GUID = GUID;
        }

        public String getPraise() {
            return praise;
        }

        public void setPraise(String praise) {
            this.praise = praise;
        }

        public String getTread() {
            return tread;
        }

        public void setTread(String tread) {
            this.tread = tread;
        }

        public String getPlayTime() {
            return playTime;
        }

        public void setPlayTime(String playTime) {
            this.playTime = playTime;
        }

        public String getImgURL() {
            return imgURL;
        }

        public void setImgURL(String imgURL) {
            this.imgURL = imgURL;
        }

        public String getSmallImgURL() {
            return smallImgURL;
        }

        public void setSmallImgURL(String smallImgURL) {
            this.smallImgURL = smallImgURL;
        }

        public String getLargeImgURL() {
            return largeImgURL;
        }

        public void setLargeImgURL(String largeImgURL) {
            this.largeImgURL = largeImgURL;
        }

        public String getRichText() {
            return richText;
        }

        public void setRichText(String richText) {
            this.richText = richText;
        }

        public String getVideoPublishTime() {
            return videoPublishTime;
        }

        public void setVideoPublishTime(String videoPublishTime) {
            this.videoPublishTime = videoPublishTime;
        }

        public String getShareURL() {
            return shareURL;
        }

        public void setShareURL(String shareURL) {
            this.shareURL = shareURL;
        }

        public String getCommentsUrl() {
            return commentsUrl;
        }

        public void setCommentsUrl(String commentsUrl) {
            this.commentsUrl = commentsUrl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStatisticID() {
            return statisticID;
        }

        public void setStatisticID(String statisticID) {
            this.statisticID = statisticID;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(String videoLength) {
            this.videoLength = videoLength;
        }

        public String getLongTitle() {
            return longTitle;
        }

        public void setLongTitle(String longTitle) {
            this.longTitle = longTitle;
        }

        public String getColumnName() {
            return columnName;
        }

        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }

        public String getCP() {
            return CP;
        }

        public void setCP(String CP) {
            this.CP = CP;
        }

        public String getCollect() {
            return collect;
        }

        public void setCollect(String collect) {
            this.collect = collect;
        }

        public String getLastPlayedTime() {
            return lastPlayedTime;
        }

        public void setLastPlayedTime(String lastPlayedTime) {
            this.lastPlayedTime = lastPlayedTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getColumnId() {
            return columnId;
        }

        public void setColumnId(String columnId) {
            this.columnId = columnId;
        }

        public WeMediaBean getWeMedia() {
            return weMedia;
        }

        public void setWeMedia(WeMediaBean weMedia) {
            this.weMedia = weMedia;
        }

        public String getNewStatus() {
            return newStatus;
        }

        public void setNewStatus(String newStatus) {
            this.newStatus = newStatus;
        }

        public static class WeMediaBean {
            /**
             * headPic : http://p2.ifengimg.com/ifengimcp/pic/20160804/5e302c40fd343f6915c5_size32_w200_h200.jpg
             * name : 好身材练出来
             * desc : 腹肌，人鱼线，马甲线统统都是这样练出来的
             * id : 8421
             * type : normal
             */

            private String headPic;
            private String name;
            private String desc;
            private String id;
            private String type;

            public String getHeadPic() {
                return headPic;
            }

            public void setHeadPic(String headPic) {
                this.headPic = headPic;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}

package com.will.weiyue.bean;

import java.util.List;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/10 .
 */
public class VideoDetailBean {

    /**
     * totalPage : 2863
     * currentPage : 1
     * type : list
     * item : [{"documentId":"video_611796","title":"狂甩陈伟霆 刘奕君逆袭成主角？","image":"http://d.ifengimg.com/w640_h360_q80/p0.ifengimg.com/pmop/2017/07/24/40f7fad4-b6a4-4d88-989f-a99eced358e5.jpg","thumbnail":"http://d.ifengimg.com/w132_h94_q80/p0.ifengimg.com/pmop/2017/07/24/40f7fad4-b6a4-4d88-989f-a99eced358e5.jpg","guid":"656e107c-fe02-4c11-8ce8-d7de1111cf8c","type":"phvideo","commentsall":0,"duration":107,"shareUrl":"http://share.iclient.ifeng.com/sharenews.f?guid=656e107c-fe02-4c11-8ce8-d7de1111cf8c","commentsUrl":"http://share.iclient.ifeng.com/sharenews.f?guid=656e107c-fe02-4c11-8ce8-d7de1111cf8c","video_url":"http://ips.ifeng.com/video19.ifeng.com/video09/2017/07/24/5081903-102-9987619-095153.mp4","video_size":7184,"praise":"0","tread":"0","playTime":"6572"}]
     */

    private int totalPage;
    private String currentPage;
    private String type;
    private List<ItemBean> item;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ItemBean> getItem() {
        return item;
    }

    public void setItem(List<ItemBean> item) {
        this.item = item;
    }

    public static class ItemBean {
        /**
         * documentId : video_611796
         * title : 狂甩陈伟霆 刘奕君逆袭成主角？
         * image : http://d.ifengimg.com/w640_h360_q80/p0.ifengimg.com/pmop/2017/07/24/40f7fad4-b6a4-4d88-989f-a99eced358e5.jpg
         * thumbnail : http://d.ifengimg.com/w132_h94_q80/p0.ifengimg.com/pmop/2017/07/24/40f7fad4-b6a4-4d88-989f-a99eced358e5.jpg
         * guid : 656e107c-fe02-4c11-8ce8-d7de1111cf8c
         * type : phvideo
         * commentsall : 0
         * duration : 107
         * shareUrl : http://share.iclient.ifeng.com/sharenews.f?guid=656e107c-fe02-4c11-8ce8-d7de1111cf8c
         * commentsUrl : http://share.iclient.ifeng.com/sharenews.f?guid=656e107c-fe02-4c11-8ce8-d7de1111cf8c
         * video_url : http://ips.ifeng.com/video19.ifeng.com/video09/2017/07/24/5081903-102-9987619-095153.mp4
         * video_size : 7184
         * praise : 0
         * tread : 0
         * playTime : 6572
         */

        private String documentId;
        private String title;
        private String image;
        private String thumbnail;
        private String guid;
        private String type;
        private int commentsall;
        private int duration;
        private String shareUrl;
        private String commentsUrl;
        private String video_url;
        private int video_size;
        private String praise;
        private String tread;
        private String playTime;

        public String getDocumentId() {
            return documentId;
        }

        public void setDocumentId(String documentId) {
            this.documentId = documentId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getCommentsall() {
            return commentsall;
        }

        public void setCommentsall(int commentsall) {
            this.commentsall = commentsall;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }

        public String getCommentsUrl() {
            return commentsUrl;
        }

        public void setCommentsUrl(String commentsUrl) {
            this.commentsUrl = commentsUrl;
        }

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public int getVideo_size() {
            return video_size;
        }

        public void setVideo_size(int video_size) {
            this.video_size = video_size;
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
    }
}

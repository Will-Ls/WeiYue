package com.will.weiyue.bean;

import java.util.List;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/19 .
 */
public class VideoChannelBean {


    /**
     * types : [{"id":9,"name":"娱乐","chType":"video","position":"down"},{"id":18,"name":"美食","chType":"video","position":"down"},{"id":22,"name":"锵锵三人行","chType":"video","position":"down"},{"id":5,"name":"军事","chType":"video","position":"up"},{"id":24,"name":"综艺","chType":"video","position":"up"},{"id":10,"name":"体育","chType":"video","position":"up"},{"id":8,"name":"生活","chType":"video","position":"up"},{"id":25,"name":"纪录片","chType":"video","position":"up"},{"id":4,"name":"社会","chType":"video","position":"up"},{"id":27,"name":"萌萌哒","chType":"video","position":"up"},{"id":2,"name":"段子","chType":"video","position":"down"},{"id":3,"name":"历史","chType":"video","position":"up"},{"id":1,"name":"美女","chType":"video","position":"down"},{"id":23,"name":"鲁豫有约 ","chType":"video","position":"down"}]
     * totalPage : 20
     * currentPage : 1
     * type : list
     * item : [{"documentId":"video_01bd4842-0410-493f-8f46-500c60663578","title":"美日等4国媒体妄称中国间谍船靠近 中方少将怒了","image":"http://d.ifengimg.com/w640_h360_q80/p2.ifengimg.com/a/2017_30/5187db499a933ad.jpg","thumbnail":"http://d.ifengimg.com/w132_h94_q80/p2.ifengimg.com/a/2017_30/5187db499a933ad.jpg","guid":"01bd4842-0410-493f-8f46-500c60663578","type":"phvideo","duration":115,"shareUrl":"http://share.iclient.ifeng.com/sharenews.f?guid=01bd4842-0410-493f-8f46-500c60663578","commentsUrl":"http://share.iclient.ifeng.com/sharenews.f?guid=01bd4842-0410-493f-8f46-500c60663578","video_url":"http://ips.ifeng.com/video19.ifeng.com/video09/2017/07/25/4710314-102-008-0939.mp4","video_size":7731,"praise":"33","tread":"30","playTime":"55296","commentsall":34}]
     */

    private int totalPage;
    private String currentPage;
    private String type;
    private List<TypesBean> types;
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

    public List<TypesBean> getTypes() {
        return types;
    }

    public void setTypes(List<TypesBean> types) {
        this.types = types;
    }

    public List<ItemBean> getItem() {
        return item;
    }

    public void setItem(List<ItemBean> item) {
        this.item = item;
    }

    public static class TypesBean {
        /**
         * id : 9
         * name : 娱乐
         * chType : video
         * position : down
         */

        private int id;
        private String name;
        private String chType;
        private String position;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getChType() {
            return chType;
        }

        public void setChType(String chType) {
            this.chType = chType;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class ItemBean {
        /**
         * documentId : video_01bd4842-0410-493f-8f46-500c60663578
         * title : 美日等4国媒体妄称中国间谍船靠近 中方少将怒了
         * image : http://d.ifengimg.com/w640_h360_q80/p2.ifengimg.com/a/2017_30/5187db499a933ad.jpg
         * thumbnail : http://d.ifengimg.com/w132_h94_q80/p2.ifengimg.com/a/2017_30/5187db499a933ad.jpg
         * guid : 01bd4842-0410-493f-8f46-500c60663578
         * type : phvideo
         * duration : 115
         * shareUrl : http://share.iclient.ifeng.com/sharenews.f?guid=01bd4842-0410-493f-8f46-500c60663578
         * commentsUrl : http://share.iclient.ifeng.com/sharenews.f?guid=01bd4842-0410-493f-8f46-500c60663578
         * video_url : http://ips.ifeng.com/video19.ifeng.com/video09/2017/07/25/4710314-102-008-0939.mp4
         * video_size : 7731
         * praise : 33
         * tread : 30
         * playTime : 55296
         * commentsall : 34
         */

        private String documentId;
        private String title;
        private String image;
        private String thumbnail;
        private String guid;
        private String type;
        private int duration;
        private String shareUrl;
        private String commentsUrl;
        private String video_url;
        private int video_size;
        private String praise;
        private String tread;
        private String playTime;
        private int commentsall;

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

        public int getCommentsall() {
            return commentsall;
        }

        public void setCommentsall(int commentsall) {
            this.commentsall = commentsall;
        }
    }
}

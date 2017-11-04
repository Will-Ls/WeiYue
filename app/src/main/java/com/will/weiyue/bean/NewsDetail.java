package com.will.weiyue.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;
import java.util.List;

public class NewsDetail implements Serializable {

    @Override
    public String toString() {
        return "NewsDetail{" +
                "listId='" + listId + '\'' +
                ", type='" + type + '\'' +
                ", expiredTime=" + expiredTime +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", topsize=" + topsize +
                ", item=" + item +
                '}';
    }

    /**
     * listId : SYLB10NEW_DOWN
     * type : list
     * expiredTime : 180000
     * currentPage : 1
     * totalPage : 1
     * topsize : 0
     * item : [{"type":"doc","thumbnail":"http://d.ifengimg.com/w198_h141_q100/p2.ifengimg.com/cmpp/2017/07/03/a9e21d53672c5b16db9c19359e498fb3_size44_w168_h120.jpg","online":"1","title":"民政部：强降雨致南方8省48人死亡失踪 近千万人受灾","showType":"0","source":"央视网","subscribe":{"cateid":"央视网","type":"source","catename":"央视网","description":""},"updateTime":"2017/07/03 17:12:53","id":"http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_034470051364453&channelKey=Y21wcF8xNzAwN183MTlfNzU=&channelid=SYLB10NEW_DOWN","documentId":"cmpp_034470051364453","staticId":"cmpp_034470051364453","style":{"backreason":["来源:央视网","内容质量差","旧闻、重复","标题党"],"view":"titleimg"},"commentsUrl":"http://news.ifeng.com/a/20170703/51364453_0.shtml","comments":"30","commentsall":"154","link":{"type":"doc","url":"http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_034470051364453&channelKey=Y21wcF8xNzAwN183MTlfNzU=&channelid=SYLB10NEW_DOWN","weburl":"http://share.iclient.ifeng.com/sharenews.f?aid=034470051364453"},"simId":"clusterId_13026763","reftype":"editor","recomToken":"788bebb2-3423-4301-a4d5-df1818b7012b"},{"type":"slide","thumbnail":"http://d.ifengimg.com/w698_h392_q100/p2.ifengimg.com/cmpp/2017/07/03/81fc850007f7f8648062409c573b6523_size450_w640_h360.jpg","online":"1","title":"辣妈大S任性追自由 香肩纹大朵刺青酷劲十足","showType":"1","source":"凤凰网娱乐","subscribe":{"cateid":"凤凰网娱乐","type":"source","catename":"凤凰网娱乐","description":""},"updateTime":"2017/07/03 14:43:32","id":"http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_010230042953136","documentId":"cmpp_010230042953136","staticId":"cmpp_010230042953136","style":{"backreason":["来源:凤凰网娱乐","标题党","旧闻、重复","内容质量差"],"type":"slides","images":["http://d.ifengimg.com/w155_h107_q100/p3.ifengimg.com/a/2017_27/f4e43f8d255d2a8_size198_w525_h700.jpg","http://d.ifengimg.com/w155_h107_q100/p2.ifengimg.com/a/2017_27/15749026b372a55_size195_w525_h700.jpg","http://d.ifengimg.com/w155_h107_q100/p2.ifengimg.com/a/2017_27/a3e29893efab3c2_size195_w663_h700.jpg","http://d.ifengimg.com/w155_h107_q100/p3.ifengimg.com/a/2017_27/23fa52500f2daf3_size199_w525_h700.jpg","http://d.ifengimg.com/w155_h107_q100/p2.ifengimg.com/a/2017_27/7a3bd08fb4ef434_size196_w525_h700.jpg"],"view":"bigimg"},"hasSlide":true,"commentsUrl":"http://ent.ifeng.com/a/20170703/42953136_0.shtml","comments":"345","commentsall":"2986","link":{"type":"slide","url":"http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_010230042953136","weburl":"http://share.iclient.ifeng.com/sharenews.f?aid=cmpp_010230042953136"},"simId":"clusterId_13575422","reftype":"remcommend","recomToken":"f762fdf3-a6b0-484d-99eb-d18686bc5c2c"},{"type":"doc","thumbnail":"http://d.ifengimg.com/w198_h141_q100/p0.ifengimg.com/pmop/2017/0703/7E226575379CDEBC6AF0B402475D961E0390C317_size136_w960_h1280.jpeg","online":"1","title":"杭州地铁二号线西北段开通 今天杭州空气好呆了","source":"图释世界","subscribe":{"cateid":"图释世界","type":"source","catename":"图释世界","description":""},"updateTime":"2017/07/03 18:01:13","id":"http://api.iclient.ifeng.com/api_vampire_article_detail?aid=sub_20920617&channelid=SYLB10NEW_DOWN","documentId":"sub_20920617","staticId":"sub_20920617","style":{"backreason":["来源:图释世界","标题党","旧闻、重复","内容质量差"],"view":"titleimg"},"commentsUrl":"sub_20920617","comments":"0","commentsall":"0","link":{"type":"doc","url":"http://api.iclient.ifeng.com/api_vampire_article_detail?aid=sub_20920617&channelid=SYLB10NEW_DOWN","weburl":"http://share.iclient.ifeng.com/vampire/sharenews.f?fromType=vampire&aid=sub_20920617"},"simId":"clusterId_6444291","reftype":"remcommend","recomToken":"10a0b4c9-9d83-4a17-aef9-55e4ee60a711"},{"type":"doc","thumbnail":"http://d.ifengimg.com/w198_h141_q100/y1.ifengimg.com/yidian/2015_01/7bae180c1bd0928_w366_h178.jpg","online":"1","title":"全记住，你就是老中医！一定收藏了，经常翻翻哦","showType":"0","source":"妈咪微社区","subscribe":{"cateid":"妈咪微社区","type":"source","catename":"妈咪微社区","description":""},"updateTime":"2017/07/03 18:12:00","id":"http://api.3g.ifeng.com/ipadtestdoc?aid=imcp_123780076&perfectNew=1","documentId":"imcp_123780076","staticId":"imcp_123780076","style":{"backreason":["来源:妈咪微社区","标题党","旧闻、重复","内容质量差"],"view":"titleimg"},"commentsUrl":"http://t.ifeng.com/appshare/20156817.shtml","comments":"50","commentsall":"141","link":{"type":"doc","url":"http://api.3g.ifeng.com/ipadtestdoc?aid=imcp_123780076&perfectNew=1","weburl":"http://share.iclient.ifeng.com/sharenews.f?aid=123780076"},"simId":"clusterId_1525528","reftype":"remcommend","recomToken":"a0875d00-399b-4c68-abec-83d2f9532608"},{"type":"doc","thumbnail":"","online":"1","title":"解决孩子上课走神的好方法，99%的家长不知道","showType":"0","source":"一年级学习","subscribe":{"cateid":"一年级学习","type":"source","catename":"一年级学习","description":""},"updateTime":"2017/07/03 03:05:18","id":"http://api.3g.ifeng.com/ipadtestdoc?aid=imcp_123368785&perfectNew=1","documentId":"imcp_123368785","staticId":"imcp_123368785","style":{"backreason":["来源:一年级学习","标题党","旧闻、重复","内容质量差"],"view":"singletitle"},"commentsUrl":"http://t.ifeng.com/appshare/19333806.shtml","comments":"7","commentsall":"11","link":{"type":"doc","url":"http://api.3g.ifeng.com/ipadtestdoc?aid=imcp_123368785&perfectNew=1","weburl":"http://share.iclient.ifeng.com/sharenews.f?aid=123368785"},"simId":"clusterId_2009480","reftype":"remcommend","recomToken":"fcd496ec-18ef-4c1e-97e3-244b868ddb80"},{"type":"doc","thumbnail":"http://d.ifengimg.com/w198_h141_q100/p0.ifengimg.com/pmop/2017/0703/8BAC48FC56928173D4D7035F297A9D47D324F079_size29_w640_h450.jpeg","online":"1","title":"妄想对中国先发制人打击！其盟友一句话令其坐卧不安","source":"大国之翼","subscribe":{"cateid":"大国之翼","type":"source","catename":"大国之翼","description":""},"updateTime":"2017/07/03 12:47:18","id":"http://api.iclient.ifeng.com/api_vampire_article_detail?aid=sub_20878465&channelid=SYLB10NEW_DOWN","documentId":"sub_20878465","staticId":"sub_20878465","style":{"backreason":["来源:大国之翼","标题党","旧闻、重复","内容质量差"],"view":"titleimg"},"commentsUrl":"sub_20878465","comments":"38","commentsall":"81","link":{"type":"doc","url":"http://api.iclient.ifeng.com/api_vampire_article_detail?aid=sub_20878465&channelid=SYLB10NEW_DOWN","weburl":"http://share.iclient.ifeng.com/vampire/sharenews.f?fromType=vampire&aid=sub_20878465"},"simId":"clusterId_13568896","reftype":"remcommend","recomToken":"0921934c-ff0e-42f8-8d5e-0625254217cc"},{"type":"doc","thumbnail":"http://d.ifengimg.com/w198_h141_q100/p0.ifengimg.com/pmop/2017/0703/46C840C267493503F2C9BBBD2238424A22B5998E_size8_w355_h353.jpeg","online":"1","title":"风云突变 俄防空导弹击落一美军机","source":"军事风云会","subscribe":{"cateid":"军事风云会","type":"source","catename":"军事风云会","description":""},"updateTime":"2017/07/03 06:43:20","id":"http://api.iclient.ifeng.com/api_vampire_article_detail?aid=sub_20832968&channelid=SYLB10NEW_DOWN","documentId":"sub_20832968","staticId":"sub_20832968","style":{"backreason":["来源:军事风云会","标题党","旧闻、重复","内容质量差"],"view":"titleimg"},"commentsUrl":"sub_20832968","comments":"73","commentsall":"332","link":{"type":"doc","url":"http://api.iclient.ifeng.com/api_vampire_article_detail?aid=sub_20832968&channelid=SYLB10NEW_DOWN","weburl":"http://share.iclient.ifeng.com/vampire/sharenews.f?fromType=vampire&aid=sub_20832968"},"simId":"clusterId_13014831","reftype":"remcommend","recomToken":"e90b899f-c42d-44d5-8340-80fa35882d97"},{"type":"doc","thumbnail":"http://d.ifengimg.com/w198_h141_q100/p0.ifengimg.com/pmop/2017/0630/EFEF6D987B0B9F3F2006A65331848D3F594C2E6C_size28_w381_h327.jpeg","online":"1","title":"这次决不能再忍：美国触及红线再发杀招，中国需要行动！","source":"第一军情1","subscribe":{"cateid":"第一军情1","type":"source","catename":"第一军情1","description":""},"updateTime":"2017/06/30 22:39:38","id":"http://api.iclient.ifeng.com/api_vampire_article_detail?aid=sub_20661529&channelid=SYLB10NEW_DOWN","documentId":"sub_20661529","staticId":"sub_20661529","style":{"backreason":["来源:第一军情1","标题党","旧闻、重复","内容质量差"],"view":"titleimg"},"commentsUrl":"sub_20661529","comments":"670","commentsall":"3043","link":{"type":"doc","url":"http://api.iclient.ifeng.com/api_vampire_article_detail?aid=sub_20661529&channelid=SYLB10NEW_DOWN","weburl":"http://share.iclient.ifeng.com/vampire/sharenews.f?fromType=vampire&aid=sub_20661529"},"simId":"clusterId_13465905","reftype":"remcommend","recomToken":"8cdccb03-1d48-45bd-8f84-df28ee4938ec"},{"type":"doc","thumbnail":"http://d.ifengimg.com/w198_h141_q100/p0.ifengimg.com/pmop/2017/0525/36D2B7BFE5DC1208F4653F709F556635BB05C7E6_size28_w640_h301.jpeg","online":"1","title":"西瓜为什么不能用勺子挖着吃？还不赶紧看看！","source":"半岛晨报","subscribe":{"cateid":"半岛晨报","type":"source","catename":"半岛晨报","description":""},"updateTime":"2017/07/03 15:40:49","id":"http://api.iclient.ifeng.com/api_vampire_article_detail?aid=sub_16702777&channelid=SYLB10NEW_DOWN","documentId":"sub_16702777","staticId":"sub_16702777","style":{"backreason":["来源:半岛晨报","标题党","旧闻、重复","内容质量差"],"view":"titleimg"},"commentsUrl":"sub_16702777","comments":"0","commentsall":"0","link":{"type":"doc","url":"http://api.iclient.ifeng.com/api_vampire_article_detail?aid=sub_16702777&channelid=SYLB10NEW_DOWN","weburl":"http://share.iclient.ifeng.com/vampire/sharenews.f?fromType=vampire&aid=sub_16702777"},"simId":"clusterId_7654467","reftype":"remcommend","recomToken":"824920d9-e6f9-4150-927a-33d02e94fd80"}]
     */


    private String listId;
    private String type;
    private int expiredTime;
    private int currentPage;
    private int totalPage;
    private int topsize;
    private List<ItemBean> item;

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(int expiredTime) {
        this.expiredTime = expiredTime;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTopsize() {
        return topsize;
    }

    public void setTopsize(int topsize) {
        this.topsize = topsize;
    }

    public List<ItemBean> getItem() {
        return item;
    }

    public void setItem(List<ItemBean> item) {
        this.item = item;
    }

    public static class ItemBean implements Serializable, MultiItemEntity {
        //广告类型
        public static final int TYPE_ADVERT_TITLEIMG = 1;

        public static final int TYPE_ADVERT_SLIDEIMG = 2;

        public static final int TYPE_ADVERT_LONGIMG = 3;
        //图片类型
        public static final int TYPE_SLIDE = 4;
        //视频类型
        public static final int TYPE_PHVIDEO = 5;

        //显示形式单图
        public static final int TYPE_DOC_TITLEIMG = 6;
        //显示形式多图
        public static final int TYPE_DOC_SLIDEIMG = 7;


        @Override
        public String toString() {
            return "ItemBean{" +
                    "type='" + type + '\'' +
                    ", thumbnail='" + thumbnail + '\'' +
                    ", online='" + online + '\'' +
                    ", title='" + title + '\'' +
                    ", showType='" + showType + '\'' +
                    ", source='" + source + '\'' +
                    ", subscribe=" + subscribe +
                    ", updateTime='" + updateTime + '\'' +
                    ", id='" + id + '\'' +
                    ", documentId='" + documentId + '\'' +
                    ", staticId='" + staticId + '\'' +
                    ", style=" + style +
                    ", commentsUrl='" + commentsUrl + '\'' +
                    ", comments='" + comments + '\'' +
                    ", commentsall='" + commentsall + '\'' +
                    ", link=" + link +
                    ", simId='" + simId + '\'' +
                    ", reftype='" + reftype + '\'' +
                    ", recomToken='" + recomToken + '\'' +
                    ", hasSlide=" + hasSlide +
                    '}';
        }

        /**
         * type : doc
         * thumbnail : http://d.ifengimg.com/w198_h141_q100/p2.ifengimg.com/cmpp/2017/07/03/a9e21d53672c5b16db9c19359e498fb3_size44_w168_h120.jpg
         * online : 1
         * title : 民政部：强降雨致南方8省48人死亡失踪 近千万人受灾
         * showType : 0
         * source : 央视网
         * subscribe : {"cateid":"央视网","type":"source","catename":"央视网","description":""}
         * updateTime : 2017/07/03 17:12:53
         * id : http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_034470051364453&channelKey=Y21wcF8xNzAwN183MTlfNzU=&channelid=SYLB10NEW_DOWN
         * documentId : cmpp_034470051364453
         * staticId : cmpp_034470051364453
         * style : {"backreason":["来源:央视网","内容质量差","旧闻、重复","标题党"],"view":"titleimg"}
         * commentsUrl : http://news.ifeng.com/a/20170703/51364453_0.shtml
         * comments : 30
         * commentsall : 154
         * link : {"type":"doc","url":"http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_034470051364453&channelKey=Y21wcF8xNzAwN183MTlfNzU=&channelid=SYLB10NEW_DOWN","weburl":"http://share.iclient.ifeng.com/sharenews.f?aid=034470051364453"}
         * simId : clusterId_13026763
         * reftype : editor
         * recomToken : 788bebb2-3423-4301-a4d5-df1818b7012b
         * hasSlide : true
         */

        @Override
        public int getItemType() {
            return itemType;
        }

        public int itemType;
        private String type;
        private String thumbnail;
        private String online;
        private String title;
        private String showType;
        private String source;
        private SubscribeBean subscribe;
        private String updateTime;
        private String id;
        private String documentId;
        private String staticId;
        private StyleBean style;
        private String commentsUrl;
        private String comments;
        private String commentsall;
        private LinkBean link;
        private String simId;
        private String reftype;
        private String recomToken;
        private boolean hasSlide;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getOnline() {
            return online;
        }

        public void setOnline(String online) {
            this.online = online;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getShowType() {
            return showType;
        }

        public void setShowType(String showType) {
            this.showType = showType;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public SubscribeBean getSubscribe() {
            return subscribe;
        }

        public void setSubscribe(SubscribeBean subscribe) {
            this.subscribe = subscribe;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDocumentId() {
            return documentId;
        }

        public void setDocumentId(String documentId) {
            this.documentId = documentId;
        }

        public String getStaticId() {
            return staticId;
        }

        public void setStaticId(String staticId) {
            this.staticId = staticId;
        }

        public StyleBean getStyle() {
            return style;
        }

        public void setStyle(StyleBean style) {
            this.style = style;
        }

        public String getCommentsUrl() {
            return commentsUrl;
        }

        public void setCommentsUrl(String commentsUrl) {
            this.commentsUrl = commentsUrl;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        public String getCommentsall() {
            return commentsall;
        }

        public void setCommentsall(String commentsall) {
            this.commentsall = commentsall;
        }

        public LinkBean getLink() {
            return link;
        }

        public void setLink(LinkBean link) {
            this.link = link;
        }

        public String getSimId() {
            return simId;
        }

        public void setSimId(String simId) {
            this.simId = simId;
        }

        public String getReftype() {
            return reftype;
        }

        public void setReftype(String reftype) {
            this.reftype = reftype;
        }

        public String getRecomToken() {
            return recomToken;
        }

        public void setRecomToken(String recomToken) {
            this.recomToken = recomToken;
        }

        public boolean isHasSlide() {
            return hasSlide;
        }

        public void setHasSlide(boolean hasSlide) {
            this.hasSlide = hasSlide;
        }

        public static class SubscribeBean {
            @Override
            public String toString() {
                return "SubscribeBean{" +
                        "cateid='" + cateid + '\'' +
                        ", type='" + type + '\'' +
                        ", catename='" + catename + '\'' +
                        ", description='" + description + '\'' +
                        '}';
            }

            /**
             * cateid : 央视网
             * type : source
             * catename : 央视网
             * description :
             */


            private String cateid;
            private String type;
            private String catename;
            private String description;

            public String getCateid() {
                return cateid;
            }

            public void setCateid(String cateid) {
                this.cateid = cateid;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getCatename() {
                return catename;
            }

            public void setCatename(String catename) {
                this.catename = catename;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }

        public static class StyleBean {
            @Override
            public String toString() {
                return "StyleBean{" +
                        "view='" + view + '\'' +
                        ", backreason=" + backreason +
                        ", images=" + images +
                        '}';
            }

            /**
             * backreason : ["来源:央视网","内容质量差","旧闻、重复","标题党"]
             * view : titleimg
             */


            private String view;
            private List<String> backreason;
            private List<String> images;

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }

            public String getView() {
                return view;
            }

            public void setView(String view) {
                this.view = view;
            }

            public List<String> getBackreason() {
                return backreason;
            }

            public void setBackreason(List<String> backreason) {
                this.backreason = backreason;
            }
        }

        public static class LinkBean {
            /**
             * type : doc
             * url : http://api.3g.ifeng.com/ipadtestdoc?aid=cmpp_034470051364453&channelKey=Y21wcF8xNzAwN183MTlfNzU=&channelid=SYLB10NEW_DOWN
             * weburl : http://share.iclient.ifeng.com/sharenews.f?aid=034470051364453
             */

            private String type;
            private String url;
            private String weburl;

            @Override
            public String toString() {
                return "LinkBean{" +
                        "type='" + type + '\'' +
                        ", url='" + url + '\'' +
                        ", weburl='" + weburl + '\'' +
                        '}';
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getWeburl() {
                return weburl;
            }

            public void setWeburl(String weburl) {
                this.weburl = weburl;
            }
        }
    }
}

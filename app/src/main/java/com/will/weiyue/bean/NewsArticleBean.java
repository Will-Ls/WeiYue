package com.will.weiyue.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/7 .
 */
public class NewsArticleBean implements Serializable {
    @Override
    public String toString() {
        return "NewsArticleBean{" +
                "meta=" + meta +
                ", body=" + body +
                ", disclaimer='" + disclaimer + '\'' +
                '}';
    }

    /**
     * meta : {"id":"http://api.3g.ifeng.com/api_vampire_article_detail?aid=sub_22659236","type":"doc","documentId":"sub_22659236","class":"722080","o":1}
     * body : {"aid":"sub_22659236","staticId":"sub_22659236","documentId":"sub_22659236","title":"一剧成名抛弃20年发妻，因戏生情娶新欢生娃之后，5年后再度离婚","author":"","source":"娱乐市场","thumbnail":"http://p0.ifengimg.com/pmop/2017/0718/9ACA34DF84F0A6EA9B53F144FC753535A5DEE346_size11_w450_h250.jpeg","editTime":"2017/07/18 00:13:31","updateTime":"2017/07/18 03:52:28","cTime":"2017/07/18 00:13:31","uTime":"2017/07/18 03:52:28","wwwurl":"http://api.3g.ifeng.com/api_vampire_article_detail?aid=sub_22659236","shareurl":"https://share.iclient.ifeng.com/shareNews?fromType=vampire&forward=1&aid=sub_22659236&token=0ATM2ITM2MDM4UDMzYDO","commentsUrl":"sub_22659236","text":"<p>娱乐圈中，不少人成名之后都厌倦目前的生活，选择开启一段新的生活，这已然是娱乐圈的常态了。因为成名后，自己也是有一定知名度的明星了，感觉目前的生活肯定不符自己的身份。而今天小编要和大家介绍的这位便是成名后抛弃二十年发妻，因戏生情娶了新欢，他就是侯勇。<\/p><p><img src=\"http://p0.ifengimg.com/pmop/2017/0718/9ACA34DF84F0A6EA9B53F144FC753535A5DEE346_size11_w450_h250.jpeg\"><\/p><p>我们先来介绍一下侯勇，1967年2月23日出生于江苏省连云港市，毕业于江苏省戏剧学校，国家一级演员、军人。想必大家对侯勇都应该非常熟悉吧，2002年时凭借电影《冲出亚马逊》成名，此后红极一时片约不断。也许这部电影有些读者没有看过，那前段时间火热的《人民的名义》大家应该看过吧，侯勇在剧中饰演处长赵德汉，给观众们留下了深刻的印象。<\/p><p><img src=\"http://p0.ifengimg.com/pmop/2017/0718/33C9290AF98C1A76FC2C2885EDC4202A72F6FC7A_size15_w500_h345.jpeg\"><\/p><p>侯勇有过两段婚姻，发妻是演员沈蓉，二妻是演员潘雨辰。发妻是侯勇的大学时期表演系的同班同学，二人在大学的时候就已经相恋，毕业后的沈蓉凭借着自己的演技在影坛崭露头角有着自己的一席之地。此后沈蓉接了很多影视作品，而且还一举夺得飞天奖最佳女主角奖。然而这个时候的侯勇发展的却不是那么顺利，一直默默无闻。1992年的时候，对爱情忠贞不渝的沈蓉还是选择了与侯勇结婚。结婚之后的沈蓉在各个方面都帮助自己的老公，最终侯勇迎来了绽放异彩的一天。<\/p><p><img src=\"http://p0.ifengimg.com/pmop/2017/0718/AFA6DD92FB273D84F9EF747EF677071225E1BDF3_size28_w636_h483.jpeg\"><\/p><p>成名之后的侯勇曾公开表示：\u201c我非常感谢妻子沈蓉，如果没有他，那么就不可能有今天的侯勇。\u201d二人结婚二十年，最大的遗憾莫过于没有孩子，而侯勇也表示和妻子商量好了决定不要孩子了。<\/p><p>然而让人意想不到的事情还是发生了，十几年来夫妻二人因为拍戏聚少离多，而且加上侯勇与80后演员的绯闻，夫妻二人的关系最终发生了变故最终二人分道扬镳，结束了长达二十年的爱情长跑。<\/p><p><img src=\"http://p0.ifengimg.com/pmop/2017/0718/67A7AA921DB9698B3073853B445039B9EAAC56D7_size20_w407_h291.jpeg\"><\/p><p>侯勇和潘雨辰在拍片时相识，二人一起合作拍摄了电视剧《不能没有你》和《沙场点兵》，拍戏期间二人因戏生情，2011年在潘雨辰的老家举办了豪华的婚礼，随后二人一起搬到了北京东城区，而潘雨辰此时也背负了\u201c小三\u201d的骂名。<\/p><p><img src=\"http://p0.ifengimg.com/pmop/2017/0718/86DE751D3B0004826E570A8D43EE436C371B5C1F_size21_w460_h287.jpeg\"><\/p><p>5年之后，潘雨辰承认自己和侯勇缘分已尽，称：\u201c我一个人带着孩子已经生活了很久了。其实分开也没什么，生活就是这样，该来的总会来，该结束的就会结束。\u201d如今，潘雨辰独自带着孩子生活在老家丹东。<\/p><p><img src=\"http://p0.ifengimg.com/pmop/2017/0718/2DF17EAC9C2D988856F18912F365EA707B1CD30C_size18_w426_h210.jpeg\"><\/p><p>虽然潘雨辰并没有明确表示二人是否真的离婚，但是从二人的状态来看，这分爱情却没有能够经受住时间的考验，最终仍是以失败告终。<\/p>","commentCount":323,"commentType":"0","allowComment":"0","img":[{"url":"http://p0.ifengimg.com/pmop/2017/0718/9ACA34DF84F0A6EA9B53F144FC753535A5DEE346_size11_w450_h250.jpeg","size":{"width":"450","height":"250"}},{"url":"http://p0.ifengimg.com/pmop/2017/0718/33C9290AF98C1A76FC2C2885EDC4202A72F6FC7A_size15_w500_h345.jpeg","size":{"width":"500","height":"345"}},{"url":"http://p0.ifengimg.com/pmop/2017/0718/AFA6DD92FB273D84F9EF747EF677071225E1BDF3_size28_w636_h483.jpeg","size":{"width":"636","height":"483"}},{"url":"http://p0.ifengimg.com/pmop/2017/0718/67A7AA921DB9698B3073853B445039B9EAAC56D7_size20_w407_h291.jpeg","size":{"width":"407","height":"291"}},{"url":"http://p0.ifengimg.com/pmop/2017/0718/86DE751D3B0004826E570A8D43EE436C371B5C1F_size21_w460_h287.jpeg","size":{"width":"460","height":"287"}},{"url":"http://p0.ifengimg.com/pmop/2017/0718/2DF17EAC9C2D988856F18912F365EA707B1CD30C_size18_w426_h210.jpeg","size":{"width":"426","height":"210"}}],"subscribe":{"type":"vampire","cateSource":"凤凰号","parentid":"0","parentname":"娱乐","cateid":"722080","catename":"娱乐市场","logo":"http://si1.go2yd.com/get-image/0EG8QVlrLfM","description":"电影市场，娱乐资讯，话题人物","api":"http://api.3g.ifeng.com/api_wemedia_list?cid=722080","show_link":0,"share_url":"https://share.iclient.ifeng.com/share_zmt_home?tag=home&cid=722080","status":1},"praise":"105","hasEditor":"0","hasVideo":"N","relateDocs":[{"thumbnail":"http://d.ifengimg.com/w134_h96_q75/p0.ifengimg.com/pmop/2017/0712/24081CF56E985D9E31D4EE68888B332D81439227_size21_w474_h315.jpeg","title":"著名的小品演员，成名后抛弃发妻，给发妻送钱送房","id":"http://api.3g.ifeng.com/ipadtestdoc?aid=125182897","source":"娱乐市场","documentId":"imcp_125182897","staticId":"imcp_125182897","createTime":"2017/07/12 01:25:21","updateTime":"2017/07/12 01:25:21","commentsUrl":"http://t.ifeng.com/appshare/22390245.shtml","type":"doc","link":{"type":"doc","url":"http://api.3g.ifeng.com/ipadtestdoc?aid=125182897"},"subscribe":{"cateid":"娱乐市场","type":"source","catename":"娱乐市场","logo":"","description":"","cateSource":"","api":"http://api.iclient.ifeng.com/api_subscribe_compre?type=source&keyword=%E5%A8%B1%E4%B9%90%E5%B8%82%E5%9C%BA"},"comments":"0","commentsall":"0","style":{"backreason":["来源:娱乐市场","标题党","旧闻、重复","内容质量差"],"view":"titleimg"}},{"thumbnail":"http://d.ifengimg.com/w134_h96_q75/p0.ifengimg.com/pmop/2017/0708/06F8EEEE460467061AB3D5159F93333213DC18D3_size28_w395_h402.jpeg","title":"他是演技派大叔，却在成名后与发妻离婚！","id":"http://api.3g.ifeng.com/ipadtestdoc?aid=124999461","source":"养生达人镜水月","documentId":"imcp_124999461","staticId":"imcp_124999461","createTime":"2017/07/08 09:12:54","updateTime":"2017/07/08 09:12:54","commentsUrl":"http://t.ifeng.com/appshare/22108874.shtml","type":"doc","link":{"type":"doc","url":"http://api.3g.ifeng.com/ipadtestdoc?aid=124999461"},"subscribe":{"cateid":"养生达人镜水月","type":"source","catename":"养生达人镜水月","logo":"http://p3.ifengimg.com/a/2017_03/b758ed6bd1cd50b.png","description":"","cateSource":"","api":"http://api.iclient.ifeng.com/api_subscribe_compre?type=source&keyword=%E5%85%BB%E7%94%9F%E8%BE%BE%E4%BA%BA%E9%95%9C%E6%B0%B4%E6%9C%88"},"comments":"0","commentsall":"0","style":{"backreason":["来源:养生达人镜水月","标题党","旧闻、重复","内容质量差"],"view":"titleimg"}},{"thumbnail":"http://d.ifengimg.com/w134_h96_q75/p1.ifengimg.com/web/2017_02/e6df711d4d7fa79_w199_h240.jpg","title":"《亮剑》主角因戏生情抛弃17年结发妻子","id":"http://api.3g.ifeng.com/ipadtestdoc?aid=117709425","source":"小程娱","documentId":"imcp_117709425","staticId":"imcp_117709425","createTime":"2017/01/11 01:07:00","updateTime":"2017/01/11 01:07:00","commentsUrl":"http://t.ifeng.com/appshare/8876769.shtml","type":"doc","link":{"type":"doc","url":"http://api.3g.ifeng.com/ipadtestdoc?aid=117709425"},"subscribe":{"cateid":"小程娱","type":"source","catename":"小程娱","logo":"","description":"","cateSource":"","api":"http://api.iclient.ifeng.com/api_subscribe_compre?type=source&keyword=%E5%B0%8F%E7%A8%8B%E5%A8%B1"},"comments":"3","commentsall":"8","style":{"backreason":["来源:小程娱","标题党","旧闻、重复","内容质量差"],"view":"titleimg"}},{"title":"国家一级演员, 成名后抛弃妻子，另寻新欢","id":"http://api.iclient.ifeng.com/api_vampire_article_detail?aid=sub_15468026","documentId":"sub_15468026","staticId":"sub_15468026","source":"娱乐水晶苑","createTime":"2017/05/14 08:27:45","updateTime":"2017/05/14 08:27:45","commentsUrl":"sub_15468026","type":"doc","thumbnail":"http://d.ifengimg.com/w134_h96_q75/p0.ifengimg.com/pmop/2017/0514/E5442AFD0B17234B4F6BE94F4F8FAAE4F41F5403_size22_w550_h367.jpeg","link":{"type":"doc","url":"http://api.iclient.ifeng.com/api_vampire_article_detail?aid=sub_15468026"},"subscribe":{"cateid":"娱乐水晶苑","type":"source","catename":"娱乐水晶苑","logo":"","description":""},"comments":"69","commentsall":"72","style":{"backreason":["来源:娱乐水晶苑","标题党","旧闻、重复","内容质量差"],"view":"titleimg"}},{"id":"233afdaf-51f4-4bfd-b5c5-360903be90e3","title":"他演《亮剑》走红 因戏生情抛弃17年结发妻子","thumbnail":"http://d.ifengimg.com/w134_h96_q75/p1.ifengimg.com/a/2017_09/be28e224623e034.jpg","createTime":"2017/01/25 12:35:59","updateTime":"2017/07/20 16:28:43","phvideo":{"channelName":"网络媒体","length":66},"type":"phvideo","documentId":"v_233afdaf-51f4-4bfd-b5c5-360903be90e3","staticId":"video_233afdaf-51f4-4bfd-b5c5-360903be90e3","commentsUrl":"http://share.iclient.ifeng.com/sharenews.f?guid=233afdaf-51f4-4bfd-b5c5-360903be90e3","link":{"type":"phvideo","url":"233afdaf-51f4-4bfd-b5c5-360903be90e3"},"comments":"0","commentsall":"0","style":{"backreason":["标题党","旧闻、重复","内容质量差"],"view":"titleimg"}}]}
     * disclaimer : 本文来自凤凰号，仅代表凤凰号自媒体观点。
     */

    private MetaBean meta;
    private BodyBean body;
    private String disclaimer;

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public static class MetaBean {
        /**
         * id : http://api.3g.ifeng.com/api_vampire_article_detail?aid=sub_22659236
         * type : doc
         * documentId : sub_22659236
         * class : 722080
         * o : 1
         */

        private String id;
        private String type;
        private String documentId;
        @SerializedName("class")
        private String classX;
        private int o;

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

        public String getDocumentId() {
            return documentId;
        }

        public void setDocumentId(String documentId) {
            this.documentId = documentId;
        }

        public String getClassX() {
            return classX;
        }

        public void setClassX(String classX) {
            this.classX = classX;
        }

        public int getO() {
            return o;
        }

        public void setO(int o) {
            this.o = o;
        }
    }

    public static class BodyBean {

        @Override
        public String toString() {
            return "BodyBean{" +
                    "aid='" + aid + '\'' +
                    ", staticId='" + staticId + '\'' +
                    ", id='" + id + '\'' +
                    ", documentId='" + documentId + '\'' +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", source='" + source + '\'' +
                    ", thumbnail='" + thumbnail + '\'' +
                    ", editTime='" + editTime + '\'' +
                    ", updateTime='" + updateTime + '\'' +
                    ", cTime='" + cTime + '\'' +
                    ", uTime='" + uTime + '\'' +
                    ", wwwurl='" + wwwurl + '\'' +
                    ", shareurl='" + shareurl + '\'' +
                    ", commentsUrl='" + commentsUrl + '\'' +
                    ", text='" + text + '\'' +
                    ", commentCount=" + commentCount +
                    ", commentType='" + commentType + '\'' +
                    ", allowComment='" + allowComment + '\'' +
                    ", subscribe=" + subscribe +
                    ", slides=" + slides +
                    ", praise='" + praise + '\'' +
                    ", hasEditor='" + hasEditor + '\'' +
                    ", hasVideo='" + hasVideo + '\'' +
                    ", img=" + img +
                    ", relateDocs=" + relateDocs +
                    '}';
        }

        /**
         * aid : sub_22659236
         * staticId : sub_22659236
         * documentId : sub_22659236
         * title : 一剧成名抛弃20年发妻，因戏生情娶新欢生娃之后，5年后再度离婚
         * author :
         * source : 娱乐市场
         * thumbnail : http://p0.ifengimg.com/pmop/2017/0718/9ACA34DF84F0A6EA9B53F144FC753535A5DEE346_size11_w450_h250.jpeg
         * editTime : 2017/07/18 00:13:31
         * updateTime : 2017/07/18 03:52:28
         * cTime : 2017/07/18 00:13:31
         * uTime : 2017/07/18 03:52:28
         * wwwurl : http://api.3g.ifeng.com/api_vampire_article_detail?aid=sub_22659236
         * shareurl : https://share.iclient.ifeng.com/shareNews?fromType=vampire&forward=1&aid=sub_22659236&token=0ATM2ITM2MDM4UDMzYDO
         * commentsUrl : sub_22659236
         * text : <p>娱乐圈中，不少人成名之后都厌倦目前的生活，选择开启一段新的生活，这已然是娱乐圈的常态了。因为成名后，自己也是有一定知名度的明星了，感觉目前的生活肯定不符自己的身份。而今天小编要和大家介绍的这位便是成名后抛弃二十年发妻，因戏生情娶了新欢，他就是侯勇。</p><p><img src="http://p0.ifengimg.com/pmop/2017/0718/9ACA34DF84F0A6EA9B53F144FC753535A5DEE346_size11_w450_h250.jpeg"></p><p>我们先来介绍一下侯勇，1967年2月23日出生于江苏省连云港市，毕业于江苏省戏剧学校，国家一级演员、军人。想必大家对侯勇都应该非常熟悉吧，2002年时凭借电影《冲出亚马逊》成名，此后红极一时片约不断。也许这部电影有些读者没有看过，那前段时间火热的《人民的名义》大家应该看过吧，侯勇在剧中饰演处长赵德汉，给观众们留下了深刻的印象。</p><p><img src="http://p0.ifengimg.com/pmop/2017/0718/33C9290AF98C1A76FC2C2885EDC4202A72F6FC7A_size15_w500_h345.jpeg"></p><p>侯勇有过两段婚姻，发妻是演员沈蓉，二妻是演员潘雨辰。发妻是侯勇的大学时期表演系的同班同学，二人在大学的时候就已经相恋，毕业后的沈蓉凭借着自己的演技在影坛崭露头角有着自己的一席之地。此后沈蓉接了很多影视作品，而且还一举夺得飞天奖最佳女主角奖。然而这个时候的侯勇发展的却不是那么顺利，一直默默无闻。1992年的时候，对爱情忠贞不渝的沈蓉还是选择了与侯勇结婚。结婚之后的沈蓉在各个方面都帮助自己的老公，最终侯勇迎来了绽放异彩的一天。</p><p><img src="http://p0.ifengimg.com/pmop/2017/0718/AFA6DD92FB273D84F9EF747EF677071225E1BDF3_size28_w636_h483.jpeg"></p><p>成名之后的侯勇曾公开表示：“我非常感谢妻子沈蓉，如果没有他，那么就不可能有今天的侯勇。”二人结婚二十年，最大的遗憾莫过于没有孩子，而侯勇也表示和妻子商量好了决定不要孩子了。</p><p>然而让人意想不到的事情还是发生了，十几年来夫妻二人因为拍戏聚少离多，而且加上侯勇与80后演员的绯闻，夫妻二人的关系最终发生了变故最终二人分道扬镳，结束了长达二十年的爱情长跑。</p><p><img src="http://p0.ifengimg.com/pmop/2017/0718/67A7AA921DB9698B3073853B445039B9EAAC56D7_size20_w407_h291.jpeg"></p><p>侯勇和潘雨辰在拍片时相识，二人一起合作拍摄了电视剧《不能没有你》和《沙场点兵》，拍戏期间二人因戏生情，2011年在潘雨辰的老家举办了豪华的婚礼，随后二人一起搬到了北京东城区，而潘雨辰此时也背负了“小三”的骂名。</p><p><img src="http://p0.ifengimg.com/pmop/2017/0718/86DE751D3B0004826E570A8D43EE436C371B5C1F_size21_w460_h287.jpeg"></p><p>5年之后，潘雨辰承认自己和侯勇缘分已尽，称：“我一个人带着孩子已经生活了很久了。其实分开也没什么，生活就是这样，该来的总会来，该结束的就会结束。”如今，潘雨辰独自带着孩子生活在老家丹东。</p><p><img src="http://p0.ifengimg.com/pmop/2017/0718/2DF17EAC9C2D988856F18912F365EA707B1CD30C_size18_w426_h210.jpeg"></p><p>虽然潘雨辰并没有明确表示二人是否真的离婚，但是从二人的状态来看，这分爱情却没有能够经受住时间的考验，最终仍是以失败告终。</p>
         * commentCount : 323
         * commentType : 0
         * allowComment : 0
         * img : [{"url":"http://p0.ifengimg.com/pmop/2017/0718/9ACA34DF84F0A6EA9B53F144FC753535A5DEE346_size11_w450_h250.jpeg","size":{"width":"450","height":"250"}},{"url":"http://p0.ifengimg.com/pmop/2017/0718/33C9290AF98C1A76FC2C2885EDC4202A72F6FC7A_size15_w500_h345.jpeg","size":{"width":"500","height":"345"}},{"url":"http://p0.ifengimg.com/pmop/2017/0718/AFA6DD92FB273D84F9EF747EF677071225E1BDF3_size28_w636_h483.jpeg","size":{"width":"636","height":"483"}},{"url":"http://p0.ifengimg.com/pmop/2017/0718/67A7AA921DB9698B3073853B445039B9EAAC56D7_size20_w407_h291.jpeg","size":{"width":"407","height":"291"}},{"url":"http://p0.ifengimg.com/pmop/2017/0718/86DE751D3B0004826E570A8D43EE436C371B5C1F_size21_w460_h287.jpeg","size":{"width":"460","height":"287"}},{"url":"http://p0.ifengimg.com/pmop/2017/0718/2DF17EAC9C2D988856F18912F365EA707B1CD30C_size18_w426_h210.jpeg","size":{"width":"426","height":"210"}}]
         * subscribe : {"type":"vampire","cateSource":"凤凰号","parentid":"0","parentname":"娱乐","cateid":"722080","catename":"娱乐市场","logo":"http://si1.go2yd.com/get-image/0EG8QVlrLfM","description":"电影市场，娱乐资讯，话题人物","api":"http://api.3g.ifeng.com/api_wemedia_list?cid=722080","show_link":0,"share_url":"https://share.iclient.ifeng.com/share_zmt_home?tag=home&cid=722080","status":1}
         * praise : 105
         * hasEditor : 0
         * hasVideo : N
         * relateDocs : [{"thumbnail":"http://d.ifengimg.com/w134_h96_q75/p0.ifengimg.com/pmop/2017/0712/24081CF56E985D9E31D4EE68888B332D81439227_size21_w474_h315.jpeg","title":"著名的小品演员，成名后抛弃发妻，给发妻送钱送房","id":"http://api.3g.ifeng.com/ipadtestdoc?aid=125182897","source":"娱乐市场","documentId":"imcp_125182897","staticId":"imcp_125182897","createTime":"2017/07/12 01:25:21","updateTime":"2017/07/12 01:25:21","commentsUrl":"http://t.ifeng.com/appshare/22390245.shtml","type":"doc","link":{"type":"doc","url":"http://api.3g.ifeng.com/ipadtestdoc?aid=125182897"},"subscribe":{"cateid":"娱乐市场","type":"source","catename":"娱乐市场","logo":"","description":"","cateSource":"","api":"http://api.iclient.ifeng.com/api_subscribe_compre?type=source&keyword=%E5%A8%B1%E4%B9%90%E5%B8%82%E5%9C%BA"},"comments":"0","commentsall":"0","style":{"backreason":["来源:娱乐市场","标题党","旧闻、重复","内容质量差"],"view":"titleimg"}},{"thumbnail":"http://d.ifengimg.com/w134_h96_q75/p0.ifengimg.com/pmop/2017/0708/06F8EEEE460467061AB3D5159F93333213DC18D3_size28_w395_h402.jpeg","title":"他是演技派大叔，却在成名后与发妻离婚！","id":"http://api.3g.ifeng.com/ipadtestdoc?aid=124999461","source":"养生达人镜水月","documentId":"imcp_124999461","staticId":"imcp_124999461","createTime":"2017/07/08 09:12:54","updateTime":"2017/07/08 09:12:54","commentsUrl":"http://t.ifeng.com/appshare/22108874.shtml","type":"doc","link":{"type":"doc","url":"http://api.3g.ifeng.com/ipadtestdoc?aid=124999461"},"subscribe":{"cateid":"养生达人镜水月","type":"source","catename":"养生达人镜水月","logo":"http://p3.ifengimg.com/a/2017_03/b758ed6bd1cd50b.png","description":"","cateSource":"","api":"http://api.iclient.ifeng.com/api_subscribe_compre?type=source&keyword=%E5%85%BB%E7%94%9F%E8%BE%BE%E4%BA%BA%E9%95%9C%E6%B0%B4%E6%9C%88"},"comments":"0","commentsall":"0","style":{"backreason":["来源:养生达人镜水月","标题党","旧闻、重复","内容质量差"],"view":"titleimg"}},{"thumbnail":"http://d.ifengimg.com/w134_h96_q75/p1.ifengimg.com/web/2017_02/e6df711d4d7fa79_w199_h240.jpg","title":"《亮剑》主角因戏生情抛弃17年结发妻子","id":"http://api.3g.ifeng.com/ipadtestdoc?aid=117709425","source":"小程娱","documentId":"imcp_117709425","staticId":"imcp_117709425","createTime":"2017/01/11 01:07:00","updateTime":"2017/01/11 01:07:00","commentsUrl":"http://t.ifeng.com/appshare/8876769.shtml","type":"doc","link":{"type":"doc","url":"http://api.3g.ifeng.com/ipadtestdoc?aid=117709425"},"subscribe":{"cateid":"小程娱","type":"source","catename":"小程娱","logo":"","description":"","cateSource":"","api":"http://api.iclient.ifeng.com/api_subscribe_compre?type=source&keyword=%E5%B0%8F%E7%A8%8B%E5%A8%B1"},"comments":"3","commentsall":"8","style":{"backreason":["来源:小程娱","标题党","旧闻、重复","内容质量差"],"view":"titleimg"}},{"title":"国家一级演员, 成名后抛弃妻子，另寻新欢","id":"http://api.iclient.ifeng.com/api_vampire_article_detail?aid=sub_15468026","documentId":"sub_15468026","staticId":"sub_15468026","source":"娱乐水晶苑","createTime":"2017/05/14 08:27:45","updateTime":"2017/05/14 08:27:45","commentsUrl":"sub_15468026","type":"doc","thumbnail":"http://d.ifengimg.com/w134_h96_q75/p0.ifengimg.com/pmop/2017/0514/E5442AFD0B17234B4F6BE94F4F8FAAE4F41F5403_size22_w550_h367.jpeg","link":{"type":"doc","url":"http://api.iclient.ifeng.com/api_vampire_article_detail?aid=sub_15468026"},"subscribe":{"cateid":"娱乐水晶苑","type":"source","catename":"娱乐水晶苑","logo":"","description":""},"comments":"69","commentsall":"72","style":{"backreason":["来源:娱乐水晶苑","标题党","旧闻、重复","内容质量差"],"view":"titleimg"}},{"id":"233afdaf-51f4-4bfd-b5c5-360903be90e3","title":"他演《亮剑》走红 因戏生情抛弃17年结发妻子","thumbnail":"http://d.ifengimg.com/w134_h96_q75/p1.ifengimg.com/a/2017_09/be28e224623e034.jpg","createTime":"2017/01/25 12:35:59","updateTime":"2017/07/20 16:28:43","phvideo":{"channelName":"网络媒体","length":66},"type":"phvideo","documentId":"v_233afdaf-51f4-4bfd-b5c5-360903be90e3","staticId":"video_233afdaf-51f4-4bfd-b5c5-360903be90e3","commentsUrl":"http://share.iclient.ifeng.com/sharenews.f?guid=233afdaf-51f4-4bfd-b5c5-360903be90e3","link":{"type":"phvideo","url":"233afdaf-51f4-4bfd-b5c5-360903be90e3"},"comments":"0","commentsall":"0","style":{"backreason":["标题党","旧闻、重复","内容质量差"],"view":"titleimg"}}]
         */

        private String aid;
        private String staticId;
        private String id;
        private String documentId;
        private String title;
        private String author;
        private String editorcode;
        private String source;
        private String thumbnail;
        private String editTime;
        private String updateTime;
        private String cTime;
        private String uTime;
        private String wwwurl;
        private String shareurl;
        private String commentsUrl;
        private String text;
        private int commentCount;
        private String commentType;
        private String allowComment;
        private SubscribeBean subscribe;
        private List<SlidesBean> slides;
        private String praise;
        private String hasEditor;
        private String hasVideo;
        private List<ImgBean> img;
        private List<RelateDocsBean> relateDocs;

        public String getEditorcode() {
            return editorcode;
        }

        public void setEditorcode(String editorcode) {
            this.editorcode = editorcode;
        }

        public List<SlidesBean> getSlides() {
            return slides;
        }

        public void setSlides(List<SlidesBean> slides) {
            this.slides = slides;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAid() {
            return aid;
        }

        public void setAid(String aid) {
            this.aid = aid;
        }

        public String getStaticId() {
            return staticId;
        }

        public void setStaticId(String staticId) {
            this.staticId = staticId;
        }

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

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getEditTime() {
            return editTime;
        }

        public void setEditTime(String editTime) {
            this.editTime = editTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getCTime() {
            return cTime;
        }

        public void setCTime(String cTime) {
            this.cTime = cTime;
        }

        public String getUTime() {
            return uTime;
        }

        public void setUTime(String uTime) {
            this.uTime = uTime;
        }

        public String getWwwurl() {
            return wwwurl;
        }

        public void setWwwurl(String wwwurl) {
            this.wwwurl = wwwurl;
        }

        public String getShareurl() {
            return shareurl;
        }

        public void setShareurl(String shareurl) {
            this.shareurl = shareurl;
        }

        public String getCommentsUrl() {
            return commentsUrl;
        }

        public void setCommentsUrl(String commentsUrl) {
            this.commentsUrl = commentsUrl;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public String getCommentType() {
            return commentType;
        }

        public void setCommentType(String commentType) {
            this.commentType = commentType;
        }

        public String getAllowComment() {
            return allowComment;
        }

        public void setAllowComment(String allowComment) {
            this.allowComment = allowComment;
        }

        public SubscribeBean getSubscribe() {
            return subscribe;
        }

        public void setSubscribe(SubscribeBean subscribe) {
            this.subscribe = subscribe;
        }

        public String getPraise() {
            return praise;
        }

        public void setPraise(String praise) {
            this.praise = praise;
        }

        public String getHasEditor() {
            return hasEditor;
        }

        public void setHasEditor(String hasEditor) {
            this.hasEditor = hasEditor;
        }

        public String getHasVideo() {
            return hasVideo;
        }

        public void setHasVideo(String hasVideo) {
            this.hasVideo = hasVideo;
        }

        public List<ImgBean> getImg() {
            return img;
        }

        public void setImg(List<ImgBean> img) {
            this.img = img;
        }

        public List<RelateDocsBean> getRelateDocs() {
            return relateDocs;
        }

        public void setRelateDocs(List<RelateDocsBean> relateDocs) {
            this.relateDocs = relateDocs;
        }

        public static class SlidesBean implements Serializable {
            @Override
            public String toString() {
                return "SlidesBean{" +
                        "image='" + image + '\'' +
                        ", title='" + title + '\'' +
                        ", description='" + description + '\'' +
                        '}';
            }

            /**
             * image : http://d.ifengimg.com/mw640_q75/p1.ifengimg.com/a/2017_29/4a70139b0ff73bc_size49_w458_h450.jpg
             * title : 女子为阻车被扣 将排泄物抹遍车身 | 组图
             * description : 7月17日，一段“妇女为强行冲关当众脱裤将排泄物抹遍车身”的不雅视频在当地流传。18日，广东省清远市公安局清新分局发布通报称，交警大队工作人员执勤时拦截了一辆逆行摩托车，且女驾驶员无相关证件。该妇女为避免车辆被扣，遂在车道上做出不雅举止，目前车主因以极端方式阻碍执勤人员执行职务的违法行为被警方依法行政拘留。图文：中国青年网
             */

            private String image;
            private String title;
            private String description;

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }

        public static class SubscribeBean {
            /**
             * type : vampire
             * cateSource : 凤凰号
             * parentid : 0
             * parentname : 娱乐
             * cateid : 722080
             * catename : 娱乐市场
             * logo : http://si1.go2yd.com/get-image/0EG8QVlrLfM
             * description : 电影市场，娱乐资讯，话题人物
             * api : http://api.3g.ifeng.com/api_wemedia_list?cid=722080
             * show_link : 0
             * share_url : https://share.iclient.ifeng.com/share_zmt_home?tag=home&cid=722080
             * status : 1
             */

            private String type;
            private String cateSource;
            private String parentid;
            private String parentname;
            private String cateid;
            private String catename;
            private String logo;
            private String description;
            private String api;
            private int show_link;
            private String share_url;
            private int status;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getCateSource() {
                return cateSource;
            }

            public void setCateSource(String cateSource) {
                this.cateSource = cateSource;
            }

            public String getParentid() {
                return parentid;
            }

            public void setParentid(String parentid) {
                this.parentid = parentid;
            }

            public String getParentname() {
                return parentname;
            }

            public void setParentname(String parentname) {
                this.parentname = parentname;
            }

            public String getCateid() {
                return cateid;
            }

            public void setCateid(String cateid) {
                this.cateid = cateid;
            }

            public String getCatename() {
                return catename;
            }

            public void setCatename(String catename) {
                this.catename = catename;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getApi() {
                return api;
            }

            public void setApi(String api) {
                this.api = api;
            }

            public int getShow_link() {
                return show_link;
            }

            public void setShow_link(int show_link) {
                this.show_link = show_link;
            }

            public String getShare_url() {
                return share_url;
            }

            public void setShare_url(String share_url) {
                this.share_url = share_url;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }

        public static class ImgBean {
            /**
             * url : http://p0.ifengimg.com/pmop/2017/0718/9ACA34DF84F0A6EA9B53F144FC753535A5DEE346_size11_w450_h250.jpeg
             * size : {"width":"450","height":"250"}
             */

            private String url;
            private SizeBean size;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public SizeBean getSize() {
                return size;
            }

            public void setSize(SizeBean size) {
                this.size = size;
            }

            public static class SizeBean {
                /**
                 * width : 450
                 * height : 250
                 */

                private String width;
                private String height;

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }
            }
        }

        public static class RelateDocsBean {
            /**
             * thumbnail : http://d.ifengimg.com/w134_h96_q75/p0.ifengimg.com/pmop/2017/0712/24081CF56E985D9E31D4EE68888B332D81439227_size21_w474_h315.jpeg
             * title : 著名的小品演员，成名后抛弃发妻，给发妻送钱送房
             * id : http://api.3g.ifeng.com/ipadtestdoc?aid=125182897
             * source : 娱乐市场
             * documentId : imcp_125182897
             * staticId : imcp_125182897
             * createTime : 2017/07/12 01:25:21
             * updateTime : 2017/07/12 01:25:21
             * commentsUrl : http://t.ifeng.com/appshare/22390245.shtml
             * type : doc
             * link : {"type":"doc","url":"http://api.3g.ifeng.com/ipadtestdoc?aid=125182897"}
             * subscribe : {"cateid":"娱乐市场","type":"source","catename":"娱乐市场","logo":"","description":"","cateSource":"","api":"http://api.iclient.ifeng.com/api_subscribe_compre?type=source&keyword=%E5%A8%B1%E4%B9%90%E5%B8%82%E5%9C%BA"}
             * comments : 0
             * commentsall : 0
             * style : {"backreason":["来源:娱乐市场","标题党","旧闻、重复","内容质量差"],"view":"titleimg"}
             * phvideo : {"channelName":"网络媒体","length":66}
             */

            private String thumbnail;
            private String title;
            private String id;
            private String source;
            private String documentId;
            private String staticId;
            private String createTime;
            private String updateTime;
            private String commentsUrl;
            private String type;
            private LinkBean link;
            private SubscribeBeanX subscribe;
            private String comments;
            private String commentsall;
            private StyleBean style;
            private PhvideoBean phvideo;

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
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

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
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

            public LinkBean getLink() {
                return link;
            }

            public void setLink(LinkBean link) {
                this.link = link;
            }

            public SubscribeBeanX getSubscribe() {
                return subscribe;
            }

            public void setSubscribe(SubscribeBeanX subscribe) {
                this.subscribe = subscribe;
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

            public StyleBean getStyle() {
                return style;
            }

            public void setStyle(StyleBean style) {
                this.style = style;
            }

            public PhvideoBean getPhvideo() {
                return phvideo;
            }

            public void setPhvideo(PhvideoBean phvideo) {
                this.phvideo = phvideo;
            }

            public static class LinkBean {
                /**
                 * type : doc
                 * url : http://api.3g.ifeng.com/ipadtestdoc?aid=125182897
                 */

                private String type;
                private String url;

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
            }

            public static class SubscribeBeanX {
                /**
                 * cateid : 娱乐市场
                 * type : source
                 * catename : 娱乐市场
                 * logo :
                 * description :
                 * cateSource :
                 * api : http://api.iclient.ifeng.com/api_subscribe_compre?type=source&keyword=%E5%A8%B1%E4%B9%90%E5%B8%82%E5%9C%BA
                 */

                private String cateid;
                private String type;
                private String catename;
                private String logo;
                private String description;
                private String cateSource;
                private String api;

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

                public String getLogo() {
                    return logo;
                }

                public void setLogo(String logo) {
                    this.logo = logo;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getCateSource() {
                    return cateSource;
                }

                public void setCateSource(String cateSource) {
                    this.cateSource = cateSource;
                }

                public String getApi() {
                    return api;
                }

                public void setApi(String api) {
                    this.api = api;
                }
            }

            public static class StyleBean {
                /**
                 * backreason : ["来源:娱乐市场","标题党","旧闻、重复","内容质量差"]
                 * view : titleimg
                 */

                private String view;
                private List<String> backreason;

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

            public static class PhvideoBean {
                /**
                 * channelName : 网络媒体
                 * length : 66
                 */

                private String channelName;
                private int length;

                public String getChannelName() {
                    return channelName;
                }

                public void setChannelName(String channelName) {
                    this.channelName = channelName;
                }

                public int getLength() {
                    return length;
                }

                public void setLength(int length) {
                    this.length = length;
                }
            }
        }
    }
}

package com.will.weiyue.bean;

import java.io.Serializable;

/**
 * desc: 新鲜事文章bean.
 * author: Will .
 * date: 2017/9/10 .
 */
public class FreshNewsArticleBean implements Serializable {


    /**
     * status : ok
     * post : {"id":90304,"content":"<p><strong>Rebecca Fisher-Jackson<\/strong><\/p>\n<p>我写下这一条回答之时，内心十分悲哀。<\/p>\n<p>过去，我家的经济状况不算很好；在2015年我经历了人生中最自私的行为。<\/p>\n<p>我的父亲是一名老烟枪，不过他不喜欢承认这一点。尽管我的母亲工作十分艰辛，我的父亲也在拼命找工作，但我们依旧得靠食物银行过活。<\/p>\n<p>那时我的母亲钱包里只有7英镑。在距离四天后她发工资之前，我们只有这些钱。这笔钱足够我们买食物度过这段艰难时期，我的母亲可以拿它来买许多土豆和意面。<\/p>\n<p>那天我的母亲准备去购物时，发现钱包空了。没有人知道钱在哪儿，我们三个人找遍了所有地方，只好接受钱已不见这一事实。那天晚上，我看见我的父亲从商店里回来，我问他去过哪儿。他推开我，走到了花园里。我则跑到了楼上的卧室。我有哮喘，因此只要闻到香烟味就会咳嗽。我到楼下准备调查却被我发现了事实。<\/p>\n<p>我的父亲十分想抽烟，但他却拉不下脸找全科医师，或者给英国国民保健服务替老烟枪准备的热线打电话；却决定偷走全家人(我、我的母亲、我的父亲、我的奶奶以及我们的狗)这四天赖以生存的7英镑。从那天起我不再尊敬他，更让我崩溃的是这种事发生过不下四次。<\/p>\n<p>最后，他非常享受他的香烟，我们却不享受淡而无味的意面。<\/p>\n<p><strong>Ethan Sommer<\/strong><\/p>\n<p>也许我写的这条不算最自私，但它却能立即让我想到。多伦多的地铁椅子大部分是红色，但某些靠近门的椅子被涂成了蓝色，如果你遇到了老年人或者孕妇，就应该将蓝色的椅子让给他们。<\/p>\n<p><img src=\"http://img.jandan.net/news/2017/08/a86e941342d83f3ad917450ee383c1ef.jpg\" alt=\"Quora：最自私的行为\" /><br />\n<em>credit：Ethan Sommer<\/em><\/p>\n<p>某次我上地铁后，发现里面几乎是空的。于是我将我的包放在了旁边的椅子上。当地铁里的人变多时，我将包放在了两腿之间，把旁边的位置让给别人坐。大约坐了一站后，一对老年夫妻(我感觉他们快八十岁)进入了车厢。那一刻地铁上没有空位置，于是他们就走向了蓝色的椅子。那里有一名男士戴着耳机，他的包放在旁边的椅子上，对这种情况毫无察觉。这位老年男士请求这位年轻人给他与他的妻子让座，因为他们的膝盖都不太好。尽管这名男子坐在蓝色椅子上，他还是拒绝了这对夫妻的请求。老人发现他不会起来后，再次请求他至少把包拿起来，让他的妻子坐下。这名男子接着就将包放在了地上，但却把脚放在了旁边的座位上，只为了膈应这对夫妻。这行为实在荒谬，我旁边的女士与我就坐在那个可怕的人类对面，之后让出了我们的座位。<\/p>\n<p><strong>Vineet Sharma<\/strong><\/p>\n<p>那时我在地铁上，正静静地坐着。一位女士带着她的儿子走进了车厢。那位女士请我让座，我出于礼貌将座位让给了她，并站在了她的面前。他们都感谢了我。<\/p>\n<p>过了几站，她旁边的座位空了下来。在我反应过来之前，她拉起她儿子的手，让他坐在了上面。<\/p>\n<p>他们都忽略了我，就好像我根本不存在一样。人们总是想要帮助，却从没想过要回报别人的帮助。<\/p>\n<p><em>本文译自  <a target=_blank rel=\"external\" href=\"https://www.quora.com/What-is-the-most-selfish-act-you-have-ever-witnessed\">Quora<\/a>，由译者 <a target=_blank href=\"http://i.jandan.net/2017/08/10/most-selfish-act.html\">肌肉桃<\/a> 基于创作共用协议(BY-NC)发布。<\/em><\/p>\n","date":"2017-08-10 15:30:46","modified":"2017-08-10 00:18:06"}
     * previous_url : http://i.jandan.net/2017/08/10/insurers-worry.html
     */

    private String status;
    private PostBean post;
    private String previous_url;

    private String title;
    private String excerpt;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PostBean getPost() {
        return post;
    }

    public void setPost(PostBean post) {
        this.post = post;
    }

    public String getPrevious_url() {
        return previous_url;
    }

    public void setPrevious_url(String previous_url) {
        this.previous_url = previous_url;
    }

    public static class PostBean {
        /**
         * id : 90304
         * content : <p><strong>Rebecca Fisher-Jackson</strong></p>
         * <p>我写下这一条回答之时，内心十分悲哀。</p>
         * <p>过去，我家的经济状况不算很好；在2015年我经历了人生中最自私的行为。</p>
         * <p>我的父亲是一名老烟枪，不过他不喜欢承认这一点。尽管我的母亲工作十分艰辛，我的父亲也在拼命找工作，但我们依旧得靠食物银行过活。</p>
         * <p>那时我的母亲钱包里只有7英镑。在距离四天后她发工资之前，我们只有这些钱。这笔钱足够我们买食物度过这段艰难时期，我的母亲可以拿它来买许多土豆和意面。</p>
         * <p>那天我的母亲准备去购物时，发现钱包空了。没有人知道钱在哪儿，我们三个人找遍了所有地方，只好接受钱已不见这一事实。那天晚上，我看见我的父亲从商店里回来，我问他去过哪儿。他推开我，走到了花园里。我则跑到了楼上的卧室。我有哮喘，因此只要闻到香烟味就会咳嗽。我到楼下准备调查却被我发现了事实。</p>
         * <p>我的父亲十分想抽烟，但他却拉不下脸找全科医师，或者给英国国民保健服务替老烟枪准备的热线打电话；却决定偷走全家人(我、我的母亲、我的父亲、我的奶奶以及我们的狗)这四天赖以生存的7英镑。从那天起我不再尊敬他，更让我崩溃的是这种事发生过不下四次。</p>
         * <p>最后，他非常享受他的香烟，我们却不享受淡而无味的意面。</p>
         * <p><strong>Ethan Sommer</strong></p>
         * <p>也许我写的这条不算最自私，但它却能立即让我想到。多伦多的地铁椅子大部分是红色，但某些靠近门的椅子被涂成了蓝色，如果你遇到了老年人或者孕妇，就应该将蓝色的椅子让给他们。</p>
         * <p><img src="http://img.jandan.net/news/2017/08/a86e941342d83f3ad917450ee383c1ef.jpg" alt="Quora：最自私的行为" /><br />
         * <em>credit：Ethan Sommer</em></p>
         * <p>某次我上地铁后，发现里面几乎是空的。于是我将我的包放在了旁边的椅子上。当地铁里的人变多时，我将包放在了两腿之间，把旁边的位置让给别人坐。大约坐了一站后，一对老年夫妻(我感觉他们快八十岁)进入了车厢。那一刻地铁上没有空位置，于是他们就走向了蓝色的椅子。那里有一名男士戴着耳机，他的包放在旁边的椅子上，对这种情况毫无察觉。这位老年男士请求这位年轻人给他与他的妻子让座，因为他们的膝盖都不太好。尽管这名男子坐在蓝色椅子上，他还是拒绝了这对夫妻的请求。老人发现他不会起来后，再次请求他至少把包拿起来，让他的妻子坐下。这名男子接着就将包放在了地上，但却把脚放在了旁边的座位上，只为了膈应这对夫妻。这行为实在荒谬，我旁边的女士与我就坐在那个可怕的人类对面，之后让出了我们的座位。</p>
         * <p><strong>Vineet Sharma</strong></p>
         * <p>那时我在地铁上，正静静地坐着。一位女士带着她的儿子走进了车厢。那位女士请我让座，我出于礼貌将座位让给了她，并站在了她的面前。他们都感谢了我。</p>
         * <p>过了几站，她旁边的座位空了下来。在我反应过来之前，她拉起她儿子的手，让他坐在了上面。</p>
         * <p>他们都忽略了我，就好像我根本不存在一样。人们总是想要帮助，却从没想过要回报别人的帮助。</p>
         * <p><em>本文译自  <a target=_blank rel="external" href="https://www.quora.com/What-is-the-most-selfish-act-you-have-ever-witnessed">Quora</a>，由译者 <a target=_blank href="http://i.jandan.net/2017/08/10/most-selfish-act.html">肌肉桃</a> 基于创作共用协议(BY-NC)发布。</em></p>
         * <p>
         * date : 2017-08-10 15:30:46
         * modified : 2017-08-10 00:18:06
         */

        private int id;
        private String content;
        private String date;
        private String modified;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getModified() {
            return modified;
        }

        public void setModified(String modified) {
            this.modified = modified;
        }
    }

    @Override
    public String toString() {
        return "FreshNewsArticleBean{" +
                "status='" + status + '\'' +
                ", post=" + post +
                ", previous_url='" + previous_url + '\'' +
                '}';
    }
}

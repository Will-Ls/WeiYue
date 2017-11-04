package com.will.weiyue.bean;

import java.io.Serializable;
import java.util.List;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class FreshNewsBean implements Serializable {

    /**
     * status : ok
     * count : 24
     * count_total : 61393
     * pages : 2559
     * posts : [{"id":89822,"url":"http://i.jandan.net/2017/07/25/mirror-x2.html","title":"半夜背后凉飕飕：镜子 两则","excerpt":"两个关于镜子的小故事。","date":"2017-07-25 23:45:59","tags":[{"id":969,"slug":"%e6%95%85%e4%ba%8b","title":"故事","description":"","post_count":90}],"author":{"id":677,"slug":"tunshu","name":"喵熊汪太狼","first_name":"","last_name":"","nickname":"喵熊汪太狼","url":"","description":""},"comment_count":20,"comment_status":"open","custom_fields":{"thumb_c":["http://img.jandan.net/news/2017/07/e449082796cbc599bbe08a93a05fa6ee.jpg"]}}]
     */

    private String status;
    private int count;
    private int count_total;
    private int pages;
    private List<PostsBean> posts;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount_total() {
        return count_total;
    }

    public void setCount_total(int count_total) {
        this.count_total = count_total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<PostsBean> getPosts() {
        return posts;
    }

    public void setPosts(List<PostsBean> posts) {
        this.posts = posts;
    }

    public static class PostsBean implements Serializable {
        /**
         * id : 89822
         * url : http://i.jandan.net/2017/07/25/mirror-x2.html
         * title : 半夜背后凉飕飕：镜子 两则
         * excerpt : 两个关于镜子的小故事。
         * date : 2017-07-25 23:45:59
         * tags : [{"id":969,"slug":"%e6%95%85%e4%ba%8b","title":"故事","description":"","post_count":90}]
         * author : {"id":677,"slug":"tunshu","name":"喵熊汪太狼","first_name":"","last_name":"","nickname":"喵熊汪太狼","url":"","description":""}
         * comment_count : 20
         * comment_status : open
         * custom_fields : {"thumb_c":["http://img.jandan.net/news/2017/07/e449082796cbc599bbe08a93a05fa6ee.jpg"]}
         */

        private int id;
        private String url;
        private String title;
        private String excerpt;
        private String date;
        private AuthorBean author;
        private int comment_count;
        private String comment_status;
        private CustomFieldsBean custom_fields;
        private List<TagsBean> tags;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getExcerpt() {
            return excerpt;
        }

        public void setExcerpt(String excerpt) {
            this.excerpt = excerpt;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public String getComment_status() {
            return comment_status;
        }

        public void setComment_status(String comment_status) {
            this.comment_status = comment_status;
        }

        public CustomFieldsBean getCustom_fields() {
            return custom_fields;
        }

        public void setCustom_fields(CustomFieldsBean custom_fields) {
            this.custom_fields = custom_fields;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public static class AuthorBean implements Serializable{
            /**
             * id : 677
             * slug : tunshu
             * name : 喵熊汪太狼
             * first_name :
             * last_name :
             * nickname : 喵熊汪太狼
             * url :
             * description :
             */

            private int id;
            private String slug;
            private String name;
            private String first_name;
            private String last_name;
            private String nickname;
            private String url;
            private String description;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getFirst_name() {
                return first_name;
            }

            public void setFirst_name(String first_name) {
                this.first_name = first_name;
            }

            public String getLast_name() {
                return last_name;
            }

            public void setLast_name(String last_name) {
                this.last_name = last_name;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }

        public static class CustomFieldsBean implements Serializable{
            private List<String> thumb_c;

            public List<String> getThumb_c() {
                return thumb_c;
            }

            public void setThumb_c(List<String> thumb_c) {
                this.thumb_c = thumb_c;
            }
        }

        public static class TagsBean implements Serializable{
            /**
             * id : 969
             * slug : %e6%95%85%e4%ba%8b
             * title : 故事
             * description :
             * post_count : 90
             */

            private int id;
            private String slug;
            private String title;
            private String description;
            private int post_count;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
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

            public int getPost_count() {
                return post_count;
            }

            public void setPost_count(int post_count) {
                this.post_count = post_count;
            }
        }
    }
}

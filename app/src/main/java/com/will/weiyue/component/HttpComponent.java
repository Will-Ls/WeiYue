package com.will.weiyue.component;

import com.will.weiyue.ui.jandan.JdDetailFragment;
import com.will.weiyue.ui.news.ArticleReadActivity;
import com.will.weiyue.ui.news.ImageBrowseActivity;
import com.will.weiyue.ui.news.NewsFragment;
import com.will.weiyue.ui.video.DetailFragment;
import com.will.weiyue.ui.video.VideoFragment;

import dagger.Component;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/2 .
 */
@Component(dependencies = ApplicationComponent.class)
public interface HttpComponent {

    void inject(VideoFragment videoFragment);

    void inject(DetailFragment detailFragment);

    void inject(JdDetailFragment jdDetailFragment);

    void inject(ImageBrowseActivity imageBrowseActivity);

    void inject( com.will.weiyue.ui.news.DetailFragment detailFragment);

    void inject(ArticleReadActivity articleReadActivity);

    void inject(NewsFragment newsFragment);

}

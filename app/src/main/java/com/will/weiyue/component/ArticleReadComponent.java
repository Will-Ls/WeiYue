package com.will.weiyue.component;

import com.will.weiyue.ui.news.ArticleReadActivity;
import com.will.weiyue.ui.news.ImageBrowseActivity;

import dagger.Component;

/**
 * desc:
 * author: Will .
 * date: 2017/9/24 .
 */
@Component(dependencies = ApplicationComponent.class)
public interface ArticleReadComponent {

    void inject(ArticleReadActivity articleReadActivity);

    void inject(ImageBrowseActivity browseActivity);
}

package com.will.weiyue.component;

import com.will.weiyue.ui.news.NewsFragment;

import dagger.Component;

/**
 * desc:
 * author: Will .
 * date: 2017/9/7 .
 */
@Component(dependencies = ApplicationComponent.class)
public interface NewsComponent {

    void inject(NewsFragment newsFragment);

}

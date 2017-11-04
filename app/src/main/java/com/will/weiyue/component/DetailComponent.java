package com.will.weiyue.component;

import com.will.weiyue.ui.news.DetailFragment;

import dagger.Component;

/**
 * desc:
 * author: Will .
 * date: 2017/9/7 .
 */
@Component(dependencies = ApplicationComponent.class)
public interface DetailComponent {

    void inject(DetailFragment detailFragment);


}

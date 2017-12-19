package com.will.weiyue.component;

import com.will.weiyue.ui.jandan.JdDetailFragment;
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

}

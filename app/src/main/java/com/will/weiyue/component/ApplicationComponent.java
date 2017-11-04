package com.will.weiyue.component;

import android.content.Context;

import com.will.weiyue.MyApp;
import com.will.weiyue.module.ApplicationModule;
import com.will.weiyue.module.HttpModule;
import com.will.weiyue.net.JanDanApi;
import com.will.weiyue.net.NewsApi;

import dagger.Component;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/2 .
 */
@Component(modules = {ApplicationModule.class,HttpModule.class})
public interface ApplicationComponent {

    MyApp getApplication();

    NewsApi getNetEaseApi();

    JanDanApi getJanDanApi();

    Context getContext();

}

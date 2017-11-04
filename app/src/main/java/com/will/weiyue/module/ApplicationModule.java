package com.will.weiyue.module;

import android.content.Context;

import com.will.weiyue.MyApp;

import dagger.Module;
import dagger.Provides;

/**
 * desc:
 * author: Will .
 * date: 2017/9/2 .
 */
@Module
public class ApplicationModule {

    private Context mContext;

    public ApplicationModule(Context context) {
        this.mContext = context;
    }

    @Provides
    MyApp provideApplication() {
        return (MyApp) mContext.getApplicationContext();
    }

    @Provides
    Context provideContext() {
        return mContext;
    }
}

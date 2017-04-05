package com.bookhi.di.module;

import com.bookhi.R;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Limingyu on 2017/4/6.
 */
@Module
public class HomePageModule {

    @Provides
    int[] getResource() {
        return new int[]{
                R.mipmap.dribbble1,
                R.mipmap.dribbble2,
                R.mipmap.dribbble3,
        };
    }

}

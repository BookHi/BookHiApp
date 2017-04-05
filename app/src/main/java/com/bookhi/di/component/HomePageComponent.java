package com.bookhi.di.component;

import com.bookhi.di.module.HomePageModule;
import com.bookhi.fragment.HomePageFragment;

import dagger.Component;

/**
 * Created by Limingyu on 2017/4/5.
 */
@Component(modules = HomePageModule.class)
public interface HomePageComponent {

    void inject(HomePageFragment fragment);

}

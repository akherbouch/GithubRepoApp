package com.ayyyoub.mvp.githubapi.di;


import com.ayyyoub.mvp.githubapi.ui.repositories.ReposActivity;
import com.ayyyoub.mvp.githubapi.ui.repositories.ReposModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = ReposModule.class)
    abstract ReposActivity reposActivity();
}

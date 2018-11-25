package com.ayyyoub.mvp.githubapi.ui.repositories;

import com.ayyyoub.mvp.githubapi.di.ActivityScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ReposModule {

    @ActivityScoped
    @Binds abstract ReposContract.Presenter reposPresenter(ReposPresenter presenter);
}

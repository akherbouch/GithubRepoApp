package com.ayyyoub.mvp.githubapi.di;

import android.app.Application;
import android.content.Context;

import com.ayyyoub.mvp.githubapi.data.network.GitHubService;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;


@Module
public abstract class ApplicationModule {

    @Binds
    abstract Context bindContext(Application application);
}


package com.ayyyoub.mvp.githubapi.di;

import com.ayyyoub.mvp.githubapi.data.network.GitHubService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {
    @Provides
    @Singleton
    GitHubService provideGitHubService() {
        return GitHubService.Creator.newGitHubService();
    }
}

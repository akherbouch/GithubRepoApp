package com.ayyyoub.mvp.githubapi.data;

import android.util.Log;

import com.ayyyoub.mvp.githubapi.data.models.ReposResponse;
import com.ayyyoub.mvp.githubapi.data.network.GitHubService;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;

import static com.ayyyoub.mvp.githubapi.utils.CommonUtils.getLastThirtyDayDate;

@Singleton
public class DataManager {

    private final GitHubService mGitHubService;
    private final String SORT = "stars";
    private final String ORDER = "desc";
    private final String QUERY;


    @Inject
    public DataManager(GitHubService gitHubService) {
        mGitHubService = gitHubService;
        QUERY = "created:>" + getLastThirtyDayDate("yyyy-MM-dd");
    }

    public Call<ReposResponse> getRepos(int page) {
        return mGitHubService.getRepos(QUERY,SORT,ORDER,page);
    }


}

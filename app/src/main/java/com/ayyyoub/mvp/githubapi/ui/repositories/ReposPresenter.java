package com.ayyyoub.mvp.githubapi.ui.repositories;

import android.util.Log;
import android.widget.Toast;

import com.ayyyoub.mvp.githubapi.data.DataManager;
import com.ayyyoub.mvp.githubapi.data.models.Repo;
import com.ayyyoub.mvp.githubapi.data.models.ReposResponse;
import com.ayyyoub.mvp.githubapi.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReposPresenter implements ReposContract.Presenter {

    private final DataManager mDataManager;

    private ReposContract.View mReposView;

    private List<Repo> mReposList;

    @Inject
    public ReposPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
        mReposList = new ArrayList<>();
    }

    @Override
    public void loadRepos(int page) {
        mDataManager.getRepos(page).enqueue(new Callback<ReposResponse>() {
            @Override
            public void onResponse(Call<ReposResponse> call, Response<ReposResponse> response) {
                try {
                    mReposList.addAll(response.body().getItems());
                    mReposView.showRepos(mReposList);
                } catch (Exception e) {
                    e.printStackTrace();
                    mReposView.showError();
                }
            }
            @Override
            public void onFailure(Call<ReposResponse> call, Throwable t) {
                t.printStackTrace();
                mReposView.showError();
            }
        });
    }

    @Override
    public void takeView(ReposContract.View view) {
        this.mReposView = view;
    }

    @Override
    public void dropView() {
        this.mReposView = null;
    }
}

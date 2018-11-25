package com.ayyyoub.mvp.githubapi.ui.repositories;

import android.support.annotation.NonNull;


import com.ayyyoub.mvp.githubapi.data.models.Repo;
import com.ayyyoub.mvp.githubapi.ui.base.BasePresenter;
import com.ayyyoub.mvp.githubapi.ui.base.BaseView;

import java.util.List;

public interface ReposContract {

    interface View extends BaseView<Presenter> {

        void showRepos(List<Repo> repos);
        void showError();

    }

    interface Presenter extends BasePresenter<View> {

        void loadRepos(int page);

    }
}

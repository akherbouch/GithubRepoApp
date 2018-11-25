package com.ayyyoub.mvp.githubapi.ui.repositories;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ayyyoub.mvp.githubapi.R;
import com.ayyyoub.mvp.githubapi.data.DataManager;
import com.ayyyoub.mvp.githubapi.data.models.Repo;
import com.ayyyoub.mvp.githubapi.data.models.ReposResponse;
import com.ayyyoub.mvp.githubapi.utils.DialogFactory;
import com.ayyyoub.mvp.githubapi.utils.EndlessRecyclerViewScrollListener;


import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReposActivity extends DaggerAppCompatActivity implements ReposContract.View{

    @Inject
    ReposAdapter mReposAdapter;

    @Inject
    ReposPresenter mReposPresenter;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos);
        ButterKnife.bind(this);

        setTitle(getString(R.string.title));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setAdapter(mReposAdapter);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                mReposPresenter.loadRepos(page);
            }
        });

        mReposPresenter.takeView(this);
        mReposPresenter.loadRepos(1);

    }

    @Override
    public void showRepos(List<Repo> Repos) {
        mReposAdapter.setRepos(Repos);
        mReposAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {
        DialogFactory.createGenericErrorDialog(this, getString(R.string.error_loading_repos))
                .show();
    }
}

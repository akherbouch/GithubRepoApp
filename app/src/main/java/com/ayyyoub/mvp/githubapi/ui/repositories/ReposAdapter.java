package com.ayyyoub.mvp.githubapi.ui.repositories;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ayyyoub.mvp.githubapi.R;
import com.ayyyoub.mvp.githubapi.data.models.Repo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.ayyyoub.mvp.githubapi.utils.CommonUtils.integerFormat;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.RepoViewHolder> {

    private List<Repo> mRepos;

    @Inject
    public ReposAdapter() {
        mRepos = new ArrayList<>();
    }

    public void setRepos(List<Repo> ribots) {
        mRepos = ribots;
    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        return new RepoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RepoViewHolder holder, int position) {
        Repo repo = mRepos.get(position);
        holder.repoName.setText(repo.getName());
        holder.repoDescription.setText(repo.getDescription());
        holder.repoStars.setText(integerFormat(repo.getStargazers_count()));
        holder.repoOwnerLogin.setText(repo.getOwner().getLogin());
        Picasso.with(holder.repoOwnerAvatar.getContext())
        .load(repo.getOwner().getAvatar_url())
        .into(holder.repoOwnerAvatar);
    }

    @Override
    public int getItemCount() {
        return mRepos.size();
    }

    class RepoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.repoName) TextView repoName;
        @BindView(R.id.repoDescription) TextView repoDescription;
        @BindView(R.id.repoStars) TextView repoStars;
        @BindView(R.id.repoOwnerLogin) TextView repoOwnerLogin;
        @BindView(R.id.repoOwnerAvatar) ImageView repoOwnerAvatar;

        public RepoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

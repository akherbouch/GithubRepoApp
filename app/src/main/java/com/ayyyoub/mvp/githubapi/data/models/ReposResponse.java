package com.ayyyoub.mvp.githubapi.data.models;

import java.util.List;

public class ReposResponse {

    List<Repo> items;

    public List<Repo> getItems() {
        return items;
    }

    public void setItems(List<Repo> items) {
        this.items = items;
    }

}

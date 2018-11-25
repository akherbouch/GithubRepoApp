package com.ayyyoub.mvp.githubapi.data.network;

import com.ayyyoub.mvp.githubapi.data.models.ReposResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubService {

    String ENDPOINT = "https://api.github.com/";

    @GET("search/repositories")
    Call<ReposResponse> getRepos(@Query("q") String query,
                                 @Query("sort") String sort,
                                 @Query("order") String order,
                                 @Query("page") int page);

    //Helper class that sets up a new services
    class Creator {
        public static GitHubService newGitHubService() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(GitHubService.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(GitHubService.class);
        }
    }
}

/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

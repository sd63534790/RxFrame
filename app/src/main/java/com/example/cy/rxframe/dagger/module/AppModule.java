package com.example.cy.rxframe.dagger.module;


import com.example.cy.rxframe.app.App;
import com.example.cy.rxframe.model.DataManager;
import com.example.cy.rxframe.model.db.DBHelper;
import com.example.cy.rxframe.model.db.RealmHelper;
import com.example.cy.rxframe.model.http.HttpHelper;
import com.example.cy.rxframe.model.http.RetrofitHelper;
import com.example.cy.rxframe.model.http.api.GankApi;
import com.example.cy.rxframe.model.prefs.ImplPreferencesHelper;
import com.example.cy.rxframe.model.prefs.PreferencesHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by codeest on 16/8/7.
 */

@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(ImplPreferencesHelper implPreferencesHelper) {
        return implPreferencesHelper;
    }
    @Provides
    @Singleton
    DBHelper provideDBHelper(RealmHelper realmHelper) {
        return realmHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, DBHelper DBHelper, PreferencesHelper preferencesHelper) {
        return new DataManager(httpHelper, DBHelper, preferencesHelper);
    }

}

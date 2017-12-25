package com.example.cy.rxframe.dagger.component;


import com.example.cy.rxframe.app.App;
import com.example.cy.rxframe.dagger.module.AppModule;
import com.example.cy.rxframe.dagger.module.HttpModule;
import com.example.cy.rxframe.model.DataManager;
import com.example.cy.rxframe.model.db.RealmHelper;
import com.example.cy.rxframe.model.http.RetrofitHelper;
import com.example.cy.rxframe.model.prefs.ImplPreferencesHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    App getContext();  // 提供App的Context

    DataManager getDataManager(); //数据中心

    RetrofitHelper retrofitHelper();  //提供http的帮助类

    RealmHelper realmHelper();    //提供数据库帮助类

    ImplPreferencesHelper preferencesHelper(); //提供sp帮助类
}

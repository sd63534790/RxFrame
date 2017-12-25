package com.example.cy.rxframe.model;


import com.example.cy.rxframe.model.bean.AndroidAPI;
import com.example.cy.rxframe.model.bean.WelfareAPI;
import com.example.cy.rxframe.model.db.DBHelper;
import com.example.cy.rxframe.model.http.HttpHelper;
import com.example.cy.rxframe.model.http.response.GankApiResult;
import com.example.cy.rxframe.model.prefs.PreferencesHelper;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @desciption:
 */

public class DataManager implements HttpHelper, DBHelper, PreferencesHelper {

    HttpHelper mHttpHelper;
    DBHelper mDbHelper;
    PreferencesHelper mPreferencesHelper;

    public DataManager(HttpHelper httpHelper, DBHelper dbHelper, PreferencesHelper preferencesHelper) {
        mHttpHelper = httpHelper;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
    }

    @Override
    public Flowable<GankApiResult<List<AndroidAPI>>> getAndroidData(int pageSize, int pageIndex) {
        return mHttpHelper.getAndroidData(pageSize, pageIndex);
    }

    @Override
    public Flowable<GankApiResult<List<WelfareAPI>>> getWalfareData(int pageSize, int pageIndex) {
        return mHttpHelper.getWalfareData(pageSize, pageIndex);
    }
}

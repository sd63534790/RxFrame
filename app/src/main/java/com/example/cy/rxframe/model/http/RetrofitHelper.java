package com.example.cy.rxframe.model.http;

import com.example.cy.rxframe.model.bean.AndroidAPI;
import com.example.cy.rxframe.model.bean.WelfareAPI;
import com.example.cy.rxframe.model.http.api.GankApi;
import com.example.cy.rxframe.model.http.response.GankApiResult;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * Created by codeest on 2016/8/3.
 */
public class RetrofitHelper implements HttpHelper {

    private GankApi mGankApiService;


    @Inject
    public RetrofitHelper(GankApi gankApiService) {
        this.mGankApiService = gankApiService;
    }

    @Override
    public Flowable<GankApiResult<List<AndroidAPI>>> getAndroidData(int pageSize, int pageIndex) {
        return mGankApiService.androidApi(pageSize, pageIndex);
    }

    @Override
    public Flowable<GankApiResult<List<WelfareAPI>>> getWalfareData(int pageSize, int pageIndex) {
        return mGankApiService.androidImageApi(pageSize, pageIndex);
    }
}

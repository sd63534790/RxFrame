package com.example.cy.rxframe.model.http.api;

import com.example.cy.rxframe.model.bean.AndroidAPI;
import com.example.cy.rxframe.model.bean.WelfareAPI;
import com.example.cy.rxframe.model.http.response.GankApiResult;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by cy on 2017/12/22.
 */

public interface GankApi {

    String HOST = "http://gank.io/api/data/";


    //Gank Android接口
    @GET("Android/{pageSize}/{pageIndex}")
    Flowable<GankApiResult<List<AndroidAPI>>> androidApi(@Path("pageSize") int pageSize, @Path("pageIndex") int pageIndex);


    //Gank Android福利接口
    @GET("福利/{pageSize}/{pageIndex}")
    Flowable<GankApiResult<List<WelfareAPI>>> androidImageApi(@Path("pageSize") int pageSize, @Path("pageIndex") int pageIndex);
}

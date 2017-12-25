package com.example.cy.rxframe.model.http;

import com.example.cy.rxframe.model.bean.AndroidAPI;
import com.example.cy.rxframe.model.bean.WelfareAPI;
import com.example.cy.rxframe.model.http.response.GankApiResult;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @description:
 */

public interface HttpHelper {

    Flowable<GankApiResult<List<AndroidAPI>>> getAndroidData(int pageSize, int pageIndex);

    Flowable<GankApiResult<List<WelfareAPI>>> getWalfareData(int pageSize,int pageIndex);


}

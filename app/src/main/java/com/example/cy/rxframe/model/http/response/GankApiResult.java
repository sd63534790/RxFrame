package com.example.cy.rxframe.model.http.response;

import java.io.Serializable;

/**
 * 接口返回实体基类
 * Created by cheny on 2017/10/19.
 */

public class GankApiResult<T> implements Serializable {


    private boolean error;
    private T results;

    public GankApiResult(boolean error, T results) {
        this.error = error;
        this.results = results;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    public static <T> GankApiResult successResult(T responseResult) {
        return new GankApiResult(false, responseResult);
    }

    public static <T> GankApiResult errorResult(T responseResult) {
        return new GankApiResult(true, responseResult);
    }


}

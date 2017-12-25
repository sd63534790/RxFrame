package com.example.cy.rxframe.base;

/**
 * Created by cy on 2017/12/21.
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();

}

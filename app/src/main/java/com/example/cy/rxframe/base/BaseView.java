package com.example.cy.rxframe.base;

/**
 * Created by cy on 2017/12/21.
 */

public interface BaseView {
    void showErrorMsg(String msg);

    void useNightMode(boolean isNight);

    //=======  State  =======
    void stateError();

    void stateEmpty();

    void stateLoading();

    void stateMain();
}

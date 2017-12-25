package com.example.cy.rxframe.presenter.main;

import com.example.cy.rxframe.base.BasePresenter;
import com.example.cy.rxframe.base.BaseView;

import java.util.List;

/**
 * Created by cy on 2017/12/22.
 */

public interface MainContract {

    interface View extends BaseView {

        void showTitleList(List<String> titleList);

    }

    interface Presenter extends BasePresenter<View> {

        void loadTabData();

    }
}

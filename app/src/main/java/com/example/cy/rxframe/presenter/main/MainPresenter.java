package com.example.cy.rxframe.presenter.main;

import com.example.cy.rxframe.base.RxPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by cy on 2017/12/22.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {

    @Inject
    public MainPresenter() {
    }

    @Override
    public void loadTabData() {
        List<String> titleList = new ArrayList<>();
        titleList.add("Android");
        titleList.add("IOS");
        mView.showTitleList(titleList);
    }
}

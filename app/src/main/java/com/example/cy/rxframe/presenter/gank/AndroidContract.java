package com.example.cy.rxframe.presenter.gank;


import com.example.cy.rxframe.base.BasePresenter;
import com.example.cy.rxframe.base.BaseView;
import com.example.cy.rxframe.model.bean.AndroidAPI;

import java.util.List;

/**
 * Created by cheny on 2017/11/8.
 */

public class AndroidContract {

    public interface View extends BaseView {

        void showLoading();

        void showRefreshLoading();

        void hideLoading();

        void hideRefreshLoading();

        void showAndroidList(List<AndroidAPI> androidAPIS);

        void refreshAndroidList(List<AndroidAPI> androidAPIS);

        void showError(String msg);
    }

    public interface Presenter extends BasePresenter<View> {

        void loadAndroidDatas(int pageSize, int pageIndex);

        void refreshAndroidDatas(int pageSize, int pageIndex);
    }
}

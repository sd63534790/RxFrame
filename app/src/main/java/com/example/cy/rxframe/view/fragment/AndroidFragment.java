package com.example.cy.rxframe.view.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.example.cy.rxframe.R;
import com.example.cy.rxframe.base.BaseFragment;
import com.example.cy.rxframe.model.bean.AndroidAPI;
import com.example.cy.rxframe.presenter.gank.AndroidContract;
import com.example.cy.rxframe.presenter.gank.AndroidPresenter;
import com.example.cy.rxframe.view.adapter.AndroidListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by cy on 2017/12/22.
 */

public class AndroidFragment extends BaseFragment<AndroidPresenter> implements AndroidContract.View {
    //view
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.swiprefresh)
    SwipeRefreshLayout mSwiprefresh;
    //adapter
    private AndroidListAdapter mMeizhiListAdapter;
    //data
    private int currentPageIndex = 1;
    List<AndroidAPI> mAndroidAPIS = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_android;
    }

    @Override
    protected void initEventAndData() {
        initRecyclerView();
        initSwipeRefresh();
        mPresenter.loadAndroidDatas(10, currentPageIndex);
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    private void initRecyclerView() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        mRecyclerview.setLayoutManager(staggeredGridLayoutManager);
        mMeizhiListAdapter = new AndroidListAdapter(getActivity(), mAndroidAPIS);
        mRecyclerview.setAdapter(mMeizhiListAdapter);
        mRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            }
        });
    }

    private void initSwipeRefresh() {
        if (mSwiprefresh != null) {
            mSwiprefresh.setColorSchemeResources(android.R.color.holo_blue_bright,
                    android.R.color.holo_green_light,
                    android.R.color.holo_orange_light,
                    android.R.color.holo_red_light);
            mSwiprefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    mPresenter.refreshAndroidDatas(10, 1);
                }
            });
        }
    }


    @Override
    public void showLoading() {
        mSwiprefresh.setRefreshing(true);
    }

    @Override
    public void showRefreshLoading() {
        mSwiprefresh.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        mSwiprefresh.setRefreshing(false);
    }

    @Override
    public void hideRefreshLoading() {
        mSwiprefresh.setRefreshing(false);
    }

    @Override
    public void showAndroidList(List<AndroidAPI> androidAPIS) {
        if (androidAPIS.size() > 0) {
            mAndroidAPIS.addAll(androidAPIS);
            mMeizhiListAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void refreshAndroidList(List<AndroidAPI> androidAPIS) {
        if (androidAPIS.size() > 0) {
            mAndroidAPIS.clear();
            mAndroidAPIS.addAll(androidAPIS);
            mMeizhiListAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}

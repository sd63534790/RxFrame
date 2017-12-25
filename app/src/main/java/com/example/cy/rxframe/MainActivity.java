package com.example.cy.rxframe;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.cy.rxframe.base.BaseActivity;
import com.example.cy.rxframe.presenter.main.MainContract;
import com.example.cy.rxframe.presenter.main.MainPresenter;
import com.example.cy.rxframe.view.adapter.HomePagerAdapter;
import com.example.cy.rxframe.view.fragment.AndroidFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View, NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.appbar_layout)
    AppBarLayout mAppbarLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.coord)
    CoordinatorLayout mCoord;
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    AndroidFragment mAndroidFragment;
    AndroidFragment mIOSFragment;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        initToolBar();
        initDrawer();
        mPresenter.loadTabData();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private void initToolBar() {
        setSupportActionBar(mToolbar);
    }

    private void initDrawer() {
        if (mNavView != null) {
            mNavView.setNavigationItemSelectedListener(this);
            ActionBarDrawerToggle toggle =
                    new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open,
                            R.string.navigation_drawer_close);
            mDrawerLayout.addDrawerListener(toggle);
            toggle.syncState();
        }
    }


    @Override
    public void showTitleList(List<String> titleList) {
        initViewPage(titleList);
    }

    private void initViewPage(List<String> titleList) {
        HomePagerAdapter mAdapter = new HomePagerAdapter(getSupportFragmentManager());
        mAndroidFragment = new AndroidFragment();
        mIOSFragment = new AndroidFragment();
        mAdapter.addTab(mAndroidFragment, titleList.get(0));
        mAdapter.addTab(mIOSFragment, titleList.get(1));
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager, false);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}

package com.example.cy.rxframe.dagger.component;

import android.app.Activity;

import com.example.cy.rxframe.MainActivity;
import com.example.cy.rxframe.dagger.module.ActivityModule;
import com.example.cy.rxframe.dagger.scope.ActivityScope;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();


    void inject(MainActivity mainActivity);


}

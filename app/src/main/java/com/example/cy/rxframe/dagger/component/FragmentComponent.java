package com.example.cy.rxframe.dagger.component;

import android.app.Activity;


import com.example.cy.rxframe.dagger.module.FragmentModule;
import com.example.cy.rxframe.dagger.scope.FragmentScope;
import com.example.cy.rxframe.view.fragment.AndroidFragment;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(AndroidFragment androidFragment);

}

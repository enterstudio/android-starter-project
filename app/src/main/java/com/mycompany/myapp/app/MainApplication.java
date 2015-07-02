package com.mycompany.myapp.app;

import android.app.Application;
import android.content.Intent;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.security.ProviderInstaller;
import com.google.android.gms.security.ProviderInstaller.ProviderInstallListener;

import javax.inject.Inject;

import dagger.ObjectGraph;
import timber.log.Timber.Tree;

public class MainApplication extends Application {
    @Inject
    Tree logger;

    private ObjectGraph appGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        initApplication();
        upgradeSecurityProvider();
        initAppGraph();
    }

    private void initApplication() {
        new BuildConfigApplicationInitialization(this).immediateInitialization();
    }

    private void upgradeSecurityProvider() {
        ProviderInstaller.installIfNeededAsync(this, new ProviderInstallListener() {
            @Override
            public void onProviderInstalled() {

            }

            @Override
            public void onProviderInstallFailed(int errorCode, Intent recoveryIntent) {
                GooglePlayServicesUtil.showErrorNotification(errorCode, MainApplication.this);
            }
        });
    }

    private void initAppGraph() {
        appGraph = ObjectGraph.create(
                new AndroidModule(this),
                new ApplicationModule());

        appGraph.inject(this);
    }

    public ObjectGraph getAppGraph() {
        return appGraph;
    }
}

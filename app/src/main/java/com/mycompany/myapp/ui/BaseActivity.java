package com.mycompany.myapp.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.mycompany.myapp.app.MainApplication;
import com.mycompany.myapp.monitoring.CrashReporter;
import com.squareup.otto.Bus;

import javax.inject.Inject;

import dagger.ObjectGraph;
import hugo.weaving.DebugLog;
import timber.log.Timber.Tree;

public abstract class BaseActivity extends ActionBarActivity {
    @Inject
    protected Tree logger;

    @Inject
    protected CrashReporter crashReporter;

    @Inject
    protected Bus bus;

    private ObjectGraph activityGraph;

    @DebugLog
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (activityGraph == null) {
            activityGraph = buildActivityGraph();
        }
        activityGraph.inject(this);
    }

    protected abstract ObjectGraph buildActivityGraph();

    @Override
    protected void onResume() {
        super.onResume();
        bus.register(this);
    }

    @Override
    protected void onPause() {
        bus.unregister(this);
        super.onPause();
    }

    public ObjectGraph getActivityGraph() {
        return activityGraph;
    }

    protected ObjectGraph getAppGraph() {
        return ((MainApplication) getApplication()).getAppGraph();
    }
}

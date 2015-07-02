package com.mycompany.myapp.ui.main;

import android.os.Bundle;

import com.mycompany.myapp.R;
import com.mycompany.myapp.ui.BaseActivity;
import com.mycompany.myapp.ui.main.MainFragment.MainFragmentListener;

import dagger.ObjectGraph;
import hugo.weaving.DebugLog;

public class MainActivity extends BaseActivity implements MainFragmentListener {
    @Override
    protected ObjectGraph buildActivityGraph() {
        return getAppGraph().plus(new MainModule(this));
    }

    @DebugLog
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crashReporter.logMessage("woohoo from the activity!");

        logger.i("Activity is ready to go!");
    }
}

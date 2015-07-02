package com.mycompany.myapp.ui.main;

import com.mycompany.myapp.app.ApplicationModule;
import com.mycompany.myapp.ui.ActivityScope;
import com.mycompany.myapp.ui.main.MainFragment.MainFragmentListener;

import dagger.Module;
import dagger.Provides;

@ActivityScope
@Module(
        addsTo = ApplicationModule.class,
        injects = {
                MainActivity.class,
                MainFragment.class
        }

)
public class MainModule {
    private final MainActivity activity;

    public MainModule(MainActivity activity) {
        this.activity = activity;
    }

    @Provides
    MainFragmentListener provideMainFragmentListener() {
        return activity;
    }
}

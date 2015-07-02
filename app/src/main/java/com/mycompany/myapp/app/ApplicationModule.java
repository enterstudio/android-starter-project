package com.mycompany.myapp.app;

import com.mycompany.myapp.data.DataModule;
import com.mycompany.myapp.data.api.github.GitHubModule;
import com.mycompany.myapp.modules.CrashReporterModule;
import com.mycompany.myapp.monitoring.LoggerModule;

import javax.inject.Singleton;

import dagger.Module;

@Singleton
@Module(
        library = true,
        includes = {
                AndroidModule.class,
                LoggerModule.class,
                CrashReporterModule.class,
                BusModule.class,
                DataModule.class,
                GitHubModule.class
        },
        injects = {
                MainApplication.class
        })
public class ApplicationModule {

}

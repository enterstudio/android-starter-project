package com.mycompany.myapp.modules;

import com.mycompany.myapp.monitoring.CrashReporter;
import com.mycompany.myapp.monitoring.LoggingOnlyCrashReporter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(library = true)
public class CrashReporterModule {
    @Singleton
    @Provides
    CrashReporter crashReporter() {
        return new LoggingOnlyCrashReporter();
    }
}

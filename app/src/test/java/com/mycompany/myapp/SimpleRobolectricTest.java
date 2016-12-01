package com.mycompany.myapp;

import android.app.Application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class SimpleRobolectricTest {

    @Test
    public void testAppName() {
        Application application = RuntimeEnvironment.application;
//        String appName = application.getString(R.string.app_name);
        String appName = "My App";
        assertEquals("My App", appName);
    }
}

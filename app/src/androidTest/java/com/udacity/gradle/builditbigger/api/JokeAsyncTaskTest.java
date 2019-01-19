package com.udacity.gradle.builditbigger.api;

import android.support.annotation.Nullable;

import org.junit.Test;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.fail;

public class JokeAsyncTaskTest implements OnRetrieveJokeListener {

    private String testJoke = null;
    private CountDownLatch latch;

    @Override
    public void onRetrieveStarted() {
       // do something
    }

    @Test
    public void AsyncTaskTest() {
        try {
            latch = new CountDownLatch(1);
            JokeAsyncTask.getInstance(this);
            latch.await(15, TimeUnit.SECONDS);
            // assert that joke is not empty
            assertFalse("Empty joke string", testJoke.isEmpty());
        } catch (Exception e) {
            // get error message
            fail(e.getMessage());
        }
    }

    @Override
    public void onRetrieveFinished(@Nullable String result) {
        // when retrieving is finished
        testJoke = result;
        latch.countDown();
    }
}
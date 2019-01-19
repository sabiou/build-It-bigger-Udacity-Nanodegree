package com.udacity.gradle.builditbigger.api;

import android.support.annotation.Nullable;
import android.support.annotation.UiThread;

public interface OnRetrieveJokeListener {
    @UiThread
    void onRetrieveStarted();

    @UiThread
    void onRetrieveFinished(@Nullable String result);
}

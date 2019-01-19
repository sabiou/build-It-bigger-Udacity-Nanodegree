package com.udacity.gradle.builditbigger.api;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;

import java.io.IOException;

public class JokeAsyncTask extends AsyncTask<Void, Void, String> {

    private static final String TAG = JokeAsyncTask.class.getSimpleName();
    private static JokeApi jokeApi = null;

    private OnRetrieveJokeListener listener;

    private JokeAsyncTask(OnRetrieveJokeListener mListener) {
        listener = mListener;
    }

    // method to create instance of JokeAsyncTask
    public static void getInstance(OnRetrieveJokeListener listener) {
        new JokeAsyncTask(listener).execute();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        listener.onRetrieveStarted();
    }

    @Override
    protected String doInBackground(Void... voids) {
        if (jokeApi == null) {
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(abstractGoogleClientRequest ->
                            abstractGoogleClientRequest.setDisableGZipContent(true));
            jokeApi = builder.build();
        }

        try {
            return jokeApi.tellJoke().execute().getData();
        } catch (IOException e) {
            Log.d(TAG, "Error ! something wrong occur");
            return  e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        listener.onRetrieveFinished(result);
    }
}
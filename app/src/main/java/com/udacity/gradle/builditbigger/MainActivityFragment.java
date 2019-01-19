package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.api.JokeAsyncTask;
import com.udacity.gradle.builditbigger.api.OnRetrieveJokeListener;

import xyz.godi.displayjokes.DisplayJokesActivity;
import xyz.godi.jokes.Jokes;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Button tellJokeBtn;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        // tell joke button
        tellJokeBtn = root.findViewById(R.id.telljokeBtn);

        tellJokeBtn.setOnClickListener(v -> tellJoke());
        return root;
    }

    private void tellJoke() {
        JokeAsyncTask.getInstance(new OnRetrieveJokeListener() {
            @Override
            public void onRetrieveStarted() {
                // do something
            }

            @Override
            public void onRetrieveFinished(@Nullable String result) {
                // pass result to startJokeActivvity()
                startJokeActivvity(result);
            }
        });
    }

    // launch DisplayJokesActivity from android Joke library
    private void startJokeActivvity(String joke) {
        Intent intent = new Intent(getActivity(), DisplayJokesActivity.class);
        intent.putExtra(DisplayJokesActivity.JOKE_KEY, joke);
        startActivity(intent);
    }
}
package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import xyz.godi.displayjokes.DisplayJokesActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button tellJokeButton = findViewById(R.id.telljokeBtn);

        // tell joke click listener
        tellJokeButton.setOnClickListener(v -> tellJoke());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    Retrieve joke string from AsyncTask and open activity
    in android library to display jokes
     */
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
        Intent intent = new Intent(this, DisplayJokesActivity.class);
        intent.putExtra(DisplayJokesActivity.JOKE_KEY, joke);
        startActivity(intent);
    }
}

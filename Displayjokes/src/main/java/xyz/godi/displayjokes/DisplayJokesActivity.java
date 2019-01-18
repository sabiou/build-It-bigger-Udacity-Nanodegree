package xyz.godi.displayjokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DisplayJokesActivity extends AppCompatActivity {
    public static final String JOKE_KEY = "jokes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_jokes);
    }
}
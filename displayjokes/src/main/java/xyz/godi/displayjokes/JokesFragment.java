package xyz.godi.displayjokes;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;
/**
 * A simple {@link Fragment} subclass.
 */
public class JokesFragment extends Fragment {

    public JokesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_jokes, container, false);
        // get the joke from intent
        Intent intent = Objects.requireNonNull(getActivity()).getIntent();
        String joke = intent.getStringExtra(DisplayJokesActivity.JOKE_KEY);
        TextView tvJokes = root.findViewById(R.id.tv_jokes);
        tvJokes.setText(joke);

        return root;
    }

}

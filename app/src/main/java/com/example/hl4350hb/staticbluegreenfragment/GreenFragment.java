package com.example.hl4350hb.staticbluegreenfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hl4350hb on 10/4/17.
 */

public class GreenFragment extends Fragment {

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.green_fragment, container, false);

        int random = -1;

        // Check to see if arguments have been received
        if (getArguments() != null) {
            random = getArguments().getInt(MainActivity.RANDOM_BUNDLE_KEY, -1);
        }

        TextView showRandomTV = (TextView) view.findViewById(R.id.green_fragment_random_textview);

        if (random == -1) {
            showRandomTV.setText("No random number received :(");
        } else {
            showRandomTV.setText("The random number is " + random);
        }

        return view;
    }
}

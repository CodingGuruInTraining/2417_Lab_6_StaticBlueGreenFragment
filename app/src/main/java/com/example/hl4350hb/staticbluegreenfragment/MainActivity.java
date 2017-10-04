package com.example.hl4350hb.staticbluegreenfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String RANDOM_BUNDLE_KEY = "Your random number";

    // Create fragment instances
    private GreenFragment greenFragment = new GreenFragment();
    private BlueFragment blueFragment = new BlueFragment();

    // Labels for currently displayed fragment
    private static final String BLUE_TAG = "BLUE";
    private static final String GREEN_TAG = "GREEN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showBlueFragment();
//        updateFragment();
//
//        // Add click listener to main window
//        // android.R.id.content is a built-in reference to Activity's main UI component
//        View v = findViewById(android.R.id.content);
//        v.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                updateFragment();
//            }
//        });
    }

    private void showBlueFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(android.R.id.content, blueFragment, BLUE_TAG);
        ft.commit();
    }

    public void sendRandomNumber(int rnd) {
        // Create a Bundle to carry arguments to the Fragment
        Bundle arguments = new Bundle();
        // Add the random integer
        arguments.putInt(RANDOM_BUNDLE_KEY, rnd);
        // Pass bundle to GreenFragment
        greenFragment.setArguments(arguments);

        // Replace the blue fragment with the green fragment
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(android.R.id.content, greenFragment, GREEN_TAG);
        ft.addToBackStack(GREEN_TAG);
        ft.commit();
    }

    private void updateFragment() {
        // Swaps fragments

        // Gets reference to this Activity's FragmentManager
        FragmentManager fm = getFragmentManager();
        // Request the fm begins a Fragment Transaction
        FragmentTransaction ft = fm.beginTransaction();

        // If blue fragment is shown, replace with green fragment
        if (fm.findFragmentByTag(BLUE_TAG) != null) {
            ft.replace(android.R.id.content, greenFragment, GREEN_TAG);
        }

        // If green fragment is shown, replace with blue fragment
        else {
            ft.replace(android.R.id.content, blueFragment, BLUE_TAG);
        }

        // Committing is necessary or no changes are made
        ft.commit();
    }
}

package com.example.hl4350hb.staticbluegreenfragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

/**
 * Created by hl4350hb on 10/4/17.
 */

public class BlueFragment extends Fragment {

    MainActivity hostingActivity;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.blue_fragment, container, false);

        Button sendRndToGreen = (Button) view.findViewById(R.id.send_rnd_to_green_button);
        sendRndToGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rng = new Random();
                int rnd = rng.nextInt(100);
                hostingActivity.sendRandomNumber(rnd);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Save a reference to the hosting activity
        hostingActivity = (MainActivity) getActivity();
    }
}

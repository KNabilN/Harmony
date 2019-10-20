package com.gys.android.harmony.UserUsage;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gys.android.harmony.HomePage;
import com.gys.android.harmony.R;
import com.gys.android.harmony.activityTwo;

/**
 * A simple {@link Fragment} subclass.
 */
public class Calculator extends Fragment {


    public Calculator() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view =inflater.inflate(R.layout.fragment_caculator, container, false);

        view.findViewById(R.id.activity2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(container.getContext(), activityTwo.class);
                startActivity(intent);
            }
        });

      return view;

    }

}

package com.gys.android.harmony.Story;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gys.android.harmony.HomePage;
import com.gys.android.harmony.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoryThree extends Fragment {


    public StoryThree() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_story_three, container, false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(container.getContext(), HomePage.class);
                startActivity(intent);
                ((Activity)container.getContext()).finish();

            }
        });
//        view.findViewById(R.id.third_img).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(container.getContext(),HomePage.class);
//                startActivity(intent);
//                ((Activity)container.getContext()).finish();
//            }
//        });
        return view;}

}

package com.gys.android.harmony.Story;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gys.android.harmony.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoryOne extends Fragment {


    public StoryOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_story_one, container, false);
    }

}

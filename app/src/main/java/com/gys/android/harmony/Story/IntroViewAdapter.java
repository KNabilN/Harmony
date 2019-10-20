package com.gys.android.harmony.Story;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class IntroViewAdapter extends FragmentPagerAdapter {



    public IntroViewAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    StoryOne firstIntro = new StoryOne();
                    return firstIntro;
                case 1:
                    StoryTwo sendFragment = new StoryTwo();
                    return sendFragment ;
                case 2:
                    StoryThree notiFragment = new StoryThree();
                    return notiFragment;
                default:
                    return null ;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }



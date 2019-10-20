
package com.gys.android.harmony.UserUsage;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class UserViewAdapter extends FragmentPagerAdapter {



    public UserViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Calculator firstIntro = new Calculator();
                return firstIntro;
            case 1:
                HelpToReduce sendFragment = new HelpToReduce();
                return sendFragment ;
            default:
                return null ;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}


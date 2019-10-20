package com.gys.android.harmony.UserUsage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

import com.gys.android.harmony.R;
import com.gys.android.harmony.Story.IntroViewAdapter;

public class UserUsageActivity extends AppCompatActivity implements View.OnClickListener {
    private UserViewAdapter mPagerViewAdapter;
    private ViewPager mMainpager;
    private TextView lineCal, lineHelp, helpBtn, calBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_usage);
        mMainpager = findViewById(R.id.userfragment);
        lineCal = findViewById(R.id.line_cal);
        calBtn = findViewById(R.id.cal_btn);
        lineHelp = findViewById(R.id.line_help);
        helpBtn = findViewById(R.id.help_btn);
        mPagerViewAdapter = new UserViewAdapter(getSupportFragmentManager());
        mMainpager.setOffscreenPageLimit(1);
        // the view pager use the new adapter
        mMainpager.setAdapter(mPagerViewAdapter);
        mMainpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // here we create a method to change textbox activation

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        calBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainpager.setCurrentItem(0);
                lineHelp.setVisibility(View.GONE);
                lineCal.setVisibility(View.VISIBLE);
                calBtn.setTextColor(getResources().getColor(R.color.checked));
                helpBtn.setTextColor(getResources().getColor(R.color.grey));
            }
        });

        helpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainpager.setCurrentItem(1);
                lineHelp.setVisibility(View.VISIBLE);
                lineCal.setVisibility(View.GONE);
                calBtn.setTextColor(getResources().getColor(R.color.grey));
                helpBtn.setTextColor(getResources().getColor(R.color.checked));

            }
        });
    }

    @Override
    public void onClick(View view) {

//        if (view.getId()== R.id.help_btn){
//
//
//        }else if (view.getId()== R.id.cal_btn){
//
//
//        }
        if (mMainpager.getCurrentItem() == 0) {
//
//            mMainpager.setCurrentItem(1);
//            lineHelp.setVisibility(View.VISIBLE);
//            lineCal.setVisibility(View.GONE);
//            calBtn.setTextColor(getResources().getColor(R.color.grey));
//            helpBtn.setTextColor(getResources().getColor(R.color.checked));
//
//        } else if ( mMainpager.getCurrentItem()==1)
//        {
//            mMainpager.setCurrentItem(0);
//            lineHelp.setVisibility(View.GONE);
//            lineCal.setVisibility(View.VISIBLE);
//            calBtn.setTextColor(getResources().getColor(R.color.checked));
//            helpBtn.setTextColor(getResources().getColor(R.color.grey));
//
//
//        }
//    }
        }
    }
}


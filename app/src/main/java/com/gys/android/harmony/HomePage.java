package com.gys.android.harmony;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gys.android.harmony.Ideas.CreateIdeas;
import com.gys.android.harmony.Ideas.ShowIdeas;
import com.gys.android.harmony.Regestiration.Login;
import com.gys.android.harmony.UserUsage.ProblemActivity;
import com.gys.android.harmony.UserUsage.UserUsageActivity;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        TextView textView=findViewById(R.id.saveTheWorld);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomePage.this,HarmonyHub.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.doAction).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomePage.this, UserUsageActivity.class);
                startActivity(intent);
            }
        });
    }
}

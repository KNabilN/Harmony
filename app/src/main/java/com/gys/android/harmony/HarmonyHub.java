package com.gys.android.harmony;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gys.android.harmony.Ideas.CreateIdeas;

public class HarmonyHub extends AppCompatActivity {
    private String[] frist=
            {"Raising the expensive stuff","Elevating houses","Relocating"};
    private int[] image=
            {R.drawable.a1,R.drawable.a2,R.drawable.a3};
    private String[] sacond=
            {"$6,000 or more to elevate HVAC systems, plumbing, and electric meters",
            "$130,000 (median price) Houses can be raised above flood levels by using six-foot tall wooden stilts or concrete blocks.",
            "for houses that are in afreas of extreme flooding, one option is to relocate to higher ground."};

    RecyclerView recyclerView;
    AdpterHarmonyHub adpterHarmonyHub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harmony_hub);
        recyclerView=findViewById(R.id.harmonyHupRecyler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adpterHarmonyHub=new AdpterHarmonyHub(frist,image,sacond);
        recyclerView.setAdapter(adpterHarmonyHub);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HarmonyHub.this , CreateIdeas.class);
                startActivity(intent);
            }
        });

    }
}

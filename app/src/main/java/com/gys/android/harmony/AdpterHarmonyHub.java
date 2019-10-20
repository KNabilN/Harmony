package com.gys.android.harmony;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdpterHarmonyHub extends RecyclerView.Adapter<AdpterHarmonyHub.MyHelper>  {
private String[] frist=new String[3];
private int[] image=new int[3];
private String[] sacond=new String[3];

    public AdpterHarmonyHub(String[] frist, int[] image, String[] sacond) {
        this.frist = frist;
        this.image = image;
        this.sacond = sacond;
    }

    @NonNull
    @Override
    public MyHelper onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design,null);
        MyHelper myHelper=new MyHelper(view);
        return myHelper;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHelper holder, int position) {
        holder.frist.setText(frist[position]);
        holder.second.setText(sacond[position]);
        holder.imageView.setImageResource(image[position]);

    }

    @Override
    public int getItemCount() {
        return frist.length;
    }

    public class MyHelper extends RecyclerView.ViewHolder {
        TextView frist;
        TextView second;
        ImageView imageView;
        public MyHelper(@NonNull View itemView) {
            super(itemView);
            frist=itemView.findViewById(R.id.text_frist);
            second=itemView.findViewById(R.id.text2);
            imageView=itemView.findViewById(R.id.image);
        }
    }
}

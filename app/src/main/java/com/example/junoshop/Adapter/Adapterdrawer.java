package com.example.junoshop.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.junoshop.Model.Drawermenu;
import com.example.junoshop.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapterdrawer extends RecyclerView.Adapter<Adapterdrawer.MenuHolder> {
    Context context;
    ArrayList <Drawermenu> drawermenuArrayList = new ArrayList<>();
    public Adapterdrawer(Context context, ArrayList<Drawermenu> drawermenuArrayList) {
        this.context = context;
        this.drawermenuArrayList = drawermenuArrayList;
    }


    @NonNull
    @Override
    public MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater= LayoutInflater.from(context);
        View v= inflater.inflate(R.layout.item_1line_drawermenu,parent,false);
        MenuHolder menuHolder= new MenuHolder(v);
        return  menuHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolder holder, int position) {
        Drawermenu drawermenu= drawermenuArrayList.get(position);
        holder.tv_optionmenu.setText(drawermenu.getText_optionmenu());
        holder.img_optionmenu.setImageResource(drawermenu.getImg_optionmenu());
    }
    @Override
    public int getItemCount() {
        return drawermenuArrayList.size();
    }
    public class MenuHolder extends RecyclerView.ViewHolder{
        TextView tv_optionmenu;
        ImageView img_optionmenu;
        public MenuHolder(@NonNull View itemView) {
            super(itemView);
            tv_optionmenu= itemView.findViewById(R.id.tv_fuction_menu);
            img_optionmenu= itemView.findViewById(R.id.img_function_menu);
        }
    }
}

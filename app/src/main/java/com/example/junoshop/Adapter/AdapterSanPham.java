package com.example.junoshop.Adapter;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.junoshop.Model.ItemSanPham;
import com.example.junoshop.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterSanPham extends RecyclerView.Adapter<AdapterSanPham.Viewholder>{
    Context context ;
    ArrayList <ItemSanPham> sanPhams ;

    public AdapterSanPham(Context context, ArrayList<ItemSanPham> sanPhams) {
        this.context = context;
        this.sanPhams = sanPhams;
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v =  inflater.inflate(R.layout.item_1_line_sp,parent,false);
        Viewholder viewholder= new Viewholder(v);
        return  viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        final ItemSanPham hangsanpham = sanPhams.get(position);
        Log.d("test",hangsanpham.getHinhsp());
        Picasso.get()
                .load(hangsanpham.getHinhsp())
                .error(R.drawable.no_products_found)
                .into(holder.AnhSanPham);
        holder.TenSapPham.setText(hangsanpham.getTensp());
        holder.GiaSanPham.setText(hangsanpham.getGiasp());
    }

    @Override
    public int getItemCount() {
        return sanPhams.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        ImageView AnhSanPham;
        TextView TenSapPham;
        TextView GiaSanPham;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            AnhSanPham= itemView.findViewById(R.id.img_product);
            TenSapPham= itemView.findViewById(R.id.tv_product);
            GiaSanPham= itemView.findViewById(R.id.tv_cost);
        }
    }


}

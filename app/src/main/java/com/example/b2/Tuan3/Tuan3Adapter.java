package com.example.b2.Tuan3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.b2.R;

import java.util.ArrayList;

public class Tuan3Adapter extends BaseAdapter {
    private final ArrayList<Tuan3Contact> ls;
    private final Context context;
    public Tuan3Adapter(ArrayList<Tuan3Contact> ls, Context context) {
        this.ls = ls;
        this.context = context;
    }
    @Override
    public int getCount() { //lấy tổng số item
        return ls.size();
    } // lấy tổng item
    @Override
    public Object getItem(int position) {//lấy về vị trí item
        return ls.get(position);
    } // lấy vị trí item đang thao tác
    @Override
    public long getItemId(int position) {//lấy id item
        return position;
    }// lấy id item đang thao tác
    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {//tạo view , gán data
        //B1: Tạo view
        View1 vax;
        // Nếu chưa có view -> tạo view mới
        if(convertView==null){
            vax = new View1(); // tạo view mới
            // ánh xạ layout
            convertView = LayoutInflater.from(context).inflate(R.layout.tuan33_item_view,null);
            // ánh xạ từng thành phần trong layout
            vax.img_hinh = convertView.findViewById(R.id.T3ItemHinh);
            vax.tv_ten = convertView.findViewById(R.id.T3ItemName);
            vax.tv_mota = convertView.findViewById(R.id.T3ItemDescription);
            // tạo template để lần sau sử dụng
            convertView.setTag(vax);
        } else { // Nếu có view rồi ta sử dụng lại view cũ
            // lấy view cũ
            vax = (View1) convertView.getTag();
        }
        // gán dữ liệu cho layout
        vax.img_hinh.setImageResource(ls.get(position).getImage());
        vax.tv_ten.setText(ls.get(position).getName());
        vax.tv_mota.setText(ls.get(position).getDesc());

        return convertView; //trả về kết quả
    }
    // Định nghĩa view
    class View1{
        ImageView img_hinh;
        TextView tv_ten ;
        TextView tv_mota ;
    }
}

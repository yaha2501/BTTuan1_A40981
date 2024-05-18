package com.example.b2.Tuan6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.b2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends BaseAdapter{
    private Context mContext;
    private List<Product> mProductList;

    public ProductAdapter(Context mContext, List<Product> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }
    @Override
    public int getCount() {
         return mProductList.size();
    }
    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // tạo view
        ViewHolderT61 holder;
        if(convertView==null)// tạo view moi
        {
            // object generate layout
            convertView= LayoutInflater.from(mContext).inflate(R.layout.tuan61_item_view,parent,false);
            //  Đến đây, ta đã có layout trắng. Sau đó ta ánh xạ từng trường
            holder=new ViewHolderT61();
            holder.imageview=convertView.findViewById(R.id.item_product_imageView);
            holder.styleIdTv=convertView.findViewById(R.id.item_styleid_textview);
            holder.brandTv=convertView.findViewById(R.id.item_branch_textview);
            holder.priceTv=convertView.findViewById(R.id.item_price_textview);
            holder.additionalInfoTv=convertView.findViewById(R.id.item_additionalInfo_textview);
            // tạo template để lần sau sử dụng
            convertView.setTag(holder);
        }
        else {
            // lấy view cũ
            holder=(ViewHolderT61) convertView.getTag();
        }
        // set data cho view
        Product product=mProductList.get(position);
        if(product!=null){
            // display image
            Picasso.get().load(product.getSearchImage()).into(holder.imageview);
            // set dữ liệu cho các trường khác
            holder.styleIdTv.setText(product.getStyleId());
            holder.brandTv.setText(product.getBrand());
            holder.priceTv.setText(product.getPrice());
            holder.additionalInfoTv.setText(product.getAdditionalInfo());
        }
        return convertView;
    }
    static class ViewHolderT61 {
        ImageView imageview;
        TextView styleIdTv, brandTv, priceTv, additionalInfoTv;
    }
}

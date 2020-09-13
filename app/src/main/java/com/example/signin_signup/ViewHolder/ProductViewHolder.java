package com.example.signin_signup.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.signin_signup.Interface.ItemClickListner;
import com.example.signin_signup.R;


public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txtProductName, txtProductAuthor;
    public ImageView imageView;
    public ItemClickListner listener;

    public ProductViewHolder(View itemView){
        super (itemView);

        imageView = (ImageView) itemView.findViewById(R.id.product_image);
        txtProductName = (TextView) itemView.findViewById(R.id.product_name);
        txtProductAuthor = (TextView) itemView.findViewById(R.id.product_author);
    }

    public void setItemClickListener (ItemClickListner listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view){

        listener.onClick(view, getLayoutPosition(), false);
    }
}

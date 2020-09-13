package com.example.signin_signup.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.signin_signup.Interface.ItemClickListner;
import com.example.signin_signup.R;


public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView txtBookName,txtAuthor;
    public ImageView imageView;
    private ItemClickListner itemClickListner;

    
    public CartViewHolder(@NonNull View itemView)
    {
        super(itemView);

        txtAuthor=(TextView) itemView.findViewById(R.id.cart_author);
        txtBookName=(TextView) itemView.findViewById(R.id.cart_name);
        imageView=(ImageView) itemView.findViewById(R.id.cart_Book_image);

    }


    @Override
    public void onClick(View view)
    {
        itemClickListner.onClick(view, getAdapterPosition(), false);
    }
    public void setItemClickListner(ItemClickListner itemClickListner)
    {
        this.itemClickListner = itemClickListner;
    }
}

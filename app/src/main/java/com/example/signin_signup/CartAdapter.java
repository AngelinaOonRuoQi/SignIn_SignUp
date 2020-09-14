package com.example.signin_signup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.signin_signup.model.Project;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{
    private static final String Tag = "RecyclerView";
    private Context mContext;
    private ArrayList<Project> bookList;

    public CartAdapter( Context mContext,ArrayList<Project> bookList){
        this.mContext=mContext;
        this.bookList=bookList;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtAuthor.setText(bookList.get(position).getAuthor());
        holder.txtBookName.setText(bookList.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView txtAuthor,txtBookName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtAuthor=(TextView) itemView.findViewById(R.id.cart_author);
            txtBookName=(TextView) itemView.findViewById(R.id.cart_name);


        }
    }

}

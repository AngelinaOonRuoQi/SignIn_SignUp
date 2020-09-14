package com.example.signin_signup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.signin_signup.model.History;
import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private static final String Tag = "RecyclerView";
    private Context mContext;
    private ArrayList<History> historyList;

    public HistoryAdapter( Context mContext,ArrayList<History> historyList){
        this.mContext=mContext;
        this.historyList=historyList;
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_cart_items_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtAuthor.setText(historyList.get(position).getAuthor());
        holder.txtBookName.setText(historyList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtAuthor,txtBookName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtAuthor=(TextView) itemView.findViewById(R.id.history_cart_author);
            txtBookName=(TextView) itemView.findViewById(R.id.history_cart_name);

        }
    }







}

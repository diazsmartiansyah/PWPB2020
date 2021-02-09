package com.diazs.sqllite;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.UserViewHolder> {
    Context context;
    OnUserClickListener listener;

    List<PersonBean> listPersonInfo;

    public RecyclerviewAdapter(Context context, List<PersonBean> listPersonInfo, OnUserClickListener listener){
        this.context = context;
        this.listPersonInfo = listPersonInfo;
        this.listener = listener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row_item, parent, false);
        UserViewHolder userViewHolder = new UserViewHolder(view);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewAdapter.UserViewHolder holder, int position) {
        final PersonBean currentPerson = listPersonInfo.get(position);
        holder.ctxtName.setText(currentPerson.getName());
        holder.ctxtAge.setText(String.valueOf(currentPerson.getAge()));
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onUserClick(currentPerson, "Edit");
            }
        });

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onUserClick(currentPerson, "Delete");
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPersonInfo.size();
    }

    public interface OnUserClickListener{
        void onUserClick(PersonBean currentPerson, String action);
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        TextView ctxtAge, ctxtName;
        ImageView imgDelete, imgEdit;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            ctxtAge = itemView.findViewById(R.id.ctxtAge);
            ctxtName = itemView.findViewById(R.id.ctxtName);
            imgDelete = itemView.findViewById(R.id.imgdelete);
            imgEdit = itemView.findViewById(R.id.imgedit);
        }
    }
}

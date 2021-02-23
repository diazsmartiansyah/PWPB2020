package com.diazs.market.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.diazs.market.Model.Item;
import com.diazs.market.R;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.Holder> {
    Context context;
    List<Item> listItems;
    OnUserClickListener listener;

    public RecyclerviewAdapter(Context context, List<Item> listItems, OnUserClickListener onUserClickListener){
        this.context = context;
        this.listItems = listItems;
        this.listener = onUserClickListener;
    }

    public interface OnUserClickListener{
        void onUserClick(Item item, String action);
    }

    @NonNull
    @Override
    public RecyclerviewAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        final Item currentItem = listItems.get(position);
        holder.inpName.setText(currentItem.getName());
        holder.inpDescription.setText(currentItem.getDescription());
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onUserClick(currentItem, "Edit");
            }
        });
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onUserClick(currentItem, "Delete");
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView inpName, inpDescription, inpDate;
        ImageView btnEdit, btnDelete;
        public Holder(@NonNull View itemView) {
            super(itemView);
            inpName = itemView.findViewById(R.id.inp_name);
            inpDescription = itemView.findViewById(R.id.inp_description);
            inpDate = (TextView) itemView.findViewById(R.id.inp_date);
            btnEdit = (ImageView) itemView.findViewById(R.id.btn_edit);
            btnDelete = (ImageView) itemView.findViewById(R.id.btn_delete);
        }
    }
}

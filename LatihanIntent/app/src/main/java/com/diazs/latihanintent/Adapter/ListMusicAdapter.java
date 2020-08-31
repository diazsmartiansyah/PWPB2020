package com.diazs.latihanintent.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.diazs.latihanintent.Music;
import com.diazs.latihanintent.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListMusicAdapter extends RecyclerView.Adapter<ListMusicAdapter.ListViewHolder> {
    ArrayList<Music> listMusic;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickListener) {
        this.onItemClickCallback = onItemClickListener;
    }
    public ListMusicAdapter(ArrayList<Music> listData){
        listMusic = listData;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_music,parent,false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Music music = listMusic.get(position);
        Glide.with(holder.itemView.getContext())
                .load(music.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgMusic);

        holder.tvJudulLagu.setText(music.getJudul());
        holder.tvPenyanyi.setText(music.getPenyanyi());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listMusic.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listMusic.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMusic;
        TextView tvJudulLagu, tvPenyanyi;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMusic = (ImageView) itemView.findViewById(R.id.img_item_photo);
            tvJudulLagu = itemView.findViewById(R.id.judul_lagu);
            tvPenyanyi = itemView.findViewById(R.id.penyanyi);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(Music music);
    }
}

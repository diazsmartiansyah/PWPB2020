package com.diazs.latihanintent;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.diazs.latihanintent.Adapter.ListMusicAdapter;
import com.diazs.latihanintent.Music;
import com.diazs.latihanintent.MusicData;
import com.diazs.latihanintent.R;

import java.util.ArrayList;

public class PremiumMusicActivity extends AppCompatActivity {
    private RecyclerView rvPaidMusic;
    private ArrayList<Music> list = new ArrayList<>();
    private String title = "Premium Music";
    public static MediaPlayer music = new MediaPlayer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_activity);
        rvPaidMusic = findViewById(R.id.rv_free_music);
        rvPaidMusic.setHasFixedSize(true);
        getSupportActionBar().setTitle(title);

        list.addAll(new MusicData().getPaidMusicListData());
        showRecycleView();

    }

    private void playMusic(Music data){
        if (music.isPlaying()){
            music.stop();
            music.release();

        }

        if (FreeMusicActivity.music.isPlaying()){
            FreeMusicActivity.music.stop();
            FreeMusicActivity.music.release();
            FreeMusicActivity.music = new MediaPlayer();
        }

        music = MediaPlayer.create(this, data.getLagu());
        music.start();
    }

    private void showRecycleView() {
        rvPaidMusic.setLayoutManager(new LinearLayoutManager(this));
        ListMusicAdapter listMusicAdapter = new ListMusicAdapter(list);
        rvPaidMusic.setAdapter(listMusicAdapter);

        listMusicAdapter.setOnItemClickCallback(new ListMusicAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Music music) {
                playMusic(music);
            }
        });
    }
}

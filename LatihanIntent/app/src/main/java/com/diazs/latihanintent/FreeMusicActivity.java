package com.diazs.latihanintent;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.diazs.latihanintent.Adapter.ListMusicAdapter;

import java.util.ArrayList;

public class FreeMusicActivity extends AppCompatActivity {
    private RecyclerView rvFreeMusic;
    private ArrayList<Music> list = new ArrayList<>();
    private String title = "Free Music";
    public static MediaPlayer music = new MediaPlayer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_activity);
        rvFreeMusic = findViewById(R.id.rv_free_music);
        rvFreeMusic.setHasFixedSize(true);
        getSupportActionBar().setTitle(title);

        list.addAll(new MusicData().getFreeMusicListData());
        showRecycleView();

    }

    private void playMusic(Music data){
        if (music.isPlaying()){
            music.stop();
            music.release();
        }
        if (PremiumMusicActivity.music.isPlaying()){
            PremiumMusicActivity.music.stop();
            PremiumMusicActivity.music.release();
            PremiumMusicActivity.music = new MediaPlayer();
        }
        music = MediaPlayer.create(this, data.getLagu());
        music.start();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, PremiumMusicActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_premium, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void showRecycleView() {
        rvFreeMusic.setLayoutManager(new LinearLayoutManager(this));
        ListMusicAdapter listMusicAdapter = new ListMusicAdapter(list);
        rvFreeMusic.setAdapter(listMusicAdapter);

        listMusicAdapter.setOnItemClickCallback(new ListMusicAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Music music) {
                playMusic(music);
            }
        });
    }
}

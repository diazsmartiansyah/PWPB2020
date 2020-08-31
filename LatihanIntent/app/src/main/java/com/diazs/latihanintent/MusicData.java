package com.diazs.latihanintent;

import java.util.ArrayList;

public class MusicData {
    public class FreeMusic {
        String judul[] = {
                "Despacito",
                "Before You Go",
                "Someone You Loved",
                "Stuck With You,",
                "On My Way",
                "Alone Pt. II",
                "Selamat Tinggal",
                "There You Are"
        };

        String penyanyi[] = {
                "Luis Fonsi & Daddy Yankee ft Justin Bieber",
                "Lewis Capaldi",
                "Lewis Capaldi",
                "Justin Bieber ft Ariana Grande",
                "Alan Walker ft Sabrina Carpenter & Farruko",
                "Alan Walker ft Ava Max",
                "Virgoun ft Audy",
                "Zayn Malik"

        };

        int photo[] = {
                R.drawable.despacito,
                R.drawable.beforeyougo,
                R.drawable.someoneyouloved,
                R.drawable.stuckwithyou,
                R.drawable.onmyway,
                R.drawable.alonept2,
                R.drawable.selamattinggal,
                R.drawable.thereyouare
        };

        int music[] = {
                R.raw.despacitojustin,
                R.raw.beforeyougo,
                R.raw.someoneyouloved,
                R.raw.stuckwithyou,
                R.raw.onmyway,
                R.raw.alonept2,
                R.raw.selamattinggal,
                R.raw.thereyouare
        };

    }

    public class PaidMusic {
        String judul[] = {
                "Dusk Till Dawn",
                "Night Changes",
                "Still Got Time",
                "Love Story (Cover)",
                "Bad Liar",
                "Insomnia",
                "Scripted",
                "It's You",
                "Entertainer"
        };

        String penyanyi[] = {
                "Zayn Malik ft Sia",
                "One Direction",
                "Zayn Malik ft PARTYNEXTDOOR",
                "Eltasya Natasha ft Indah Aqila",
                "Imagine Dragons",
                "Zayn Malik",
                "Zayn Malik",
                "Zayn Malik",
                "Zayn Malik"
        };

        int photo[] = {
                R.drawable.dusktilldawn,
                R.drawable.nightchanges,
                R.drawable.stillgottime,
                R.drawable.lovestory,
                R.drawable.badliar,
                R.drawable.insomnia,
                R.drawable.scripted,
                R.drawable.itsyou,
                R.drawable.entertainer
        };

        int music[] = {
                R.raw.dusktilldawn,
                R.raw.nightchanges,
                R.raw.stillgottime,
                R.raw.lovestory,
                R.raw.badliar,
                R.raw.insomnia,
                R.raw.scripted,
                R.raw.itsyou,
                R.raw.entertainer
        };
    }

    public ArrayList<Music> getFreeMusicListData(){
        ArrayList<Music> listData = new ArrayList<>();
        for (int i = 0; i <  new FreeMusic().judul.length; i++) {
            Music music = new Music();
            music.setJudul(new FreeMusic().judul[i]);
            music.setPenyanyi(new FreeMusic().penyanyi[i]);
            music.setPhoto(new FreeMusic().photo[i]);
            music.setLagu(new FreeMusic().music[i]);
            listData.add(music);
        }
        return listData;
    }

    public ArrayList<Music> getPaidMusicListData(){
        ArrayList<Music> listData = new ArrayList<>();
        for (int i = 0; i <  new PaidMusic().judul.length; i++) {
            Music music = new Music();
            music.setJudul(new PaidMusic().judul[i]);
            music.setPenyanyi(new PaidMusic().penyanyi[i]);
            music.setPhoto(new PaidMusic().photo[i]);
            music.setLagu(new PaidMusic().music[i]);
            listData.add(music);
        }
        return listData;
    }
}

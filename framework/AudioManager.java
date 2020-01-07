package com.redlabs.finalgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;

public class AudioManager {



    public static Dictionary<String,Sound> sounds = new Hashtable<>();

    public static Dictionary<String, Music> musics = new Hashtable<>();


    public static void AddSoundClip(String key,String path){
        Sound _sound = Gdx.audio.newSound(Gdx.files.internal(path));
        sounds.put(key,_sound);
    }

    public static void AddMusicClip(String key,String path){
        Music _music = Gdx.audio.newMusic(Gdx.files.internal(path));
        musics.put(key,_music);
    }

    public static void PlaySound(String key){
        sounds.get(key).play();
    }

    public static void PlaySound(String[] key){
        int random = new Random().nextInt(key.length);
        sounds.get(key[random]).play();
    }


    public static void PlayMusic(String key){
        musics.get(key).setVolume(0.001f);
        musics.get(key).setLooping(true);
        musics.get(key).play();
        System.out.println("Volume : " + musics.get(key).getVolume());
    }

    public static void StopMusic(String key){
        musics.get(key).stop();
    }

}

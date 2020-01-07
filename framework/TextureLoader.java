package com.redlabs.finalgame;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class TextureLoader {

    private static Dictionary<String,Texture> textures = new Hashtable<>();

    private static ArrayList<AnimationClip> animationClips = new ArrayList<>();

    public static Texture AddTexture(String _key,String path){
        Texture tex = new Texture(path);
        textures.put(_key,tex);
        return tex;
    }

    public static void RemoveTexture(String _key){
        textures.remove(textures.get(_key));
    }

    public static Texture GetTexture(String _key){
        return textures.get(_key);
    }

    public  static void  AddAnimationClip(String _key, String _path, int _frameCount̥){
        AnimationClip clip = new AnimationClip();
        clip.name=_key;
        try {
            ArrayList<String> frames = new ArrayList<>();

            for (int i = 0; i < _frameCount̥; i++) {
                AddTexture(_key + i,_path+"/" + i + ".png");
                frames.add(_key+i);
            }

            clip.frames = frames;
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

        animationClips.add(clip);
    }

    public static AnimationClip GetAnimationClip(String _key){
        for (int i = 0; i < animationClips.size(); i++) {
            if (animationClips.get(i).name == _key){
                return animationClips.get(i);
            }
        }
        return null;
    }

}

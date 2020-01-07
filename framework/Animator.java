package com.redlabs.finalgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Animator extends Component {

    private ArrayList<AnimationClip> clips = new ArrayList<>();

    private int currFrame=0;
    private float time=0;

    public String currAnim="";
    public float speed=0.25f;

    SpriteRenderer renderer;

    @Override
    public void Init() {
        renderer = (SpriteRenderer) gameObject.GetComponent("SpriteRenderer");
    }

    public void AddAnimation(AnimationClip _clip){
        clips.add(_clip);
        if (currAnim==""){
            currAnim = _clip.name;
        }
    }

    @Override
    public void Update() {


        if (currAnim.equals("")){
            return;
        }


        if (time<speed){
            time+=Gdx.graphics.getDeltaTime();
        }else{
            time=0;
            ChangeFrame(currFrame);

            if (currFrame!=TextureLoader.GetAnimationClip(currAnim).frames.size()-1){
                currFrame+=1;
            }else{
                currFrame=0;
            }

        }

    }

    public void PlayAnimation(String _key){
        if (_key!=currAnim){
            currAnim=_key;
            currFrame=0;
            time=0;
            ChangeFrame(currFrame);
        }
    }

    public void PlayAnimation(String _key,float _speed){
        if (_key!=currAnim){
            currAnim=_key;
            currFrame=0;
            time=0;
            speed=_speed;
            ChangeFrame(currFrame);
        }
    }

    public void PlayAnimation(String _key,float _speed,int startFrame){
        if (_key!=currAnim){
            currAnim=_key;
            currFrame=startFrame;
            time=0;
            speed=_speed;
            ChangeFrame(currFrame);
        }
    }


    void ChangeFrame(int i){
       // System.out.println("Frame :" + currAnim);
        renderer.sprite = TextureLoader.GetTexture(TextureLoader.GetAnimationClip(currAnim).frames.get(i));
    }



}

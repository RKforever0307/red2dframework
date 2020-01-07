package com.redlabs.finalgame;

import com.badlogic.gdx.Gdx;
import com.redlabs.finalgame.Utils.Vector;

import java.util.ArrayList;

public class ClickEventManager {

    public boolean active=true;

    ArrayList<OnClick> onClickEvent = new ArrayList<>();

    ArrayList<Integer> ids = new ArrayList<>();
    boolean onClicked;

    public static ClickEventManager current;

    public ClickEventManager(){
        current=this;
    }

    public  void AddListener(OnClick _onClick,int gameObjectID){
        onClickEvent.add(_onClick);
        ids.add(gameObjectID);
    }

    public  void RemoveListener(int gameObjectID){

        for (int i = 0; i < ids.size(); i++) {
            if (ids.get(i)==gameObjectID){
                onClickEvent.remove(i);
                ids.remove(i);
            }
        }

    }


    public void CheckEvents(){

        CheckOnClickEvents(ClickType.Hover,Gdx.input.getX(),Gdx.input.getY());

    }

    public  void CheckOnClickEvents(ClickType _type,int touchID){
        for (int i = 0; i < onClickEvent.size(); i++) {
            if (GameObject.FindGameObject(ids.get(i)).transform.GetRect().OverlapPoint(new Vector(Gdx.input.getX(touchID),Game.Screen.y-Gdx.input.getY(touchID)))){
                onClickEvent.get(i).OnClick(_type);
            }
        }
    }

    public void EnableClick(){
        System.out.println("Enable Click------------------------------");
        active=true;
    }

    public void CheckOnClickEvents(ClickType _type,int x,int y){

        if (!active){
            return;
        }

        float maxDepth=-1000;
        int index=-1;

        for (int i = 0; i < onClickEvent.size(); i++) {
            if (GameObject.FindGameObject(ids.get(i)).active){
                if (GameObject.FindGameObject(ids.get(i)).transform.GetRect().OverlapPoint(new Vector(x,Game.Screen.y-y))){

                    //System.out.println(GameObject.FindGameObject(ids.get(i)).name + " Depth : " + GameObject.FindGameObject(ids.get(i)).depth + ">" + maxDepth);

                    if (GameObject.FindGameObject(ids.get(i)).depth>maxDepth){
                        maxDepth=GameObject.FindGameObject(ids.get(i)).depth;
                        index =i;
                    }

                   // if (_type==ClickType.Up){
                   //     active=false;
                   //     Time.DelayInvoke(this,"EnableClick",1);
                   //     i=onClickEvent.size();
                   // }

                }
            }
        }


        if (index!=-1){
            onClickEvent.get(index).OnClick(_type);
        }


    }

}

package com.redlabs.finalgame;

import com.badlogic.gdx.Gdx;
import com.redlabs.finalgame.Utils.Vector;

import java.util.ArrayList;

public class CollisionEventManager {

    ArrayList<Collision> onCollisionEvent = new ArrayList<>();

    ArrayList<Integer> ids = new ArrayList<>();

    public static CollisionEventManager current;

    public CollisionEventManager(){
        current=this;
    }

    public  void AddListener(Collision _collision,int gameObjectID){
        onCollisionEvent.add(_collision);
        ids.add(gameObjectID);
    }

    public  void RemoveListener(int gameObjectID){

        for (int i = 0; i < ids.size(); i++) {
            if (ids.get(i)==gameObjectID){
                onCollisionEvent.remove(i);
                ids.remove(i);
            }
        }

    }


    public  void CheckEvents(){
        CheckOnClickEvents();
    }

    public  void CheckOnClickEvents(){
        for (int i = 0; i < onCollisionEvent.size(); i++) {
            for (int j = 0; j < onCollisionEvent.size(); j++) {


                if (GameObject.FindGameObject(ids.get(i)).ID !=(GameObject.FindGameObject(ids.get(j)).ID)){

                    if (GameObject.FindGameObject(ids.get(i)).transform.GetRect().OverlapRect(GameObject.FindGameObject(ids.get(j)).transform.GetRect())){
                        onCollisionEvent.get(i).OnCollision(GameObject.FindGameObject(ids.get(j)));
                    }

                }


            }
        }
    }
}

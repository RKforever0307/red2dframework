package com.redlabs.finalgame;

import java.util.ArrayList;
import java.util.Collections;

import sun.java2d.Disposer;

public class Scene {
    ArrayList<GameObject> gameObjects = new ArrayList<>();

    int uniqueID=0;

    public void RestartScene(){


        for (int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).Destroy();
        }

        ClickEventManager.current.ids.clear();
        ClickEventManager.current.onClickEvent.clear();

        gameObjects.clear();

        InitScene();

    }


    public void UnloadScene(){

        for (int i = 0; i < gameObjects.size(); i++) {
            if (!gameObjects.get(i).isGlobal){
                gameObjects.get(i).Destroy();
            }
        }

        ClickEventManager.current.ids.clear();
        ClickEventManager.current.onClickEvent.clear();


    }


    public void UpdateGameObjects(){
        UpdateScene();
        for (int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).UpdateComponents();
        }
    }

    public void AddGameObject(GameObject _gameObject){
        _gameObject.ID= uniqueID;
        gameObjects.add(_gameObject);
        uniqueID+=1;
    }

    public void RemoveGameObject(int id){
        int index=-1;
        for (int i = 0; i < gameObjects.size(); i++) {
            if (gameObjects.get(i).ID==id){
                index=i;
            }
        }
        if (index!=-1){
            gameObjects.remove(index);
        }
    }

    public void SortDepth(){

        for (int i = 0; i < gameObjects.size(); i++) {
            for (int j = i; j < gameObjects.size(); j++) {
                if (gameObjects.get(i).depth > gameObjects.get(j).depth){
                    Collections.swap(gameObjects,i,j);
                }
            }
        }
    }

    public void InitScene(){

    }

    public void UpdateScene(){

    }

}

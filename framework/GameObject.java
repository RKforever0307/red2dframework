package com.redlabs.finalgame;

import com.badlogic.gdx.Gdx;
import com.redlabs.finalgame.Utils.Vector;

import java.util.ArrayList;

public class GameObject {

    public boolean active=true;
    public int ID=-1;
    public float timeSpan=-1;
    public String name="New GameObject";
    public String tag="Untagged";
    public boolean noDepth=false;
    public float depth=0;
    public boolean isGlobal=false;

    ArrayList<Component> components = new ArrayList<>();

    public Transform transform;

    public GameObject(){
        transform = new Transform();
        Game.currentScene.AddGameObject(this);
    }

    public GameObject(String _name, Vector _pos,float _angle, Vector _scale){

        transform = new Transform();
        transform.position = _pos;
        transform.angle = _angle;
        transform.scale = _scale;

        name=_name;

        Game.currentScene.AddGameObject(this);
    }

    public void InitGameObject(){

    }

    public static GameObject FindGameObject(int id){
        for (int i = 0; i < Game.currentScene.gameObjects.size(); i++) {
            if (Game.currentScene.gameObjects.get(i).ID == id){
                return Game.currentScene.gameObjects.get(i);
            }
        }
        return null;
    }

    public static GameObject FindGameObject(String _name){
        for (int i = 0; i < Game.currentScene.gameObjects.size(); i++) {
            if (Game.currentScene.gameObjects.get(i).name.equals(_name)){
                return Game.currentScene.gameObjects.get(i);
            }
        }
        return null;
    }

    public Component AddComponent(Component _component){
        _component.gameObject=this;
        _component.Init();
        components.add(_component);
        return _component;
    }

    public Component GetComponent(String _componentName){
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i).getClass().getSimpleName().equals(_componentName)){
                return components.get(i);
            }
        }
        return null;
    }


    public void UpdateComponents(){
        if (!active){
            return;
        }
        if(timeSpan!=-1){
            if (timeSpan>0){
                timeSpan-= Gdx.graphics.getDeltaTime();
            }else{
                Destroy();
            }
        }

        for (int i = 0; i < components.size(); i++) {
            components.get(i).Update();
        }
    }

    public void Destroy(){
        System.out.println("Destroying : " + name);
        for (int i = 0; i < components.size(); i++) {
            components.get(i).Destroy();
        }
        components.clear();
        Game.currentScene.RemoveGameObject(ID);
    }



}

package com.redlabs.finalgame;

public class SceneManager {

    public static void LoadScene(Scene _scene){

        if (Game.currentScene!=null){
            Game.currentScene.UnloadScene();
        }
        Game.currentScene = _scene;
        _scene.InitScene();

    }

}

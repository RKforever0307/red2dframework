package com.redlabs.finalgame;

import DesiGangWar.Scenes.LoadingScene;

public class MainGame {


    void Begin(){

        LoadingScene baseScene = new LoadingScene();

        SceneManager.LoadScene(baseScene);

    }

}

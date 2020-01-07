package com.redlabs.finalgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.redlabs.finalgame.Utils.Vector;

import java.net.*;
import java.io.*;

public class Game extends ApplicationAdapter {

	MainGame mg = new MainGame();
	ClickEventManager clickEventManager;
	CollisionEventManager collisionEventManager;

	InputHandler handler;

	public static SpriteBatch batch;


	public static Vector Screen;

	public static Scene currentScene;


	@Override
	public void create () {
		Screen = new Vector(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

		clickEventManager = new ClickEventManager();
		collisionEventManager = new CollisionEventManager();
		handler = new InputHandler();
		Gdx.input.setInputProcessor(handler);

	    batch = new SpriteBatch();
		mg.Begin();
	}

	@Override
	public void render () {

		Time.ClickTick(Gdx.graphics.getDeltaTime());

        Gdx.gl.glClearColor(0.1f, 0.01f, 0.01f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        currentScene.UpdateGameObjects();
		handler.Update();
        ClickEventManager.current.CheckEvents();
        CollisionEventManager.current.CheckEvents();

	}
	
	@Override
	public void dispose () {

	}
}

package com.redlabs.finalgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor {

    public boolean[] mouseHolding = new boolean[]{false,false,false};


    public void Update(){
        for (int i = 0; i < 3; i++) {
            if (mouseHolding[i]){
                ClickEventManager.current.CheckOnClickEvents(ClickType.Hold, Gdx.input.getX(i),Gdx.input.getY(i));
            }
        }

    }



    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        mouseHolding[pointer]=true;
        ClickEventManager.current.CheckOnClickEvents(ClickType.Pressed,screenX,screenY);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        ClickEventManager.current.CheckOnClickEvents(ClickType.Hold,screenX,screenY);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        mouseHolding[pointer]=false;
        ClickEventManager.current.CheckOnClickEvents(ClickType.Up,screenX,screenY);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }
}

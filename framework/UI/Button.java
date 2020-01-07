package com.redlabs.finalgame.UI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.redlabs.finalgame.AudioManager;
import com.redlabs.finalgame.ClickEventManager;
import com.redlabs.finalgame.ClickType;
import com.redlabs.finalgame.Component;
import com.redlabs.finalgame.FunctionEvent;
import com.redlabs.finalgame.OnClick;
import com.redlabs.finalgame.SpriteRenderer;
import com.redlabs.finalgame.Utils.Vector;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Button extends Component implements OnClick {

    FunctionEvent onClick;

    SpriteRenderer renderer;
    Texture texture;

    Text textRenderer;

    String text;

    BitmapFont font;

    public Button(String _name, BitmapFont _font, Texture _texture, Object _object, String _functionName){
        font = _font;
        text = _name;
        texture = _texture;
        if (_object!=null){
            onClick = new FunctionEvent(_object,_functionName);
        }
    }

    @Override
    public void Init() {
        ClickEventManager.current.AddListener(this,gameObject.ID);
        InitSprite();
    }

    void InitSprite(){
        renderer = (SpriteRenderer)gameObject.AddComponent(new SpriteRenderer(texture,false));
        textRenderer = (Text) gameObject.AddComponent(new Text(text,font, new Vector(0,0)));
    }



    @Override
    public void Destroy() {
        ClickEventManager.current.RemoveListener(gameObject.ID);
    }

    @Override
    public void OnClick(ClickType _clickType) {

        if (onClick==null){
            return;
        }

        if (_clickType==ClickType.Pressed){
            renderer.color = Color.GRAY;
            gameObject.transform.localScale=new Vector(0.95f,0.95f);
        }

        if (_clickType==ClickType.Up){
            renderer.color = Color.WHITE;
            onClick.Invoke();
            AudioManager.PlaySound("Tap");
            gameObject.transform.localScale=new Vector(1f,1f);
        }

    }
}

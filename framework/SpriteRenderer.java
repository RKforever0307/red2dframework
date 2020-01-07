package com.redlabs.finalgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.redlabs.finalgame.Utils.Vector;

import DesiGangWar.Enums.GameState;

public class SpriteRenderer extends Component{

    public Texture sprite;

    public boolean debugMode=false;

    public boolean maintainAspect=true;

    public boolean flipX,flipY;

    ShapeRenderer shape;

    public Sprite gdxSprite;

    public Color color=Color.WHITE;

    public SpriteRenderer(Texture _sprite,boolean _maintainAspect){
        shape = new ShapeRenderer();
        sprite=_sprite;
        maintainAspect=_maintainAspect;
        gdxSprite = new Sprite();
        gdxSprite.setTexture(_sprite);
    }

    @Override
    public void Init() {
        gameObject.transform.size.y = Game.Screen.y;

        if (maintainAspect){
            gameObject.transform.size.x = Game.Screen.y * (sprite.getWidth()/ sprite.getHeight());
        }else{
            gameObject.transform.size.x = Game.Screen.x;
        }

        gameObject.transform.SetPivot(new Vector((gameObject.transform.scale.x * gameObject.transform.size.x)/2,0));
    }

    @Override
    public void Update() {

       // gdxSprite.setBounds(gameObject.transform.GetRect().x,gameObject.transform.GetRect().y,gameObject.transform.GetRect().witdh,gameObject.transform.GetRect().height);
       // gdxSprite.setCenter(gameObject.transform.GetRect().center.x,gameObject.transform.GetRect().center.y);
       // Game.batch.begin();
       // gdxSprite.draw(Game.batch);
       // Game.batch.end();

        Game.batch.begin();
        Game.batch.setColor(color);
        Game.batch.draw(sprite,gameObject.transform.GetRect().x ,gameObject.transform.GetRect().y,gameObject.transform.GetRect().center.x-gameObject.transform.GetRect().x,gameObject.transform.GetRect().center.y-gameObject.transform.GetRect().y,gameObject.transform.GetRect().witdh,gameObject.transform.GetRect().height,gameObject.transform.localScale.x,gameObject.transform.localScale.y,gameObject.transform.angle,0,0,sprite.getWidth(),sprite.getHeight(),flipX,flipY);
        Game.batch.end();


        if (debugMode){
            shape.setAutoShapeType(true);
            shape.begin();
            shape.rect(gameObject.transform.GetRect().x,gameObject.transform.GetRect().y,gameObject.transform.GetRect().witdh,gameObject.transform.GetRect().height);
            shape.circle(gameObject.transform.GetRect().center.x,gameObject.transform.GetRect().center.y,8f);
            shape.end();
        }
    }

}

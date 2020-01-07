package com.redlabs.finalgame.UI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.redlabs.finalgame.Component;
import com.redlabs.finalgame.Game;
import com.redlabs.finalgame.Utils.Vector;

public class Text extends Component {

    public String value="";
    public BitmapFont font;
    public Vector offset;

    public Color color;

    public Text(String _value,BitmapFont _font,Vector _offset) {
        value = _value;
        font = _font;
        offset = _offset;
        color = new Color(111.0f/255.0f,75.0f/255.0f,52.0f/255.0f,1.0f);
    }

    @Override
    public void Init() {

    }

    public void Update(){
        Game.batch.begin();
        font.setColor(color);
        font.draw(Game.batch,value,((gameObject.transform.position.x*Game.Screen.x) + offset.x) - 30,((gameObject.transform.position.y *Game.Screen.y) +  offset.y) + 15);
        Game.batch.setColor(Color.WHITE);
        Game.batch.end();
    }
}

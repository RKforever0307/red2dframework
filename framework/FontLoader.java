package com.redlabs.finalgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.util.Dictionary;
import java.util.Hashtable;

public class FontLoader {

    public static Dictionary <String, BitmapFont> fonts = new Hashtable<>();

    public static BitmapFont AddFont(String _key, String _path,double _size){
        fonts.put(_key,GenerateFont(_path,_size));
        return GetFont(_key);
    }

    public static BitmapFont GetFont(String _key){
        return fonts.get(_key);
    }


    private static BitmapFont GenerateFont(String path, double size)
    {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(path));
        FreeTypeFontGenerator.FreeTypeFontParameter parameters = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameters.genMipMaps = true;
        parameters.color = Color.WHITE;
        parameters.size = (int) Math.ceil(size);
        parameters.magFilter = Texture.TextureFilter.Linear;
        parameters.minFilter = Texture.TextureFilter.Linear;
        generator.scaleForPixelHeight((int) size);
        return generator.generateFont(parameters);
    }

}

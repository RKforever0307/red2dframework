package com.redlabs.finalgame.Utils;

import com.redlabs.finalgame.PivotType;

public class Rect {
    public float x,y,witdh,height;
    public Vector center = new Vector(0,0);

    public void UpdateCenter(PivotType _pivotType){
        switch (_pivotType ){
            case Center:
                center.x = x + (witdh/2);
                center.y = y + (height/2);
                break;
            case Bottom:
                center.x = x + (witdh/2);
                center.y = y;
                break;
            case Top:
                center.x = x + (witdh/2);
                center.y = y + (height);
                break;
            case Left:
                center.x = x;
                center.y = y + (height/2);
                break;

        }

    }

    public boolean OverlapPoint(Vector point){
        if (point.x>x && point.x<x+witdh && point.y>y && point.y<y+height){
            return true;
        }else{
            return false;
        }
    }

    public boolean OverlapRect(Rect rect){
        if (x<rect.x+rect.witdh && x+witdh>rect.x && y>rect.y + rect.height && y+height<rect.y){
            return true;
        }else{
            return false;
        }

    }

}

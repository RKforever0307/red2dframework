package com.redlabs.finalgame;

import com.redlabs.finalgame.Utils.Rect;
import com.redlabs.finalgame.Utils.Vector;

public class Transform extends Component {
    public Transform parent=null;

    public Vector position;
    public Vector localposition;

    public float angle;
    public Vector scale;
    public Vector localScale;


    private Rect rect;
    public Vector size;

    public Vector pivot;

    public PivotType pivotType = PivotType.Center;


    public Transform(){
        position= new Vector(0,0);
        localposition= new Vector(0,0);

        angle = 0;
        scale = new Vector(1,1);
        localScale = new Vector(1,1);

        size = new Vector(0,0);
        rect = new Rect();
        pivot = new Vector(0,0);
        UpdateRect();
    }

    public void SetPosition(Vector newPos){
        position = newPos;
    }

    public void SetPositionRelative(Vector newPos){
        position.Add(newPos);
    }

    public void SetLocalPosition(Vector newPos){
        localposition = newPos;
    }

    public void SetLocalPositionRelative(Vector newPos){
        localposition.Add(newPos);
    }

    public void SetAngle(float _angle){
        angle = _angle;
    }

    public void SetAngleRelative(float _angle){
        angle += _angle;
    }

    public void SetScale(Vector newScale){
        scale = newScale;
    }

    public void SetScaleRelative(Vector newScale){
        scale.Add(newScale);
    }


    public void SetLocalScale(Vector newScale){
        localScale= newScale;
    }

    public void SetLocalScaleRelative(Vector newScale){
        localScale.Add(newScale);
    }


    public void SetPivot(Vector newPivot){
     //   pivot = newPivot;
    }

    public Rect GetRect(){
        UpdateRect();
        return rect;
    }

    void UpdateRect(){

        if (parent!=null){
            position.x = parent.position.x+localposition.x;
            position.y = parent.position.y+localposition.y;
        }

        rect.x =(position.x * Game.Screen.x) - (rect.witdh/2);
        rect.y = (position.y * Game.Screen.y) - (rect.height/2);

        rect.witdh = size.x * scale.x;
        rect.height = size.y * scale.y;
        rect.UpdateCenter(pivotType);
    }

}

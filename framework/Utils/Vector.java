package com.redlabs.finalgame.Utils;

public class Vector {

    public float x,y;
    
    public static final Vector One = new Vector(1,1);
    public static final Vector Zero = new Vector(0,0);

    public Vector(float _x,float _y){
        x=_x;
        y=_y;
    }

    public void Add(Vector other){
       this.x+=other.x;
       this.y+=other.y;
    }


   public void Multiply(Vector other){
        this.x *=other.x;
        this.y *=other.y;
    }

    public static Vector Lerp(Vector v1,Vector v2,float time){
        Vector newVec = new Vector(0,0);
        newVec.x = (1-time) * v1.x + time * v2.x;
        newVec.y = (1-time) * v1.y + time * v2.y;
        return newVec;
    }

}

package com.redlabs.finalgame;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FunctionEvent {
    public Object object;
    public Method function;

    public FunctionEvent(Object _object,String _functionName){
        object = _object;
        try{
            function =object.getClass().getMethod(_functionName);
        }catch (NoSuchMethodException e){

        }
    }

    public void Invoke(){
        try{
            try{
                function.invoke(object,null);
            }catch (IllegalAccessException e){

            }
        }catch (InvocationTargetException e){

        }
    }

}

package com.redlabs.finalgame;

import java.util.ArrayList;

public class Time {

    static ArrayList<FunctionEvent> functionEvents = new ArrayList<>();
    static ArrayList<Float> timing = new ArrayList<>();

    public static float time=0;


    public static void DelayInvoke(Object _object,String _functionName,float delay){
        functionEvents.add(new FunctionEvent(_object,_functionName));
        timing.add(time+delay);
    }

    public static void ClickTick(float _deltaTime){
        time+=_deltaTime;
        for (int i = 0; i < timing.size(); i++) {
            if (timing.get(i)<time){
                functionEvents.get(i).Invoke();
                functionEvents.remove(i);
                timing.remove(i);
            }
        }
    }

}

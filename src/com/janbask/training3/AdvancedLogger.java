package com.janbask.training3;

import java.util.Date;

public class AdvancedLogger implements Logger{
    public void Log(String event){
        String message = String.format("Advanced Logging - %s: %s", new Date(), event);
        System.out.println(message);
    }
}

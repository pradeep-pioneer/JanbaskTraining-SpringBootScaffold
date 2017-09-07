package com.janbask.training3;

import java.util.Date;

public class SimpleLogger implements Logger {
    public void Log(String event){
        String message = String.format("%s: %s", new Date(), event);
        System.out.println(message);
    }
}

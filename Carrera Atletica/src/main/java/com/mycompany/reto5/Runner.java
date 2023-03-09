
package com.mycompany.reto5;

import java.util.Random;

public class Runner {
    
    private String name;
    private int speed;
    
    public Runner () {
        this.speed = (int)((Math.random()*(30-0)) + 0); 
    }
    
    public void setName(String  value){
        this.name = value;
    }
    
    public String getName(){
        return this.name;
    }
    public int getSpeed(){
        return this.speed;    
    }
}


package com.codepolitan.sqllitecontactexample;

/**
 * Created by rudihartono on 6/2/18.
 */

public class Item {

    private int id;
    private String name;
    private int priority;

    public  Item(){

    }

    //create constructor
    public Item(String nameParam, int priority){

        name = nameParam;
        this.priority = priority;
    }

    //constructor yang ke 2
    public Item(int id, String name, int priority){
        this.priority = priority;
        this.id = id;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void SetNamaOverride(String name){
        this.name = name;
    }
}


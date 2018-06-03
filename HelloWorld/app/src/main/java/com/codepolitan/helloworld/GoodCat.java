package com.codepolitan.helloworld;

/**
 * Created by rudihartono on 4/28/18.
 */

public class GoodCat {

    public  GoodCat(){

    }

    private int size;
    public static String Nama;

    public void setSize(int size){

        this.size = size;
    }

    public int getSize(){
        return size;
    }

    public String getName(){

        if(size < 30){
            return "kucing";
        }else if(size > 50 && size <= 100){
            return "Harimau";
        }else{
            return  "Singa";
        }
    }
}

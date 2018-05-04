package com.company;
import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Integer> winlose;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getWinlose() {
        return winlose;
    }

    public void setWinlose(ArrayList<Integer> winlose) {
        this.winlose = winlose;
    }



    Player(String name){
        this.name = name;
        winlose = new ArrayList<>();
        System.out.println("Hello player1 " + name);

    }
}

package com.company;
import java.util.Random;

public class Player {

    private String name;
    private boolean isComputer;
    private String playerPick;


    public boolean isComputer() {
        return isComputer;
    }

    public String getName() {
        return name;
    }

    Player(String name, boolean isComputer){
        this.name = name;
        this.isComputer = isComputer;
    }

    public void setPlayerPick(String input){
        playerPick = input;
    }
    public String getPlayerPick(){
        return playerPick;
    }

    public String computerChoice(){
        // computer will choose a random number between 1-3, 1=rock, 2=paper 3=scissors.
        //return the result as a string: e.g. "computer picks rock!"
        Random rand = new Random();
        int num = rand.nextInt((3-1) + 1) + 1;
        if(num == 1){
            this.setPlayerPick("rock");
        } else if (num == 2){
            this.setPlayerPick("paper");
        } else if(num == 3){
            this.setPlayerPick("scissors");
        }
        return "Computer chooses " + this.getPlayerPick();
    }

}

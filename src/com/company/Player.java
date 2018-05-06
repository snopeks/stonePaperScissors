package com.company;
import java.util.Random;

public class Player {

    private String name;
    private boolean isComputer;
    private String playerPick;
    private String computerPick;

    public String getComputerPick() {
        return computerPick;
    }

    public void setComputerPick(String computerPick) {
        this.computerPick = computerPick;
    }


    public boolean isComputer() {
        return isComputer;
    }

    public void setComputer(boolean computer) {
        isComputer = computer;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Player(String name, boolean isComputer){
        this.name = name;
        this.isComputer = isComputer;
    }

    public String setPlayerPick(String input){
        playerPick = input;
        return this.getName() + " picks " + input;
    }
    public String getPlayerPick(){
        return playerPick;
    }

    public String computerChoice(){
        // computer will choose a random number between 1-3, 1=rock, 2=paper 3=scissors.
        //return the result as a string: e.g. "computer picks rock!"
        System.out.println(this.getName());
        Random rand = new Random();
        int num = rand.nextInt((3-1) + 1) + 1;
        System.out.println(num);
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

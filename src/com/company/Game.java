package com.company;

public class Game {
    Player player1;
    Player opponent;
    public Game(String name, String opponent){
        player1 = new Player(name);
        this.opponent = new Player(opponent);

        System.out.println("the game is about to begin!");
    }


}

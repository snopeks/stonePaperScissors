package com.company;

import java.util.ArrayList;

public class Game {
    private Player player1;
    private Player opponent;
    private static ArrayList<String> winlose;
    private String winner;

    public Player getPlayer1() {
        return player1;
    }

    public Player getOpponent() {
        if(!opponent.isComputer()){
            System.out.println("your opponent is the computer");
        } else {
            System.out.println("your opponent is a human");
        }
        return opponent;
    }

    public void setOpponent(boolean opponent) {
        if(!opponent){
            this.opponent = new Player(true);
        } else {
            this.opponent = new Player(false);
        }
    }


    public Game(){
        winlose = new ArrayList<>();
        player1 = new Player(false);

        System.out.println("the game is about to begin!");
    }

    public String evaluatePlay(String p1pick, String p2pick){
        if(p1pick.equals("rock")){
            if(p2pick.equals("paper")){
                winner = "winner: player 2";
            } else if (p2pick.equals("scissors")){
                winner = "winner: player 1";
            } else if(p2pick.equals("rock")){
                winner = "it's a tie!!";
            }
        }
        if(p1pick.equals("paper")){
            if(p2pick.equals("rock")){
                winner = "player 1";
            } else if (p2pick.equals("scissors")){
                winner = "player 2";
            } else if (p2pick.equals("paper")){
                winner = "it's a tie!";
            }
        }
        if(p1pick.equals("scissors")){
            if(p2pick.equals("rock")){
                winner = "player 2";
            } else if(p2pick.equals("paper")){
                winner = "Player 1";
            } else if(p2pick.equals("scissors")){
                winner = "it's a tie!";
            }

        }
        return winner;
    }

    public static ArrayList<String> getWinlose(){
        if(winlose == null){
            System.out.println("no history! play a game to start tracking wins and losses");
        } else {
            System.out.println("Here's your history");
        }
        return winlose;
    }


}

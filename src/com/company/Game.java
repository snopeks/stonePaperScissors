package com.company;

import java.util.ArrayList;

public class Game {
    private Player player1;
    private Player opponent;
    private static ArrayList<String> winlose = new ArrayList<>();
    private String win;
//    private String result = player1.getName() + "-" + p1pick + " " + opponent.getName() + "-" + p2pick;

    public void setPlayer1(String name, boolean isComputer){
        player1 = new Player(name, isComputer);
    }
    public Player getPlayer1() {
        return player1;
    }

    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(String name, boolean isComputer) {
            this.opponent = new Player(name, isComputer);
    }

    public Game(){
//        player1 = new Player(null,  false);
    }

    public String evaluatePlay(String p1pick, String p2pick){
        System.out.println(p1pick);
        player1.setPlayerPick(p1pick);
        opponent.setPlayerPick(p2pick);
        System.out.println(p2pick);
        if(p1pick.equals(p2pick)){
            win = "TIE GAME";
            winlose.add("TIE " + player1.getName() + "-" + p1pick + " " + opponent.getName() + "-" + p2pick);
        }
        else if (p1pick.equals("rock")){
            if(p2pick.equals("paper")){
                win = "YOU LOSE!";
                winlose.add("LOSS " + player1.getName() + "-" + p1pick + " " + opponent.getName() + "-" + p2pick);
            } else {
                win = "YOU WIN!";
                winlose.add("WIN " + player1.getName() + "-" + p1pick + " " + opponent.getName() + "-" + p2pick);
            }
        }
        else if(p1pick.equals("paper")){
            if(p2pick.equals("rock")){
                win = "YOU WIN!";
                winlose.add("WIN " + player1.getName() + "-" + p1pick + " " + opponent.getName() + "-" + p2pick);
            } else {
                win = "YOU LOSE!";
                winlose.add("LOSS " + player1.getName() + "-" + p1pick + " " + opponent.getName() + "-" + p2pick);
            }
        }
        else if(p1pick.equals("scissors")){
            if(p2pick.equals("rock")){
                win = "YOU LOSE!";
                winlose.add("LOSS " + player1.getName() + "-" + p1pick + " " + opponent.getName() + "-" + p2pick);
            } else {
                win = "YOU WIN!";
                winlose.add("WIN " + player1.getName() + "-" + p1pick + " " + opponent.getName() + "-" + p2pick);
            }
        }
        return win;
    }

    public ArrayList<String> getWinlose(){
        if(winlose.size() == 0){
            System.out.println("no history! play a game to start tracking wins and losses");
        }
        return winlose;
    }


}

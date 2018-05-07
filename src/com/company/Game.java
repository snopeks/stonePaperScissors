package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player opponent;
    private static ArrayList<String> history = new ArrayList<>();
    private String win;

    private void setPlayer1(String name, boolean isComputer){
        player1 = new Player(name, isComputer);
    }

    private void setOpponent(String name, boolean isComputer) {
            this.opponent = new Player(name, isComputer);
    }

    public Game(){

    }

    public void mainMenu(){
        //GAME MENU
        // menu inspired by https://www.experts-exchange.com/questions/22998261/Command-line-menu-Java.html
        System.out.println("");
        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("");
        System.out.println("MAIN MENU");
        System.out.println("=====");
        System.out.println("1. Type 'play' to play" );
        System.out.println("2. Type 'history' to view your history");
        System.out.println("Type 'quit' to stop playing");
    }

    private void setPlayers(Game game, Scanner sc){
        System.out.println("Let's set up the players! Please enter your name:");
        String p1name = sc.nextLine();
        try{
            game.setPlayer1(p1name, false);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Type '2 players' for a two player game or 'vs. Computer' to play against the computer");

        //choose an opponent
        String opponent = sc.nextLine();
        while (!opponent.equals("2 players") && !opponent.equals("vs. Computer")) {
            System.out.println("Sorry, that's not right. Please enter '2 players' or 'vs. Computer' to begin the game");
            opponent = sc.nextLine();
        }
        try {
            if (opponent.equals("2 players")) {
                System.out.println("enter player 2 name:");
                String p2name = sc.nextLine();
                game.setOpponent(p2name, false);

            } else if (opponent.equals("vs. Computer")) {
                game.setOpponent("computer", true);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void playGame(Game game, Scanner sc){
        if(player1 == null && opponent == null){
            game.setPlayers(game, sc);
        }
            System.out.println(player1.getName() + ": rock, paper or scissors?");
            String p1choice = sc.nextLine().toLowerCase();

            //ensure input is a valid choice
            while(!p1choice.equals("rock") && !p1choice.equals("paper") && !p1choice.equals("scissors")){
                System.out.println("sorry, that didn't work. Please choose rock, paper or scissors");
                p1choice = sc.nextLine();
            }
            try{
                player1.setPlayerPick(p1choice);
                if (!opponent.isComputer()) {
                    System.out.println(opponent.getName() + ": rock, paper or scissors?");
                    String p2choice = sc.nextLine().toLowerCase();
                    //ensure input is a valid choice
                    while(!p2choice.equals("rock") && !p2choice.equals("paper") && !p2choice.equals("scissors")){
                        System.out.println("sorry, that didn't work. Please choose rock, paper or scissors");
                        p2choice = sc.nextLine();
                    }
                    opponent.setPlayerPick(p2choice);
                    System.out.println(game.evaluatePlay(player1.getPlayerPick(), opponent.getPlayerPick()));
                } else {
                    System.out.println(opponent.computerChoice());
                    System.out.println(game.evaluatePlay(player1.getPlayerPick(), opponent.getPlayerPick()));
                }

            } catch (Exception e) {
                System.out.println("an exception occurred!");
                System.out.println(e.getMessage());
            }
        }

    private String evaluatePlay(String p1pick, String p2pick){
        String result = player1.getName() + "-" + p1pick + " " + opponent.getName() + "-" + p2pick;
        player1.setPlayerPick(p1pick.toLowerCase());
        opponent.setPlayerPick(p2pick.toLowerCase());
        if(p1pick.equals(p2pick)){
            win = "TIE ";
            history.add(win + result);
        }
        else if (p1pick.equals("rock")){
            if(p2pick.equals("paper")){
                win = "LOSS ";
                history.add(win + result);
            } else {
                win = "WIN ";
                history.add(win + result);
            }
        }
        else if(p1pick.equals("paper")){
            if(p2pick.equals("rock")){
                win = "WIN ";
                history.add(win + result);
            } else {
                win = "LOSE ";
                history.add(win + result);
            }
        }
        else if(p1pick.equals("scissors")){
            if(p2pick.equals("rock")){
                win = "LOSS ";
                history.add(win + result);
            } else {
                win = "WIN ";
                history.add(win + result);
            }
        }
        return win + result;
    }

    public ArrayList<String> getHistory(){
        if(history.size() == 0){
            System.out.println("no history! play a game to start tracking wins and losses");
        }
        return history;
    }


}

package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //initialize game variable.
        Game game= new Game();

        //Create scanner for user input
        Scanner sc = new Scanner(System.in);
        String input = "";

        //check for invalid inputs
        try{
            while (!input.toLowerCase().equals("quit")) {
                mainMenu();
                input = sc.nextLine();
                if (input.equals("history")) {
                    System.out.println("====GAME HISTORY====");
                    System.out.println(game.getWinlose());
                }
                if (input.equals("play")) {
                    System.out.println("in play");
                    playGame(game, sc);
                }

            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }


        System.out.println("goodbye!");

    }
    public static void mainMenu(){
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
    public static void playGame(Game game, Scanner sc){
        System.out.println("Let's start this game! Please enter your name:");
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

        Player p1 = game.getPlayer1();
        Player p2 = game.getOpponent();
        System.out.println(p1.getName() + " enter your choice: rock, paper or scissors?");
        String p1choice = sc.nextLine();
        System.out.println(p1.setPlayerPick(p1choice));
        if (!p2.isComputer()) {
            System.out.println(p2.getName() + " enter your choice: rock, paper or scissors?");
            String p2choice = sc.nextLine();
            System.out.println(p2.setPlayerPick(p2choice));
            System.out.println(game.evaluatePlay(p1.getPlayerPick(), p2.getPlayerPick()));
        } else {
            System.out.println(p2.computerChoice());
            System.out.println(game.evaluatePlay(p1.getPlayerPick(), p2.getPlayerPick()));
        }
    }
}

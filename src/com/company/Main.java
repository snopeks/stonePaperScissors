package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //GAME MENU
        // menu inspired by https://www.experts-exchange.com/questions/22998261/Command-line-menu-Java.html
        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("");
        System.out.println("MAIN MENU");
        System.out.println("=====");
        System.out.println("1. Type 'play' to play" );
        System.out.println("2. Type 'history' to view your history");
        System.out.println("Type 'quit' to stop playing");

        //initialize game variable.
        Game game;

        //Create scanner for user input
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        //check for invalid inputs and standardize
        while(!input.toLowerCase().equals("play") && !input.toLowerCase().equals("history")){
            System.out.println("oops, that's not an option. Type 'play' or 'history'");
            input = sc.nextLine();
        }

        if(input.equals("history")){
            System.out.println(Game.getWinlose());
        }

        //start game play! Would like to put this in a method.
        if(input.equals("play")) {
            game = new Game();
            System.out.println("Let's start this game! Type '2 players' for a two player game or 'vs. Computer' to play against the computer" );

            //choose an opponent
            String opponent = sc.nextLine();
            while(!opponent.equals("2 players") && !opponent.equals("vs. Computer")){
                System.out.println("Sorry, that's not right. Please enter '2 players' or 'vs. Computer' to begin the game");
                opponent = sc.nextLine();
            }
            try{
                if(opponent.equals("2 players")){
                    System.out.println("two players!!");
                    game.setOpponent(false);
                } else if(opponent.equals("vs. Computer")){
                    System.out.println("computer player!!");
                    game.setOpponent(true);
                }
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }

            Player p1 = game.getPlayer1();
            Player p2 = game.getOpponent();
            System.out.println("Player 1 enter your choice: rock, paper or scissors?");
            String p1choice = sc.nextLine();
            System.out.println(p1.setPlayerPick(p1choice));
            System.out.println(p2.computerChoice());
            System.out.println(game.evaluatePlay(p1.getPlayerPick(), p2.getComputerPick()));
        }

    }
}

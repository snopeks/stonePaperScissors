package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
    // menu inspired by https://www.experts-exchange.com/questions/22998261/Command-line-menu-Java.html
        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("");
        System.out.println("MAIN MENU");
        System.out.println("=====");
        System.out.println("1. Type 'play' to play" );
        System.out.println("2. Type 'history' to view your history");
        System.out.println("Type 'quit' to stop playing");


        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while(!input.equals("play") && !input.equals("history")){
            System.out.println("oops, that's not an option. Type 'play' or 'history'");
            input = sc.nextLine();
        }

        if(input.equals("play")) {
            System.out.println("Let's start this game! Please enter your name");
            String name = sc.nextLine();
            System.out.println("hi " + name + ". Type '2 players' for a two player game or 'vs. Computer' to play against the computer" );
            String opponent = sc.nextLine();
            while(!opponent.equals("2 players") && !opponent.equals("vs. Computer")){
                System.out.println("Sorry, that's not right. Please enter '2 players' or 'vs. Computer' to begin the game");
                opponent = sc.nextLine();
            }
            if(opponent.equals("2 players")){
                System.out.println("two players!!");
                Game game = new Game(name, "player2");
            } else if(opponent.equals("vs. Computer")){
                System.out.println("computer player!!");
                Game game = new Game(name, "computer");
            }
        }








    }
}

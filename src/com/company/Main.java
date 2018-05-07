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
                game.mainMenu();
                input = sc.nextLine();
                if (input.equals("history")) {
                    System.out.println("====GAME HISTORY====");
                    System.out.println(game.getHistory());
                }
                else if (input.equals("play")) {
                    game.playGame(game, sc);
                } else if(!input.equals("quit")) {
                    System.out.println("sorry, didn't recognize that input. Please choose 'play', 'history', or 'quit'");
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        //exit with message and close scanner
        System.out.println("goodbye!");
        sc.close();
    }

}

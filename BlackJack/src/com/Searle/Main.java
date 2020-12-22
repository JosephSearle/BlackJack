package com.Searle;

import java.util.*;

public class Main {

    public static HashMap<String, Integer> hand1 = new HashMap<>();
    public static HashMap<String, Integer> hand2 = new HashMap<>();
    public static Deck deck = new Deck();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // shuffle the deck.
        deck.shuffle();

        // Welcome player to the game and prompt them to give their name.
        System.out.println("Welcome to Black Jack");
        System.out.println("What's your name?");

        String username = s.nextLine();

        // Start Game
        startGame(username);

        // Every round the player can choose to draw or stick with the cards they have.
        boolean round = true;
        while(round) {
            System.out.println("Would you like to stick or draw a new card?");
            System.out.println("Type draw to draw a new card or type stick to keep the hand you already have.");
            String play = s.nextLine();
            if(play.equals("draw")) {
                draw(hand1);
                if(!below21(hand1)) {
                    System.out.println("YOU WENT BUST!!");
                    System.out.println(handTotal(hand1) + " is greater than 21.");
                    round = false;
                }else if(handTotal(hand1) == 21) {
                    System.out.println("You have 21!");
                    round = false;
                }
            }else if(play.equals("stick")) {
                System.out.println(username + " decided to stick with their current hand.");
                round = false;
            }else {
                System.out.println("Please type whether you would like to stick or draw.");
            }
            System.out.println(username + "'s hand at the end of this round is: ");
            printHand(hand1);
            System.out.println();
            System.out.println("Total: " + handTotal(hand1));
        }

        // computers turn.
        compTurn();

        // Compare the two hands! closest to 21 wins.
        whoWins(hand1, hand2);
        System.out.println(username + "'s total was: " + handTotal(hand1));
        System.out.println("The computers total was: " + handTotal(hand2));
        System.out.println("Thank you for playing Black Jack " + username);
    }

    // Start the game
    public static void startGame(String user) {
        draw(hand1);
        draw(hand1);

        draw(hand2);
        draw(hand2);

        System.out.println( user + "'s hand:");
        printHand(hand1);
        System.out.println();
        System.out.println("Total: " + handTotal(hand1));
    }

    // Runs through the computers turn.
    public static void compTurn() {
        if(below21(hand1)) {
            while(handTotal(hand2) < 16) {
                draw(hand2);
                if(handTotal(hand2) > 21) {
                    System.out.println("The computer went bust");
                }
            }
        }

    }

    // Compares the two hands to see who is closest to or has 21.
    public static void whoWins(HashMap<String, Integer> player, HashMap<String, Integer> comp) {
        if(handTotal(player) == handTotal(comp)) {
            System.out.println("It is a draw!");
        }else if((handTotal(player) > handTotal(comp) && handTotal(player) <= 21) || handTotal(comp) > 21){
            System.out.println("Congratulations you won!!");
        }else if(handTotal(player) < handTotal(comp) && handTotal(comp) < 21) {
            System.out.println("Computer Wins!!");
        }
    }

    // Draw a card from the deck and put it in the players hand.
    public static void draw(HashMap<String, Integer> hand) {
        String card = deck.drawCard();
        String[] spl = card.split(" ");
        String type = spl[0];
        switch(type) {
            case "Ace":
                hand.put(card, 1);
                break;
            case "Two":
                hand.put(card, 2);
                break;
            case "Three":
                hand.put(card, 3);
                break;
            case "Four":
                hand.put(card, 4);
                break;
            case "Five":
                hand.put(card, 5);
                break;
            case "Six":
                hand.put(card, 6);
                break;
            case "Seven":
                hand.put(card, 7);
                break;
            case "Eight":
                hand.put(card, 8);
                break;
            case "Nine":
                hand.put(card, 9);
                break;
            case "Ten":
            case "Jack":
            case "Queen":
            case "King":
                hand.put(card, 10);
                break;
        }
    }

    // Total up the cards that are held in the players hand.
    public static int handTotal(HashMap<String, Integer> hand) {
        Iterator it = hand.entrySet().iterator();
        int total = 0;
        while(it.hasNext()) {
            Map.Entry mapElement = (Map.Entry)it.next();
            total += ((int)mapElement.getValue());
        }

        return total;
    }

    // Check to see if the score that the player holds in their hand is below 21.
    public static boolean below21(HashMap<String, Integer> hand) {
        if(handTotal(hand) < 21) return true;
        return false;
    }

    // Print the cards that are held in the players hand.
    public static void printHand(HashMap<String, Integer> hand) {
        Iterator it = hand.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry mapElement = (Map.Entry)it.next();
            System.out.print(mapElement.getKey() + ", ");
        }
    }
}

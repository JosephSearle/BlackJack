package com.Searle;

import java.util.*;

public class Deck {

    public Stack<String> deck;

    public Deck() {
        deck = new Stack<>();
        deck.push("Ace of Spades");
        deck.push("Ace of Clubs");
        deck.push("Ace of Hearts");
        deck.push("Ace of Diamonds");
        deck.push("Two of Spades");
        deck.push("Two of Clubs");
        deck.push("Two of Hearts");
        deck.push("Two of Diamonds");
        deck.push("Three of Spades");
        deck.push("Three of Clubs");
        deck.push("Three of Hearts");
        deck.push("Three of Diamonds");
        deck.push("Four of Spades");
        deck.push("Four of Clubs");
        deck.push("Four of Hearts");
        deck.push("Four of Diamonds");
        deck.push("Five of Spades");
        deck.push("Five of Clubs");
        deck.push("Five of Hearts");
        deck.push("Five of Diamonds");
        deck.push("Six of Spades");
        deck.push("Six of Clubs");
        deck.push("Six of Hearts");
        deck.push("Six of Diamonds");
        deck.push("Seven of Spades");
        deck.push("Seven of Clubs");
        deck.push("Seven of Hearts");
        deck.push("Seven of Diamonds");
        deck.push("Eight of Spades");
        deck.push("Eight of Clubs");
        deck.push("Eight of Hearts");
        deck.push("Eight of Diamonds");
        deck.push("Nine of Spades");
        deck.push("Nine of Clubs");
        deck.push("Nine of Hearts");
        deck.push("Nine of Diamonds");
        deck.push("Ten of Spades");
        deck.push("Ten of Clubs");
        deck.push("Ten of Hearts");
        deck.push("Ten of Diamonds");
        deck.push("Queen of Spades");
        deck.push("Queen of Clubs");
        deck.push("Queen of Hearts");
        deck.push("Queen of Diamonds");
        deck.push("King of Spades");
        deck.push("King of Clubs");
        deck.push("King of Hearts");
        deck.push("King of Diamonds");
        deck.push("Jack of Spades");
        deck.push("Jack of Clubs");
        deck.push("Jack of Hearts");
        deck.push("Jack of Diamonds");
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public void printCards() {
        for(String card : deck) {
            System.out.println(card);
        }
    }

    public int size() {
        return deck.size();
    }

    public String drawCard() {
        return deck.pop();
    }
}

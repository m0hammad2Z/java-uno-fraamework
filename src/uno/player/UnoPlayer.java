package uno.player;

import uno.action.player.PlayerAction;
import uno.action.player.UnoDefaultPlayerBehaviour;
import uno.card.UnoCard;
import uno.deck.UnoDeck;
import uno.game.UnoGameEngine;

import java.util.ArrayList;
import java.util.List;

public abstract class UnoPlayer{
    // Player's hand of cards
    private List<UnoCard> hand;
    // Player's current score
    private int score;
    // Player's name
    private String name;

    // Player's action behavior
    private PlayerAction action;

    // Player's saidUno
    private boolean saidUno;

    public UnoPlayer(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
        this.action = new UnoDefaultPlayerBehaviour();
    }

    // Set the player's action behavior
    public void setAction(PlayerAction action) {
        if (action == null) {
            throw new IllegalArgumentException("Action cannot be null");
        }
        this.action = action;
    }

    // Take a turn in the game.
    public void takeTurn(UnoGameEngine game) {
        if (game == null) {
            throw new IllegalArgumentException("Gane engine instanece cannot be null");
        }
        action.onTakeTurn(this, game);
        action.onEndTurn(this, game);
    }

    // Draw a specified number of cards from a deck
    public void drawCards(UnoDeck deck, int count) {
        if (deck == null) {
            throw new IllegalArgumentException("Deck cannot be null");
        }
        if (count < 0) {
            throw new IllegalArgumentException("Count cannot be negative");
        }
        for (int i = 0; i < count; i++) {
            hand.add(deck.drawCard());
        }
    }

    // Getters and setters for score
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Null-empty name");
        }
        this.name = name;
    }

    // Method to draw a card from a deck
    public void drawCard(UnoDeck deck) {
        if (deck == null) {
            throw new IllegalArgumentException("Deck cannot be null");
        }
        hand.add(deck.drawCard());
    }

    // Methods to remove a card from the player's hand
    public void removeCard(UnoCard card) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null");
        }
        hand.remove(card);
    }

    public UnoCard removeCard(int index) {
        if (index < 0 || index >= hand.size()) {
            throw new IndexOutOfBoundsException("No card at index " + index);
        }
        return hand.remove(index);
    }

    // Getter for hand
    public List<UnoCard> getHand() {
        return hand;
    }

    // Setter for hand
    public void setHand(List<UnoCard> hand) {
        if (hand == null) {
            throw new IllegalArgumentException("Hand cannot be null");
        }
        this.hand = hand;
    }

    // Getter and setter for saidUno
    public boolean hasSaidUno() {
        return saidUno;
    }

    public void setSaidUno(boolean saidUno) {
        this.saidUno = saidUno;
    }

    // toString method
    public String toString() {
        return "Player{" +
                "hand=" + hand +
                ", score=" + score +
                ", name='" + name + '\'' +
                '}';
    }
}


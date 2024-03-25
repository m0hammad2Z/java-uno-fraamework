package uno.card;

import uno.action.card.CardAction;
import uno.enums.UnoCardType;
import uno.game.UnoGameEngine;

import java.util.Objects;


public abstract class UnoCard {
    private int score;
    private UnoCardColor cardColor;
    private UnoCardType cardType;
    private UnoCardValue cardValue;
    private final CardAction action;

    public UnoCard(UnoCardColor cardColor, UnoCardType cardType, UnoCardValue cardValue, int score, CardAction action) {
        // Throw a NullPointerException if any of the objects are null
        this.cardColor = Objects.requireNonNull(cardColor);
        this.cardType = Objects.requireNonNull(cardType);
        this.cardValue = Objects.requireNonNull(cardValue);
        this.action = Objects.requireNonNull(action);

        // Throw an IllegalArgumentException if the score is negative
        if (score < 0) {
            throw new IllegalArgumentException("UnoCard: Invalid score");
        }
        this.score = score;
    }


    // ----- Getters and Setters -----
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public UnoCardColor getCardColor() {
        return cardColor;
    }

    public void setCardColor(UnoCardColor cardColor) {
        this.cardColor = cardColor;
    }

    public UnoCardType getCardType() {
        return cardType;
    }

    public void setCardType(UnoCardType cardType) {
        this.cardType = cardType;
    }

    public UnoCardValue getCardValue() {
        return cardValue;
    }

    public void setCardValue(UnoCardValue cardValue) {
        this.cardValue = cardValue;
    }

    public CardAction getAction() {
        return action;
    }


    // ----- Common Methods -----

    // This method is called when a player plays a card
    public final void playCard(UnoGameEngine game) {
        action.onPlay(this,  game);
    }

    // Print the card details
    @Override
    public String toString() {
        return "Card: Color: " + cardColor + ", Value: " + cardValue + ", Type: " + cardType;
    }
    // Check if the card color matches
    public boolean colorMatch(UnoCard card) {
        return card.getCardColor().toString().equals(getCardColor().toString());
    }

    // Check if the card value matches
    public boolean valueMatch(UnoCard card) {
        return card.getCardValue().toString().equals(getCardValue().toString());
    }

    // Check if the card type matches
    public boolean typeMatch(UnoCard card) {
        return card.getCardType() == getCardType();
    }


    // ----- Abstract Methods -----

    // Check if the card is a valid move
    public abstract boolean isValidMove(UnoCard card);


}

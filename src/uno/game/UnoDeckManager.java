package uno.game;

import uno.deck.UnoDeck;
import uno.card.*;

import java.util.List;

public class UnoDeckManager {
    private List<UnoDeck> decks;

    // The discard pile of cards
    private UnoDeck discardPile;

    // The last played card
    private UnoCard lastPlayedCard;

    private UnoGameEngine gameEngine;

    public UnoDeckManager(List<UnoDeck> decks, UnoGameEngine gameEngine) {
        this.decks = decks;
        this.gameEngine = gameEngine;
        // Initialize the discard pile from the same parameters as the decks list
        this.discardPile = new UnoDeck();
        // Initialize the last played card to null
        this.lastPlayedCard = null;
    }

    // ------------- Setter and Getter Methods ----------------
    public List<UnoDeck> getDecks() {
        return decks;
    }

    // Add deck to game
    public void addDeck(UnoDeck deck) {
        if (deck == null) {
            throw new IllegalArgumentException("Cannot add null deck to game");
        }
        if (canAddDeck()) {
            decks.add(deck);
        } else {
            throw new IllegalArgumentException("Cannot add deck to game");
        }
    }

    // Check if can add deck to game
    public boolean canAddDeck() {
        return decks.size() < gameEngine.settings.getNumberOfDecks();
    }

    // Get deck by index
    public UnoDeck getDeck(int index) {
        return decks.get(index);
    }

    // Add cards to a deck
    public void addCardsToDeck(UnoDeck deck, int numberOfCards, UnoCard card) {
        for (int i = 0; i < numberOfCards; i++) {
            deck.addCard(card);
        }
    }

    // Get the discard pile
    public UnoDeck getDiscardPile() {
        return discardPile;
    }

    // Set the discard pile
    public void setDiscardPile(UnoDeck discardPile) {
        this.discardPile = discardPile;
    }

    // Get the top card of the discard pile
    public UnoCard getTopCard() {
        if (discardPile.isEmpty()) {
            return null;
        } else {
            return discardPile.getCards().get(discardPile.getCards().size() - 1);
        }
    }

    // Add a card to the discard pile
    public void addCardToDiscardPile(UnoCard card) {
        discardPile.addCard(card);
        // Update the last played card
        lastPlayedCard = card;
    }


    // Get the last played card
    public UnoCard getLastPlayedCard() {
        return lastPlayedCard;
    }

    // Set the last played card
    public void setLastPlayedCard(UnoCard lastPlayedCard) {
        this.lastPlayedCard = lastPlayedCard;
    }

}

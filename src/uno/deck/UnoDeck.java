package uno.deck;

import uno.action.card.*;
import uno.card.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnoDeck {

    private List<UnoCard> cards;

    public UnoDeck() {
        cards = new ArrayList<>();
    }


    // Initialize deck. Create all classic Uno cards and add them to the deck.
    public void Initialize() {
        for (UnoCardColor color : UnoCardColor.COLORS) {
            if (color == UnoCardColor.BLACK) {
                continue;  // Skip black color (wild cards)
            }

            createNumberCards(color);
            createActionCards(color);
        }

        createWildCards();
    }

    // Create Number cards
    private void createNumberCards(UnoCardColor color) {
        for (UnoCardValue value : UnoCardValue.VALUES.subList(0, 10)) {
            int score = 32;  // Assign score based on value order
            CardAction action = new UnoNumberdAction();  // Replace with appropriate action
            CardFactory cardFactory = new UnoNumberCardFactory(color, value, score, action);
            UnoCard card = cardFactory.createCard();

            if (value == UnoCardValue.ZERO) {
                addCards(card, 1);  // Add one copy of the zero card
            } else {
                addCards(card, 2);  // Add two copies of each number card
            }
        }
    }

    // Create Action cards
    private void createActionCards(UnoCardColor color) {
        for (UnoCardValue value : UnoCardValue.VALUES.subList(10, 13)) {
            int score = 50;
            CardAction action = createActionForValue(value);
            CardFactory cardFactory = new UnoActionCardFactory(color, value, score, action);
            UnoCard card = cardFactory.createCard();
            addCards(card, 2);
        }
    }

    // This method creates the appropriate action for each action card
    private CardAction createActionForValue(UnoCardValue value) {
        if(value == UnoCardValue.DRAW_TWO){
            return new UnoDrawTwoAction();
        }
        else if(value == UnoCardValue.SKIP){
            return new UnoSkipAction();
        }
        else if(value == UnoCardValue.REVERSE){
            return new UnoReverseAction();
        }
        else{
            return null;
        }
    }

    // Create Wild cards
    private void createWildCards() {
        CardFactory wildCardFactory = new UnoWildCardFactory(UnoCardValue.WILD, 50, new UnoWildAction());  // Replace with appropriate action
        UnoCard wildCard = wildCardFactory.createCard();
        addCards(wildCard, 4);

        CardFactory wildDrawFourFactory = new UnoWildCardFactory(UnoCardValue.WILD_DRAW_FOUR, 50, new UnoWildDrawFourAction());  // Replace with appropriate action
        UnoCard wildDrawFourCard = wildDrawFourFactory.createCard();
        addCards(wildDrawFourCard, 4);
    }

    // Add a number of cards to the deck
    public void addCards(UnoCard card, int count){
        for (int i = 0; i < count; i++) {
            cards.add(card);
        }
    }

    // Add a card to the deck
    public void addCard(UnoCard card) {
        cards.add(card);
    }

    // get all cards in the deck
    public List<UnoCard> getCards() {
        return cards;
    }

    // Randomize the order of the cards in the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Draw a card from the deck
    public UnoCard drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        } else {
            System.out.println("No more cards in the deck.");
            return null;
        }
    }


    // Check if the deck is empty
    public boolean isEmpty() {
        return cards.isEmpty();
    }
}

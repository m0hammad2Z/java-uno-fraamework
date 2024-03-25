package uno.card;

import uno.action.card.CardAction;

public class UnoActionCardFactory implements CardFactory {

    private UnoCardColor cardColor;
    private UnoCardValue cardValue;
    private int score;
    private CardAction action;

    public UnoActionCardFactory(UnoCardColor cardColor, UnoCardValue cardValue, int score, CardAction action) {
        this.cardColor = cardColor;
        this.cardValue = cardValue;
        this.score = score;
        this.action = action;
    }

    @Override
    public UnoCard createCard() {
        return new UnoActionCard(cardColor, cardValue, score, action);
    }
}
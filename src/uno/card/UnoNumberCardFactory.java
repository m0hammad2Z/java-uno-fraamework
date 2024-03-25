package uno.card;

import uno.action.card.CardAction;

public class UnoNumberCardFactory implements CardFactory {

    private UnoCardColor cardColor;
    private UnoCardValue cardValue;
    private int score;
    private CardAction action;

    public UnoNumberCardFactory(UnoCardColor cardColor, UnoCardValue cardValue, int score, CardAction action) {
        this.cardColor = cardColor;
        this.cardValue = cardValue;
        this.score = score;
        this.action = action;
    }

    @Override
    public UnoCard createCard() {
        return new UnoNumberCard(cardColor, cardValue, score, action);
    }
}

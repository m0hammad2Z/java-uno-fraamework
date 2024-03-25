package uno.card;

import uno.action.card.CardAction;

public class UnoWildCardFactory implements CardFactory {

    private UnoCardValue cardValue;
    private int score;
    private CardAction action;

    public UnoWildCardFactory(UnoCardValue cardValue, int score, CardAction action) {
        this.cardValue = cardValue;
        this.score = score;
        this.action = action;
    }

    @Override
    public UnoCard createCard() {
        return new UnoWildCard(cardValue, score, action);
    }
}

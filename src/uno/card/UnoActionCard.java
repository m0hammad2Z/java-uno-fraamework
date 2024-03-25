package uno.card;

import uno.action.card.CardAction;
import uno.enums.UnoCardType;

public class UnoActionCard extends UnoCard {
    public UnoActionCard(UnoCardColor cardColor, UnoCardValue cardValue, int score, CardAction action) {
        super(cardColor, UnoCardType.ACTION, cardValue, score, action);
    }

    @Override
    public boolean isValidMove(UnoCard card) {
        return colorMatch(card) || valueMatch(card);
    }
}
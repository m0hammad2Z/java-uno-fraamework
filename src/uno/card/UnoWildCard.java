package uno.card;

import uno.action.card.CardAction;
import uno.enums.UnoCardType;

public class UnoWildCard extends UnoCard {
    public UnoWildCard(UnoCardValue cardValue, int score, CardAction action) {
        super(UnoCardColor.BLACK, UnoCardType.WILD, cardValue, score, action);
    }

    @Override
    public boolean isValidMove(UnoCard card) {
        return true;
    }
}
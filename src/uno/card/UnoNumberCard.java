package uno.card;

import uno.action.card.CardAction;
import uno.enums.UnoCardType;

public class UnoNumberCard extends UnoCard {
    public UnoNumberCard(UnoCardColor cardColor, UnoCardValue cardValue, int score, CardAction action){
        super(cardColor, UnoCardType.NUMBER, cardValue, score, action);
    }

    @Override
    public boolean isValidMove(UnoCard card) {
        return colorMatch(card) || valueMatch(card);
    }
}
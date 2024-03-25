
import uno.card.*;
import uno.enums.UnoCardType;

public class ValueOnlyCard extends UnoCard {
    public ValueOnlyCard(UnoCardColor cardColor, UnoCardValue cardValue, int score){
        super(cardColor, UnoCardType.OTHER_CARD_TYPE, cardValue, score, null);
    }

    @Override
    public boolean isValidMove(UnoCard card) {
        return valueMatch(card);
    }

}



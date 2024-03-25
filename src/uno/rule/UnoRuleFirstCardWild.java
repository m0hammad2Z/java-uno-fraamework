package uno.rule;

import uno.card.UnoCard;
import uno.enums.UnoCardType;
import uno.game.UnoGameEngine;

public class UnoRuleFirstCardWild implements Rule{

    // Check if any first top card is wild. if it is, shuffle the deck until it is not.
    public void apply(UnoGameEngine game) {
        while(game.topCard.getCardType() == UnoCardType.WILD){
            game.deckManager.getDeck(0).addCard(game.topCard);
            game.deckManager.getDeck(0).shuffle();
            game.topCard = game.deckManager.getDeck(0).drawCard();
        }
    }


}

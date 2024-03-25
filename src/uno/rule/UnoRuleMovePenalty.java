package uno.rule;

import uno.card.UnoCard;
import uno.game.UnoGameEngine;
import uno.player.UnoPlayer;

public class UnoRuleMovePenalty implements Rule {



    // Check if the played card is a valid move and handle the consequences if it is not
    public void apply(UnoGameEngine game) {
        UnoPlayer player = game.playerManager.getCurrentPlayer();

        UnoCard card = game.deckManager.getLastPlayedCard();

        System.out.println("You played an invalid card! Take it back and draw a card as a penalty.");
        player.drawCards(game.deckManager.getDeck(0), 1);

    }

}

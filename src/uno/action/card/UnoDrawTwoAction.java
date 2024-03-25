package uno.action.card;

import uno.card.UnoCard;
import uno.game.UnoGameEngine;

// ----------- Pre defined actions for Uno cards ------------
public class UnoDrawTwoAction implements CardAction {
    @Override
    public void onPlay(UnoCard card, UnoGameEngine game) {
        game.playerManager.getNextPlayer().drawCards(game.deckManager.getDeck(0), 2);
    }
}

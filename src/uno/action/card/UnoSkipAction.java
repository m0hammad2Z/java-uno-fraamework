package uno.action.card;

import uno.card.*;
import uno.game.UnoGameEngine;

// ----------- Pre defined actions for Uno cards ------------
public class UnoSkipAction implements CardAction {

    @Override
    public void onPlay(UnoCard card, UnoGameEngine game) {
        // Skip the next player
        game.advanceToNextPlayer();
    }
}

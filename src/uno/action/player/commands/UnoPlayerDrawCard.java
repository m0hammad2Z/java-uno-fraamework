package uno.action.player.commands;

import uno.game.UnoGameEngine;
import uno.player.UnoPlayer;

public class UnoPlayerDrawCard implements PlayerCommand<Void> {

    // Draw a card from the first deck
    @Override
    public Void execute(UnoPlayer player, UnoGameEngine game) {
        player.drawCard(game.deckManager.getDeck(0));
        return null;
    }


}

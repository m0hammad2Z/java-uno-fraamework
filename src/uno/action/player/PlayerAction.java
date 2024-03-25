package uno.action.player;

import uno.game.UnoGameEngine;
import uno.player.UnoPlayer;

// This interface is used to define the actions that execute when a player takes a turn or ends a turn.
public interface PlayerAction {
    public void onTakeTurn(UnoPlayer player, UnoGameEngine game);

    public void onEndTurn(UnoPlayer player, UnoGameEngine game);
}

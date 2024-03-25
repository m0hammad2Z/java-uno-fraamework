package uno.action.player.commands;

import uno.game.UnoGameEngine;
import uno.player.UnoPlayer;

public interface PlayerCommand<T> {
    public T execute(UnoPlayer player, UnoGameEngine game);
}

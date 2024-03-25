package uno.player;

import uno.game.UnoGameEngine;
import uno.action.player.commands.PlayerCommand;

public class UnoPlayerActionInvoker {

    // Invoke the player command
    private final UnoGameEngine game;
    public UnoPlayerActionInvoker(UnoGameEngine game) {
        this.game = game;
    }
    public <T> T invoke(PlayerCommand<T> command, UnoPlayer player) {
        return command.execute(player, game);
    }
}

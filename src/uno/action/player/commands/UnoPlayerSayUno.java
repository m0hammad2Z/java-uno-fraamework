package uno.action.player.commands;

import uno.game.UnoGameEngine;
import uno.player.UnoPlayer;

public class UnoPlayerSayUno implements PlayerCommand<Void> {

    @Override
    public Void execute(UnoPlayer player, UnoGameEngine game) {
        System.out.println(player.getName() + " says UNO!");
        player.setSaidUno(true);
        return null;
    }
}

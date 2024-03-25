package uno.action.player.commands;

import uno.game.UnoGameEngine;
import uno.player.UnoPlayer;

public class UnoGetPlayerChoice implements PlayerCommand<Integer> {

    // Get input from the player
    @Override
    public Integer execute(UnoPlayer player, UnoGameEngine game) {
          try {
            return game.scanner.nextInt();
          }
            catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                game.scanner.nextLine();
                return execute(player, game);
            }
    }
}

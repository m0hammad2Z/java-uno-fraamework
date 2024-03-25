import uno.game.UnoGameEngine;
import uno.player.UnoPlayer;
import uno.rule.Rule;

public class SayUnoRule implements Rule {
    // Check if the player has to say UNO and punish him with draw a card if he violates it
    public void apply(UnoGameEngine game) {
        // Get the current player
        UnoPlayer player = game.playerManager.getCurrentPlayer();

        // if the player hand more than 1 card, assign the player sayUno to false
        if (player.getHand().size() > 1) {
            player.setSaidUno(false);
        }

        if (player.getHand().size() == 1) {
            // Check if the player has said UNO
            if (!player.hasSaidUno()) {
                System.out.println("You forgot to say UNO! Draw two cards as a penalty.");
                player.drawCards(game.deckManager.getDeck(0), 2);
            }
        }
    }
}

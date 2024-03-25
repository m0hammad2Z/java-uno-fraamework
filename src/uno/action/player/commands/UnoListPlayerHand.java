package uno.action.player.commands;

import uno.game.UnoGameEngine;
import uno.player.UnoPlayer;

public class UnoListPlayerHand implements PlayerCommand<Void> {

    // Let the player know what cards they have in their hand and print thier index to chooes from
    @Override
    public Void execute(UnoPlayer player, UnoGameEngine game) {
        System.out.println(player.getName() + "'s hand:");
        // List the cards in the player's hand
        for(int i = 0; i < player.getHand().size(); i++){
            System.out.println(i + ": " + player.getHand().get(i).toString());
        }
        // Option to say UNO
        System.out.println(player.getHand().size() + ": Draw a card");

        // Option to draw a card
        System.out.println(player.getHand().size() + 1 + ": Say UNO!");

        System.out.println("Top card: " + game.topCard.toString());

        return  null;
    }
}

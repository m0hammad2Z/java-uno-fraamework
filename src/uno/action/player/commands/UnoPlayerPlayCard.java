package uno.action.player.commands;

import uno.card.UnoCard;
import uno.game.UnoGameEngine;
import uno.player.UnoPlayer;

public class UnoPlayerPlayCard implements PlayerCommand<Void> {

    UnoCard card;

    public UnoPlayerPlayCard(UnoCard card){
        this.card = card;
    }
    @Override
    public Void execute(UnoPlayer player, UnoGameEngine game) {
        game.deckManager.addCardToDiscardPile(game.topCard);
        game.topCard = card;
        card.playCard(game);
        player.removeCard(card);
        player.setScore(player.getScore() + card.getScore());

        return null;
    }
}

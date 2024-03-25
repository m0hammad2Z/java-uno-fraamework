import uno.action.card.CardAction;
import uno.card.UnoCard;
import uno.game.UnoGameEngine;
import uno.player.UnoPlayer;

public class SwapHandCardAction implements CardAction {

    @Override
    public void onPlay(UnoCard card, UnoGameEngine game) {
        UnoPlayer currentPlayer = game.playerManager.getCurrentPlayer();
        UnoPlayer nextPlayer = game.playerManager.getNextPlayer();

        swapHandCard(currentPlayer, nextPlayer, card);



        System.out.println(currentPlayer.getName() + " swapped hand with " + nextPlayer.getName());
    }

    private void swapHandCard(UnoPlayer currentPlayer,UnoPlayer nextPlayer, UnoCard card) {
        var temp = currentPlayer.getHand().stream().filter(c -> c != card).toList();
        currentPlayer.setHand(nextPlayer.getHand());
        nextPlayer.setHand(temp);
    }
}

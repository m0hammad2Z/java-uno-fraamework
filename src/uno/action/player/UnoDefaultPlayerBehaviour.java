package uno.action.player;

import uno.card.UnoCard;
import uno.game.*;
import uno.deck.UnoDeck;
import uno.player.UnoPlayer;
import uno.player.UnoPlayerActionInvoker;
import uno.action.player.commands.*;
import uno.rule.UnoRuleMovePenalty;

public class UnoDefaultPlayerBehaviour implements PlayerAction {

    private UnoPlayerActionInvoker invoker;

    @Override
    public void onTakeTurn(UnoPlayer player, UnoGameEngine unoGame) {
        UnoCard topCard = unoGame.topCard;
        UnoDeck drawpile = unoGame.deckManager.getDeck(0);
        invoker = new UnoPlayerActionInvoker(unoGame);



        // When the player takes a turn:
        // 1. List all the cards in the player's hand with an option to draw a card, and let the player choose one.
        invoker.invoke(new UnoListPlayerHand(), player);
        // 2. Get the index of the player's choice
        int choiceIndex = invoker.invoke(new UnoGetPlayerChoice(), player);

        // 3. If the choice index is out of range, repeat the turn.
        if (!withinRange(choiceIndex, 0, player.getHand().size() + 1)) {
            onTakeTurn(player, unoGame);
        } else {
            // Handle the player's choice
            handlePlayerChoice(player, choiceIndex, drawpile, topCard, unoGame);

        }

    }

    @Override
    public void onEndTurn(UnoPlayer player, UnoGameEngine unoGame) {
        System.out.println("Your score: " + player.getScore());
    }

    // Check if the choice index is within the range of the player's hand
    private boolean withinRange(int choiceIndex, int min, int max) {
        return (choiceIndex >= min && choiceIndex <= max);
    }

    // Handle the player's choice based on the selected index
    private void handlePlayerChoice(UnoPlayer player, int choiceIndex, UnoDeck drawpile, UnoCard topCard, UnoGameEngine unoGame) {
        if (withinRange(choiceIndex, 0, player.getHand().size() - 1)) {
            UnoCard card = player.getHand().get(choiceIndex);

            if(card.isValidMove((topCard))){
                invoker.invoke(new UnoPlayerPlayCard(card), player);
            }
            else{
                unoGame.ruleManager.applyRule(new UnoRuleMovePenalty());
            }

        } else if (choiceIndex == player.getHand().size()) {
            // Player chooses to draw a card
            player.drawCards(drawpile, 1);
        } else if (choiceIndex == player.getHand().size() + 1) {
            // Player says UNO if they have one card in hand
            handleUnoSaying(player, unoGame);
        }
    }

    // Handle the case where the player says UNO
    private void handleUnoSaying(UnoPlayer player, UnoGameEngine unoGame) {
        if (player.getHand().size() == 1) {
            invoker.invoke(new UnoPlayerSayUno(), player);
        } else {
            System.out.println("You can only say UNO when you have one card in hand!");
            onTakeTurn(player, unoGame);
        }
    }
}

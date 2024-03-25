package uno.action.card;

import uno.card.UnoCard;
import uno.card.UnoCardColor;
import uno.game.UnoGameEngine;

import java.util.List;

// ----------- Pre defined actions for Uno cards ------------

public class UnoWildDrawFourAction implements CardAction {

    @Override
    public void onPlay(UnoCard card, UnoGameEngine game) {
        System.out.println("Choose a color:");
        List colors = UnoCardColor.COLORS;
        for(int i = 0; i < colors.size(); i++){
            if(colors.get(i) != UnoCardColor.BLACK)
                System.out.println(i + ". " + colors.get(i));
        }

        int chosenColorIndex = game.scanner.nextInt();

        UnoCardColor chosenColor = (UnoCardColor) colors.get(chosenColorIndex);

        game.topCard.setCardColor(chosenColor);

        game.playerManager.getNextPlayer().drawCards(game.deckManager.getDeck(0), 4);
    }
}

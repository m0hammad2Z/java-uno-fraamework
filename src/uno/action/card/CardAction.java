package uno.action.card;

import uno.card.UnoCard;
import uno.game.UnoGameEngine;

// Pattern used: Strategy

// This is the interface for the action that is executed when a card is played.
public interface CardAction {
    public void onPlay(UnoCard card, UnoGameEngine game);
}
package uno.action.card;
import uno.card.UnoCard;
import uno.enums.TurnOrder;
import uno.game.UnoGameEngine;

// ----------- Pre defined actions for Uno cards ------------
public class UnoReverseAction implements CardAction {
    @Override
    public void onPlay(UnoCard card, UnoGameEngine game){
        // Reverse the order of play
        if(game.settings.getTurnOrder() == TurnOrder.CLOCKWISE){
            game.settings.setTurnOrder(TurnOrder.COUNTER_CLOCKWISE);
        }else{
            game.settings.setTurnOrder(TurnOrder.CLOCKWISE);
        }
    }
}

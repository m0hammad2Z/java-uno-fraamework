import uno.card.CardFactory;
import uno.card.UnoCard;
import uno.card.UnoCardColor;
import uno.card.UnoCardValue;
import uno.enums.UnoCardType;

// Factory
public class ValueOnlyCardFactory implements CardFactory {

    private UnoCardColor cardColor;
    private UnoCardValue cardValue;
    private int score;


    public ValueOnlyCardFactory(UnoCardColor cardColor, UnoCardValue cardValue, int score) {
        this.cardColor = cardColor;
        this.cardValue = cardValue;
        this.score = score;
    }

    @Override
    public UnoCard createCard() {
        return new ValueOnlyCard(cardColor, cardValue, score);
    }
}

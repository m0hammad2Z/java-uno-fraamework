import uno.card.CardFactory;
import uno.card.UnoActionCardFactory;
import uno.card.UnoCardColor;
import uno.card.UnoCardValue;
import uno.deck.UnoDeck;
import uno.game.*;
import uno.player.UnoPlayer;
import uno.rule.*;

public class Game extends UnoGameEngine {

    // This will be called when the game starts and for once
    @Override
    public void onGameStart() {
        Initialize();

        // The main deck
        UnoDeck deck = new UnoDeck();

        // Add the deck to the deck manager
        deckManager.addDeck(deck);
        // Add 108 cards to the deck
        deck.Initialize();



        // New card factory for the swap hand card (new type of card)
        UnoCardValue swapHand = new UnoCardValue("Swap Hand");
        CardFactory cardFactory = new UnoActionCardFactory(UnoCardColor.BLUE, swapHand, 50, new SwapHandCardAction());

        deck.addCards(cardFactory.createCard(), 10);
        deck.shuffle();




        System.out.println("Enter number of players: ");
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine();


        // Set the settings
        settings = new UnoSettings().setNumberOfPlayers(numberOfPlayers)
                .setNumberOfCardsPerPlayer(5).build();




        // Ask for the names of the players and number of the players.
        generatePlayers();

        // Each player draws cards as the number specified in the settings
        dealCardsToPlayers(deck);

        System.out.println("Welcome to Uno!");

        // Set the current player to the first player
        playerManager.setCurrentPlayer(playerManager.getPlayers().get(0));
        // Draw the top card from the deck
        topCard = deck.drawCard();

        // Add the rules
        ruleManager.applyRule(new UnoRuleFirstCardWild());
        ruleManager.addRule(new SayUnoRule());


    }

    // The game loop
    @Override
    public void onGameUpdate() {

        System.out.println("It is " + playerManager.getCurrentPlayer().getName() + "'s turn");
        playerManager.getCurrentPlayer().takeTurn(this);
        ruleManager.applyRules();
        checkWinner();
        advanceToNextPlayer();
    }


    // When the game ends.
    @Override
    public void onGameEnd() {
        System.out.println("Game ended!");
        System.out.println("Winner is: " + playerManager.getWinner().getName());

        // Print out the scores of all players
        for(UnoPlayer player : playerManager.getPlayers()){
            System.out.println(player.getName() + " score: " + player.getScore());
        }
    }

    // Check the winner of the game
    public void checkWinner() {
        for (int i = 0; i < playerManager.getPlayers().size(); i++) {
            if (playerManager.getPlayers().get(i).getHand().isEmpty() || playerManager.getPlayers().get(i).getScore() >= settings.getWinningScore()) {
                playerManager.setWinner(playerManager.getPlayers().get(i));
                endGame();
            }
        }
    }
}


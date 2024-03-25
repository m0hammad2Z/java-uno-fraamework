package uno.game;

import uno.enums.*;
import uno.card.*;
import uno.deck.*;
import uno.player.*;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class UnoGameEngine {

    // ------------- Properties ----------------
    public UnoSettings settings;
    public UnoPlayerManager playerManager;
    public UnoDeckManager deckManager;
    public UnoGameStateManager gameStateManager;
    public UnoRuleManager ruleManager;
    public UnoCard topCard;
    public Scanner scanner;


    // ------------- Main Methods ----------------
    // Templete method, Play game
    public final void playGame() {
        try {
            onGameStart();
            while (gameStateManager.getState() == GameState.RUNNING) {
                onGameUpdate();
            }
            onGameEnd();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            endGame();
        }

    }

    // Initialize game
    public final void Initialize() {
        scanner = new Scanner(System.in);
        gameStateManager = new UnoGameStateManager();
        settings = new UnoSettings();
        deckManager = new UnoDeckManager(new ArrayList<UnoDeck>(), this);
        playerManager = new UnoPlayerManager(new ArrayList<UnoPlayer>(), this);
        ruleManager = new UnoRuleManager(this);
        gameStateManager.setState(GameState.RUNNING);
    }

    // Change game state and end game
    public final void endGame() {
        gameStateManager.setState(GameState.ENDED);
    }


    // ------------- Abstract methods ----------------



    /**
     * This will be called when the game starts and for once
     */
    public abstract void onGameStart();

    // On the game update (game loop)
    public abstract void onGameUpdate();

    // On the game end (end game)
    public abstract void onGameEnd();




 // ============== (Helper methods) ============= //


// ------------ Game Setup ------------


    // Generate players with real-time input
    public void generatePlayers() {
        if(settings.getNumberOfPlayers() < 2){
            throw new IllegalArgumentException("Number of players must be at least 2");
        }

        for (int i = 0; i < settings.getNumberOfPlayers(); i++) {
            System.out.println("Enter player " + (i + 1) + " name: ");
            String name = scanner.nextLine();
            if(name.isEmpty()){
                name = "Player " + (i + 1);
            }
            UnoPlayer player = new UnoHumanPlayer(name);
            playerManager.addPlayer(player);
        }
    }


    // Deal cards to players from a specific deck
    public void dealCardsToPlayers(UnoDeck deck) {
        if(settings.getNumberOfCardsPerPlayer() < 1){
            throw new IllegalArgumentException("Number of cards per player must be at least 1");
        }
        if(settings.getNumberOfCardsPerPlayer() * settings.getNumberOfPlayers() > deck.getCards().size()){
            throw new IllegalArgumentException("Not enough cards in the deck");
        }
        for (int i = 0; i < settings.getNumberOfCardsPerPlayer(); i++) {
            for (UnoPlayer player : playerManager.getPlayers()) {
                player.drawCard(deck);
            }
        }
    }


// ------------ Gameplay ------------


    // Advance to the next player
    public void advanceToNextPlayer() {
        playerManager.setCurrentPlayer(playerManager.getNextPlayer());
    }

    // Advance to the previous player
    public void advanceToPreviousPlayer() {
        playerManager.setCurrentPlayer(playerManager.getPreviousPlayer());
    }

    // Advance to a specific player
    public void advanceToPlayer(UnoPlayer player) {
        playerManager.setCurrentPlayer(player);
    }

    // Advance to a player at a specific index
    public void advanceToPlayer(int index) {
        playerManager.setCurrentPlayer(playerManager.getPlayer(index));
    }

}





package uno.game;

import uno.enums.TurnOrder;
import uno.rule.Rule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnoSettings {
    private UnoSetting<Integer> numberOfPlayers = new UnoSetting<>(2, 2, "numberOfPlayers");
    private UnoSetting<Integer> numberOfCardsPerPlayer = new UnoSetting<>(7, 7, "numberOfCardsPerPlayer");
    private UnoSetting<Integer> numberOfDrawCardsPerTurn = new UnoSetting<>(1, 1, "numberOfDrawCardsPerTurn");
    private UnoSetting<Integer> winningScore = new UnoSetting<>(500, 500, "winningScore");
    private UnoSetting<Integer> numberOfDecks = new UnoSetting<>(1, 1, "numberOfDecks");
    private UnoSetting<TurnOrder> turnOrder = new UnoSetting<>(TurnOrder.CLOCKWISE, TurnOrder.CLOCKWISE, "turnOrder");

    // Map to store custom settings
    private Map<String, UnoSetting<?>> customSettings = new HashMap<>();


    // -------------------- Builder -------------------

    public UnoSettings setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers.setValue(numberOfPlayers);
        return this;
    }

    public UnoSettings setNumberOfCardsPerPlayer(int numberOfCardsPerPlayer) {
        this.numberOfCardsPerPlayer.setValue(numberOfCardsPerPlayer);
        return this;
    }

    public UnoSettings setNumberOfDrawCardsPerTurn(int numberOfDrawCardsPerTurn) {
        this.numberOfDrawCardsPerTurn.setValue(numberOfDrawCardsPerTurn);
        return this;
    }

    public UnoSettings setWinningScore(int winningScore) {
        this.winningScore.setValue(winningScore);
        return this;
    }

    public UnoSettings setNumberOfDecks(int numberOfDecks) {
        this.numberOfDecks.setValue(numberOfDecks);
        return this;
    }

    public UnoSettings setTurnOrder(TurnOrder turnOrder) {
        this.turnOrder.setValue(turnOrder);
        return this;
    }

    public UnoSettings build() {
        return this;
    }


    // ------------------ More Methods ----------------------


    // Reset settings to default
    public UnoSettings reset() {
        numberOfPlayers.reset();
        numberOfCardsPerPlayer.reset();
        numberOfDrawCardsPerTurn.reset();
        winningScore.reset();
        numberOfDecks.reset();
        turnOrder.reset();
        for (UnoSetting<?> setting : customSettings.values()) {
            setting.reset();
        }
        return this;
    }

    // Register a custom setting
    public void registerCustomSetting(UnoSetting<?> setting) {
        if (setting == null) {
            throw new IllegalArgumentException("Setting cannot be null.");
        }

        if (customSettings.containsKey(setting.getName())) {
            throw new IllegalArgumentException("Setting with name " + setting.getName() + " already exists.");
        }

        customSettings.put(setting.getName(), setting);
    }


    // -------------  Getters  ---------------


    public int getNumberOfPlayers() {
        return numberOfPlayers.getValue();
    }

    public int getNumberOfCardsPerPlayer() {
        return numberOfCardsPerPlayer.getValue();
    }

    public int getNumberOfDrawCardsPerTurn() {
        return numberOfDrawCardsPerTurn.getValue();
    }

    public int getWinningScore() {
        return winningScore.getValue();
    }

    public int getNumberOfDecks() {
        return numberOfDecks.getValue();
    }

    public TurnOrder getTurnOrder() {
        return turnOrder.getValue();
    }

    public Map<String, UnoSetting<?>> getCustomSettings() {
        return customSettings;
    }
}


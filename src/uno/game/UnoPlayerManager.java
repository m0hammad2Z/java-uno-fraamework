    package uno.game;

import uno.enums.TurnOrder;
import uno.player.UnoPlayer;

import java.util.List;

public class UnoPlayerManager {
    private List<UnoPlayer> players;
    private UnoPlayer currentPlayer;
    private UnoPlayer winner;

    private UnoGameEngine gameEngine;

    public UnoPlayerManager(List<UnoPlayer> players, UnoGameEngine gameEngine) {
        this.players = players;
        this.gameEngine = gameEngine;
    }


    // ------------- Setter and Getter Methods ----------------

    public List<UnoPlayer> getPlayers() {
        return players;
    }

    public UnoPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(UnoPlayer player) {
        if(player == null)
            throw new IllegalArgumentException("Player cannot be null");

        if(!players.contains(player))
            throw new IllegalArgumentException("Player is not in the game");

        currentPlayer = player;
    }

    public UnoPlayer getWinner() {
        return winner;
    }

    public void setWinner(UnoPlayer winner) {
        this.winner = winner;
    }


    // Add player to game
    public void addPlayer(UnoPlayer player)  {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        if (!canAddPlayer()) {
            throw new IllegalArgumentException("Cannot add player to game");
        }
        players.add(player);
    }

    // Check if can add player to game
    public boolean canAddPlayer() {
        return players.size() <= gameEngine.settings.getNumberOfPlayers();
    }

    // Get the next player in the turn order
    public UnoPlayer getNextPlayer() {
        int index = players.indexOf(currentPlayer);
        return (gameEngine.settings.getTurnOrder() == TurnOrder.CLOCKWISE)
                ? (index == players.size() - 1) ? players.get(0) : players.get(index + 1)
                : (index == 0) ? players.get(players.size() - 1) : players.get(index - 1);
    }

    // Get the next player in the turn order
    public UnoPlayer getPreviousPlayer() {
        int index = players.indexOf(currentPlayer);
        return (gameEngine.settings.getTurnOrder() == TurnOrder.CLOCKWISE)
                ? (index == 0) ? players.get(players.size() - 1) : players.get(index - 1)
                : (index == players.size() - 1) ? players.get(0) : players.get(index + 1);
    }

    // Get player by index
    public UnoPlayer getPlayer(int index) {
        if(index < 0 || index >= players.size()){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return players.get(index);
    }

}

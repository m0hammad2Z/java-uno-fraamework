package uno.game;

import uno.enums.GameState;

public class UnoGameStateManager {
    private GameState currentState;

    public UnoGameStateManager() {
        currentState = GameState.NOT_STARTED;
    }

    // ------------ Setters and Getters ------------
    public void setState(GameState state) {
        currentState = state;
    }

    public GameState getState() {
        return currentState;
    }
}

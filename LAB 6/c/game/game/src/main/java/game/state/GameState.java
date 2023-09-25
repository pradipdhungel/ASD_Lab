package game.state;

import game.Game;

public abstract class GameState {
    protected final Game game;

    public GameState(Game game) {
        this.game = game;
    }
    public abstract void addPoints(int points);
    public abstract String getLevel();
}

package game.state.level;

import game.Game;
import game.state.GameState;

public class Three extends GameState {
    public Three(Game game) {
        super(game);
    }

    @Override
    public void addPoints(int points) {
        int totalPoints= game.getTotalPoints()+(3*points);
        game.setTotalPoints(totalPoints);
    }

    @Override
    public String getLevel() {
        return "3";
    }
}

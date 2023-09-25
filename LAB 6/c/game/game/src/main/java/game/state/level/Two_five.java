package game.state.level;

import game.Game;
import game.state.GameState;

public class Two_five extends GameState {
    public Two_five(Game game) {
        super(game);
    }

    @Override
    public void addPoints(int points) {
      int totalPoints=game.getTotalPoints()+(2*points);
      game.setTotalPoints(totalPoints);
      checkForLevelUpgrade();
    }
    private void checkForLevelUpgrade(){
        if(game.getTotalPoints()>20){
            GameState newState = new Three(game);
            game.setGameState(newState);
            game.setTotalPoints(game.getTotalPoints()+2);
        }
    }

    @Override
    public String getLevel() {
        return null;
    }
}

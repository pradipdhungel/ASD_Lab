package game.state.level;

import game.Game;
import game.state.GameState;

public class One extends GameState {


    public One(Game game) {
        super(game);
    }

    @Override
    public void addPoints(int points) {
      int totalPoints=game.getTotalPoints()+points;
      game.setTotalPoints(totalPoints);
      checkForLevelUpgrade();
    }

    private void checkForLevelUpgrade(){
        if(game.getTotalPoints()>10){
            GameState newState= new Two(game);
            game.setGameState(newState);
            game.setTotalPoints(game.getTotalPoints()+1);
        }
    }


    @Override
    public String getLevel() {
        return "1";
    }
}

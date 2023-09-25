package game.state.level;

import game.Game;
import game.state.GameState;

public class Two extends GameState {

    public Two(Game game) {
        super(game);
    }

    @Override
    public void addPoints(int points) {
        int totalPoints= game.getTotalPoints()+(2*points);
        game.setTotalPoints(totalPoints);
        checkForLevelUpgrade();
    }
private void checkForLevelUpgrade(){
        if(game.getTotalPoints()>=15){
            GameState newState=new Two_five(game);
            game.setGameState(newState);
            game.setTotalPoints(game.getTotalPoints()+1);
        }
}
    @Override
    public String getLevel() {
        return "2";
    }
}

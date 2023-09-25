package game;

import game.state.GameState;

import java.util.Random;

public class Game {
	private int totalPoints = 0;

	private GameState gameState;
//	private int level = 1;

	public void play() {
		Random random = new Random();
		addPoints(random.nextInt(7));
		System.out.println("value="+random.nextInt(7)+"total points="+totalPoints+" level="+getGameState().getLevel());
	}

	public void addPoints(int newPoints) {
		gameState.addPoints(newPoints);
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
}

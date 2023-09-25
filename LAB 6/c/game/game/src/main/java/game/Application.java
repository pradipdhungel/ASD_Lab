package game;

import game.state.level.One;

public class Application {

	public static void main(String[] args) {
		Game game = new Game();
		game.setGameState(new One(game));
		game.play();
		game.play();
		game.play();
		game.play();
		game.play();

	}

}

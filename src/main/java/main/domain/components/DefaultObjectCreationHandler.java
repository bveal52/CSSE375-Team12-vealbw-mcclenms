package main.domain.components;

import main.domain.datastructures.LevelInfo;
import main.domain.gameobjects.*;

public class DefaultObjectCreationHandler implements GameObjectFactory {
	@Override
	public GameObject createGameObject(String type, int col, int row, LevelInfo levelInfo) {
			GameObject gameObject = null;
			switch (type) {
				case "Player":
					gameObject = createPlayer(col, row, levelInfo);
					break;
				case "E1":
					gameObject = createEnemy(col, row, 0, levelInfo);
					break;
				case "E2":
					gameObject = createEnemy(col, row, 1, levelInfo);
					break;
				case "D1":
					gameObject = createAsteroid(col, row, 1, levelInfo);
					break;
				case "D2":
					gameObject = createAsteroid(col, row, 2, levelInfo);
					break;
				case "P1":
					gameObject = createPowerUp(col, row, 0, levelInfo);
					break;
				case "P2":
					gameObject = createPowerUp(col, row, 1, levelInfo);
					break;
				case "F":
					gameObject = createFuel(col, row, 0, levelInfo);
					break;
				case "Part1":
					gameObject = createFuel(col, row, 1, levelInfo);
					break;
				case "Part2":
					gameObject = createFuel(col, row, 2, levelInfo);
					break;
				case "Part3":
					gameObject = createFuel(col, row, 3, levelInfo);
					break;
				case "L":
					gameObject = createBigShip(col, row, levelInfo);
					break;
			}
			return gameObject;
	}

	private Player createPlayer(int col, int row, LevelInfo levelInfo) {
		return new Player(col * levelInfo.getPixelModifierX(), row * levelInfo.getPixelModifierY(), levelInfo.getDifficulty());
	}

	private Enemy createEnemy(int col, int row, int type, LevelInfo levelInfo) {
		return new Enemy(col * levelInfo.getPixelModifierX(), row * levelInfo.getPixelModifierY(), type);
	}

	private Asteroid createAsteroid(int col, int row, int size, LevelInfo levelInfo) {
		return new Asteroid(col * levelInfo.getPixelModifierX(), row * levelInfo.getPixelModifierY(), size);
	}

	private PowerUp createPowerUp(int col, int row, int type, LevelInfo levelInfo) {
		return new PowerUp(col * levelInfo.getPixelModifierX(), row * levelInfo.getPixelModifierY(), type);
	}

	private Fuel createFuel(int col, int row, int type, LevelInfo levelInfo) {
		return new Fuel(col * levelInfo.getPixelModifierX(), row * levelInfo.getPixelModifierY(), type);
	}

	private BigShip createBigShip(int col, int row, LevelInfo levelInfo) {
		return new BigShip(col * levelInfo.getPixelModifierX(), row * levelInfo.getPixelModifierY());
	}
}

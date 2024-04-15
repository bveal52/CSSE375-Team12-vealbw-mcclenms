package main.domain.components;

import main.domain.datastructures.LevelInfo;
import main.domain.gameobjects.Enemy;
import main.domain.gameobjects.GameObject;
import main.domain.gameobjects.Player;

import java.util.ArrayList;

public class MockObjectCreationHandler implements GameObjectFactory {

	@Override
	public GameObject createGameObject(String type, int col, int row, LevelInfo levelInfo) {
		// For testing purposes, we'll create specific mock objects based on input type
		GameObject gameObject = null;
		switch (type) {
			case "Player":
				gameObject = new Player(col, row, levelInfo.getDifficulty());
				break;
			case "Enemy":
				gameObject = new Enemy(col, row, 0);
				break;
			// Add more cases for other types as needed
			default:
				break;
		}

		return gameObject;
	}
}

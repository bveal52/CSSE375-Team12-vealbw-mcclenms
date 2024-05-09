package main.domain.components;

import main.domain.datastructures.LevelInfo;
import main.domain.gameobjects.Enemy;
import main.domain.gameobjects.GameObject;
import main.domain.gameobjects.Player;

import java.util.ArrayList;

public class MockObjectCreationHandler implements GameObjectFactory {

	@Override
	public GameObject createGameObject(String type, int col, int row, LevelInfo levelInfo) {
		GameObject gameObject = null;
		//for the sake of testing, only test the creation of a single type of object. Can add more types if needed
		switch (type) {
			case "Player":
				gameObject = new Player(col, row, levelInfo.getDifficulty(), 0);
				break;
			default:
				break;
		}

		return gameObject;
	}
}

package main.domain.components;

import main.domain.datastructures.LevelInfo;
import main.domain.gameobjects.GameObject;

public interface GameObjectFactory {

	GameObject createGameObject(String type, int col, int row, LevelInfo levelInfo);
}

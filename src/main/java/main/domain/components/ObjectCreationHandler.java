package main.domain.components;

import main.domain.datastructures.LevelInfo;
import main.domain.gameobjects.*;

import java.util.ArrayList;

public class ObjectCreationHandler {

    public ObjectCreationHandler() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<GameObject> createObjects(LevelInfo levelInfo) {
        ArrayList<GameObject> objectsInLevel = new ArrayList<>();
        String[][] levelData = levelInfo.getLevelData();

        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 19; col++) {
                String currentLetter = levelData[row][col];
                GameObject currentObject = createGameObject(currentLetter, col, row, levelInfo);
                if (currentObject != null) {
                    objectsInLevel.add(currentObject);
                }
            }
        }

        return objectsInLevel;
    }

    private GameObject createGameObject(String type, int col, int row, LevelInfo levelInfo) {
	    return switch (type) {
		    case "Player" -> createPlayer(col, row, levelInfo);
		    case "E1" -> createEnemy(col, row, 0, levelInfo);
		    case "E2" -> createEnemy(col, row, 1, levelInfo);
		    case "D1" -> createAsteroid(col, row, 1, levelInfo);
		    case "D2" -> createAsteroid(col, row, 2, levelInfo);
		    case "P1" -> createPowerUp(col, row, 0, levelInfo);
		    case "P2" -> createPowerUp(col, row, 1, levelInfo);
		    case "F" -> createFuel(col, row, 0, levelInfo);
		    case "Part1" -> createFuel(col, row, 1, levelInfo);
		    case "Part2" -> createFuel(col, row, 2, levelInfo);
		    case "Part3" -> createFuel(col, row, 3, levelInfo);
		    case "L" -> createBigShip(col, row, levelInfo);
		    default -> null;
	    };
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

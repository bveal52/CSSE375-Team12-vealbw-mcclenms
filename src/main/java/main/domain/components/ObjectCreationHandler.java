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
        switch (type) {
            case "Player":
                return new Player(col * levelInfo.getPixelModifierX(), row * levelInfo.getPixelModifierY(), levelInfo.getDifficulty());
            case "E1":
                return new Enemy(col * levelInfo.getPixelModifierX(), row * levelInfo.getPixelModifierY(), 0);
            case "E2":
                return new Enemy(col * levelInfo.getPixelModifierX(), row * levelInfo.getPixelModifierY(), 1);
            case "D1":
                return new Asteroid(col * levelInfo.getPixelModifierX(), row * levelInfo.getPixelModifierY(), 1);
            case "D2":
                return new Asteroid(col * levelInfo.getPixelModifierX(), row * levelInfo.getPixelModifierY(), 2);
            case "P1":
                return new PowerUp(col * levelInfo.getPixelModifierX(), row * levelInfo.getPixelModifierY(), 0);
            case "P2":
                return new PowerUp(col * levelInfo.getPixelModifierX(), row * levelInfo.getPixelModifierY(), 1);
            case "F":
                return new Fuel(col * levelInfo.getPixelModifierX(), row * levelInfo.getPixelModifierY(), 0);
            case "Part1":
                return new Fuel(col * levelInfo.getPixelModifierX(), row * levelInfo.getPixelModifierY(), 1);
            case "Part2":
                return new Fuel(col * levelInfo.getPixelModifierX(), row * levelInfo.getPixelModifierY(), 2);
            case "Part3":
                return new Fuel(col * levelInfo.getPixelModifierX(), row * levelInfo.getPixelModifierY(), 3);
            case "L":
                return new BigShip(col * levelInfo.getPixelModifierX(), row * levelInfo.getPixelModifierY());
            default:
                return null;
        }
    }

}

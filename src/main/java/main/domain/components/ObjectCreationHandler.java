package main.domain.components;

import main.domain.datastructures.LevelInfo;
import main.domain.gameobjects.*;

import java.util.ArrayList;

public class ObjectCreationHandler {

    private GameObjectFactory gameObjectFactory;
    public ObjectCreationHandler(GameObjectFactory gameObjectFactory) {
       this.gameObjectFactory = gameObjectFactory;
    }

    public ArrayList<GameObject> createObjects(LevelInfo levelInfo) {
        ArrayList<GameObject> objectsInLevel = new ArrayList<>();
        String[][] levelData = levelInfo.getLevelData();


        for (int row = 0; row < levelData.length; row++) {
            for (int col = 0; col < levelData[0].length; col++) {
                String currentLetter = levelData[row][col];
                GameObject currentObject = gameObjectFactory.createGameObject(currentLetter, col, row, levelInfo);
                if (currentObject != null) {
                    objectsInLevel.add(currentObject);
                }
            }
        }

        return objectsInLevel;
    }


}

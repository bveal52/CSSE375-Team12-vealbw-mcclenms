package main.domain.components;

import main.domain.gameobjects.*;

import javax.swing.*;
import java.awt.image.PixelGrabber;
import java.util.ArrayList;

public class ObjectCreationHandler {

    public ObjectCreationHandler() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<GameObject> createObjects(String[][] levelData, int pixelModifierX, int pixelModifierY, int difficulty ) {

        System.out.println(pixelModifierX + " " + pixelModifierY);

        System.out.println("Creating objects");
        ArrayList<GameObject> objectsInLevel = new ArrayList<GameObject>();

        boolean playerCreated = false;

        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 19; col++) {
                String currentLetter = levelData[row][col];
                //System.out.print(currentLetter); //displays the level in the console

                if (currentLetter.contentEquals("Player")) {
                    if (!playerCreated) {
                        Player currentObject = new Player(col* pixelModifierX,row* pixelModifierY, difficulty);
                        objectsInLevel.add(currentObject);
                        playerCreated = true;
                    }
                }
                // ENEMY 2
                if (currentLetter.contentEquals("E1")) {
                    Enemy currentObject = new Enemy(col* pixelModifierX,row* pixelModifierY, 0);
                    objectsInLevel.add(currentObject);
                }
                // ENEMY 2
                if (currentLetter.contentEquals("E2")) {
                    Enemy currentObject = new Enemy(col* pixelModifierX,row* pixelModifierY, 1);
                    objectsInLevel.add(currentObject);
                }

                // DEBRIS SIZE 1
                if (currentLetter.contentEquals("D1")) {
                    Asteroid currentObject = new Asteroid(col* pixelModifierX,row* pixelModifierY, 1);
                    objectsInLevel.add(currentObject);
                }

                // DEBRIS SIZE 2
                if (currentLetter.contentEquals("D2")) {
                    Asteroid currentObject = new Asteroid(col* pixelModifierX,row* pixelModifierY, 2);
                    objectsInLevel.add(currentObject);
                }

                // POWERUP TYPE 1
                if (currentLetter.contentEquals("P1")) {
                    PowerUp currentObject = new PowerUp(col* pixelModifierX,row* pixelModifierY, 0);
                    objectsInLevel.add(currentObject);
                }

                // POWERUP TYPE 2
                if (currentLetter.contentEquals("P2")) {
                    PowerUp currentObject = new PowerUp(col* pixelModifierX,row* pixelModifierY, 1);
                    objectsInLevel.add(currentObject);
                }

                // FUEL
                if (currentLetter.contentEquals("F")) {
                    Fuel currentObject = new Fuel(col* pixelModifierX,row* pixelModifierY, 0);
                    objectsInLevel.add(currentObject);
                }

                // Ship Parts (classified as fuel for easier implementation)
                if (currentLetter.contentEquals("Part1")) {
                    Fuel currentObject = new Fuel(col* pixelModifierX,row* pixelModifierY, 1);
                    objectsInLevel.add(currentObject);
                }
                if (currentLetter.contentEquals("Part2")) {
                    Fuel currentObject = new Fuel(col* pixelModifierX,row* pixelModifierY, 2);
                    objectsInLevel.add(currentObject);
                }
                if (currentLetter.contentEquals("Part3")) {
                    Fuel currentObject = new Fuel(col* pixelModifierX,row* pixelModifierY, 3);
                    objectsInLevel.add(currentObject);
                }

                // BIGSHIP
                if (currentLetter.contentEquals("L")) {
                    System.out.println("BigShip created at" + col*pixelModifierX + " " + row*pixelModifierY);
                    BigShip currentObject = new BigShip(col* pixelModifierX,row* pixelModifierY);
                    objectsInLevel.add(currentObject);
                }
            }
        }

        //print objectsInLevel
//        for (GameObject object : objectsInLevel) {
//            System.out.println(object);
//        }

        return objectsInLevel;
    }

}

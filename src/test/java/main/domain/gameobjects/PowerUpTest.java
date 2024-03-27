package main.domain.gameobjects;


import main.domain.gameobjects.PowerUp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerUpTest {

    @Test
    public void testConstructor() {
        PowerUp powerUp = new PowerUp(10, 20, 0);

        assertEquals(10, powerUp.getPositionX());
        assertEquals(20, powerUp.getPositionY());
        assertEquals(0, powerUp.getPowerType());
        assertEquals(6, powerUp.type);

        // Check if the image is set for powerType 0
//        BufferedImage expectedImage = loadImage("images/health.png");
//        assertEquals(expectedImage, powerUp.getImage());

        // Check if the object size is set for powerType 0
        assertEquals(50, powerUp.getObjectSizeX());
        assertEquals(50, powerUp.getObjectSizeY());
    }

    @Test
    public void testConstructorWithPowerType1() {
        PowerUp powerUp = new PowerUp(30, 40, 1);

        assertEquals(30, powerUp.getPositionX());
        assertEquals(40, powerUp.getPositionY());
        assertEquals(1, powerUp.getPowerType());
        assertEquals(6, powerUp.type);

        // Check if the image is set for powerType 1
//        BufferedImage expectedImage = loadImage("images/speedBoost.png");
//        assertEquals(expectedImage, powerUp.getImage());

        // Check if the object size is set for powerType 1
        assertEquals(30, powerUp.getObjectSizeX());
        assertEquals(60, powerUp.getObjectSizeY());
    }

    // Helper method to load images for comparison
//    private BufferedImage loadImage(String filename) {
//        try {
//            return ImageIO.read(new File(filename));
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}


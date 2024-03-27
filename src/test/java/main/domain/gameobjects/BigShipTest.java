package main.domain.gameobjects;
// setup this file to test the constructor of BigShip class

import org.junit.jupiter.api.Test;

import main.domain.gameobjects.BigShip;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigShipTest {
        
        @Test
        public void testConstructor() {
            BigShip bigShip = new BigShip(10, 20);

            assertEquals(10, bigShip.getPositionX());
            assertEquals(20, bigShip.getPositionY());
            assertEquals(5, bigShip.type); // should be 5
        }

        @Test
        public void testGetHasTurned() {
            BigShip bigShip = new BigShip(10, 20);
            assertEquals(false, bigShip.getHasTurned());
        }

        @Test
        public void testSetHasTurned() {
            BigShip bigShip = new BigShip(10, 20);
            bigShip.setHasTurned(true);
            assertEquals(true, bigShip.getHasTurned());
        }

        @Test
        public void testSetImageCompletion() {
            BigShip bigShip = new BigShip(10, 20);
            bigShip.setImageCompletion(0);
            assertEquals("images/fuelShipP0.png", bigShip.getImgFilename());
            assertEquals(100, bigShip.getObjectSizeX());
            assertEquals(60, bigShip.getObjectSizeY());
            bigShip.setImageCompletion(1);
            assertEquals("images/fuelShipP0P1.png", bigShip.getImgFilename());
            assertEquals(140, bigShip.getObjectSizeX());
            assertEquals(60, bigShip.getObjectSizeY());
            bigShip.setImageCompletion(2);
            assertEquals("images/fuelShipP0P2.png", bigShip.getImgFilename());
            assertEquals(100, bigShip.getObjectSizeX());
            assertEquals(100, bigShip.getObjectSizeY());
            bigShip.setImageCompletion(3);
            assertEquals("images/fuelShipP0P3.png", bigShip.getImgFilename());
            assertEquals(140, bigShip.getObjectSizeX());
            assertEquals(60, bigShip.getObjectSizeY());
        }
}


package main.domain.gameobjects;
// setup this file to test the constructor of BigShip class

import org.junit.jupiter.api.Test;

import main.domain.gameobjects.BigShip;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigShipTest {

        @Test
        public void testGetHasTurned() {
            BigShip bigShip = new BigShip(10, 20);
            assertEquals(false, bigShip.getHasTurned());
        }


}


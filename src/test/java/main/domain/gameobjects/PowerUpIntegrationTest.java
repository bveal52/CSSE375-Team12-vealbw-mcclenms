package main.domain.gameobjects;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PowerUpIntegrationTest {

    @Test
    public void testConstructor() {
        PowerUp powerUp = new PowerUp(10, 20, 0);

        assertEquals(10, powerUp.getPositionX());
        assertEquals(20, powerUp.getPositionY());
        assertEquals(0, powerUp.getPowerType());
        assertEquals(6, powerUp.type);

        assertEquals(50, powerUp.getObjectSizeX());
        assertEquals(50, powerUp.getObjectSizeY());

        assertNotNull(powerUp.getImage());
    }

    @Test
    public void testConstructorWithPowerType1() {
        PowerUp powerUp = new PowerUp(30, 40, 1);

        assertEquals(30, powerUp.getPositionX());
        assertEquals(40, powerUp.getPositionY());
        assertEquals(1, powerUp.getPowerType());
        assertEquals(6, powerUp.type);

        assertEquals(30, powerUp.getObjectSizeX());
        assertEquals(60, powerUp.getObjectSizeY());

        assertNotNull(powerUp.getImage());
    }

}


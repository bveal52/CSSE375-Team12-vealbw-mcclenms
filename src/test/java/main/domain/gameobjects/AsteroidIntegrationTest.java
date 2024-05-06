package main.domain.gameobjects;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AsteroidIntegrationTest {

     @Test
     public void testConstructor() {
         Asteroid asteroid = new Asteroid(10, 20, 10);

         assertEquals(10, asteroid.getPositionX());
         assertEquals(20, asteroid.getPositionY());
         assertEquals(7, asteroid.type);

         assertNotNull(asteroid.getImage());
     }

}

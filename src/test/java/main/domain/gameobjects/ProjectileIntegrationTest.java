package main.domain.gameobjects;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProjectileIntegrationTest {

    @Test
    public void testConstructorWithRedLaser() {
        Projectile redProjectile = new Projectile(50, 50, 45, true);
        assertEquals(20, redProjectile.getObjectSizeX());
        assertEquals(15, redProjectile.getObjectSizeY());
        assertEquals(3, redProjectile.type);
    }

    @Test
    public void testConstructorWithGreenLaser() {
        Projectile greenProjectile = new Projectile(50, 50, 45, false);
        assertEquals(20, greenProjectile.getObjectSizeX());
        assertEquals(5, greenProjectile.getObjectSizeY());
        assertEquals(3, greenProjectile.type);
    }

}


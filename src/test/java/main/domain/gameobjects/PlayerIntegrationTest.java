package main.domain.gameobjects;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerIntegrationTest {

    @Test
    public void createPlayer_testConstructor() {
        Player player = new Player(10, 20, 2, 0);

        assertEquals(10, player.getPositionX());
        assertEquals(20, player.getPositionY());
        assertEquals(40, player.getHealth());
        assertEquals(100, player.getObjectSizeX());
        assertEquals(100, player.getObjectSizeY());

        //assert that the image for the player is set correctly
        assertNotNull(player.getImage());
    }
}

package main.domain.components;

import main.domain.gameobjects.BigShip;
import main.domain.gameobjects.Player;
import main.domain.gameobjects.Projectile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class ClickComponentTest {

    private ClickComponent clickComponent;

    @BeforeEach
    void setUp() {
        JFrame frame = new JFrame();
        JLabel label = new JLabel();
        int difficulty = 1;
        clickComponent = new ClickComponent(frame, label, difficulty);
    }

    @Test
    void constructorTest() {
        assertNotNull(clickComponent);
        assertNotNull(clickComponent.getCurrentObjects());
        assertNotNull(clickComponent.getCurrentEnemies());
        assertNotNull(clickComponent.getCurrentProjectiles());
        assertNotNull(clickComponent.getCurrentFuel());
        assertNotNull(clickComponent.getCurrentPowerUps());
        assertNotNull(clickComponent.getCurrentAsteroids());
    }

    @Test
    void switchLevelTest() {
        assertDoesNotThrow(() -> clickComponent.SwitchLevel(true));
        assertEquals(2, clickComponent.getLevelNumber());
        assertDoesNotThrow(() -> clickComponent.SwitchLevel(true));
        assertEquals(3, clickComponent.getLevelNumber());
        assertDoesNotThrow(() -> clickComponent.SwitchLevel(true));
        assertEquals(4, clickComponent.getLevelNumber());
        assertThrows(Exception.class, () -> clickComponent.SwitchLevel(true));
    }

    @Test
    void playerMovementTest() {
        // Assuming player is initialized properly in setUp
        Player player = clickComponent.getPlayer();
        assertNotNull(player);

        int initialX = player.getPositionX();
        int initialY = player.getPositionY();
        int initialRotation = player.getRotation();

        clickComponent.up();
        assertEquals(initialY, player.getPositionY());

        clickComponent.down();
        assertEquals(initialY, player.getPositionY());

        clickComponent.left();
        assertEquals(initialX, player.getPositionX());
        assertEquals(initialRotation - 10, player.getRotation());

        clickComponent.right();
        clickComponent.right();
        assertEquals(initialX, player.getPositionX());
        assertEquals(initialRotation + 10, player.getRotation());
    }

    @Test
    void checkIfEndgameTest() {
        // Test player health reaching zero
        clickComponent.getPlayer().setHealth(0);
        clickComponent.checkIfEndgame();
        assertTrue(clickComponent.isGameOver());
        clickComponent.getPlayer().setHealth(1);

    }

    @Test
    public void testCheckIfEndgameBigShip1() {
        // Test the big ship leaving
        clickComponent.setFuel(3);
        clickComponent.getBigShip().setPositionY(-10);
        BigShip bigShip = (BigShip) clickComponent.getBigShip();
        bigShip.setHasTurned(true);
        clickComponent.checkIfEndgame();
        assertTrue(clickComponent.isGameOver());
    }

    @Test
    public void testCheckIfEndgameBigShip2() {
        clickComponent.getBigShip().setPositionY(10);
        clickComponent.setFuel(2);
        BigShip bigShip = (BigShip) clickComponent.getBigShip();
        bigShip.setHasTurned(false);
        clickComponent.checkIfEndgame();
        //assertFalse(clickComponent.isGameOver());
    }

    @Test
    public void testCheckIfEndgameWinGame() {
        // Test winning the game
        clickComponent.setLevelNumber(clickComponent.getNumLevels());
        clickComponent.checkIfEndgame();
        assertTrue(clickComponent.isGameOver());
        assertFalse(clickComponent.getChangeLevel());
    }

    @Test
    public void testCheckIfEndgameLoseGame() {
        // Test losing the game
        clickComponent.setFuel(0);
        clickComponent.setGameOver(false);
        clickComponent.setLevelNumber(1);
        clickComponent.checkIfEndgame();
        assertTrue(clickComponent.isGameOver());
        assertFalse(clickComponent.getChangeLevel());
    }

    @Test
    void playerFireTest() {
        // Assuming player is initialized properly in setUp
        Player player = clickComponent.getPlayer();
        assertNotNull(player);

        // No projectiles initially
        assertEquals(0, clickComponent.getCurrentProjectiles().size());

        // Fire a projectile
        clickComponent.playerFire();
        assertEquals(1, clickComponent.getCurrentProjectiles().size());

        // Projectile position should be the same as player's position
        Projectile projectile = clickComponent.getCurrentProjectiles().get(0);
        assertTrue(clickComponent.getCurrentProjectiles().contains(projectile));
    }

}

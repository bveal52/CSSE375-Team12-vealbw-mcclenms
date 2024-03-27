package main.domain.gameobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

	@Test
	public void createPlayer_testConstructor() {
		Player player = new Player(10, 20, 2);

		assertEquals(10, player.getPositionX());
		assertEquals(20, player.getPositionY());
		assertEquals(20, player.getHealth());
		assertEquals(100, player.getObjectSizeX());
		assertEquals(100, player.getObjectSizeY());
	}

	@Test
	public void player_testMoveDown() {
		//moves player down by 1
		Player player = new Player(10, 20, 2);
		player.moveDown();
		assertEquals(21, player.getPositionY());
	}

	@Test
	public void player_testMoveDown10() {
		//moves player down by
		Player player = new Player(10, 20, 2);

		for (int i = 0; i < 10; i++) {
			player.moveDown();
		}

		assertEquals(30, player.getPositionY());
	}

	@Test
	public void player_testIncreaseMaxSpeed() {
		Player player = new Player(10, 20, 20);
		//increases max speed by 5
		player.increaseMaxSpeed();
		assertEquals(17, player.getMaxSpeed());
	}

	@Test
	public void player_testIncreaseMaxSpeedBy15() {
		Player player = new Player(10, 20, 20);
		//increases max speed by 5
		player.increaseMaxSpeed();
		player.increaseMaxSpeed();
		player.increaseMaxSpeed();
		assertEquals(27, player.getMaxSpeed());
	}
}
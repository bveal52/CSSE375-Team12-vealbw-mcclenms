package main.domain.gameobjects;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemyTest {

	@Test
	public void createEnemy_testConstructorType0() {
		Enemy enemy = new Enemy(10, 20, 0);

		assertEquals(10, enemy.getPositionX());
		assertEquals(20, enemy.getPositionY());
		assertEquals(70, enemy.getObjectSizeX());
		assertEquals(70, enemy.getObjectSizeY());
		assertEquals(0, enemy.getEnemyClass());
		assertEquals(2, enemy.type);
	}

	@Test
	public void createEnemy_testConstructorType1() {
		Enemy enemy = new Enemy(10, 20, 1);

		assertEquals(10, enemy.getPositionX());
		assertEquals(20, enemy.getPositionY());
		assertEquals(90, enemy.getObjectSizeX());
		assertEquals(70, enemy.getObjectSizeY());
		assertEquals(1, enemy.getEnemyClass());
		assertEquals(2, enemy.type);
	}
}

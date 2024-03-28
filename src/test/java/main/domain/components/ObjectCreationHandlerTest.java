package main.domain.components;

import main.domain.datastructures.LevelInfo;

import main.domain.gameobjects.*;

import main.domain.components.ObjectCreationHandler;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObjectCreationHandlerTest {

	@Test
	public void testCreateObjects_Order_Level1() {
		ObjectCreationHandler handler = new ObjectCreationHandler();
		String[][] levelData = getLevel1Data();

		//expected arrayList of gameObjects - powerup, enemy, asteroid, part1, enemy, player, part3, part2, asteroid, enemy, powerup

		int pixelModifierX = 0;
		int pixelModifierY = 0;
		int difficulty = 2;

		LevelInfo levelInfo = new LevelInfo(levelData, pixelModifierX, pixelModifierY, difficulty);

		ArrayList<GameObject> objects = handler.createObjects(levelInfo);

		assertEquals(12, objects.size()); // Assuming the expected count of objects

		// Test if objects are of correct types
		assertTrue(objects.get(0) instanceof PowerUp);

		assertTrue(objects.get(1) instanceof Enemy);

		assertTrue(objects.get(2) instanceof Asteroid);

		assertTrue(objects.get(3) instanceof Fuel);

		assertTrue(objects.get(4) instanceof Enemy);

		assertTrue(objects.get(5) instanceof Player);

		assertTrue(objects.get(6) instanceof Fuel);

		assertTrue(objects.get(7) instanceof BigShip);

		assertTrue(objects.get(8) instanceof Fuel);

		assertTrue(objects.get(9) instanceof Asteroid);

		assertTrue(objects.get(10) instanceof Enemy);

		assertTrue(objects.get(11) instanceof PowerUp);

	}

	private String[][] getLevel1Data() {

		return new String[][]{
				{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"},
				{"2", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
				{"3", "x", "x", "x", "x", "P1", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
				{"4", "x", "x", "E2", "x", "x", "x", "D1", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
				{"5", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "Part1", "x", "x", "x"},
				{"6", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
				{"7", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "E1", "x", "x"},
				{"8", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
				{"9", "x", "x", "x", "x", "x", "x", "x", "x", "Player", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
				{"10", "x", "Part3", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
				{"11", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
				{"12", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "L", "x"},
				{"13", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
				{"14", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
				{"15", "x", "x", "x", "x", "Part2", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
				{"16", "x", "x", "D1", "x", "x", "x", "x", "x", "x", "x", "x", "E1", "x", "x", "x", "x", "x", "x", "x"},
				{"17", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
				{"18", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "P2", "x", "x", "x", "x", "x"},
				{"19", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
				{"20", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"}
		};
	}
}



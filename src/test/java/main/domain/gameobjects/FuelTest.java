package main.domain.gameobjects;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FuelTest {

	@Test
	public void createFuel_testConstructorPartType0() {
		Fuel fuel = new Fuel(10, 20, 0);

		assertEquals(10, fuel.getPositionX());
		assertEquals(20, fuel.getPositionY());
		assertEquals(50, fuel.getObjectSizeX());
		assertEquals(50, fuel.getObjectSizeY());
		assertEquals(4, fuel.type);
		assertEquals(0, fuel.getPartNumber());
	}

	@Test
	public void createFuel_testConstructorPartType1() {
		Fuel fuel = new Fuel(10, 20, 1);

		assertEquals(10, fuel.getPositionX());
		assertEquals(20, fuel.getPositionY());
		assertEquals(50, fuel.getObjectSizeX());
		assertEquals(50, fuel.getObjectSizeY());
		assertEquals(4, fuel.type);
		assertEquals(1, fuel.getPartNumber());
	}

	@Test
	public void createFuel_testConstructorPartType2() {
		Fuel fuel = new Fuel(10, 20, 2);

		assertEquals(10, fuel.getPositionX());
		assertEquals(20, fuel.getPositionY());
		assertEquals(50, fuel.getObjectSizeX());
		assertEquals(50, fuel.getObjectSizeY());
		assertEquals(4, fuel.type);
		assertEquals(2, fuel.getPartNumber());
	}

	@Test
	public void createFuel_testConstructorPartType3() {
		Fuel fuel = new Fuel(10, 20, 3);

		assertEquals(10, fuel.getPositionX());
		assertEquals(20, fuel.getPositionY());
		assertEquals(50, fuel.getObjectSizeX());
		assertEquals(50, fuel.getObjectSizeY());
		assertEquals(4, fuel.type);
		assertEquals(3, fuel.getPartNumber());
	}
}

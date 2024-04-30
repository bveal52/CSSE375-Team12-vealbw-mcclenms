package main.domain.gameobjects;



import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FuelIntegrationTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3})
	public void createFuel_testConstructorPartType0(int val) {
		Fuel fuel = new Fuel(10, 20, val);

		assertEquals(10, fuel.getPositionX());
		assertEquals(20, fuel.getPositionY());
		assertEquals(50, fuel.getObjectSizeX());
		assertEquals(50, fuel.getObjectSizeY());
		assertEquals(4, fuel.type);
		assertEquals(val, fuel.getPartNumber());

		assertNotNull(fuel.getImage());
	}

}

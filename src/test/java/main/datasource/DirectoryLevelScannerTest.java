package main.datasource;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectoryLevelScannerTest {

	@Test
	public void testScanner_scanLevels_expect3() {
		DirectoryLevelScanner dls = new DirectoryLevelScanner();

		assertEquals(3, dls.scanner());
	}

}

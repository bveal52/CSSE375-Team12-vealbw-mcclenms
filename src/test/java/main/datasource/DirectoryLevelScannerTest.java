package main.datasource;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DirectoryLevelScannerTest {

	@Test
	public void testScanner_getDirectory_expectNotNull() {
		DirectoryLevelScanner dls = new DirectoryLevelScanner();

		assertTrue(dls.getDirectory("levels") != null);
	}

	@Test
	public void testScanner_scanLevels_expect3() {

		File mockDirectory = EasyMock.createMock(File.class);
		EasyMock.expect(mockDirectory.listFiles()).andReturn(new File[] { new File("level1"), new File("level2"),
				new File("level3") });
		EasyMock.replay(mockDirectory);

		DirectoryLevelScanner dls = new DirectoryLevelScanner();

		assertEquals(3, dls.scanner(mockDirectory));
	}

}

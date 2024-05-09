package main.datasource;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LevelReaderTest {
	@Test
	public void testLevel_loadLevel1() throws IOException {
//        LevelReader levelReader = new LevelReader();
//
//        String[][] expected = getLevel1Data();
//
//        String[][] actual = levelReader.readFile("levels/LEVEL1.csv");
//
//		//skip the first row, then compare that arrays are equal
//		for (int i = 1; i < expected.length - 1; i++) {
//			for(int j = 0; j < expected[i].length; j++) {
//				assertEquals(expected[i][j], actual[i][j]);
//			}
//		}
//

	}

	private String[][] getLevel1Data() {

		return new String[][]{
				{"Level I", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
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

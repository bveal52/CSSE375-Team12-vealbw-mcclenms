package main.datasource;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LevelReader implements Reader {

	private final int ARRAY_SIZE = 21;
	private final int COL_SIZE = 19;
	private final int ROW_SIZE = 21;

	@Override
	public String[][] readFile(String levelFileName) throws IOException {

        FileReader file = new FileReader(levelFileName);
		Scanner s = new Scanner(file);
		s.useDelimiter(",");

		String[][] levelData = new String[ARRAY_SIZE][COL_SIZE];
		for (int row=0; row<ROW_SIZE; row++) {
			for (int col=0; col<COL_SIZE; col++) {
				String currentLetter = s.next();
				levelData[row][col] = currentLetter;
			}
		}

		file.close();
		s.close();

		return levelData;
	}
}
		

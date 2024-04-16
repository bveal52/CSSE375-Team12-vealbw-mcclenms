package main.datasource;

import java.io.File;

public class DirectoryLevelScanner implements Scanner {

	@Override
	public int scanner() {
		//scan the levels directory for the number of files in it, and return the number of files as an integer

		//use relative path to scan the levels directory
		String relPath = "./levels";
		File directory = new File(relPath);
		File[] files = directory.listFiles();



		if (files == null) {
			throw new RuntimeException("No files found in the directory");
		}

		return files.length;

	}


}

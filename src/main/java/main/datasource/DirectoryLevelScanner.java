package main.datasource;

import java.io.File;

public class DirectoryLevelScanner implements Scanner {

	@Override
	public File getDirectory(String relPath) {
		return new File(relPath);
	}

	@Override
	public int scanner(File directory) {

		File[] files = directory.listFiles();

		if (files == null) {
			throw new RuntimeException("No files found in the directory");
		}

		return files.length;

	}


}

package main.datasource;

import java.io.File;

public interface Scanner {

	public File getDirectory(String relPath);

	public int scanner(File directory);
}

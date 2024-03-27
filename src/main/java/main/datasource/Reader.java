package main.datasource;

import java.io.IOException;

public interface Reader {

    public String[][] readFile(String levelFileName) throws IOException;

}

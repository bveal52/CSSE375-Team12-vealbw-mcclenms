package main.datasource;

import java.awt.image.BufferedImage;

public interface Loader {
    public BufferedImage getLevelImage(int levelNumber) throws Exception;
}

package main.datasource;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.NotActiveException;

public class ImageLoader implements Loader {

    private final String level1Filename = "images/level1.jpg";
    private final String level2Filename = "images/level2.jpg";
    private final String level3Filename = "images/level3.jpg";
    private final String titleScreen = "images/titleImage.jpg";

    public BufferedImage loadImage(int levelNumber) throws IOException {
        if (levelNumber == 1) {
            return ImageIO.read(new File(level1Filename));
        } else if (levelNumber == 2 ){
            return ImageIO.read(new File(level2Filename));
        } else if (levelNumber == 3 ){
            return ImageIO.read(new File(level3Filename));
        } else {
            return ImageIO.read(new File(titleScreen));
        }

    }

    @Override
    public Clip loadClip(int identifier) throws Exception {
        throw new NotActiveException();
    }
}

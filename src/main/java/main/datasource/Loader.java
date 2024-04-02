package main.datasource;

import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;

public interface Loader {
    public BufferedImage loadImage(int identifier) throws Exception;

    public Clip loadClip(int identifier) throws Exception;


}

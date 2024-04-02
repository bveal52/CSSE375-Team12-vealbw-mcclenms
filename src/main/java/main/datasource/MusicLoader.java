package main.datasource;

import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import java.io.NotActiveException;

public class MusicLoader implements Loader {

	@Override
	public BufferedImage loadImage(int identifier) throws Exception {
		throw new NotActiveException();
	}

	@Override
	public Clip loadClip(int identifier) throws Exception {
		return null;
	}
}

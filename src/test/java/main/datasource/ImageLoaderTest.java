package main.datasource;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ImageLoaderTest {

	@Test
	public void testImageLoader_getLevel1Image() {
		ImageLoader imageLoader = new ImageLoader();
		try {
			BufferedImage level1Image = ImageIO.read(new File("images/level1.jpg"));
			assertArrayEquals(getImagePixels(level1Image), getImagePixels(imageLoader.getLevelImage(1)));
		} catch (IOException e) {
			fail("IOException occurred: " + e.getMessage());
		}
	}

	@Test
	public void testImageLoader_getLevel2Image() {
		ImageLoader imageLoader = new ImageLoader();
		try {
			BufferedImage level2Image = ImageIO.read(new File("images/level2.jpg"));
			assertArrayEquals(getImagePixels(level2Image), getImagePixels(imageLoader.getLevelImage(2)));
		} catch (IOException e) {
			fail("IOException occurred: " + e.getMessage());
		}
	}

	@Test
	public void testImageLoader_getLevel3Image() {
		ImageLoader imageLoader = new ImageLoader();
		try {
			BufferedImage level3Image = ImageIO.read(new File("images/level3.jpg"));
			assertArrayEquals(getImagePixels(level3Image), getImagePixels(imageLoader.getLevelImage(3)));
		} catch (IOException e) {
			fail("IOException occurred: " + e.getMessage());
		}
	}

	@Test
	public void testImageLoader_getTitleScreenImage() {
		ImageLoader imageLoader = new ImageLoader();
		try {
			BufferedImage titleImage = ImageIO.read(new File("images/titleImage.jpg"));
			assertArrayEquals(getImagePixels(titleImage), getImagePixels(imageLoader.getLevelImage(4)));
		} catch (IOException e) {
			fail("IOException occurred: " + e.getMessage());
		}
	}

	@Test
	public void testImageLoader_getAllLevelImages() {
		ImageLoader imageLoader = new ImageLoader();
		try {
			BufferedImage level1Image = ImageIO.read(new File("images/level1.jpg"));
			BufferedImage level2Image = ImageIO.read(new File("images/level2.jpg"));
			BufferedImage level3Image = ImageIO.read(new File("images/level3.jpg"));
			BufferedImage titleScreenImage = ImageIO.read(new File("images/titleImage.jpg"));


			assertArrayEquals(getImagePixels(level1Image), getImagePixels(imageLoader.getLevelImage(1)));
			assertArrayEquals(getImagePixels(level2Image), getImagePixels(imageLoader.getLevelImage(2)));
			assertArrayEquals(getImagePixels(level3Image), getImagePixels(imageLoader.getLevelImage(3)));
			assertArrayEquals(getImagePixels(titleScreenImage), getImagePixels(imageLoader.getLevelImage(4)));
		} catch (IOException e) {
			fail("IOException occurred: " + e.getMessage());
		}
	}

	private int[] getImagePixels(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		int[] pixels = new int[width * height];
		image.getRGB(0, 0, width, height, pixels, 0, width);
		return pixels;
	}
}

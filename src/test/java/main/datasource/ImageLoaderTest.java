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
			assertArrayEquals(getImagePixels(level1Image), getImagePixels(imageLoader.loadImage(1)));
		} catch (IOException e) {
			fail("IOException occurred: " + e.getMessage());
		}
	}

	@Test
	public void testImageLoader_getLevel2Image() {
		ImageLoader imageLoader = new ImageLoader();
		try {
			BufferedImage level2Image = ImageIO.read(new File("images/level2.jpg"));
			assertArrayEquals(getImagePixels(level2Image), getImagePixels(imageLoader.loadImage(2)));
		} catch (IOException e) {
			fail("IOException occurred: " + e.getMessage());
		}
	}

	@Test
	public void testImageLoader_getLevel3Image() {
		ImageLoader imageLoader = new ImageLoader();
		try {
			BufferedImage level3Image = ImageIO.read(new File("images/level3.jpg"));
			assertArrayEquals(getImagePixels(level3Image), getImagePixels(imageLoader.loadImage(3)));
		} catch (IOException e) {
			fail("IOException occurred: " + e.getMessage());
		}
	}

	@Test
	public void testImageLoader_getTitleScreenImage() {
		ImageLoader imageLoader = new ImageLoader();
		try {
			BufferedImage titleImage = ImageIO.read(new File("images/titleImage.jpg"));
			assertArrayEquals(getImagePixels(titleImage), getImagePixels(imageLoader.loadImage(-1)));
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
			BufferedImage level4Image = ImageIO.read(new File("images/level4.jpg"));
			BufferedImage titleScreenImage = ImageIO.read(new File("images/titleImage.jpg"));


			assertArrayEquals(getImagePixels(level1Image), getImagePixels(imageLoader.loadImage(1)));
			assertArrayEquals(getImagePixels(level2Image), getImagePixels(imageLoader.loadImage(2)));
			assertArrayEquals(getImagePixels(level3Image), getImagePixels(imageLoader.loadImage(3)));
			assertArrayEquals(getImagePixels(level4Image), getImagePixels(imageLoader.loadImage(4)));
			assertArrayEquals(getImagePixels(titleScreenImage), getImagePixels(imageLoader.loadImage(-1)));
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

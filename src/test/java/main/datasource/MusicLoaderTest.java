package main.datasource;

import org.junit.jupiter.api.Test;

import javax.sound.sampled.Clip;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MusicLoaderTest {

	@Test
	public void testMusicLoader_getBackgroundMusic() throws Exception {

		MusicLoader musicLoader = new MusicLoader();
		try (Clip backgroundMusic = musicLoader.loadClip(1000)) {
			backgroundMusic.open();
			backgroundMusic.start();
			assertTrue(backgroundMusic.isOpen());
			assertTrue(backgroundMusic.isRunning());
			backgroundMusic.stop();
			backgroundMusic.close();
		}
		catch (Exception e) {
			assert false;
		}

	}

	@Test
	public void testMusicLoader_getLaserSound() throws Exception {

		MusicLoader musicLoader = new MusicLoader();
		try (Clip laserSound = musicLoader.loadClip(1001)) {
			laserSound.open();
			laserSound.start();
			assertTrue(laserSound.isOpen());
			assertTrue(laserSound.isRunning());
			laserSound.stop();
		}
		catch (Exception e) {
			assert false;
		}

	}

}

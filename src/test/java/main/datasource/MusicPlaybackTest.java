package main.datasource;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.Clip;
import javax.swing.plaf.multi.MultiInternalFrameUI;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MusicPlaybackTest {

	private MusicPlayback musicStuff;

	@BeforeEach
	public void setUp() {
		musicStuff = new MusicPlayback();
	}



	@Test
	public void testPlayMusicInvalidFile() {
		String invalidMusicPath = "path/to/nonexistent/file.mp3";
		musicStuff.play(invalidMusicPath, true);

		assertFalse(musicStuff.isMusicPlaying());
		musicStuff.stopMusic();

	}

	@Test
	public void testPlayTurbolaser() {
		String validTurbolaserPath = "images/turbolaser.wav";
		musicStuff.play(validTurbolaserPath, true);

		//wait for music to start playing since there is a delay in this track
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertTrue(musicStuff.isMusicPlaying());
		musicStuff.stopMusic();

	}

	@Test
	public void testPlayMusic() {
		String validMusicPath = "images/level3OST.wav";
		musicStuff.play(validMusicPath, true);

		//wait for music to start playing since there is a delay in this track
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertTrue(musicStuff.isMusicPlaying());
		musicStuff.stopMusic();
	}

	@Test
	public void testPlayTurbolaserInvalidFile() {
		String invalidTurbolaserPath = "path/to/nonexistent/turbolaser/file.wav";
		musicStuff.play(invalidTurbolaserPath, true);
		assertFalse(musicStuff.isMusicPlaying());
		musicStuff.stopMusic();
	}

}

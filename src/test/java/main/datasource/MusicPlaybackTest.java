package main.datasource;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MusicPlaybackTest {

	@Test
	public void testPlayMusicInvalidFile() {
		MusicPlayback musicStuff = new MusicPlayback();
		String invalidMusicPath = "path/to/nonexistent/file.mp3";
		musicStuff.play(invalidMusicPath, true);

		assertFalse(musicStuff.isMusicPlaying());
		musicStuff.stopMusic();

	}

	@Test
	public void testPlayTurbolaser() {
		MusicPlayback musicStuff = new MusicPlayback();
		String validTurbolaserPath = "images/turbolaser.wav";
		musicStuff.play(validTurbolaserPath, true);

		//wait without using Thread.sleep
		long startTime = System.currentTimeMillis();
		while (System.currentTimeMillis() - startTime < 1000) {
		}
		assertTrue(musicStuff.isMusicPlaying());
		musicStuff.stopMusic();

	}

	@Test
	public void testPlayMusic() {
		MusicPlayback musicStuff = new MusicPlayback();
		String validMusicPath = "images/level3OST.wav";
		musicStuff.play(validMusicPath, true);

		//wait without using Thread.sleep
		long startTime = System.currentTimeMillis();
		while (System.currentTimeMillis() - startTime < 1000) {
		}

		assertTrue(musicStuff.isMusicPlaying());
		musicStuff.stopMusic();
	}

	@Test
	public void testPlayTurbolaserInvalidFile() {
		MusicPlayback musicStuff = new MusicPlayback();
		String invalidTurbolaserPath = "path/to/nonexistent/turbolaser/file.wav";
		musicStuff.play(invalidTurbolaserPath, true);
		assertFalse(musicStuff.isMusicPlaying());
		musicStuff.stopMusic();
	}

}

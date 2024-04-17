//package main.datasource;
//
//import org.junit.jupiter.api.Test;
//
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class MusicPlaybackTest {
//
//	@Test
//	public void testPlayMusicInvalidFile() {
//		MusicPlayback musicStuff = new MusicPlayback();
//		String invalidMusicPath = "path/to/nonexistent/file.mp3";
//		musicStuff.play(invalidMusicPath, true);
//
//		assertFalse(musicStuff.isMusicPlaying());
//		musicStuff.stopMusic();
//
//	}
//
//	@Test
//	public void testPlayTurbolaser() {
//		MusicPlayback musicStuff = new MusicPlayback();
//		String validTurbolaserPath = "images/turbolaser.wav";
//		musicStuff.play(validTurbolaserPath, true);
//
//		//wait without using Thread.sleep
//		long startTime = System.currentTimeMillis();
//		while (System.currentTimeMillis() - startTime < 1000) {
//		}
//		assertTrue(musicStuff.isMusicPlaying());
//		musicStuff.stopMusic();
//
//	}
//
//	@Test
//	public void testPlayMusic() {
//		MusicPlayback musicStuff = new MusicPlayback();
//		String validMusicPath = "images/level3OST.wav";
//		musicStuff.play(validMusicPath, true);
//
//		//wait without using Thread.sleep
//		long startTime = System.currentTimeMillis();
//		while (System.currentTimeMillis() - startTime < 1000) {
//		}
//
//		assertTrue(musicStuff.isMusicPlaying());
//		musicStuff.stopMusic();
//	}
//
//	@Test
//	public void testPlayTurbolaserInvalidFile() {
//		MusicPlayback musicStuff = new MusicPlayback();
//		String invalidTurbolaserPath = "path/to/nonexistent/turbolaser/file.wav";
//		musicStuff.play(invalidTurbolaserPath, true);
//		assertFalse(musicStuff.isMusicPlaying());
//		musicStuff.stopMusic();
//	}
//
//}

package main.datasource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MusicPlaybackTest {

	private MusicPlayback musicPlayback;

	@BeforeEach
	void setUp() {
		musicPlayback = new MusicPlayback();
	}

	@Test
	void testPlayStopMusic() {
		String musicLocation = "images/level3OST.wav"; // Path to a test audio file
		File musicFile = new File(musicLocation);
		assertTrue(musicFile.exists(), "Test audio file not found at: " + musicLocation);

		musicPlayback.play(musicLocation, false);

		try {
			// Sleep to allow the music to play for a short duration
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertTrue(musicPlayback.isMusicPlaying(), "Music playback not detected");

		musicPlayback.stopMusic();

		assertFalse(musicPlayback.isMusicPlaying(), "Music still playing after stop");
	}
}


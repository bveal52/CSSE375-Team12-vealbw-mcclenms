package main.datasource;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class MusicPlayback implements Playback {

	private Clip clip;

	@Override
	public void play(String musicLocation, boolean loop) {
		try
		{
			File musicPath = new File(musicLocation);
			if(musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();

				if(loop) {
					clip.loop(Clip.LOOP_CONTINUOUSLY);
				}
			}
			else {
				System.out.println("Cannot find the file");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	protected void stopMusic() {

		if (clip == null) {
			return;
		}
		clip.stop();
	}

	protected boolean isMusicPlaying() {

		if (clip == null) {
			return false;
		}

		System.out.println(clip);

		return clip.isRunning();
	}

}

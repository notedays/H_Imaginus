package narutoRPG;

import java.io.File;
import java.io.FileInputStream;

import javax.sound.sampled.AudioSystem;

import javazoom.jl.player.advanced.AdvancedPlayer;

public class SoundPlayer {

	public static void playClip(File file) {
		try {
			AudioSystem.getClip().open(AudioSystem.getAudioInputStream(file));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static AdvancedPlayer player;

	public static void playBGM(File file) {
		do {
			try {
				player = new AdvancedPlayer(new FileInputStream(file));
				player.play();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (true);
	}
}

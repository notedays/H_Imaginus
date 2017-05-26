package narutoRPG;

import java.io.File;
import java.io.FileInputStream;

import javax.sound.sampled.AudioSystem;

import javazoom.jl.player.Player;


public class SoundPlayer {
	
	public static void playClip(File file){
		try {
			AudioSystem.getClip().open(AudioSystem.getAudioInputStream(file));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void playBGM(File file){
		try {
			Player player = new Player(new FileInputStream(file));
			player.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

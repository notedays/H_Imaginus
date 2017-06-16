package musaRPG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.sound.sampled.AudioSystem;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class SoundPlayer{
	// # 싱글 톤
	private static SoundPlayer player = new SoundPlayer();
	private Thread playThread;
	
	public static SoundPlayer getInstance(){
		return player;
	}
	
	// # 클립 재생
	public static void playClip(File file) {
		try {
			AudioSystem.getClip().open(AudioSystem.getAudioInputStream(file));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// # BGM 재생
	private AdvancedPlayer bgmPlayer;
	private String fileName;
	
	public SoundPlayer() {
		playThread = new Thread(){
			@Override
			public void run() {
				while(true){
					playBgmOnce(fileName);
				}
			}
		};
	}
	public void playBgm(String fileName){
		this.fileName = fileName;
		playThread.start();
	}
	
	public void playBgmOnce(String fileName) {
		
		File bgmFile = new File("resources/"+fileName);
		try {
			bgmPlayer = new AdvancedPlayer(new FileInputStream(bgmFile));
			bgmPlayer.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void stopBgm(){
		if(playThread.isAlive()) playThread.interrupt();
	}
}

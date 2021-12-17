package io;

import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 * A class for playing sounds.
 * @author Codi Chun
 * @version Fall 2021
 */
public class PlaySound {
	
	/**
	 * The sound file.
	 */
	private File mySoundFile;
	
	/**
	 * The clip.
	 */
	private Clip myClip;
	
	/**
	 * The constructor.
	 * @param theSoundFile
	 */
	public PlaySound(File theSoundFile) {
		mySoundFile = theSoundFile;
		play(mySoundFile);
		
	}
	
	/**
	 * Playing the sound.
	 * @param theSoundFile
	 */
	public void play(File theSoundFile) {
		try {
		    File soundFile = theSoundFile;
		    AudioInputStream stream;
		    AudioFormat format;
		    DataLine.Info info;

		    stream = AudioSystem.getAudioInputStream(soundFile);
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format);
		    myClip = (Clip) AudioSystem.getLine(info);
		    myClip.open(stream);
		    myClip.start();

		}
		catch (Exception e) {

		}
	}
	
	/**
	 * Srart playing.
	 */
	public void start() {
	    myClip.start();
	}
	
	/**
	 * Looping the sound continuously.
	 */
	public void loop() {
		myClip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	/**
	 * Stopping playing the sound.
	 */
	public void stop() {
		myClip.stop();
	}
	
	/**
	 * Check if the music is playing.
	 */
	public boolean isPlaying() {
		return myClip.isRunning();
	}

}

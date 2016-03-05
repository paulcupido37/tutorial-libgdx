package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.audio.AudioDevice;
import com.badlogic.gdx.audio.AudioRecorder;

public class RecorderDemo extends ApplicationAdapter
{
	AudioRecorder recorder;
	AudioDevice device;
	
	
	public void create()
	{
		recorder = Gdx.audio.newAudioRecorder(44100, true);
		short[] audioBuffer = new short[44100 * 15];
		
		recorder.read(audioBuffer, 0, audioBuffer.length);
		device = Gdx.audio.newAudioDevice(44100, true);
		device.writeSamples(audioBuffer, 0, audioBuffer.length);
		
		Gdx.app.exit();
		
		// I wonder whether I could save the audio that is recorded here into a file and use that for commentaries or something
	}
	
	public void render()
	{
		
	}
	
	public void dispose()
	{
		recorder.dispose();
		device.dispose();
	}
	
}

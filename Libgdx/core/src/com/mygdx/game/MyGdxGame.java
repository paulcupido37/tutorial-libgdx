package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.badlogic.gdx.audio.Sound;

public class MyGdxGame extends ApplicationAdapter
{
	private SpriteBatch batch;
	private Sound sound;
	
	public void create() 
	{
		batch = new SpriteBatch();
		
		// Creates the sound file
		this.sound = Gdx.audio.newSound(Gdx.files.internal("glass-break-mono.wav"));
		
		// Gets the id of the sound instance being played
		final long id = this.sound.loop();
		
		// changing the sound's volume
		this.sound.setVolume(id, 0.5f);
		
		// changing the sound's pitch
		this.sound.setPitch(id, 0.5f);
		
		// can only set panning for sounds that are set as mono
		this.sound.setPan(id, 1f, 1f);
		
		// id = this.sound.play(0.5f, 0.5f, 1f); // the same as the above 3 calls
		// can use the loop call instead of play with the same parameters
		sound.loop(1.0f, 2.0f, -1.0f);
		
		// Timer to stop the sounds from playing after a 10 second delay
		Timer.schedule(new Task() {
			public void run() {
				
				// pauses all sounds when no ID is passed through
				sound.stop();
				
				// cancel the timer
				this.cancel();
			}
		}, 10f);
		
		
	}

	public void render() 
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.end();
	}

	public void dispose() 
	{
		batch.dispose();
		sound.dispose();
	}
	
}

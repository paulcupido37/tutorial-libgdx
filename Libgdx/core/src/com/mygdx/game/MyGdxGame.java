package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;


public class MyGdxGame implements ApplicationListener
{
	private SpriteBatch batch;
	private BitmapFont font;

	private Music music;
	private long musicId;
	
	public void create() 
	{
		// instantiates the sprite batch
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.RED);
		
		// Music class is used to stream larger sounds such as tracks
		music = Gdx.audio.newMusic(Gdx.files.internal("easy.mp3"));
		music.play();
		
		// set the sound to loop when it finishes
		music.setLooping(true);
		
		// pan only works if the audio has been recorded in mono
		// music.setPan(1.0f, 1.0f);
		// Decreases the volume every 0.5 seconds and stops the song once the volume is less than 10%
		Timer.schedule(new Task() {
			public void run() {
				
				if (music.getVolume() <= 0.10f) {
					// stops the music
					music.stop();
					
					// cancels the task once the music dips below 10% volume
					this.cancel();
				} else {
					music.setVolume(music.getVolume() - 0.1f);
				}
			}
		}, 0.0f, 1f);
	}

	@Override
	public void resize(int width, int height) 
	{
	}

	public void render() 
	{
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		font.draw(batch, "Hello World", 
				Gdx.graphics.getWidth()/2 - font.getLineHeight()/2, 
				Gdx.graphics.getHeight()/2 - font.getLineHeight()/2);
		batch.end();
	}

	@Override
	public void pause() 
	{		
	}

	@Override
	public void resume() 
	{		
	}

	public void dispose() 
	{
		font.dispose();
		batch.dispose();
		music.dispose();
	}
	
}

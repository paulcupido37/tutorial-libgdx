package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter
{
	private SpriteBatch batch;
	private BitmapFont font;
	
	private Sprite sprite;
	private TextureAtlas textureAtlas;
	private TextureRegion textureRegion;
	
	private int currentFrame = 1;
	public static final int MAX_FRAMES = 19;
	
	public void create() 
	{
		// Instantiates the sprite batch
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.RED);
		
		// instantiate the texture atlas and region
		textureAtlas = new TextureAtlas(Gdx.files.internal("spritesheets/spritesheet.atlas"));
		textureRegion = new TextureRegion(textureAtlas.findRegion(String.format("%04d", 1)));
		
		// Instantiates the sprite from the TextureRegion
		sprite = new Sprite(textureRegion);
		
		// Sets the position of the sprite on the screen - sprite will be drawn in the center
		sprite.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2, 
				Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
		
		// Uses a timer to change the sprite to a different position in the texture atlas 30 times per second
		Timer.schedule(new Task(){
			public void run()
			{
				currentFrame++;
				if (currentFrame > MAX_FRAMES) {
					currentFrame = 1;
				}
				sprite.setRegion(textureAtlas.findRegion(String.format("%04d", currentFrame)));
			}
		}, 0, 1/30.0f);
	}

	/** Renders the scene*/
	public void render() 
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		sprite.draw(batch);
		batch.end();
	
	}

	public void dispose() 
	{
		font.dispose();
		batch.dispose();
		
	}
	
}
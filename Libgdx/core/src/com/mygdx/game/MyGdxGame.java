package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class MyGdxGame extends ApplicationAdapter implements InputProcessor
{
	// public variables
	public static final int MAX_FRAMES = 19;
	
	// private variables
	private Sprite sprite;
	private SpriteBatch batch;
	private TextureAtlas atlas;
	private TextureRegion region;
	
	private int currentFrame =1;
	
	public void create() 
	{
		// instantiates the sprite batch
		batch = new SpriteBatch();
		
		// instantiates the texture
		atlas = new TextureAtlas(Gdx.files.internal("SpriteSheets/spritesheet.atlas"));
		
		// instantiate the regions by manually finding one from the atlas
		region = atlas.findRegion("0001");
		
		// instantiates the sprite from the region
		sprite = new Sprite(region);
		
		// sets the position of the sprite on the screen - sprite will be drawn in the center
		sprite.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2, 
				Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
		
		// registers the the input processor as the one implemented by this class
		Gdx.input.setInputProcessor(this);
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
		atlas.dispose();
		batch.dispose();
	}

	/** Activates when the key is pressed*/
	public boolean keyDown(int keycode) 
	{
		// Cycles through the sprite sheet each time a key is pressed up or down and updates the sprite
		// with that information
		
		if (keycode == Input.Keys.UP) {
			currentFrame++;
			if (currentFrame > MAX_FRAMES) {
				currentFrame = 1;
			}
		}
		if (keycode == Input.Keys.DOWN) {
			currentFrame--;
			if (currentFrame < 1) {
				currentFrame = MAX_FRAMES;
			}
		}
		
		sprite.setRegion(atlas.findRegion(String.format("%04d", currentFrame)));
		
		return false;
	}

	/** Activates when the key is released*/
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
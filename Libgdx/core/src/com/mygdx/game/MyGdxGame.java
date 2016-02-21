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
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;;


public class MyGdxGame extends ApplicationAdapter implements InputProcessor
{
	// public variables
	public static final int MAX_FRAMES = 19;
	
	// private variables
	private Sprite sprite;
	private SpriteBatch batch;
	private TextureAtlas atlas;
	private TextureRegion region;
	
	private int currentFrame = 1;
	
	public void create() 
	{
		// instantiates the sprite batch
		batch = new SpriteBatch();
		
		// instantiates the texture
		atlas = new TextureAtlas(Gdx.files.internal("spritesheets/spritesheet.atlas"));
		
		// instantiate the regions by manually finding one from the atlas
		region = atlas.findRegion("0001");
		
		// instantiates the sprite from the region
		sprite = new Sprite(region);
		
		// sets the position of the sprite on the screen - sprite will be drawn in the center
		sprite.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2, 
				Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
		
		Timer.schedule(new Task(){
			public void run() 
			{
				currentFrame++;
				if (currentFrame > MAX_FRAMES) {
					currentFrame = 1;
				}
				sprite.setRegion(atlas.findRegion(String.format("%04d", currentFrame)));
				
			}
		}, 0, 1/30.0f);
		
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

	public boolean keyDown(int keycode) 
	{
		// Moves the sprite to the left or right based on player input - uses the edges the of the screen as a barrier
		if (keycode == Input.Keys.LEFT) 
		{
			if (!((sprite.getX() - 5) <= 0))
			{
				sprite.setPosition(sprite.getX() - 5, sprite.getY());
			}
		}
		if (keycode == Input.Keys.RIGHT) 
		{
			if (!((sprite.getX() + 5) >= Gdx.graphics.getWidth())) 
			{
				sprite.setPosition(sprite.getX() + 5, sprite.getY());
			}			
		}
		
		sprite.setRegion(atlas.findRegion(String.format("%04d", currentFrame)));
		
		return false;
	}

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
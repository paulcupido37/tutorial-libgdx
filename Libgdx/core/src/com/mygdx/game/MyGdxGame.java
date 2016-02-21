package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;


public class MyGdxGame extends ApplicationAdapter implements InputProcessor
{
	private TextureAtlas textureAtlas;
	private TextureRegion textureRegion;
	
	private SpriteBatch batch;
	private Sprite sprite;
	
	private Sprite[] allSprites;
	
	private int selectButton =0;

	/** 
	 * The create method sees to it that all instance variables are initialized
	 * */
	public void create() 
	{
		
		String[] text = {"campaign-button", 
						 "challenge-button", 
						 "shop-button", 
						 "quit-button", 
						 "legends-banner", 
						 "legends-heroes"};
		
		// instantiates the sprite batch
		batch = new SpriteBatch();
		
		// instantiates the texture atlas and region
		textureAtlas = new TextureAtlas(Gdx.files.internal("spritesheets/mainmenu-spritesheet.atlas"));
		textureRegion = textureAtlas.findRegion("legends-banner");
		allSprites = new Sprite[6];
		
		// Initialize the sprites with specific texture regions provided by the text
		for (int i = 0; i < allSprites.length && i < text.length; i ++ )
		{
			allSprites[i] = new Sprite(textureAtlas.findRegion(text[i]));
			allSprites[i].setRegion(textureAtlas.findRegion(text[i]));
		}
		
		// Positional data - must find a better way to deal with this
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();
		
		allSprites[0].setPosition(allSprites[2].getWidth()/2, height/2 - (height/12));
		
		allSprites[1].setPosition(allSprites[2].getWidth()/2,
				height/2 - 1.5f * allSprites[2].getHeight() - (height/12));
		
		allSprites[2].setPosition(allSprites[2].getWidth()/2,
				height/2 - 3 * allSprites[2].getHeight() - (height/12));
		
		allSprites[3].setPosition(width - ((1.5f) * allSprites[3].getWidth()),
				height/2 - 3 * allSprites[2].getHeight() - (height/12));
		
		allSprites[4].setPosition(width/2 - allSprites[4].getWidth()/2,
				height - allSprites[4].getHeight());
		
		allSprites[5].setPosition(width - (1.125f * allSprites[5].getWidth()),
				(0.75f) * allSprites[5].getHeight());
		
		//Set the input
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void resize(int width, int height) 
	{
		// TODO Auto-generated method stub
		
	}

	/** Renders the scene*/
	public void render() 
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		// draws the sprite - here I'm rotating the sprite
		allSprites[0].draw(batch);
		allSprites[1].draw(batch);
		allSprites[2].draw(batch);
		allSprites[3].draw(batch);
		allSprites[4].draw(batch);
		allSprites[5].draw(batch);
		batch.end();
	
	}

	public void dispose() 
	{
		// free up the resources held by font and batch
		batch.dispose();
		
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		if (keycode == Input.Keys.UP) {
			// set selected sprite
		}
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
		// want to set a button as selected when the mouse moves over it
	
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
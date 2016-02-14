package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MyGdxGame implements ApplicationListener
{
	private SpriteBatch batch;
	private BitmapFont font;
	private Texture img;
	private Sprite sprite;

	/** 
	 * The create method sees to it that all instance variables are initialized
	 * */
	public void create() 
	{
		// instantiates the sprite batch
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.RED);
		
		// instantiates the texture
		img = new Texture("hello-world.png");
		
		// instantiates the sprite
		sprite = new Sprite(img);
		
		// sets the position of the sprite on the screen - sprite will be drawn in the center
		sprite.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2, 
				Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
		
		// rotates the sprite 90 degrees (pi/2 radians) about the origin (which is set to 0,0 by default)
		sprite.setRotation(90f);
		
		// scales the sprite
		sprite.setScale(2.0f, 1.0f);
	}

	@Override
	public void resize(int width, int height) 
	{
		// TODO Auto-generated method stub
		
	}

	/** Renders the scene*/
	public void render() 
	{
		// open up open gl inside here and draw all objects which are to be drawn
		// no calculations related to game artifacts should be done here - and not while open gl is drawing
			
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		// draw textures/ artifacts here
		
		// Challenge 1: Print out the diary of prophecy
		// Challenge 2: Create the Star Wars crawl
		
		font.draw(batch, "Hello World", 400, 400);
		
		// draws the sprite - here I'm rotating the sprite
		batch.draw(sprite, sprite.getX(), sprite.getY(), 
				sprite.getWidth()/2, 
				sprite.getHeight()/2, 
				sprite.getWidth(),
				sprite.getHeight(),
				sprite.getScaleX(), 
				sprite.getScaleY(), 
				sprite.getRotation());
		batch.end();
	
	}

	@Override
	public void pause() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() 
	{
		// TODO Auto-generated method stub
		
	}

	/** Destroys unnecessary / no longer used objects - functionally similar to a destructor method, I imagine?*/
	public void dispose() 
	{
		// free up the resources held by font and batch
		font.dispose();
		batch.dispose();
		
	}
	
}
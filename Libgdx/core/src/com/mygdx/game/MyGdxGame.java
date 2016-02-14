package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MyGdxGame implements ApplicationListener
{
	private SpriteBatch batch;
	private BitmapFont font;

	/** 
	 * The create method sees to it that all instance variables are initialized
	 * */
	public void create() 
	{
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.RED);
		
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
			
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		// draw textures/ artifacts here
		// need to find out how to get the screen size - I want to centre this text and then have it print out the diary of prophecy
		// Come my people and shut thy doors about thee, for a great power has come to punish the weak for their inequity and it shall be the end of the world as you know it.
		font.draw(batch, "Hello World", 400, 400);
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
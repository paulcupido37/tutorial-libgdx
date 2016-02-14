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

	public void create() 
	{
		// instantiates the sprite batch
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.RED);
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
	}
	
}

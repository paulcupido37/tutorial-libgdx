package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class MyGdxGame extends ApplicationAdapter
{

	private Sprite sprite;
	private Texture texture;
	private SpriteBatch batch;
	
	public void create() 
	{
		
		batch = new SpriteBatch();
	}

	public void render() 
	{
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.end();
	}

	public void dispose() 
	{
		batch.dispose();
		texture.dispose();
	}
	
}

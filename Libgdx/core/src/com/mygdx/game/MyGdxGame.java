package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MyGdxGame implements ApplicationListener
{
	
	private Sprite sprite;
	private Texture texture;
	private SpriteBatch batch;

	public void create() 
	{
		// instantiates the sprite batch, texture and the sprite
		batch   = new SpriteBatch();
		
		// the texture represents the underlying GL texture
		texture = new Texture(Gdx.files.internal("jet.png"));

		// stores the positional and colour data of the texture
		sprite  = new Sprite(texture);
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
		sprite.draw(batch);
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
		// The sprite is not disposed because it does not implement the disposable interface
		// Everything that can be disposed must be disposed
		
		batch.dispose();
		texture.dispose();
		
	}
	
}

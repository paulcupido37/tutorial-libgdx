package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class MyGdxGame implements ApplicationListener
{
	private SpriteBatch batch;
	private Animation animation;
	private TextureAtlas textureAtlas;

	private float elapsedTime = 0;
	
	public void create() 
	{
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas(Gdx.files.internal("spritesheet.atlas"));
		animation = new Animation(1/30f, textureAtlas.getRegions());
	}

	@Override
	public void resize(int width, int height) 
	{
	}

	public void render() 
	{
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		elapsedTime += Gdx.graphics.getDeltaTime();
		
		batch.begin();
		batch.draw(animation.getKeyFrame(elapsedTime, true), 0, 0);
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
		batch.dispose();
		textureAtlas.dispose();
	}
	
}

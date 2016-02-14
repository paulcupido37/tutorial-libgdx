package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame implements ApplicationListener
{
	private String myText = null;
	private SpriteBatch batch;
	private BitmapFont font;
	private BitmapFont.TextBounds bounds;
	
	public void create() 
	{
		// Instantiates the sprite batch and the font
		batch = new SpriteBatch();
		// Using a bitmap font here - true type font scales better but is slower
		// bitmap = image, true type = algorithm
		font = new BitmapFont();
		
		// font = new BitmapFont(Gdx.files.internal("")); <- How to load the text from a file
		font.setColor(Color.WHITE);
		
		// Set the text content
		myText = "Come my people and shut thy doors about thee.\n" +
		"For a great power will return to punish the weak for their inequity.\n" + 
		"And it shall be the end of the world as you know it.";
		
		// Gets the bounds of the text (multi-line text in this case) 
		bounds = font.getMultiLineBounds(myText);
	}

	@Override
	public void resize(int width, int height) 
	{
	}

	public void render() 
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		// Draws the multi-line text and centres (justifies) it as well
		font.drawMultiLine(batch, myText, 0, 
				Gdx.graphics.getHeight()/2 + bounds.height/2,
				Gdx.graphics.getWidth(),
				BitmapFont.HAlignment.CENTER);
		
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

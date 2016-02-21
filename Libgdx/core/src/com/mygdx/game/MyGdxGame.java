package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;


public class MyGdxGame extends ApplicationAdapter
{
	private TextureAtlas textureAtlas;
	private TextureRegion textureRegion;
	
	private SpriteBatch batch;
	private Sprite sprite;

	/** 
	 * The create method sees to it that all instance variables are initialized
	 * */
	public void create() 
	{
		// instantiates the sprite batch
		batch = new SpriteBatch();
		
		// instantiates the texture atlas and region
		textureAtlas = new TextureAtlas(Gdx.files.internal("spritesheets/mainmenu-spritesheet.atlas"));
		textureRegion = textureAtlas.findRegion("legends-banner");
		
		/* It may be better to use an array of texture regions.
		 * The other option is to use the textureAtlas.findRegion() method to select the texture to be displayed.
		 * This would then require an array of sprites, though I think those are necessary anyway. */
		
		Array<AtlasRegion> regions = textureAtlas.getRegions();
		
		// need to check if this the best way to do the sprite switching
		sprite = new Sprite(new Texture(Gdx.files.internal("spritesheets/mainmenu-spritesheet.png")));
		//sprite = textureRegion.;//setRegion(textureAtlas.findRegion("legends-banner").getTexture());
		
		// sets the position of the sprite on the screen - sprite will be drawn in the center
		sprite.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2, 
				Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
		
		
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
		
		// draws the sprite - here I'm rotating the sprite
		sprite.draw(batch);
		batch.end();
	
	}

	public void dispose() 
	{
		// free up the resources held by font and batch
		batch.dispose();
		
	}
	
}
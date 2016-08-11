package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/** Class to model a basic orthographic camera and its movement around the screen
 * 
 * @author Paul Cupido
 * @date 26 February 2016
 * */

public class MyGdxGame extends ApplicationAdapter
{
	private float cameraPositionX;
	
	

	AtlasRegion rock1;

	// Sprite and SpriteBatch
	private ArrayList<Sprite> allSprites;
	private Sprite grass;
	private Sprite[][] rock2;
	private SpriteBatch batch;
	
	// Texture and Orthographic Camera
	private Texture texture;
	private OrthographicCamera camera;
	
	public final int SCREEN_WIDTH = 1280;
	public final int SCREEN_HEIGHT = 720;
	
	private TextureAtlas atlas   = null;
	private TextureRegion region = null;
	
	
	// Boolean to determine whether or not the camera is active 
	private CameraInput cameraInput;
	
	/**
	 * Initializes the camera, texture and sprite
	 * 
	 * @todo Add a viewport to stop the camera from going passed the bounds of the image
	 * @todo Create a separate class for input processing - extend Input Adapter
	 * */
	public void create() 
	{

		allSprites = new ArrayList<Sprite>();
		
		// Initialize the Orthographic Camera at 1280 x 720p
		camera = new OrthographicCamera(SCREEN_WIDTH, SCREEN_HEIGHT);
		
		cameraInput = new CameraInput();
		
		// instantiates the sprite batch
		batch = new SpriteBatch();	
		atlas = new TextureAtlas(Gdx.files.internal("survival_game.txt"));
				
		//loads the texture
		region = atlas.findRegion("grass_tile");
		rock1 = atlas.findRegion("soft_rock");
		int regionWidth = region.getRegionWidth();
		int regionHeight = region.getRegionHeight();
		
		int textureWidth = SCREEN_WIDTH / regionWidth;
		int textureHeight = SCREEN_HEIGHT / regionHeight;
		//texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	
		Sprite sprite = new Sprite();
		
		for (int x=0; x < textureWidth; x++) {
				
			for (int y =0; y < textureHeight; y++) {
				sprite = new Sprite(region);
				sprite.setOrigin(0,0);
				sprite.setPosition(x * regionWidth, y * regionHeight);
				allSprites.add(sprite);
				
				if (x == 0 || y == 0 || x == (textureWidth -1) || y == (textureHeight -1)) {
					sprite = new Sprite(rock1);
					sprite.setPosition(x * regionWidth, y * regionHeight);
					allSprites.add(sprite);
				}
				
			}
			
			
		}
		
		
		
		Gdx.input.setInputProcessor(cameraInput);
	}
	
	@Override
	public void render() 
	{
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
		// Translates the camera and updates it depending on whether cameraMovement is true
		if (cameraInput.isCameraMoving()) {
			
			// Need to set bounds for the camera - can be done with an IF statement or by including the camera in CameraInput
			camera.translate(cameraInput.getX(), cameraInput.getY());
			camera.update();
		}
		
		// Ties the LibGDX camera to the OpenGL renderer
		batch.setProjectionMatrix(camera.combined);
		
		// Draw the sprite
		batch.begin();
		for (int index = 0; index < allSprites.size(); index++) {
			allSprites.get(index).draw(batch);
		}
			
		batch.end();
	}

	@Override
	public void dispose() 
	{
		batch.dispose();
		atlas.dispose();
	}
}

package com.mygdx.game;

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

/** Class to model a basic orthographic camera and its movement around the screen
 * 
 * @author Paul Cupido
 * @date 26 February 2016
 * */

public class MyGdxGame extends ApplicationAdapter
{
	private float cameraPositionX;
	
	// Sprite and SpriteBatch
	private Sprite sprite;
	private SpriteBatch batch;
	
	// Texture and Orthographic Camera
	private Texture texture;
	private OrthographicCamera camera;
	
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
		// Initialize the Orthographic Camera at 1280 x 720p
		camera = new OrthographicCamera(1280, 720);
		
		cameraInput = new CameraInput();
		
		// instantiates the sprite batch
		batch = new SpriteBatch();
		
		//loads the texture
		texture = new Texture(Gdx.files.internal("Toronto Skyline.jpg"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		sprite = new Sprite(texture);
		sprite.setOrigin(0, 0);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		
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
		sprite.draw(batch);	
		batch.end();
	}

	@Override
	public void dispose() 
	{
		batch.dispose();
		texture.dispose();
	}
}

package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
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

public class MyGdxGame extends ApplicationAdapter implements InputProcessor
{
	// Sprite and SpriteBatch
	private Sprite sprite;
	private SpriteBatch batch;
	
	// Texture and Orthographic Camera
	private Texture texture;
	private OrthographicCamera camera;
	
	// Translation coordinates 
	private float translateX = 0f;
	private float translateY = 0f;
	
	// Counter for the number of inputs
	private int numberOfInputs = 0;
	
	// Boolean to determine whether or not the camera is active 
	private boolean cameraMovement = false;
	
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
		
		// instantiates the sprite batch
		batch = new SpriteBatch();
		
		//loads the texture
		texture = new Texture(Gdx.files.internal("Toronto Skyline.jpg"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		sprite = new Sprite(texture);
		sprite.setOrigin(0, 0);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		
		Gdx.input.setInputProcessor(this);
	}
	
	@Override
	public void render() 
	{
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Translates the camera and updates it depending on whether cameraMovement is true
		if (cameraMovement) {
			camera.translate(translateX, translateY);
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

	/** 
	 * Starts moving the camera in a specific direction, depending on which of the directional keys has been pressed
	 * */
	public boolean keyDown(int keycode) 
	{
		// Increment a counter to keeps track of the number of keys that have been pressed
		numberOfInputs++;
		
		// Sets the direction of translation based on the key that has been pressed
		switch (keycode) {
		
			case(Input.Keys.RIGHT): 
				
				translateX = 1.0f;
				cameraMovement = true;
				break;
				
			case(Input.Keys.UP): 
				translateY = 1.0f;
				cameraMovement = true;
				break;
				
			case(Input.Keys.DOWN): 
				translateY = -1.0f;
				cameraMovement = true;
				break;
				
			case(Input.Keys.LEFT): 
				translateX = -1.0f;
				cameraMovement = true;
				break;
	}
		
		return false;
	}

	/**
	 * Stops the camera from moving when the user releases a relevant key
	 * */
	public boolean keyUp(int keycode) 
	{
		// Decrement the counter that keeps track of the number of keys that have been pressed
		numberOfInputs--;
		
		// Sets the camera translation on a specific axis to 0 if the relevant key is released
		switch (keycode) {
			
			case(Input.Keys.RIGHT): 
				translateX = 0f;
				break;
				
			case(Input.Keys.UP): 
				translateY = 0f;
				break;
				
			case(Input.Keys.DOWN): 
				translateY = 0f;
				break;
				
			case(Input.Keys.LEFT): 
				translateX = 0f;
				break;
		}
		
		// If there no keys are being pressed, then the camera stops moving
		if (numberOfInputs == 0) {
			cameraMovement = false;
		}
		
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
}

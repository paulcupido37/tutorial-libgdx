package com.mygdx.game;

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

public class MyGdxGame implements ApplicationListener, InputProcessor
{
	private OrthographicCamera camera;
	
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	
	private boolean cameraMovement = false;
	
	private int numberOfInputs = 0; 
	private float translateX = 0f;
	private float translateY = 0f;
	
	/**
	 * @todo Add a viewport to stop the camera from going passed the bounds of the image
	 * @todo Create a separate class for input processing - extend Input Adapter
	 * @todo Comment this file properly
	 * */
	public void create() 
	{
		// With a 2d game - Orthogonal camera
		camera = new OrthographicCamera(1280, 720);
		
		// instantiates the sprite batch
		batch = new SpriteBatch();
		
		//load the texture
		texture = new Texture(Gdx.files.internal("Toronto Skyline.jpg"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		sprite = new Sprite(texture);
		sprite.setOrigin(0, 0);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void resize(int width, int height) 
	{
	}

	public void render() 
	{
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if (cameraMovement) {
			camera.translate(translateX, translateY);
			camera.update();
		}
		
		batch.setProjectionMatrix(camera.combined);
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
		batch.dispose();
		texture.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		
		// inputs - counter to keep track of the number of keys that have been pressed
		numberOfInputs++;
		
		// sets the direction of translation based on the key that has been pressed
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

	@Override
	public boolean keyUp(int keycode) {
		// Stop moving the camera when the user releases the keys
		
		// decrement counter
		numberOfInputs--;
		
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
		
		// if there no keys are being pressed, then the camera stops moving
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

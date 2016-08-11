package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class CameraInput extends InputAdapter
{
	
	
	// Counter for the number of inputs
	private int numberOfInputs = 0;
	
	// Speed that the camera moves at
	private float cameraSpeed = 2.5f;
	
	// Translation coordinates 
	private float translateX = 0f;
	private float translateY = 0f;
	
	private boolean cameraMovement = false;
	
	@Override
	public boolean keyDown(int keycode)
	{
		// Increment a counter to keeps track of the number of keys that have been pressed
		numberOfInputs++;
		
		// Sets the direction of translation based on the key that has been pressed
		switch (keycode) {
		
			case(Input.Keys.RIGHT): 
				
				translateX = this.cameraSpeed;
				cameraMovement = true;
				break;
				
			case(Input.Keys.UP): 
				translateY = this.cameraSpeed;
				cameraMovement = true;
				break;
				
			case(Input.Keys.DOWN): 
				translateY = -1 * this.cameraSpeed;
				cameraMovement = true;
				break;
				
			case(Input.Keys.LEFT): 
				translateX = -1 * this.cameraSpeed;
				cameraMovement = true;
				break;
		}
		
		return false;
	}
	
	@Override
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

	/** 
	 * Returns the value of the translation on the X-axis
	 * @return transalteX	returns the translation the direction of the X coordinate*/
	public float getX()
	{
		return this.translateX;
	}
	
	/**
	 * Returns the value of the translation on the Y-axis
	 * @return transalteY	returns the translation the direction of the Y coordinate*/
	public float getY()
	{
		return this.translateY;
	}
	
	/** Returns whether the camera is moving or not
	 * 
	 * @return cameraMovement 	returns TRUE when the user inputs a command*/
	public boolean isCameraMoving()
	{
		return cameraMovement;
	}
}
package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.game.Components.PlayerController;
import com.rectgdx.*;

public class SpaceGameMain extends ApplicationAdapter {
	public RectSprite player;
	public OrthographicCamera camera;

	@Override
	public void create () {

		/*
		Adds a key to keybinds.
		The first parameter is what you will refer to the key as.
		The second parameter is the keycode.
		To check if W is being held down, use KeyBinder.getKeyDown("up");
		 */
		KeyBinder.keyBinds.put("accelerate", Input.Keys.W);
		KeyBinder.keyBinds.put("decelerate", Input.Keys.S);
		KeyBinder.keyBinds.put("left", Input.Keys.A);
		KeyBinder.keyBinds.put("right", Input.Keys.D);
		KeyBinder.keyBinds.put("fire", Input.Buttons.LEFT);
		KeyBinder.keyBinds.put("fire2", Input.Buttons.RIGHT);

		/*
		Adds textures (found under assets.)
		Asteroid.png needs to be added (use same format.)
		 */
		TextureManager.add(new SerializableTexture(Gdx.files.internal("spaceShip.png")),"spaceShip");
		TextureManager.add(new SerializableTexture(Gdx.files.internal("ph.png")),"placeHolder");

		/*
		How large an object will be (default is set to 100)
		 */
		SpriteManager.baseObjectSize = 100;

		/*
		Creates camera
		 */
		camera = new OrthographicCamera();
		camera.zoom = 1f;
		camera.setToOrtho(false, 800, 480);

		//player
		player = SpriteManager.requestRectSprite(); //Creates sprite for player
		player.create(TextureManager.getTexture("spaceShip"), 100, -1,10,RectSprite.noArgs); //Basically a constructor
		PlayerController playerController = (PlayerController) SpriteManager.requestComponent(PlayerController.class); //Creates component player controller
		player.addComponent(playerController); //Adds component to play
		SpriteManager.addSpriteToMap("player",player); //Adds player to map for easy access (not required for creating a sprite)
		player.initial(); //Initializes all components and sprite

		SetupManager.setup(camera);
		RenderManager.setBackgroundColor(0,0,1,1);
		RenderManager.setGlobalLighting(1f);
		RenderManager.debugTexture = TextureManager.getTexture("placeHolder");
	}

	@Override
	public void render () {
		SetupManager.update();
	}

	@Override
	public void dispose () {
		SetupManager.dispose();
	}
}

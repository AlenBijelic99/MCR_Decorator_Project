package com.decorator.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.decorator.game.screens.GameScreen;

public class DecoratorGame extends Game {
	public static DecoratorGame INSTANCE;
	private int width;
	private int height;
	private OrthographicCamera camera;

	public DecoratorGame() {
		INSTANCE = this;
	}
	
	@Override
	public void create () {
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, width, height);
		setScreen(new GameScreen(camera));
	}
}

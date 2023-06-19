package com.decorator.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.decorator.game.screens.GameScreen;

/**
 * Represents the game.
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */
public class DecoratorGame extends Game {
    public static DecoratorGame INSTANCE;

    public DecoratorGame() {
        INSTANCE = this;
    }

    @Override
    public void create() {
        int width = Gdx.graphics.getWidth();
        int height = Gdx.graphics.getHeight();
        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);
        setScreen(new GameScreen(camera));
    }
}

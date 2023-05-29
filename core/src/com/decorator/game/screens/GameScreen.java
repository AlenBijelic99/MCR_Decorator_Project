package com.decorator.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.decorator.game.utils.TileMapHelper;

import static com.decorator.game.utils.Constants.PPM;

public class GameScreen extends ScreenAdapter {
  private final OrthographicCamera camera;
  private final SpriteBatch batch;
  private final World world;
  private final Box2DDebugRenderer box2DDebugRenderer;
  private final OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;

  public GameScreen(OrthographicCamera camera) {
    this.camera = camera;
    batch = new SpriteBatch();
    world = new World(new Vector2(0, 0), false);
    box2DDebugRenderer = new Box2DDebugRenderer();
    orthogonalTiledMapRenderer = new TileMapHelper().setupMap();
  }

  @Override
  public void render(float delta) {
    //super.render(delta);
    this.update();
    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    orthogonalTiledMapRenderer.render();

    batch.begin();

    batch.end();
    box2DDebugRenderer.render(world, camera.combined.scl(PPM));
  }

  private void update() {
    world.step(1/60f, 6, 2);
    updateCamera();
    batch.setProjectionMatrix(camera.combined);
    orthogonalTiledMapRenderer.setView(camera);
    if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
      Gdx.app.exit();
    }
  }

  private void updateCamera() {
    camera.position.set(new Vector3(0, 0, 0));
    camera.update();
  }
}

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
import com.decorator.game.objects.player.Player;
import com.decorator.game.utils.Constants;
import com.decorator.game.utils.TileMapHelper;

import static com.decorator.game.utils.Constants.PPM;

public class GameScreen extends ScreenAdapter {
  private final OrthographicCamera camera;
  private final SpriteBatch batch;
  private final World world;
  private final Box2DDebugRenderer box2DDebugRenderer;
  private final TileMapHelper tileMapHelper;
  private final OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;

  private Player player;

  public GameScreen(OrthographicCamera camera) {
    this.camera = camera;
    batch = new SpriteBatch();
    world = new World(new Vector2(0, Constants.EARTH_GRAVITY), false);
    box2DDebugRenderer = new Box2DDebugRenderer();
    tileMapHelper = new TileMapHelper(this);
    orthogonalTiledMapRenderer = tileMapHelper.setupMap();
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
    Vector3 position = camera.position;
    // Multiply and divide by 10 to round to the nearest 10th for smoother camera movement
    position.x = Math.round(player.getBody().getPosition().x * PPM * 10) / 10f;
    position.y = Math.round(player.getBody().getPosition().y * PPM * 10) / 10f;
    camera.position.set(position);
    camera.update();
  }

  public World getWorld() {
    return world;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }
}

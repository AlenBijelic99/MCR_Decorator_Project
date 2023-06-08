package com.decorator.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.decorator.game.objects.door.Door;
import com.decorator.game.objects.door.DoorUnlocked;
import com.decorator.game.objects.door.Key;
import com.decorator.game.objects.equipment.JumpPotion;
import com.decorator.game.objects.equipment.SpeedPotion;
import com.decorator.game.objects.equipment.StrengthPotion;
import com.decorator.game.objects.player.*;
import com.decorator.game.utils.Constants;
import com.decorator.game.utils.TileMapHelper;

import java.util.LinkedList;
import java.util.List;

import static com.decorator.game.utils.Constants.PPM;

public class GameScreen extends ScreenAdapter {
  private final OrthographicCamera camera;
  private final SpriteBatch batch;
  private final World world;
  private final Box2DDebugRenderer box2DDebugRenderer;
  private final TileMapHelper tileMapHelper;
  private final OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;

  private boolean doorEntered;

  private Player player;
  private Door door;
  private Key key;
  private List<SpeedPotionEntity> speedPotions;
  private List<JumpPotionEntity> jumpPotions;
  private List<StrengthPotionEntity> strengthPotions;
  private List<Body> bodiesToDelete;

  public GameScreen(final OrthographicCamera camera) {
    this.camera = camera;
    speedPotions = new LinkedList<>();
    jumpPotions = new LinkedList<>();
    strengthPotions = new LinkedList<>();
    bodiesToDelete = new LinkedList<>();
    batch = new SpriteBatch();
    world = new World(new Vector2(0,Constants.GRAVITY), false);
    box2DDebugRenderer = new Box2DDebugRenderer();
    tileMapHelper = new TileMapHelper(this);
    orthogonalTiledMapRenderer = tileMapHelper.setupMap();

    doorEntered = false;

    world.setContactListener(new ContactListener() {
      @Override
      public void beginContact(Contact contact) {
        // Collision with one of the speed potions
        for (SpeedPotionEntity potion : speedPotions) {
          if (contact.getFixtureB().getBody() == potion.getBody()) {
            player.setEquipment(new SpeedPotion(player.getEquipment()));
            bodiesToDelete.add(potion.getBody());
            speedPotions.remove(potion);
            System.out.println("Speed Potion drank");
          }
        }
        // Collision with one of the jump potions
        for (JumpPotionEntity potion : jumpPotions) {
          if (contact.getFixtureB().getBody() == potion.getBody()) {
            player.setEquipment(new JumpPotion(player.getEquipment()));
            bodiesToDelete.add(potion.getBody());
            jumpPotions.remove(potion);
            System.out.println("Jump Potion drank");
          }
        }
        // Collision with one of the strength potions
        for (StrengthPotionEntity potion : strengthPotions) {
          if (contact.getFixtureB().getBody() == potion.getBody()) {
            player.setEquipment(new StrengthPotion(player.getEquipment()));
            bodiesToDelete.add(potion.getBody());
            strengthPotions.remove(potion);
            System.out.println("Strength Potion drank");
          }
        }

        // Collision with the key
        if (contact.getFixtureB().getBody() == key.getBody()) {
          bodiesToDelete.add(key.getBody());
          System.out.println("You got the key!");
          // We set the Door as unlocked
          setDoor(new DoorUnlocked(door.getX(), door.getY(), door.getWidth(), door.getHeight(), door.getBody()));
        }

        // Collision with the unlocked door
        if (contact.getFixtureB().getBody() == door.getBody() && door.isUnlocked()) {
          doorEntered = true;
          System.out.println("Door entered");
        }

      }

      @Override
      public void endContact(Contact contact) {
      }

      @Override
      public void postSolve(Contact arg0, ContactImpulse arg1) {
      }

      @Override
      public void preSolve(Contact arg0, Manifold arg1) {
      }
    });
  }

  @Override
  public void show() {
  }

  @Override
  public void render(float delta) {
    //super.render(delta);
    this.update();
    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    orthogonalTiledMapRenderer.render();

    if (!door.isUnlocked()) key.render(batch);
    door.render(batch);

    player.render(batch);

    for (PotionEntity potion : speedPotions) {
      potion.render(batch);
    }

    for (PotionEntity potion : jumpPotions) {
      potion.render(batch);
    }

    for (PotionEntity potion : strengthPotions) {
      potion.render(batch);
    }

    for (Body body : bodiesToDelete) {
      world.destroyBody(body);
    }

    if (doorEntered) {
      endScreen();
      pause();
    }

    bodiesToDelete.clear();

    box2DDebugRenderer.render(world, camera.combined.scl(PPM));
  }

  private void update() {
    world.step(1/60f, 6, 2);
    updateCamera();
    batch.setProjectionMatrix(camera.combined);
    orthogonalTiledMapRenderer.setView(camera);
    player.update();
    if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
      Gdx.app.exit();
    }
    if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
      if (!player.isPaused()) {
        pause();
      } else {
        resume();
      }
    }
  }

  @Override
  public void pause() {
    player.pause();
    super.pause();
  }

  @Override
  public void resume() {
    player.resume();
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

  public void setDoor(Door door) {
    this.door = door;
  }

  public void setKey(Key key) {
    this.key = key;
  }

  public void setSpeedPotions(SpeedPotionEntity potion) {
    speedPotions.add(potion);
  }
  public void setJumpPotions(JumpPotionEntity potion) {
    jumpPotions.add(potion);
  }
  public void setStrengthPotions(StrengthPotionEntity potion) {
    strengthPotions.add(potion);
  }

  private void endScreen() {
    batch.begin();
    TextureRegion region = new TextureRegion(new Texture("screens/endscreen.png"));
    batch.draw(region, camera.position.x / 2, camera.position.y / 2,
            region.getRegionWidth() * 2, region.getRegionHeight() * 2);
    batch.end();
  }
}

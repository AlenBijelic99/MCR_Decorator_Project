package com.decorator.game.objects.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.decorator.game.utils.Constants;


public class Player extends MovableGameEntity {
  private int jumpCount;

  public Player(float width, float height, Body body) {
    super(width, height, body);
    this.speed = Constants.PLAYER_SPEED;
  }

  @Override
  public void update() {
    x = body.getPosition().x * Constants.PPM;
    y = body.getPosition().y * Constants.PPM;
    checkUserInput();
  }

  @Override
  public void render(SpriteBatch batch) {
  }

  private void checkUserInput() {
    dx = 0;
    if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
      dx = -1;
    } else if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
      dx = 1;
    }

    if ((Gdx.input.isKeyJustPressed(Input.Keys.W) || Gdx.input.isKeyJustPressed(Input.Keys.UP) || Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) && jumpCount < Constants.MAX_JUMPING_COUNT) {
      ++jumpCount;
      body.setLinearVelocity(body.getLinearVelocity().x, 0);
      body.applyLinearImpulse(new Vector2(0, body.getMass() * Constants.JUMPING_SPEED), body.getPosition(), true);
    }

    if (body.getLinearVelocity().y == 0) {
      jumpCount = 0;
    }

    body.setLinearVelocity(dx * speed, Math.min(body.getLinearVelocity().y, Constants.MAX_JUMPING_HEIGHT));
  }
}

package com.decorator.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class GameEntity {
  protected float x, y, dx, dy, width, height, speed;
  protected Body body;

  public GameEntity(float width, float height, Body body) {
    x = body.getPosition().x;
    y = body.getPosition().y;
    this.width = width;
    this.height = height;
    dx = 0;
    dy = 0;
    speed = 0;
    this.body = body;
  }

  public abstract void update();

  public abstract void render(SpriteBatch batch);

  public Body getBody() {
    return body;
  }
}

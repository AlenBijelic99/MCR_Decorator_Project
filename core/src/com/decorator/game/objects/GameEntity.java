package com.decorator.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class GameEntity {
  protected float x, y,width, height;
  protected Body body;

  public GameEntity(float width, float height, Body body) {
    x = body.getPosition().x;
    y = body.getPosition().y;
    this.width = width;
    this.height = height;
    this.body = body;
  }

  public abstract void update();

  public abstract void render(SpriteBatch batch);

  public Body getBody() {
    return body;
  }

  public float getX() {
    return x;
  }

  public float getY() {
    return y;
  }

  public float getWidth() {
    return width;
  }

  public float getHeight() {
    return height;
  }
}

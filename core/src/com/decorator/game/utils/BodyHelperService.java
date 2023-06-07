package com.decorator.game.utils;

import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.physics.box2d.*;

public class BodyHelperService {
  public static Body createBody(int x, int y, float width, float height, boolean isStatic, World world) {
    BodyDef bodyDef = new BodyDef();
    bodyDef.type = isStatic ? BodyDef.BodyType.StaticBody : BodyDef.BodyType.DynamicBody;
    bodyDef.position.set(x / Constants.PPM, y / Constants.PPM);
    bodyDef.fixedRotation = true;
    Body body = world.createBody(bodyDef);

    PolygonShape shape = new PolygonShape();
    shape.setAsBox(width / 2 / Constants.PPM, height / 2 / Constants.PPM);

    FixtureDef fixtureDef = new FixtureDef();
    fixtureDef.shape = shape;
    fixtureDef.friction = 0;
    body.createFixture(fixtureDef);
    shape.dispose();
    return body;
  }

  public static Body createSensorBody(int x, int y, float width, float height, World world) {BodyDef bodyDef = new BodyDef();
    bodyDef.type = BodyDef.BodyType.StaticBody;
    bodyDef.position.set(x / Constants.PPM, y / Constants.PPM);
    bodyDef.fixedRotation = true;
    Body body = world.createBody(bodyDef);

    PolygonShape shape = new PolygonShape();
    shape.setAsBox(width / 2 / Constants.PPM, height / 2 / Constants.PPM);

    FixtureDef fixtureDef = new FixtureDef();
    fixtureDef.shape = shape;
    fixtureDef.friction = 0;
    fixtureDef.isSensor = true;
    body.createFixture(fixtureDef);
    shape.dispose();
    return body;
  }
}

package com.decorator.game.utils;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.decorator.game.objects.player.Player;
import com.decorator.game.screens.GameScreen;


import static com.decorator.game.utils.Constants.MAPS;

public class TileMapHelper {
  private TiledMap tiledMap;
  private GameScreen gameScreen;

  public TileMapHelper(GameScreen gameScreen) {
    this.gameScreen = gameScreen;
    tiledMap = new TmxMapLoader().load(MAPS[0]);
    parseMapObjects(tiledMap.getLayers().get("objects").getObjects());
  }
  public OrthogonalTiledMapRenderer setupMap(){
    return new OrthogonalTiledMapRenderer(new TmxMapLoader().load(MAPS[0]));
  }

  private void parseMapObjects(MapObjects mapObjects) {
    for (MapObject mapObject : mapObjects) {
      if (mapObject instanceof PolygonMapObject) {
        createStaticBody((PolygonMapObject) mapObject);
      } else if (mapObject instanceof RectangleMapObject) {
        Rectangle rectangle = ((RectangleMapObject) mapObject).getRectangle();
        String rectangleName = mapObject.getName();
        if (rectangleName.equals("player")) {
          Body body = BodyHelperService.createBody(
                  (int) (rectangle.getX() + rectangle.getWidth() / 2),
                  (int) (rectangle.getY() + rectangle.getHeight() / 2),
                  rectangle.getWidth(),
                  rectangle.getHeight(),
                  false,
                  gameScreen.getWorld()
          );
          gameScreen.setPlayer(new Player(rectangle.getWidth(), rectangle.getHeight(), body));
        }
      }
    }
  }

  private void createStaticBody(PolygonMapObject polygonMapObject) {
    BodyDef bodyDef = new BodyDef();
    bodyDef.type = BodyDef.BodyType.StaticBody;
    Body body = gameScreen.getWorld().createBody(bodyDef);
    Shape shape = createPolygonShape(polygonMapObject);
    body.createFixture(shape, 1000);
    shape.dispose();
  }

  private Shape createPolygonShape(PolygonMapObject polygonMapObject) {
    float[] vertices = polygonMapObject.getPolygon().getTransformedVertices();
    for (int i = 0; i < vertices.length; ++i) {
      vertices[i] = vertices[i] / Constants.PPM;
    }
    PolygonShape polygonShape = new PolygonShape();
    polygonShape.set(vertices);
    return polygonShape;
  }
}

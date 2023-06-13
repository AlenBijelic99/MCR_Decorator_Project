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
import com.decorator.game.objects.door.DoorLocked;
import com.decorator.game.objects.door.Key;
import com.decorator.game.objects.player.*;
import com.decorator.game.objects.player.potionEntity.JumpPotionEntity;
import com.decorator.game.objects.player.potionEntity.SpeedPotionEntity;
import com.decorator.game.objects.player.potionEntity.StrengthPotionEntity;
import com.decorator.game.objects.player.weaponEntity.DaggerEntity;
import com.decorator.game.objects.player.weaponEntity.LongSwordEntity;
import com.decorator.game.screens.GameScreen;


import static com.decorator.game.utils.Constants.MAPS;

public class TileMapHelper {
    private TiledMap tiledMap;
    private GameScreen gameScreen;

    public TileMapHelper(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    /* TODO recheck , moved this part to setupMap
    tiledMap = new TmxMapLoader().load(MAPS[0]);
    parseMapObjects(tiledMap.getLayers().get("objects").getObjects());
    parseMapEquipments(tiledMap.getLayers().get("equipments").getObjects());
    parseDoor(tiledMap.getLayers().get("door").getObjects());

     */
    }

    public OrthogonalTiledMapRenderer setupMap() {
        tiledMap = new TmxMapLoader().load(MAPS[0]);
        parseMapObjects(tiledMap.getLayers().get("objects").getObjects());
        parseMapEquipments(tiledMap.getLayers().get("equipments").getObjects());
        parseDoor(tiledMap.getLayers().get("door").getObjects());
        parseEnemies(tiledMap.getLayers().get("enemies").getObjects());


        return new OrthogonalTiledMapRenderer(new TmxMapLoader().load(MAPS[0]));
    }

    private Body getBody(Rectangle rectangle) {
        return BodyHelperService.createBody(
                (int) (rectangle.getX() + rectangle.getWidth() / 2),
                (int) (rectangle.getY() + rectangle.getHeight() / 2),
                rectangle.getWidth(),
                rectangle.getHeight(),
                true,
                gameScreen.getWorld()
        );
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

    private void parseMapEquipments(MapObjects mapObjects) {
        for (MapObject mapObject : mapObjects) {
            if (!(mapObject instanceof RectangleMapObject)) return;
            Rectangle rectangle = ((RectangleMapObject) mapObject).getRectangle();
            String rectangleName = mapObject.getName();
            Body body = getBody(rectangle);
            if (rectangleName.contains("speedPotion")) {
                gameScreen.setSpeedPotions(new SpeedPotionEntity(rectangle.getX(), rectangle.getY(),
                        rectangle.getWidth(), rectangle.getHeight(), body));
            } else if (rectangleName.contains("jumpPotion")) {
                gameScreen.setJumpPotions(new JumpPotionEntity(rectangle.getX(), rectangle.getY(),
                        rectangle.getWidth(), rectangle.getHeight(), body));
            } else if (rectangleName.contains("strengthPotion")) {
                gameScreen.setStrengthPotions(new StrengthPotionEntity(rectangle.getX(), rectangle.getY(),
                        rectangle.getWidth(), rectangle.getHeight(), body));
            } else if (rectangleName.contains("shortSword")) {
                gameScreen.setShortSwords(new DaggerEntity(rectangle.getX(), rectangle.getY(),
                        rectangle.getWidth(), rectangle.getHeight(), body));
            } else if (rectangleName.contains("longSword")) {
                gameScreen.setLongSwords(new LongSwordEntity(rectangle.getX(), rectangle.getY(),
                        rectangle.getWidth(), rectangle.getHeight(), body));
            }
        }
    }


    private void parseDoor(MapObjects mapObjects) {
        for (MapObject mapObject : mapObjects) {
            if (!(mapObject instanceof RectangleMapObject)) return;
            Rectangle rectangle = ((RectangleMapObject) mapObject).getRectangle();
            String rectangleName = mapObject.getName();
            if (rectangleName.equals("door")) {
                Body body = BodyHelperService.createSensorBody(
                        (int) (rectangle.getX() + rectangle.getWidth() / 2),
                        (int) (rectangle.getY() + rectangle.getHeight() / 2),
                        rectangle.getWidth(),
                        rectangle.getHeight(),
                        gameScreen.getWorld()
                );
                gameScreen.setDoor(new DoorLocked(rectangle.getX(), rectangle.getY(),
                        rectangle.getWidth(), rectangle.getHeight(), body));
            } else if (rectangleName.equals("key")) {
                Body body = BodyHelperService.createBody(
                        (int) (rectangle.getX() + rectangle.getWidth() / 2),
                        (int) (rectangle.getY() + rectangle.getHeight() / 2),
                        rectangle.getWidth(),
                        rectangle.getHeight(),
                        true,
                        gameScreen.getWorld()
                );
                gameScreen.setKey(new Key(rectangle.getX(), rectangle.getY(),
                        rectangle.getWidth(), rectangle.getHeight(), body));
            }
        }
    }

    private void parseEnemies(MapObjects mapObjects) {
        for (MapObject mapObject : mapObjects) {
            if (!(mapObject instanceof RectangleMapObject)) return;
            Rectangle rectangle = ((RectangleMapObject) mapObject).getRectangle();
            String rectangleName = mapObject.getName();
            if (rectangleName.equals("enemy")) {
                Body body = BodyHelperService.createBody(
                        (int) (rectangle.getX() + rectangle.getWidth() / 2),
                        (int) (rectangle.getY() + rectangle.getHeight() / 2),
                        rectangle.getWidth(),
                        rectangle.getHeight(),
                        true,
                        gameScreen.getWorld()
                );
                gameScreen.setEnemy(new Enemy(rectangle.getX(), rectangle.getY(), body));
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

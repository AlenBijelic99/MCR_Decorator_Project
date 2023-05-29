package com.decorator.game.utils;

import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class TileMapHelper {
  public OrthogonalTiledMapRenderer setupMap(){
    return new OrthogonalTiledMapRenderer(new TmxMapLoader().load("testmap.tmx"));
  }
}

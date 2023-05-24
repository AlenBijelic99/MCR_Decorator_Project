package com.decorator.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class DecoratorGame extends ApplicationAdapter {
	private OrthographicCamera camera;
	private Viewport viewport;
	private SpriteBatch batch;
	private TiledMap tiledMap;
	private TiledMapRenderer tiledMapRenderer;

	@Override
	public void create() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);

		// Charger la carte créée avec Tiled
		tiledMap = new TmxMapLoader().load("assets/testmap.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

		MapObjects objects = tiledMap.getLayers().get("RefPoints").getObjects();			// Nom du Calque d'objets
		RectangleMapObject rectangleMapObject = (RectangleMapObject) objects.get("Spawn");	// Nom de l'objet
		Rectangle rectangle = rectangleMapObject.getRectangle();
		System.out.println("Position x = " + rectangle.x);
		System.out.println("Position y = " + rectangle.y);

		// Ajuster le zoom de la caméra pour afficher la carte complète
		float mapWidth = tiledMap.getProperties().get("width", Integer.class) * tiledMap.getProperties().get("tilewidth", Integer.class);
		float mapHeight = tiledMap.getProperties().get("height", Integer.class) * tiledMap.getProperties().get("tileheight", Integer.class);

		// Centrer la caméra sur la carte
		camera.position.set(mapWidth / 2, mapHeight / 2, 0);
	}

	@Override
	public void render() {
		// Effacer l'écran avec une couleur de fond
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Mettre à jour la caméra et le viewport
		camera.update();
		batch.setProjectionMatrix(camera.combined);

		// Afficher la carte
		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);

		// Ajuster le zoom de la caméra lors du redimensionnement de la fenêtre
		float mapWidth = tiledMap.getProperties().get("width", Integer.class) * tiledMap.getProperties().get("tilewidth", Integer.class);
		float mapHeight = tiledMap.getProperties().get("height", Integer.class) * tiledMap.getProperties().get("tileheight", Integer.class);

		// Centrer la caméra sur la carte
		camera.position.set(mapWidth / 2, mapHeight / 2, 0);
	}

	@Override
	public void dispose() {
		batch.dispose();
		tiledMap.dispose();
	}
}

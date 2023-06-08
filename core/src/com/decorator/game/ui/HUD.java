package com.decorator.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.decorator.game.objects.equipment.Equipment;


public class HUD implements Disposable {
    public Stage stage;
    private Viewport viewport;

    private boolean keyGot;
    private int speedPotionCount;
    private int jumpPotionCount;
    private int strengthPotionCount;
    private int health;
    private int defense;
    private int attack;

    private Image speedPotion, jumpPotion, strengthPotion;
    private Image key;
    private Label speedCount, jumpCount, strengthCount;
    private Label healthLabel;
    private Label defenseLabel;
    private Label attackLabel;

    public HUD(SpriteBatch batch, Equipment equipment) {
        keyGot = false;
        speedPotionCount = 0;
        jumpPotionCount = 0;
        strengthPotionCount = 0;

        health = 100;
        attack = equipment.addStrength();
        defense = equipment.addDefense();

        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera());
        stage = new Stage(viewport, batch);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        healthLabel = new Label(String.format("%-15s%03d", "Health: ", health), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        attackLabel = new Label(String.format("%-15s%03d", "Attack:", attack), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        defenseLabel = new Label(String.format("%-15s%03d", "Defense:", defense), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        healthLabel.setFontScale(2f);
        attackLabel.setFontScale(2f);
        defenseLabel.setFontScale(2f);

        speedCount = new Label(String.format("x%d", speedPotionCount), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        jumpCount = new Label(String.format("x%d", jumpPotionCount), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        strengthCount = new Label(String.format("x%d", strengthPotionCount), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        TextureRegion region = new TextureRegion(new Texture("kenney_tiny-dungeon/Potions/tile_0116.png"));
        speedPotion = new Image(region);
        region = new TextureRegion(new Texture("kenney_tiny-dungeon/Potions/tile_0114.png"));
        jumpPotion = new Image(region);
        region = new TextureRegion(new Texture("kenney_tiny-dungeon/Potions/tile_0115.png"));
        strengthPotion = new Image(region);
        region = new TextureRegion(new Texture("kenney_tiny-town/Key/tile_0117_empty.png"));
        key = new Image(region);

        table.add(healthLabel).left().expandX().size(50).padTop(50).padLeft(50);
        table.add(speedPotion).size(50).padTop(50);
        table.add(speedCount).size(50).padTop(50);
        table.add(jumpPotion).size(50).padTop(50);
        table.add(jumpCount).size(50).padTop(50);
        table.add(strengthPotion).size(50).padTop(50);
        table.add(strengthCount).size(50).padTop(50);
        table.add(key).padTop(50);
        table.add().expandX();
        table.row();
        table.add(attackLabel).left().padTop(50).padLeft(50);
        table.row();
        table.add(defenseLabel).left().padTop(50).padLeft(50);

        stage.addActor(table);
        stage.draw();
    }

    public void render() {
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}

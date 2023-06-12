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
import com.decorator.game.objects.player.Player;


public class HUD implements Disposable {
    public Stage stage;

    private boolean keyGot;
    private int speedPotionCount;
    private int jumpPotionCount;
    private int strengthPotionCount;
    private String armorImagePath;
    private String swordImagePath;

    private final Player player;

    private final static int IMAGE_SIZE = 75;
    private final static int LEFT_PADDING = 50;
    private final static int TOP_PADDING = 50;

    public HUD(SpriteBatch batch, Player player) {
        keyGot = false;
        speedPotionCount = 0;
        jumpPotionCount = 0;
        strengthPotionCount = 0;

        this.player = player;

        armorImagePath = "kenney_tiny-dungeon/Equipment/tile_0085.png";
        swordImagePath = "kenney_tiny-dungeon/Equipment/tile_0086.png";

        Viewport viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera());
        stage = new Stage(viewport, batch);

        ui();

        stage.draw();
    }

    public void updateSpeedPotionCount() {
        speedPotionCount++;
    }

    public void updateJumpPotionCount() {
        jumpPotionCount++;
    }

    public void updateStrengthPotionCount() {
        strengthPotionCount++;
    }

    public void updateKey() {
        keyGot = true;
    }

    public void updateArmorImagePath(String newPath) {
        armorImagePath = newPath;
    }

    public void updateSwordImagePath(String newPath) {
        swordImagePath = newPath;
    }

    public void ui() {
        Table table = new Table();
        table.top();
        table.setFillParent(true);

        BitmapFont font = new BitmapFont(Gdx.files.internal("fonts/VT323.fnt"));

        Label healthLabel = new Label(String.format("%-10s%03d", "Health:", player.getHealth()), new Label.LabelStyle(font, Color.WHITE));
        Label attackLabel = new Label(String.format("%-10s%03d", "Attack:", player.getStrength()), new Label.LabelStyle(font, Color.WHITE));
        Label defenseLabel = new Label(String.format("%-10s%03d", "Defense:", player.getDefense()), new Label.LabelStyle(font, Color.WHITE));
        healthLabel.setFontScale(2f);
        attackLabel.setFontScale(2f);
        defenseLabel.setFontScale(2f);

        Label speedCount = new Label(String.format("x%d", speedPotionCount), new Label.LabelStyle(font, Color.WHITE));
        Label jumpCount = new Label(String.format("x%d", jumpPotionCount), new Label.LabelStyle(font, Color.WHITE));
        Label strengthCount = new Label(String.format("x%d", strengthPotionCount), new Label.LabelStyle(font, Color.WHITE));

        TextureRegion region = new TextureRegion(new Texture(armorImagePath));
        Image armor = new Image(region);
        region = new TextureRegion(new Texture(swordImagePath));
        Image sword = new Image(region);
        region = new TextureRegion(new Texture("kenney_tiny-dungeon/Potions/tile_0116.png"));
        Image speedPotion = new Image(region);
        region = new TextureRegion(new Texture("kenney_tiny-dungeon/Potions/tile_0114.png"));
        Image jumpPotion = new Image(region);
        region = new TextureRegion(new Texture("kenney_tiny-dungeon/Potions/tile_0115.png"));
        Image strengthPotion = new Image(region);
        String path;
        if (keyGot) {
            path = "kenney_tiny-town/Key/tile_0117.png";
        } else {
            path = "kenney_tiny-town/Key/tile_0117_empty.png";
        }
        region = new TextureRegion(new Texture(path));
        Image key = new Image(region);

        table.add(healthLabel).left().padTop(TOP_PADDING).padLeft(LEFT_PADDING);
        table.add(armor).size(IMAGE_SIZE).padLeft(LEFT_PADDING * 2).padTop(TOP_PADDING);
        table.add(sword).size(IMAGE_SIZE).padTop(TOP_PADDING);
        table.add(speedPotion).size(IMAGE_SIZE).padTop(TOP_PADDING).padLeft(LEFT_PADDING);
        table.add(speedCount).size(IMAGE_SIZE).padTop(TOP_PADDING);
        table.add(jumpPotion).size(IMAGE_SIZE).padTop(TOP_PADDING);
        table.add(jumpCount).size(IMAGE_SIZE).padTop(TOP_PADDING);
        table.add(strengthPotion).size(IMAGE_SIZE).padTop(TOP_PADDING);
        table.add(strengthCount).size(IMAGE_SIZE).padTop(TOP_PADDING);
        table.add(key).size(IMAGE_SIZE).padTop(TOP_PADDING);
        table.add().expandX();
        table.row();
        table.add(attackLabel).left().padLeft(LEFT_PADDING);
        table.row();
        table.add(defenseLabel).left().padLeft(LEFT_PADDING);

        stage.addActor(table);
    }

    public void render() {
        stage.dispose();
        ui();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}

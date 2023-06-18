package com.decorator.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.decorator.game.objects.Hole;
import com.decorator.game.objects.door.Door;
import com.decorator.game.objects.door.DoorUnlocked;
import com.decorator.game.objects.door.Key;
import com.decorator.game.objects.equipment.Equipment;
import com.decorator.game.objects.equipment.PlayerEquipment;
import com.decorator.game.objects.equipment.armor.Armor;
import com.decorator.game.objects.equipment.armor.BronzeArmor;
import com.decorator.game.objects.equipment.armor.GoldArmor;
import com.decorator.game.objects.equipment.armor.SilverArmor;
import com.decorator.game.objects.equipment.potion.JumpPotion;
import com.decorator.game.objects.equipment.potion.SpeedPotion;
import com.decorator.game.objects.equipment.potion.StrengthPotion;
import com.decorator.game.objects.equipment.weapon.Dagger;
import com.decorator.game.objects.equipment.weapon.LongSword;
import com.decorator.game.objects.player.*;
import com.decorator.game.objects.player.armorEntity.ArmorEntity;
import com.decorator.game.objects.player.armorEntity.BronzeArmorEntity;
import com.decorator.game.objects.player.armorEntity.GoldArmorEntity;
import com.decorator.game.objects.player.armorEntity.SilverArmorEntity;
import com.decorator.game.objects.player.potionEntity.JumpPotionEntity;
import com.decorator.game.objects.player.potionEntity.PotionEntity;
import com.decorator.game.objects.player.potionEntity.SpeedPotionEntity;
import com.decorator.game.objects.player.potionEntity.StrengthPotionEntity;
import com.decorator.game.objects.player.weaponEntity.DaggerEntity;
import com.decorator.game.objects.player.weaponEntity.LongSwordEntity;
import com.decorator.game.objects.player.weaponEntity.WeaponEntity;
import com.decorator.game.utils.Constants;
import com.decorator.game.utils.TileMapHelper;
import com.decorator.game.ui.HUD;

import java.util.LinkedList;
import java.util.List;


public class GameScreen extends ScreenAdapter {
    private final OrthographicCamera camera;
    private final SpriteBatch batch;
    private final World world;
    private final OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;
    private final HUD hud;

    private boolean doorEntered;

    // All the elements displayed on the map
    private Player player;
    private Door door;
    private Key key;
    private final List<Enemy> enemies;
    private final List<SpeedPotionEntity> speedPotions;
    private final List<JumpPotionEntity> jumpPotions;
    private final List<StrengthPotionEntity> strengthPotions;
    private final List<DaggerEntity> shortSwords;
    private final List<LongSwordEntity> longSwords;
    private final List<GoldArmorEntity> goldArmors;
    private final List<SilverArmorEntity> silverArmors;
    private final List<BronzeArmorEntity> bronzeArmors;
    private final List<Hole> holes;

    private final List<Body> bodiesToDelete;  // List of bodies to remove from the map
    private Texture backgroundTexture;
    private FitViewport viewport;             // The viewport of the map

    public GameScreen(final OrthographicCamera camera) {
        this.camera = camera;
        speedPotions = new LinkedList<>();
        jumpPotions = new LinkedList<>();
        strengthPotions = new LinkedList<>();
        shortSwords = new LinkedList<>();
        longSwords = new LinkedList<>();
        goldArmors = new LinkedList<>();
        silverArmors = new LinkedList<>();
        bronzeArmors = new LinkedList<>();
        holes = new LinkedList<>();

        enemies = new LinkedList<>();
        bodiesToDelete = new LinkedList<>();
        batch = new SpriteBatch();
        world = new World(new Vector2(0, Constants.GRAVITY), false);
        Box2DDebugRenderer box2DDebugRenderer = new Box2DDebugRenderer();
        TileMapHelper tileMapHelper = new TileMapHelper(this);
        orthogonalTiledMapRenderer = tileMapHelper.setupMap();
        doorEntered = false;
        hud = new HUD(batch, player);


        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {

                // Collision with one of the speed potions
                for (SpeedPotionEntity potion : speedPotions) {
                    if (contact.getFixtureA().getBody() == potion.getBody()) {
                        player.setEquipments(new SpeedPotion(player.getCurrentEquipment()));
                        bodiesToDelete.add(potion.getBody());
                        speedPotions.remove(potion);
                        System.out.println("Speed Potion drank");
                        hud.updateSpeedPotionCount();
                    }
                }
                // Collision with one of the jump potions
                for (JumpPotionEntity potion : jumpPotions) {
                    if (contact.getFixtureA().getBody() == potion.getBody()) {
                        player.setEquipments(new JumpPotion(player.getCurrentEquipment()));
                        bodiesToDelete.add(potion.getBody());
                        jumpPotions.remove(potion);
                        System.out.println("Jump Potion drank");
                        hud.updateJumpPotionCount();
                    }
                }
                // Collision with one of the strength potions
                for (StrengthPotionEntity potion : strengthPotions) {
                    if (contact.getFixtureA().getBody() == potion.getBody()) {
                        player.setEquipments(new StrengthPotion(player.getCurrentEquipment()));
                        bodiesToDelete.add(potion.getBody());
                        strengthPotions.remove(potion);
                        System.out.println("Strength Potion drank");
                        hud.updateStrengthPotionCount();
                    }
                }
                // Collision with one of the short swords
                for (DaggerEntity sword : shortSwords) {
                    if (contact.getFixtureA().getBody() == sword.getBody()) {
                        // if the player already has a long sword, then dont take this daggeer
                        boolean hasWeapon = false;

                        Equipment e = player.getCurrentEquipment();
                        while (!(e instanceof PlayerEquipment)) {
                            if (e instanceof LongSword || e instanceof Dagger) {
                                hasWeapon = true;
                                break;
                            }
                            e = e.getEquipment();
                        }
                        if (hasWeapon) {
                            break;
                        }
                        player.setEquipments(new Dagger(player.getCurrentEquipment()));
                        bodiesToDelete.add(sword.getBody());
                        shortSwords.remove(sword);
                        System.out.println("Dagger Sword equipped");
                        hud.updateSwordImagePath("weapons/Dagger.png");
                    }
                }
                // Collision with one of the long swords
                for (LongSwordEntity sword : longSwords) {
                    if (contact.getFixtureA().getBody() == sword.getBody()) {
                        //if the player already has a long sword, then dont take this long sword
                        boolean hasLongSword = false;

                        Equipment e = player.getCurrentEquipment();
                        while (!(e instanceof PlayerEquipment)) {
                            if (e instanceof LongSword) {
                                hasLongSword = true;
                                break;
                            }
                            e = e.getEquipment();
                        }
                        if (hasLongSword) {
                            break;
                        }

                        player.removeEquipment(Dagger.class);
                        player.setEquipments(new LongSword(player.getCurrentEquipment()));
                        bodiesToDelete.add(sword.getBody());
                        longSwords.remove(sword);
                        System.out.println("Long Sword equipped");
                        hud.updateSwordImagePath("weapons/LSword.png");
                    }
                }
                // Collision with one of the gold armors
                for (GoldArmorEntity armor : goldArmors) {

                    if (contact.getFixtureA().getBody() == armor.getBody()) {
                        // if the player already has a gold armor, then dont take this gold armor
                        boolean hasGoldArmor = false;

                        Equipment e = player.getCurrentEquipment();
                        while (!(e instanceof PlayerEquipment)) {
                            if (e instanceof GoldArmor) {
                                hasGoldArmor = true;
                                break;
                            }
                            e = e.getEquipment();
                        }
                        if (hasGoldArmor) {
                            break;
                        }
                        player.removeEquipment(SilverArmor.class);
                        player.removeEquipment(BronzeArmor.class);
                        player.setEquipments(new GoldArmor(player.getCurrentEquipment()));
                        bodiesToDelete.add(armor.getBody());
                        goldArmors.remove(armor);
                        System.out.println("Gold Armor equipped");
                        hud.updateArmorImagePath("assets/armor/gold.png");
                    }
                }
                // Collision with one of the silver armors
                for (SilverArmorEntity armor : silverArmors) {

                    if (contact.getFixtureA().getBody() == armor.getBody()) {
                        // update only if player has no gold armor
                        boolean hasGoldOrSilverArmor = false;
                        Equipment e = player.getCurrentEquipment();
                        while (!(e instanceof PlayerEquipment)) {
                            if (e instanceof GoldArmor || e instanceof SilverArmor) {
                                hasGoldOrSilverArmor = true;
                                break;
                            }
                            e = e.getEquipment();
                        }
                        if (hasGoldOrSilverArmor) {
                            break;
                        }

                        player.removeEquipment(BronzeArmor.class);
                        player.setEquipments(new SilverArmor(player.getCurrentEquipment()));
                        bodiesToDelete.add(armor.getBody());
                        silverArmors.remove(armor);
                        System.out.println("Silver Armor equipped");
                        hud.updateArmorImagePath("assets/armor/silver.png");

                    }
                }
                // Collision with one of the bronze armors
                for (BronzeArmorEntity armor : bronzeArmors) {
                    if (contact.getFixtureA().getBody() == armor.getBody()) {
                        // update only if player doesnt have any armor
                        boolean hasArmor = false;
                        Equipment e = player.getCurrentEquipment();
                        while (!(e instanceof PlayerEquipment)) {
                            if (e instanceof Armor) {
                                hasArmor = true;
                                break;
                            }
                            e = e.getEquipment();
                        }
                        if (hasArmor) {
                            break;
                        }
                        player.setEquipments(new BronzeArmor(player.getCurrentEquipment()));
                        bodiesToDelete.add(armor.getBody());
                        bronzeArmors.remove(armor);
                        System.out.println("Bronze Armor equipped");
                        hud.updateArmorImagePath("assets/armor/bronze.png");

                    }
                }

                // Collision with the holes
                for (Hole hole : holes) {
                    if (contact.getFixtureB().getBody() == hole.getBody()) {
                        player.setDead(true);
                        bodiesToDelete.add(player.getBody());
                        System.out.println("You fell into the hole");
                        deadScreen();

                    }
                }


                // Collision with the key
                if (contact.getFixtureA().getBody() == key.getBody()) {
                    bodiesToDelete.add(key.getBody());
                    System.out.println("You got the key!");
                    // We set the Door as unlocked
                    setDoor(new DoorUnlocked(door.getX(), door.getY(), door.getWidth(), door.getHeight(), door.getBody()));
                    hud.updateKey();
                }

                // Collision with the unlocked door
                if (contact.getFixtureA().getBody() == door.getBody() && door.isUnlocked()) {
                    doorEntered = true;
                    System.out.println("Door entered");
                }


            }

            @Override
            public void endContact(Contact contact) {
            }

            @Override
            public void postSolve(Contact arg0, ContactImpulse arg1) {
            }

            @Override
            public void preSolve(Contact arg0, Manifold arg1) {
            }
        });
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
    }


    @Override
    public void show() {

        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();
        viewport = new FitViewport(screenWidth, screenHeight, camera);
        viewport.apply();
    }

    @Override
    public void render(float delta) {
        this.update();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        viewport.apply();
        batch.setProjectionMatrix(camera.combined);

        orthogonalTiledMapRenderer.render();

        if (!door.isUnlocked()) key.render(batch);
        door.render(batch);

        player.render(batch);

        for (PotionEntity potion : speedPotions) {
            potion.render(batch);
        }

        for (PotionEntity potion : jumpPotions) {
            potion.render(batch);
        }

        for (PotionEntity potion : strengthPotions) {
            potion.render(batch);
        }

        for (WeaponEntity sword : shortSwords) {
            sword.render(batch);
        }

        for (WeaponEntity sword : longSwords) {
            sword.render(batch);
        }
        for (ArmorEntity armor : goldArmors) {
            armor.render(batch);
        }
        for (ArmorEntity armor : silverArmors) {
            armor.render(batch);
        }
        for (ArmorEntity armor : bronzeArmors) {
            armor.render(batch);
        }

        for (Hole hole : holes) {
            hole.render(batch);
        }

        for (Enemy enemy : enemies) {
            enemy.render(batch);
        }
        for (Body body : bodiesToDelete) {
            world.destroyBody(body);
        }

        bodiesToDelete.clear();


        if (doorEntered) {
            endScreen();
            pause();
        }

        if (player.isDead()) {
            deadScreen();
            pause();
        }
        hud.render();
    }


    private void update() {
        world.step(1 / 60f, 6, 2);
        updateCamera();
        batch.setProjectionMatrix(camera.combined);
        orthogonalTiledMapRenderer.setView(camera);
        player.update();

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            if (!player.isPaused()) {
                pause();
            } else {
                resume();
            }
        }
    }

    private void updateCamera() {
        Vector3 position = camera.position;
        position.x = Gdx.graphics.getWidth() / 2f;
        position.y = Gdx.graphics.getHeight() / 2f;
        camera.position.set(position);
        camera.update();
    }

    public World getWorld() {
        return world;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setEnemy(Enemy enemy) {
        enemies.add(enemy);

    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void setHole(Hole hole) {
        this.holes.add(hole);
    }

    public void setSpeedPotions(SpeedPotionEntity potion) {
        speedPotions.add(potion);
    }

    public void setJumpPotions(JumpPotionEntity potion) {
        jumpPotions.add(potion);
    }

    public void setStrengthPotions(StrengthPotionEntity potion) {
        strengthPotions.add(potion);
    }

    public void setShortSwords(DaggerEntity shortSwords) {
        this.shortSwords.add(shortSwords);
    }

    public void setGoldArmors(GoldArmorEntity goldArmorEntity) {
        this.goldArmors.add(goldArmorEntity);
    }

    public void setSilverArmor(SilverArmorEntity silverArmorEntity) {
        this.silverArmors.add(silverArmorEntity);
    }

    public void setBronzeArmor(BronzeArmorEntity bronzeArmorEntity) {
        this.bronzeArmors.add(bronzeArmorEntity);
    }

    private void endScreen() {
        screen("screens/endscreen.png");
    }

    private void deadScreen() {
        screen("screens/gameOver.png");
    }

    private void screen(String imagePath) {
        batch.begin();
        TextureRegion region = new TextureRegion(new Texture(imagePath));
        float x = Gdx.graphics.getWidth() / 2f - region.getRegionWidth();
        float y = Gdx.graphics.getHeight() / 2f - region.getRegionHeight();
        batch.draw(region, x, y, region.getRegionWidth() * 2, region.getRegionHeight() * 2);
        batch.end();
    }

    public void setLongSwords(LongSwordEntity longSwords) {
        this.longSwords.add(longSwords);
    }


}

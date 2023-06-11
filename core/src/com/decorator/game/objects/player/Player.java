package com.decorator.game.objects.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;
import com.decorator.game.objects.equipment.Equipment;
import com.decorator.game.objects.equipment.PlayerEquipment;
import com.decorator.game.utils.Constants;

public class Player extends MovableGameEntity {

  private final String[] WEAPON_NAMES = {"None", "Dagger", "LSword"};
  private final String[] ARMOR_NAMES = {"None", "Bronze", "Silver", "Gold"};
  private final String[] ACTIONS_NAMES = {"Idle", "Run", "Jump", "Attack", "Dead"};
  private final int currentWeapon = 2;
  private final int currentArmor = 3;
  private final Animation<TextureRegion>[][][] animations = new Animation[WEAPON_NAMES.length][ARMOR_NAMES.length][ACTIONS_NAMES.length];
  public enum State {JUMPING, IDLE, RUNNING, ATTACKING, DEAD};
  public State currentState;
  public State previousState;
  private float stateTimer;
  private int jumpCount;
  private boolean isRunningRight;
  private Equipment equipment;
  private float jumpHeight;
  private int strength;
  private boolean isRunning;
  private boolean isAttacking;
  private boolean isDead;
  private boolean isDeadAnimationFinished;
  private float attackStateTimer;

  private void initAnimations(){
    for (int i = 0; i < WEAPON_NAMES.length; ++i){
      for (int j = 0; j < ARMOR_NAMES.length; ++j){
        Array<TextureRegion> frames = new Array<>();
        // Idle
        for (int f = 0; f < 1; ++f) {
          frames.add(new TextureRegion(new Texture("player/" + ACTIONS_NAMES[0] + "/Player_" + WEAPON_NAMES[i] + "_" + ARMOR_NAMES[j] + "_" + f + ".png")));
        }
        animations[i][j][0] = new Animation<>(0.3f, frames);
        frames.clear();
        // Run
        for (int f = 0; f < 9; ++f) {
          frames.add(new TextureRegion(new Texture("player/" + ACTIONS_NAMES[1] + "/Player_" + WEAPON_NAMES[i] + "_" + ARMOR_NAMES[j] + "_" + f + ".png")));
        }
        animations[i][j][1] = new Animation<>(0.1f, frames, Animation.PlayMode.LOOP);
        frames.clear();

        // Jump
        for (int f = 0; f < 1; ++f) {
          frames.add(new TextureRegion(new Texture("player/" + ACTIONS_NAMES[2] + "/Player_" + WEAPON_NAMES[i] + "_" + ARMOR_NAMES[j] + "_" + f + ".png")));
        }
        animations[i][j][2] = new Animation<>(0.3f, frames);
        frames.clear();

        // Attack
        for (int f = 0; f < 11; ++f) {
          frames.add(new TextureRegion(new Texture("player/" + ACTIONS_NAMES[3] + "/Player_" + WEAPON_NAMES[i] + "_" + ARMOR_NAMES[j] + "_" + f + ".png")));
        }
        animations[i][j][3] = new Animation<>(0.031f, frames);
        frames.clear();

        // Dead
        for (int f = 0; f < 5; ++f) {
          frames.add(new TextureRegion(new Texture("player/" + ACTIONS_NAMES[4] + "/Player_" + WEAPON_NAMES[i] + "_" + ARMOR_NAMES[j] + "_" + f + ".png")));
        }
        animations[i][j][4] = new Animation<>(0.3f, frames);
        frames.clear();
      }
    }
  }

  public Player(float width, float height, Body body) {
    super(width, height, body);
    setEquipment(new PlayerEquipment());

    jumpCount = 0;
    currentState = State.IDLE;
    previousState = State.IDLE;
    stateTimer = 0;
    isRunningRight = true;

    initAnimations();
  }

  @Override
  public void update() {
    x = body.getPosition().x * Constants.PPM;
    y = body.getPosition().y * Constants.PPM;
    checkUserInput();
  }

  public Equipment getEquipment() {
    return equipment;
  }

  public void setEquipment(Equipment equipment) {
    this.equipment = equipment;
    speed = equipment.addSpeed();
    jumpHeight = equipment.addJump();
    strength = equipment.addStrength();
  }

  @Override
  public void render(SpriteBatch batch) {
    batch.begin();
    TextureRegion region = getFrame(Gdx.graphics.getDeltaTime());
    batch.draw(region, x - width / 2, y - height / 2, region.getRegionWidth() * 2, region.getRegionHeight() * 2);
    batch.end();
  }

  private void checkUserInput() {
    dx = 0;
    if (!isDead) {
      if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
        dx = -1;
        isRunning = true;
      } else if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
        dx = 1;
        isRunning = true;
      } else {
        isRunning = false;
      }

      if ((Gdx.input.isKeyJustPressed(Input.Keys.W) || Gdx.input.isKeyJustPressed(Input.Keys.UP)) && jumpCount < Constants.MAX_JUMPING_COUNT && body.getLinearVelocity().y == 0) {
        ++jumpCount;
        body.setLinearVelocity(body.getLinearVelocity().x, 0);
        body.applyLinearImpulse(new Vector2(0, body.getMass() * Constants.JUMPING_SPEED), body.getPosition(), true);
      }

      // Reset jump count if player is on the ground
      if (body.getLinearVelocity().y == 0) {
        jumpCount = 0;
      }

      if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
        if (!isAttacking) {
          isAttacking = true;
          attackStateTimer = 0;
        }
      }
    } else {
      isRunning = false;
      isAttacking = false;
    }

    if (Gdx.input.isKeyJustPressed(Input.Keys.X)) {
      if (!isDead) {
        isDead = true;
        isDeadAnimationFinished = false;
      } else if (isDeadAnimationFinished) {
        // Restart the game or perform any other action
      }
    }

    body.setLinearVelocity(dx * speed, Math.min(body.getLinearVelocity().y, jumpHeight));
  }

  public State getState(){
    if (body.getLinearVelocity().y > 0 || (body.getLinearVelocity().y < 0 && previousState == State.JUMPING)){
      if (isAttacking && !animations[currentWeapon][currentArmor][3].isAnimationFinished(stateTimer)) {
        return State.ATTACKING;
      }
      return State.JUMPING;
    }
    else if (isAttacking) {
      if (attackStateTimer < animations[currentWeapon][currentArmor][3].getAnimationDuration()) {
        return State.ATTACKING;
      } else {
        isAttacking = false;
        return State.IDLE;
      }
    }
    else if (isRunning){
      return State.RUNNING;
    }
    else if (isDead){
      return State.DEAD;
    }
    else {
      return State.IDLE;
    }
  }

  public TextureRegion getFrame(float dt) {
    previousState = currentState;
    currentState = getState();
    TextureRegion region;

    switch (currentState) {
      case JUMPING:
        region = animations[currentWeapon][currentArmor][2].getKeyFrame(stateTimer);
        break;
      case RUNNING:
        region = animations[currentWeapon][currentArmor][1].getKeyFrame(stateTimer, true);
        break;
      case ATTACKING:
        region = animations[currentWeapon][currentArmor][3].getKeyFrame(attackStateTimer);
        if (attackStateTimer < animations[currentWeapon][currentArmor][3].getAnimationDuration()) {
          attackStateTimer += dt;
        } else {
          isAttacking = false;
        }
        break;
      case DEAD:
        region = animations[currentWeapon][currentArmor][4].getKeyFrame(stateTimer);
        if (animations[currentWeapon][currentArmor][4].isAnimationFinished(stateTimer)) {
          if (!isDeadAnimationFinished) {
            isDeadAnimationFinished = true;
            stateTimer -= dt; // Subtract the delta time to keep the last frame
          }
        }
        break;
      default:
        region = animations[currentWeapon][currentArmor][0].getKeyFrame(stateTimer, true);
        break;
    }
    // Flip player if he is running left
    if ((body.getLinearVelocity().x < 0 || !isRunningRight) && !region.isFlipX()) {
      region.flip(true, false);
      isRunningRight = false;
    }
    else if((body.getLinearVelocity().x > 0 || isRunningRight) && region.isFlipX()){
      region.flip(true, false);
      isRunningRight = true;
    }

    //if the current state is the same as the previous state increase the state timer.
    //otherwise the state has changed and we need to reset timer.
    stateTimer = currentState == previousState ? stateTimer + dt : 0;
    //update previous state
    previousState = currentState;
    //return our final adjusted frame
    return region;
  }
}

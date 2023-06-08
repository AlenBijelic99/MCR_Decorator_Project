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
  public enum State {JUMPING, IDLE, RUNNING, ATTACKING, DEAD};
  public State currentState;
  public State previousState;
  private float stateTimer;
  private int jumpCount;
  private final Animation<TextureRegion> idle;
  private final Animation<TextureRegion> run;
  private final Animation<TextureRegion> jump;
  private final Animation<TextureRegion> attack;
  private final Animation<TextureRegion> dead;
  private boolean isRunningRight;
  private Equipment equipment;
  private float jumpHeight;
  private int strength;
  private boolean isRunning;
  private boolean isAttacking;
  private boolean isDead;
  private boolean isDeadAnimationFinished;


  public Player(float width, float height, Body body) {
    super(width, height, body);
    setEquipment(new PlayerEquipment());

    jumpCount = 0;
    currentState = State.IDLE;
    previousState = State.IDLE;
    stateTimer = 0;
    isRunningRight = true;

    Array<TextureRegion> frames = new Array<>();

    for (int i = 0; i < 1; ++i){
      frames.add(new TextureRegion(new Texture("player/idle/Player_None_None_" + i + ".png")));
    }
    idle = new Animation<>(0.3f, frames);
    frames.clear();

    for (int i = 0; i < 9; ++i){
      frames.add(new TextureRegion(new Texture("player/run/Player_None_None_" + i + ".png")));
    }
    run = new Animation<>(0.1f, frames, Animation.PlayMode.LOOP);
    frames.clear();

    for (int i = 0; i < 1; ++i){
      frames.add(new TextureRegion(new Texture("player/idle/Player_None_None_" + i + ".png")));
    }
    jump = new Animation<>(0.3f, frames);
    frames.clear();

    for (int i = 0; i < 11; ++i){
      frames.add(new TextureRegion(new Texture("player/attack/Player_None_None_" + i + ".png")));
    }
    attack = new Animation<>(0.06f, frames);
    frames.clear();

    for (int i = 0; i < 5; ++i){
      frames.add(new TextureRegion(new Texture("player/dead/Player_None_None_" + i + ".png")));
    }
    dead = new Animation<>(0.3f, frames);
    frames.clear();
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

      if ((Gdx.input.isKeyJustPressed(Input.Keys.W) || Gdx.input.isKeyJustPressed(Input.Keys.UP)) && jumpCount < Constants.MAX_JUMPING_COUNT) {
        ++jumpCount;
        body.setLinearVelocity(body.getLinearVelocity().x, 0);
        body.applyLinearImpulse(new Vector2(0, body.getMass() * Constants.JUMPING_SPEED), body.getPosition(), true);
      }

      if (body.getLinearVelocity().y == 0) {
        jumpCount = 0;
      }

      if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
        isAttacking = true;
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
      return State.JUMPING;
    }/*
    else if (body.getLinearVelocity().y < 0){
      return State.FALLING;
    }*/
    else if (isRunning){
      return State.RUNNING;
    }
    else if (isAttacking){
      return State.ATTACKING;
    }
    else if (isDead){
      return State.DEAD;
    }
    else
      return State.IDLE;
  }

  public TextureRegion getFrame(float dt) {
    previousState = currentState;
    currentState = getState();
    TextureRegion region;

    switch (currentState) {
      case JUMPING:
        region = jump.getKeyFrame(stateTimer);
        break;
      case RUNNING:
        region = run.getKeyFrame(stateTimer, true);
        break;
      case ATTACKING:
        region = attack.getKeyFrame(stateTimer);
        if (attack.isAnimationFinished(stateTimer)) {
          currentState = State.IDLE;
        }
        break;
      case DEAD:
        region = dead.getKeyFrame(stateTimer);
        if (dead.isAnimationFinished(stateTimer)) {
          if (!isDeadAnimationFinished) {
            isDeadAnimationFinished = true;
            stateTimer -= dt; // Subtract the delta time to keep the last frame
          }
        }
        break;
      default:
        region = idle.getKeyFrame(stateTimer, true);
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

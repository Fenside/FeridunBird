package com.steven.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.steven.game.sprites.Animation;

public class Goose {
    private static final int gravity = -15;
    private static final int movement = 100;
    private Vector3 position;
    private Vector3 velocity;
    private Rectangle bounds;
    private Texture goose;
    private Animation gooseAnimation;
    private Texture texture;
    private Sound flap;

    public Goose(int x, int y) {
        this.position = new Vector3((float)x, (float)y, 0.0F);
        this.velocity = new Vector3(0.0F, 0.0F, 0.0F);
        this.texture = new Texture("birdanimation.png");
        this.gooseAnimation = new Animation(new TextureRegion(this.texture), 3, 0.5F);
        this.bounds = new Rectangle((float)x, (float)y, (float)(this.texture.getWidth() / 3), (float)this.texture.getHeight());
        this.flap = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
    }

    public void update(float DeltaTime) {
        this.gooseAnimation.update(DeltaTime);
        if(this.position.y > 0.0F) {
            this.velocity.add(0.0F, -15.0F, 0.0F);
        }

        this.velocity.scl(DeltaTime);
        this.position.add(100.0F * DeltaTime, this.velocity.y, 0.0F);
        if(this.position.y < 0.0F) {
            this.position.y = 0.0F;
        }

        this.velocity.scl(1.0F / DeltaTime);
        this.bounds.setPosition(this.position.x, this.position.y);
    }

    public Vector3 getPosition() {
        return this.position;
    }

    public TextureRegion getGooseTexture() {
        return this.gooseAnimation.getFrame();
    }

    public float getWidth() {
        return (float)this.texture.getWidth();
    }

    public float getHeight() {
        return (float)this.texture.getHeight();
    }

    public void Jump() {
        this.velocity.y = 250.0F;
        this.flap.play(0.8F);
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    public void dispose() {
        this.texture.dispose();
        this.flap.dispose();
    }
}

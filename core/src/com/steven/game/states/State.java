package com.steven.game.states;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.steven.game.states.GameStateManager;

public abstract class State {
    protected OrthographicCamera camera;
    protected Vector3 mouse;
    protected GameStateManager GSM;

    protected State(GameStateManager GSM) {
        this.GSM = GSM;
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, 240.0F, 400.0F);
    }

    protected abstract void handleInput();

    public abstract void update(float var1);

    public abstract void render(SpriteBatch var1);

    public abstract void dispose();
}

package com.steven.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.steven.game.FeridunBirds;
import com.steven.game.states.GameStateManager;
import com.steven.game.states.PlayState;
import com.steven.game.states.State;

public class MenuState extends State {
    private Texture playButton;
    private Texture background;

    public MenuState(GameStateManager GSM) {
        super(GSM);
        this.camera.setToOrtho(false, 240.0F, 400.0F);
        this.background = new Texture("bg.png");
        this.playButton = new Texture("playbtn.png");
    }

    public void handleInput() {
        if(Gdx.input.justTouched()) {
            this.GSM.set(new PlayState(this.GSM));

        }

    }

    public void update(float deltaTime) {
        this.handleInput();
    }

    public void render(SpriteBatch SB) {
        SB.setProjectionMatrix(this.camera.combined);
        SB.begin();
        SB.draw(this.background, 0, 0);
        SB.draw(this.playButton, this.camera.position.x - (float)(this.playButton.getWidth() / 2), this.camera.position.y);
        SB.end();
    }

    public void dispose() {
        this.background.dispose();
        this.playButton.dispose();
        System.out.println("Menu State Disposed");
    }
}

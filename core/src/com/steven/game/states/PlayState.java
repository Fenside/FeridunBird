package com.steven.game.states;

import java.util.Iterator;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.steven.game.sprites.Goose;
import com.steven.game.sprites.Tube;
import com.steven.game.states.GameStateManager;
import com.steven.game.states.State;
import java.util.Iterator;

public class PlayState extends State {
    private static final int tubeSpacing = 100;
    private static final int tubeCount = 30;
    private static final int groundYOffset = -5;
    private Goose mainGoose = new Goose(50, 300);
    private Texture background;
    private Texture ground;
    private Vector2 groundPos1;
    private Vector2 groundPos2;
    private Array<Tube> tubes;

    public PlayState(GameStateManager GameSM) {
        super(GameSM);
        this.camera.setToOrtho(false, 240.0F, 400.0F);
        this.background = new Texture("bg1.png");
        this.ground = new Texture("ground.png");
        this.groundPos1 = new Vector2(this.camera.position.x - this.camera.viewportWidth / 2.0F, -5.0F);
        this.groundPos2 = new Vector2(this.camera.position.x - this.camera.viewportWidth / 2.0F + (float)this.ground.getWidth(), -5.0F);
        this.tubes = new Array();

        for(int i = 0; i <= 30; ++i) {
            this.tubes.add(new Tube((float)(i * 142)));
        }

    }

    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            this.mainGoose.Jump();
        }

    }

    public void update(float deltaTime) {
        this.handleInput();
        this.UpdateGround();
        this.mainGoose.update(deltaTime);
        this.camera.position.x = this.mainGoose.getPosition().x + 80.0F;

        for(int i = 0; i < 29; ++i) {
            Tube tube = (Tube)this.tubes.get(i);
            if(this.camera.position.x - this.camera.viewportWidth / 2.0F > tube.getPosTopTube().x + (float)tube.getTopTube().getWidth()) {
                tube.reposition(tube.getPosTopTube().x + 4260.0F);
            }

            if(tube.collides(this.mainGoose.getBounds())) {
                //this.GSM.set(new PlayState(this.GSM));
                this.GSM.set(new DeathState(this.GSM));
            }
        }

        if(this.mainGoose.getPosition().y <= (float)(this.ground.getHeight() + -5)) {
            //this.GSM.set(new PlayState(this.GSM));
            this.GSM.set(new DeathState(this.GSM));
        }

        this.camera.update();
    }

    public void render(SpriteBatch SB) {
        SB.setProjectionMatrix(this.camera.combined);
        SB.begin();
        SB.draw(this.background, this.camera.position.x - this.camera.viewportWidth / 2.0F, 0.0F);
        SB.draw(this.mainGoose.getGooseTexture(), this.mainGoose.getPosition().x, this.mainGoose.getPosition().y);
        Iterator var2 = this.tubes.iterator();

        while(var2.hasNext()) {
            Tube tube = (Tube)var2.next();
            SB.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
            SB.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
        }

        SB.draw(this.ground, this.groundPos1.x, this.groundPos1.y);
        SB.draw(this.ground, this.groundPos2.x, this.groundPos2.y);
        SB.end();
    }

    public void dispose() {
        this.background.dispose();
        this.mainGoose.dispose();
        this.ground.dispose();
        Iterator var1 = this.tubes.iterator();

        while(var1.hasNext()) {
            Tube tube = (Tube)var1.next();
            tube.dispose();
        }

        System.out.println("Play State Disposed");
    }

    private void UpdateGround() {
        if(this.camera.position.x - this.camera.viewportWidth / 2.0F > this.groundPos1.x + (float)this.ground.getWidth()) {
            this.groundPos1.add((float)(this.ground.getWidth() * 2), 0.0F);
        }

        if(this.camera.position.x - this.camera.viewportWidth / 2.0F > this.groundPos2.x + (float)this.ground.getWidth()) {
            this.groundPos2.add((float)(this.ground.getWidth() * 2), 0.0F);
        }

    }
}

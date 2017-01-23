package com.steven.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import javax.swing.text.html.ImageView;

/**
 * Created by Steven on 2017-01-22.
 */

public class DeathState extends State {

    private Texture deathbackground;
    private Texture gameover;



    private Texture replayButton;
    //private Texture quitButton;





    public DeathState(GameStateManager GSM) {
        super(GSM);
        this.camera.setToOrtho(false, 240.0F, 400.0F);
        this.deathbackground = new Texture("bg1.png");
        this.replayButton = new Texture("Replay.png");
        //this.quitButton = new Texture("Quit.png");
        this.gameover = new Texture("gameover.png");




    }



    @Override
    protected void handleInput() {

        if(Gdx.input.justTouched()) {
            this.GSM.set(new PlayState(this.GSM));
            //System.exit(0);
        }
    }



    @Override
    public void update(float var1) {
            this.handleInput();

    }

    @Override
    public void render(SpriteBatch SB) {
        SB.setProjectionMatrix(this.camera.combined);
        SB.begin();


        SB.draw(this.deathbackground, 0, 0);
        //SB.draw(this.replaybutton, this.camera.position.x - (float)(this.replaybutton.getWidth() / 2 ), this.camera.position.y/2);
        SB.draw(this.gameover, this.camera.position.x - (float)(this.gameover.getWidth() / 2)  , this.camera.position.y  );
        SB.draw(this.replayButton, this.camera.position.x - 40    , this.camera.position.y /2 + 15 );
        //SB.draw(this.quitButton, this.camera.position.x - 40, this.camera.position.y/2 - replayButton.getHeight() + 5 );

        SB.end();

    }

    @Override
    public void dispose() {
        this.deathbackground.dispose();
        this.replayButton.dispose();
    }
}

package com.steven.game.sprites;

import java.util.Random;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class Tube {
    public static final int tubeWidth = 52;
    private static final int fluctuation = 130;
    private static final int tubeGap = 80;
    private static final int lowestBotTubePos = 130;
    private Texture botTube = new Texture("bottomtube.png");
    private Texture topTube = new Texture("toptube.png");
    private Vector2 posTopTube;
    private Vector2 posBotTube;
    private Rectangle boundsTop;
    private Rectangle boundsBot;
    private Random rand = new Random();
    private float topylast;
    private float botylast;

    public Tube(float x) {
        this.posTopTube = new Vector2(x, (float)(this.rand.nextInt(130) + 99 + 130));
        this.posBotTube = new Vector2(x, this.posTopTube.y - 99.0F - (float)this.botTube.getHeight());
        this.topylast = this.posTopTube.y;
        this.botylast = this.posBotTube.y;
        this.boundsTop = new Rectangle(this.posTopTube.x, this.posTopTube.y, (float)this.topTube.getWidth(), (float)this.topTube.getHeight());
        this.boundsBot = new Rectangle(this.posBotTube.x, this.posBotTube.y, (float)this.botTube.getWidth(), (float)this.botTube.getHeight());
    }

    public Texture getBottomTube() {
        return this.botTube;
    }

    public void setBotTube(Texture botTube) {
        this.botTube = botTube;
    }

    public Texture getTopTube() {
        return this.topTube;
    }

    public void setTopTube(Texture topTube) {
        this.topTube = topTube;
    }

    public void setPosTopTube(Vector2 posTopTube) {
        this.posTopTube = posTopTube;
    }

    public void setPosBotTube(Vector2 posBotTube) {
        this.posBotTube = posBotTube;
    }

    public Vector2 getPosTopTube() {
        return this.posTopTube;
    }

    public Vector2 getPosBotTube() {
        return this.posBotTube;
    }

    public void reposition(float x) {
        float a = (float)(this.rand.nextInt(130) + 99 + 130);
        float b = this.posTopTube.y - 99.0F - (float)this.botTube.getHeight();
        if(a <= this.topylast) {
            a = (float)(this.rand.nextInt(130) + 99 + 130);
        }

        if(b >= this.botylast) {
            b = this.posTopTube.y - 99.0F - (float)this.botTube.getHeight();
        }

        this.posTopTube.set(x, a);
        this.posBotTube.set(x, b);
        this.topylast = this.posTopTube.y;
        this.botylast = this.posBotTube.y;
        this.boundsTop.setPosition(this.posTopTube.x, this.posTopTube.y);
        this.boundsBot.setPosition(this.posBotTube.x, this.posBotTube.y);
    }

    public boolean collides(Rectangle player) {
        return player.overlaps(this.boundsTop) || player.overlaps(this.boundsBot);
    }

    public Rectangle getBoundsBot() {
        return this.boundsBot;
    }

    public Rectangle getBoundsTop() {
        return this.boundsTop;
    }

    public void dispose() {
        this.topTube.dispose();
        this.botTube.dispose();
    }
}

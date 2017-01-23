package com.steven.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animation {
    private Array<TextureRegion> frames = new Array();
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int frame;

    public Animation(TextureRegion region, int frameCount, float cycleTime) {
        int frameWidth = region.getRegionWidth() / frameCount;

        for(int i = 0; i < frameCount; ++i) {
            this.frames.add(new TextureRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight()));
        }

        this.frameCount = frameCount;
        this.maxFrameTime = cycleTime / (float)frameCount;
        this.frame = 0;
    }

    public void update(float deltaTime) {
        this.currentFrameTime += deltaTime;
        if(this.currentFrameTime > this.maxFrameTime) {
            ++this.frame;
            this.currentFrameTime = 0.0F;
        }

        if(this.frame >= this.frameCount) {
            this.frame = 0;
        }

    }

    public TextureRegion getFrame() {
        return (TextureRegion)this.frames.get(this.frame);
    }
}

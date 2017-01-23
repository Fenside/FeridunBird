package com.steven.game.states;


import java.util.Stack;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.steven.game.states.State;


public class GameStateManager {
    private Stack<State> states = new Stack();

    public GameStateManager() {
    }

    public void push(State state) {
        this.states.push(state);
    }

    public void pop() {
        ((State)this.states.pop()).dispose();
    }

    public void set(State state) {
        ((State)this.states.pop()).dispose();
        this.states.push(state);
    }

    public void Update(float deltaTime) {
        ((State)this.states.peek()).update(deltaTime);
    }

    public void Render(SpriteBatch SB) {
        ((State)this.states.peek()).render(SB);
    }
}

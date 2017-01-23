package com.steven.game;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//



		import com.badlogic.gdx.ApplicationAdapter;
		import com.badlogic.gdx.Gdx;
		import com.badlogic.gdx.audio.Music;
		import com.badlogic.gdx.graphics.Texture;
		import com.badlogic.gdx.graphics.g2d.SpriteBatch;
		import com.steven.game.states.GameStateManager;
		import com.steven.game.states.MenuState;

public class FeridunBirds extends ApplicationAdapter {
	public static final int view_Width = 480;
	public static final int view_Height = 800;
	public static final String title = "Feridun Bird";
	private GameStateManager GSM;
	private Music music;
	private SpriteBatch batch;
	private Texture img;

	public FeridunBirds() {
	}

	public void create() {
		this.batch = new SpriteBatch();
		this.GSM = new GameStateManager();
		this.img = new Texture("badlogic.jpg");
		this.music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		this.music.setLooping(true);
		this.music.setVolume(1F);
		this.music.play();
		Gdx.gl.glClearColor(1.0F, 0.0F, 0.0F, 1.0F);
		this.GSM.push(new MenuState(this.GSM));
	}

	public void render() {
		Gdx.gl.glClearColor(1.0F, 0.0F, 0.0F, 1.0F);
		Gdx.gl.glClear(16384);
		this.GSM.Update(Gdx.graphics.getDeltaTime());
		this.GSM.Render(this.batch);
	}

	public void dispose() {
		this.batch.dispose();
		this.img.dispose();
		this.music.dispose();
	}
}

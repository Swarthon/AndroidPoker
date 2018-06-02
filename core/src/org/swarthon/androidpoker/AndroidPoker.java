package org.swarthon.androidpoker;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

public class AndroidPoker extends InputAdapter implements ApplicationListener {
    Stage stage;
    Game game;

    protected void drawPlayer(int num) {
        int size = game.getPlayers().length();
        int x = Math.cos(Math.PI/size * num);
        int y = Math.sin(Math.PI/size * num);
    }
    
	public void create () {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

        game = new Game(2);

        stage.addActor(new CardObject(game.getDeck().get(15)));
	}

	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}

	public void resize (int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	public void dispose () {
		stage.dispose();
    }
    public void resume() {
    }
    public void pause() {
    }
}

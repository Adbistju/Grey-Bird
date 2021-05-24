package adbistju.system;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGreyBird extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture imgBack;
	float x = 10;
	float y = 0;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		imgBack = new Texture("back.png");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(imgBack, 0, 0);
		batch.draw(img, (x++)+(x++), y++);
		if(x>1000){
			x = 0;
			y = 0;
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}

package adbistju.system.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import adbistju.system.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture imgBack;
    private Vector2 pos;
    //private Vector2 v;

    @Override
    public void show() {
        super.show();
        img = new Texture("klipartz.png");
        imgBack = new Texture("1719751.png");
        pos = new Vector2(img.getHeight(), img.getHeight());
        //v = new Vector2(img.getHeight(), img.getHeight());
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        //batch.draw(imgBack, 0, 0);
        //pos.add(v);
        //ScreenUtils.clear(0.33f, 0.45f, 0.68f, 1);
        ScreenUtils.clear(0.3f,0.5f,0.2f,1); //3.5.5
        batch.begin();
        batch.draw(imgBack, -30, 0);
        batch.draw(img, pos.x - (img.getWidth()/2), pos.y - (img.getHeight()/2));
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        pos.set(screenX, Gdx.graphics.getHeight() - screenY);
        return super.touchDown(screenX, screenY, pointer, button);
    }
}

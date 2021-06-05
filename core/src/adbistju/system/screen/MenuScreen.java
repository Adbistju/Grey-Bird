package adbistju.system.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import adbistju.system.base.BaseScreen;
import adbistju.system.math.Rect;
import adbistju.system.sprite.Background;
import adbistju.system.sprite.Logo;

public class MenuScreen extends BaseScreen {

    private Texture img;

    private Texture bg;

    private Background background;
    private Logo logo;

    @Override
    public void show() {
        super.show();
        img = new Texture("klipartz.png");
        bg = new Texture("1719751.png");

        background = new Background(bg);
        logo = new Logo(img);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        logo.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        logo.update(delta);
        ScreenUtils.clear(0.33f, 0.45f, 0.68f, 1);
        batch.begin();
        background.draw(batch);
        logo.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        logo.touchDown(touch, pointer, button);
        return false;
    }
}

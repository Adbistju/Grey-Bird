package adbistju.system.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import adbistju.system.base.BaseScreen;
import adbistju.system.math.Rect;
import adbistju.system.pool.BulletPool;
import adbistju.system.sprite.Background;
import adbistju.system.sprite.MainShip;
import adbistju.system.sprite.Star;

public class GameScreen extends BaseScreen {

    private static final int STAR_COUNT = 1024;

    private Texture bg;
    private TextureAtlas atlas;
    private TextureAtlas atlas1;

    private Background background;
    private Star[] stars;

    private BulletPool bulletPool;
    private MainShip mainShip;

    @Override
    public void show() {
        Music music = Gdx.audio.newMusic(Gdx.files.internal("13052020.wav"));
        super.show();
        bg = new Texture("1719751.png");
        background = new Background(bg);
        atlas = new TextureAtlas("textures/mainAtlas.tpack");
        atlas1 = new TextureAtlas("textures/menuAtlas.tpack");
        stars = new Star[STAR_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(atlas1);
        }
        bulletPool = new BulletPool();
        mainShip = new MainShip(atlas, bulletPool);
        music.setLooping(true);
        music.setVolume(0.8f);
        music.play();

    }

    @Override
    public void render(float delta) {
        update(delta);
        freeAllDestroyed();
        draw();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (Star star : stars) {
            star.resize(worldBounds);
        }
        mainShip.resize(worldBounds);
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        atlas.dispose();
        bulletPool.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        mainShip.keyDown(keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        mainShip.keyUp(keycode);
        return false;
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        mainShip.touchDown(touch, pointer, button);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        mainShip.touchUp(touch, pointer, button);
        return false;
    }

    private void update(float delta) {
        for (Star star : stars) {
            star.update(delta);
        }
        mainShip.update(delta);
        bulletPool.updateActiveSprites(delta);
    }

    private void freeAllDestroyed() {
        bulletPool.freeAllDestroyed();
    }

    private void draw() {
        ScreenUtils.clear(0.33f, 0.45f, 0.68f, 1);
        batch.begin();
        background.draw(batch);
        for (Star star : stars) {
            star.draw(batch);
        }
        mainShip.draw(batch);
        bulletPool.drawActiveSprites(batch);
        batch.end();
    }
}

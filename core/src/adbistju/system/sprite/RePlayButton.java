package adbistju.system.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import adbistju.system.base.ScaledButton;
import adbistju.system.math.Rect;
import adbistju.system.screen.GameScreen;

public class RePlayButton extends ScaledButton {

    private static final float HEIGHT = 0.06f;
    private static final float PADDING = 0.08f;

    private final Game game;

    public RePlayButton(TextureRegion atlas, Game game) {
        super(atlas);
        this.game = game;
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(HEIGHT);
        setBottom(worldBounds.getTop() - PADDING);
        setLeft(worldBounds.getLeft() + 0.03f);
    }

    @Override
    protected void action() {
        game.setScreen(new GameScreen(game));
    }
}

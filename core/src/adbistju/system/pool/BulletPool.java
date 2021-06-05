package adbistju.system.pool;

import adbistju.system.base.SpritesPool;
import adbistju.system.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}

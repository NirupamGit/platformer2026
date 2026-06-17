package platformer.code.gamelogic.enemies;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import platformer.code.gameengine.PhysicsObject;
import platformer.code.gameengine.hitbox.RectHitbox;
import platformer.code.gamelogic.GameResources;
import platformer.code.gamelogic.level.Level;

public class TNT extends PhysicsObject {

    private BufferedImage image;
    private float walkSpeed = 200;

    public TNT(float x, float y, Level level) {
        super(x, y, (int)(level.getLevelData().getTileSize() * 1.5),
                     (int)(level.getLevelData().getTileSize() * 1.5),
                     level);
        movementVector.x = -walkSpeed;
        this.hitbox = new RectHitbox(this, 10, 10, width - 10, height - 10);
        this.image = GameResources.tileset.getImage("TNT");
    }

    @Override
    public void update(float tslf) {
        position.x += movementVector.x * tslf;
        hitbox.update();
    }

    @Override
    public void draw(Graphics g) {
        if (image != null) {
            g.drawImage(image, (int)position.x, (int)position.y, width, height, null);
        }
        hitbox.draw(g);
    }
}
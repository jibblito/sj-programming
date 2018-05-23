import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bird extends GameObject {

    int width = 30; int height = 20;
    private Handler handler;
    private Color color = Color.yellow;
    BufferedImage sprite; {
    try {
        sprite = ImageIO.read(getClass().getResource("/resources/images/Flappy-Bird_Sprite.png"));
    } catch (IOException e) {
        e.printStackTrace();
        sprite = null;
    }
    }

    public Bird(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.x = Game.WIDTH / 5;
        this.handler = handler;
        velY = -3.5;
    }

    public void tick() {
        y += (int)velY;
        y = Game.clamp(y,0, Game.HEIGHT-40);
        if(y < Game.HEIGHT) velY += gravity;
        collision();
    }

    public void render(Graphics g) {

        g.drawImage(sprite,x,y,null);

    }

    public Rectangle hitbox() {
        return new Rectangle(x,y,sprite.getHeight(),sprite.getHeight());
    }

    public void jump() {
        velY = -14;
    }

    public void collision() {
        for(GameObject i : handler.objects) {
            if(i instanceof Pipe) {
                if(hitbox().intersects(i.hitbox())) {

                }
            }
        }
    }

}

import java.awt.*;

public class Player extends GameObject {

    int size = 20;

    public Player(int x, int y, ID id) {
        super(x, y, id);
        velY = -5;
        velX = 30;
    }

    public void tick() {

        y += (int) velY;
        x += (int) velX;

        if(KeyControl.isdPressed()) velX = 10;
        if(KeyControl.isaPressed()) velX = -10;

        if(x > Game.WIDTH - size) {
            x = Game.WIDTH - size;
            velX = 0;
        }

        if(x < 0) {
            x = 0;
            velX = 0;
        }

        if(y >= Game.HEIGHT - size) {
            velY *= -0.3;
            y = Game.HEIGHT - size;
            velY += velY * -yResistance;
        }

        if(y < 0) {
            y = 0;
            velY = 0;
        }

        if(y < Game.HEIGHT - size) velY += gravity;
        if(y >= Game.HEIGHT - size) velX *=xResistance;
        else velX *= 0.98;

    }

    public void render(Graphics g) {
        if(id == ID.Player) g.setColor(Color.WHITE);
        else if(id == ID.Player2) g.setColor(Color.blue);
        if(x >= 0 && x <= Game.WIDTH && y >= 0 && y <= Game.HEIGHT) g.fillOval(x,y,size,size);
        g.drawLine(0,0,x + size/2, y + size/2);
        g.drawLine(Game.WIDTH,0,x + size/2, y + size/2);
        g.drawLine(0, Game.HEIGHT,x + size/2, y + size/2);
        g.drawLine(Game.WIDTH, Game.HEIGHT,x + size/2, y + size/2);
    }

    public Rectangle hitbox() {
        return null;
    }

    public void jump() {
        if(id == ID.Player) velY = -15;
    }

}

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Pipe extends GameObject {

    private Handler handler;
    private int height;
    private boolean followed = false;

    private BufferedImage pipeBody;
    private BufferedImage pipeTop;
    private BufferedImage pipeBot;

    {
        try {
            pipeBody = ImageIO.read(getClass().getResource("/resources/images/Pipe-Body_Sprite.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    {
        try {
            pipeTop = ImageIO.read(getClass().getResource("resources/images/Pipe-Bottom_Sprite.png"));
        } catch (IOException e) {
            e.printStackTrace();
            pipeTop = null;
        }
    }

    {
        try {
            pipeBot = ImageIO.read(getClass().getResource("resources/images/Pipe-Top_Sprite.png"));
        } catch (IOException e) {
            e.printStackTrace();
            pipeBot = null;
        }
    }

    public Pipe(int x, int y, ID id, int height, Handler handler) {
        super(x, y, id);
        if(id == ID.PipeTop) x += 200;
        velX = 4;
        this.handler = handler;
        this.height = height;

    }

    public void tick() {
        if(KeyControl.isaPressed()) x -= (int) velX * 1.5;
        if(KeyControl.isdPressed()) x = x;
        else x -= 4;

        if (x < -50) {
            handler.removeObject(this);
        }

        if(x < Game.WIDTH - 375 && !followed && id == ID.PipeTop) {
            sendPipe();
            followed = true;
        }

    }

    public void render(Graphics g) {

        g.drawImage(pipeBody,x + 2, height - 410,null);
        g.drawImage(pipeBot,x,height-10,null);
        g.setColor(Color.WHITE);
        g.drawString("" + x, x-30, y + 390);

        g.drawImage(pipeBody,x + 2,height + 160,null);
        g.drawImage(pipeTop,x,height + 150,null);
        g.setColor(Color.WHITE);
        g.drawString("" + x, x-30, 400);


    }

    public Rectangle hitbox() {
        return new Rectangle(x,y,50,height);
    }

    void sendPipe() {

        int neWhole = (int) (Math.random() * (400)) + 50;

        handler.addObject(new Pipe(Game.WIDTH,0,ID.PipeTop,neWhole,handler));

    }

}

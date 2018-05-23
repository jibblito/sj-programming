import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 1000, HEIGHT = WIDTH / 4 * 3;
    private Thread thread;
    private boolean running = false;
    private static Handler handler;
    public static Game gameInstance;
    private BufferedImage grass;
    private int x = 0;
    {
        try {
            grass = ImageIO.read(getClass().getResource("/resources/images/Grass-Sprite.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Game() {
        new Window(WIDTH,HEIGHT,"Dumb Game",this);
        handler = new Handler();
        this.addKeyListener(new KeyControl(handler));
        handler.addObject(new Bird(0,400,ID.Bird, handler));

        int hole = (int) (Math.random() * (HEIGHT - 300)) + 25;
        handler.addObject(new Pipe(WIDTH,0,ID.PipeTop,hole,handler));

    }

    public Handler getHandler() { return handler; }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void tick() {
        handler.tick();
        if(x >= -1000) x-= 4;
        else x = 0;
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();

        if(bs == null) {
            this.createBufferStrategy(4);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(new Color(135,206,250));
        g.fillRect(0,0,WIDTH,HEIGHT);
        handler.render(g);
        g.drawImage(grass,x,600,1000,250,null);
        g.drawImage(grass,x + 1000,600,1000,250,null);

        g.dispose();
        bs.show();

    }

    public void run() {         // This is the game loop

        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(running) {

            long now = System.nanoTime();       // Change in time since last iteration
            delta += (now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1) {         // Tick to make up for time in between ??
                tick();
                delta--;
            }

            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {     // Output frames every 1000 ms (1 sec)
                timer += 1000;
                System.out.println(frames);
                frames = 0;
            }
        }
        stop();
    }

    public static int clamp(int cur, int min, int max) {
        if(cur > max) return cur = max;
        if(cur < min) return cur = min;
        else return cur;
    }

    public static void main(String[] args) {
        gameInstance = new Game();
    }

}

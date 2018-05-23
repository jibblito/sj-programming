import java.awt.*;

public abstract class GameObject {

    protected int x,y;
    protected ID id;
    protected double velX,velY;
    double gravity = 0.99;
    double xResistance = 0.920;
    double yResistance = 0.33;

    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle hitbox();

    public void setX(int x) {
        this.x = x;
    }

    public int getX() { return x; }
    public void setY(int y) { this.y = y; }
    public int getY() { return y; }
    public void setId(ID id) { this.id = id; }
    public ID getId() { return id; }
    public void setVelX(double velX) { this.velX = velX; }
    public double getVelX() { return velX; }
    public void setVelY(double velY) { this.velY = velY; }
    public double getVelY() { return velY; }
}

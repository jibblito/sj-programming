import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyControl extends KeyAdapter {

    private Handler handler;

    public static boolean dPressed = false;
    public static boolean aPressed = false;

    public KeyControl(Handler h) {

        handler = h;

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A && !aPressed)  aPressed = true;

        if (key == KeyEvent.VK_D && !dPressed) dPressed = true;

        for(int i = 0; i < handler.objects.size(); i++) {
            GameObject temp = handler.objects.get(i);

            if(temp instanceof Player) {

                if (key == KeyEvent.VK_SPACE) ((Player) temp).jump();

            }

            if(temp instanceof Bird) {

                if (key == KeyEvent.VK_SPACE) ((Bird) temp).jump();

            }

        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A && aPressed) aPressed = false;

        if (key == KeyEvent.VK_D && dPressed) dPressed = false;

        for(int i = 0; i< handler.objects.size(); i++) {
            GameObject temp = handler.objects.get(i);

            if(temp instanceof Player) {


            }

        }

    }

    public static boolean isdPressed() {
        return dPressed;
    }
    public static boolean isaPressed() {
        return aPressed;
    }
}

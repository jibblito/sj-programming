import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    private int HEIGHT,WIDTH;
    private String title;

    public Window(int width,int height,String title, Game game) {

        JFrame frame = new JFrame(title);
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(game);
        game.start();


    }

}

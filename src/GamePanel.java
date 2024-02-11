import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel {
    public static final long serialVersionUID = 1L;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 800;
    private BufferedImage img;

    public GamePanel() {
        LoadImage();
    }

    private void LoadImage() {
        try {
            img = ImageIO.read(new File("C:/Users/Mudda/IdeaProjects/FlappyBird/Images/Background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, null);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }
}

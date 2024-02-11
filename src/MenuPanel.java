import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serial;

public class MenuPanel extends JPanel {
    @Serial
    private static final long serialVersionUID=1L;
    private BufferedImage img=null;
    public boolean startingPoint=false;
    public MenuPanel(){
        LoadImage();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                startingPoint=true;
            }
        });
    }

    private void LoadImage() {
        try {
            img= ImageIO.read(new File("C://Users//Mudda//IdeaProjects//FlappyBird//Images//Menu.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img,0,0, GamePanel.WIDTH, GamePanel.HEIGHT,null);
    }
}

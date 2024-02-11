import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class WallImage {
    private Random r = new Random();
    public int X;
    private int Y=r.nextInt((GamePanel.HEIGHT/2)+200);
    private int width_wall=45;
    private int height=GamePanel.HEIGHT-Y;
    private int gap = 200; // Gap between the two pipes
    public static int speed=-6;
    private BufferedImage img = null;

    public WallImage(int X) {
        this.X = X;
        LoadImage();
    }


    private void LoadImage() {
        try {
            img = ImageIO.read(new File("C://Users//Mudda//IdeaProjects//FlappyBird//Images//pipe.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void wallView(Graphics g) {
        g.drawImage(img,X,Y,null);
        g.drawImage(img,X,(-GamePanel.HEIGHT)+(Y-gap),null);
    }
    public void wallMove(){
        X+=speed;
        if(X<=width_wall){
            X=GamePanel.WIDTH;
            Y=r.nextInt((GamePanel.HEIGHT/2)+200);
            height=GamePanel.HEIGHT-Y;
        }
    }
//    Rectangle lower=new Rectangle(X,Y,width_wall,height);
//    Rectangle upper=new Rectangle(X,0,width_wall,GamePanel.HEIGHT-(height+gap));
//    if(lower.intersects(BirdImage.birdrect()) || upper.intersects(BirdImage.birdrect())){
//        BirdImage.reset();
//    }
public boolean intersects(Rectangle rect1, Rectangle rect2) {
    return rect1.intersects(rect2);
}

    public void checkIntersection() {
        Rectangle lower = new Rectangle(X, Y, width_wall, height);
        Rectangle upper = new Rectangle(X, 0, width_wall, GamePanel.HEIGHT - (height + gap));

        Rectangle birdRect = BirdImage.birdrect(); // Ensure this method returns a Rectangle

        if (intersects(lower, birdRect) || intersects(upper, birdRect)) {
            BirdImage.reset();
            wall_reset();

        }
    }
    private void wall_reset(){
        Y=r.nextInt((GamePanel.HEIGHT/2)+200);
        height=GamePanel.HEIGHT-Y;
        GamePanel.Gameover=true;

    }

}

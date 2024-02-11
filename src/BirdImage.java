import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class BirdImage {
    public static int bird_dia=45;
    public static int x=(GamePanel.WIDTH/2)-bird_dia;
    public static int y=(GamePanel.HEIGHT/2);
    private static int speed=2;
    private int acce=1;
    public BufferedImage img;
    public BirdImage(){
        LoadImage();
    }

    private void LoadImage() {
        try {
            img = ImageIO.read(new File("C://Users//Mudda//IdeaProjects//FlappyBird//Images//bird.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void birdview(Graphics g){
        g.drawImage(img,x,y,null);
    }
    public void birdmove(){
        if(y>0 && y<GamePanel.HEIGHT){
            speed+=acce;
            y+=speed;
        }else reset();
    }
    public static void reset(){
        speed=2;
        y=GamePanel.HEIGHT/2;
        GamePanel.Gameover=true;
    }
    public void goUpward(){
        speed=-14;
    }
    public static Rectangle birdrect(){
        Rectangle birdRect=new Rectangle(x,y,bird_dia,bird_dia);
        return birdRect;
    }

}

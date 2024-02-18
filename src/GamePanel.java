import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel {
    public static final long serialVersionUID = 1L;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 800;
    private BufferedImage img;
    public static boolean Gameover=false;
    public int xcoor=0;
    public static int  score = 0;
    public static boolean starting=false;
    public static int proceed=-1;

    BirdImage bdimg=new BirdImage();
    WallImage wimg=new WallImage(GamePanel.WIDTH);
    WallImage wimg2=new WallImage((GamePanel.WIDTH)+(GamePanel.WIDTH/2));
    public GamePanel() {
        LoadImage();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                bdimg.goUpward();
            }
        });
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
            g.drawImage(img, xcoor, 0, null);
            g.drawImage(img,xcoor+2400,0,null);
        }
        bdimg.birdview(g);
        wimg.wallView(g);
        wimg2.wallView(g);
        g.drawString("Score: " + score, 20, 20);
        if(starting){
            g.setFont(new Font("Arial",Font.BOLD,150));
            g.drawString(Integer.toString(proceed), WIDTH/2-75, 250);
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }
    public void Move(){
        bdimg.birdmove();
        wimg.wallMove();
        wimg2.wallMove();
        wimg.checkIntersection();
        wimg2.checkIntersection();
        if(Gameover){
            wimg.X=GamePanel.WIDTH;
            wimg2.X=(GamePanel.WIDTH)+(GamePanel.WIDTH/2);
            Gameover=false;
        }
        xcoor+=WallImage.speed;
        if(xcoor==-2400){
            xcoor=0;
        }
        System.out.println(wimg.X+"-> "+bdimg.x+":"+wimg2.X+"->"+bdimg.x);
        if(wimg.X==bdimg.x || wimg2.X == bdimg.x){
            score+=1;
        }
    }
    public static boolean popUp(){
        int result = JOptionPane.showConfirmDialog(null, "Game Over! Your Score is: "+score+"\nDo you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
        if(result == JOptionPane.YES_OPTION){
            return true;
        }else{
            return false;
        }
    }

}

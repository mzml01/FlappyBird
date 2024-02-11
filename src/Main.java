import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JFrame window;

    public Main() {
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setSize(GamePanel.WIDTH, GamePanel.HEIGHT);
        window.setLocationRelativeTo(null);
        window.setTitle("Flappy Bird");
    }

    public void startGame() {
        MenuPanel menuPanel = new MenuPanel();
        GamePanel gamePanel = new GamePanel();
        Timer time=new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.repaint();
                gamePanel.Move();
            }
        });

        window.add(menuPanel);
        window.setVisible(true);

        // Wait for the user to click to start the game
        menuPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                window.remove(menuPanel);
                window.add(gamePanel);
                window.revalidate();
                gamePanel.requestFocusInWindow(); // Ensure the game panel has focus for key events
                time.start();
            }
        });
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.startGame();
    }
}

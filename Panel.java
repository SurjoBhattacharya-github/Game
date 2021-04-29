import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Panel extends JPanel implements ActionListener,KeyListener {
    static boolean appleEatWait = false,appleGenerateScope = true;
    static char direction = 'R';
    static int x = 10,y=10,spd=10,appleX,appleY,size=50;
    Timer tim = new Timer(75,this);
    Panel()  {
        tim.start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        generateApple();
        draw(g);
    }
    public void generateApple() {
        if(appleGenerateScope) {
            appleX = (int) Math.round(Math.random() * 500 );
            appleY = (int) Math.round(Math.random() * 500);
            appleGenerateScope = false;
        }
    }
    void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x,y,size,size);
        g.setColor(Color.GREEN);
        g.fillOval(appleX,appleY,20,20);
    }
    void gameOver() {
        if(x == getWidth() || y == getHeight() || x == -getWidth() || y == -getHeight()) {
            System.exit(1);
        }
    }

     public void move() {
           if (direction == 'R') {
             x+=spd;
         }
         else if (direction == 'L') {
             x-=spd;
         }
         else if (direction == 'U') {
             y-=spd;
         }
         else if (direction == 'D'){
             y+=spd;
         }
     }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
        int n = e.getKeyCode();
        if(n == e.VK_UP) {
            direction = 'U';
        } else if(n == e.VK_DOWN) {
         direction = 'D';
        } else if(n == e.VK_LEFT) {
            direction = 'L';
        } else if(n == e.VK_RIGHT) {
          direction = 'R';
        }
    }

    public void actionPerformed(ActionEvent e) {
        gameOver();
        move();
        repaint();
    }
    public void keyReleased(KeyEvent e){}
}

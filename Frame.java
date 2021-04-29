import javax.swing.*;
import java.awt.event.*;
public class Frame extends JFrame implements ActionListener{

    Timer tm = new Timer(0,this);
    Frame() {
        tm.start();
        this.addKeyListener(new Panel());
        this.setSize(1000,1000);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(new Panel());



    }
    public static void main(String[] args) {
        new Frame();
    }
    void reSize() {
        this.setSize(Panel.y+100*5,Panel.x+100*5);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(Panel.appleX > Panel.x-Panel.spd && Panel.appleX <  Panel.x + Panel.spd && Panel.appleY < Panel.y + Panel.spd && Panel.appleY > Panel.y - Panel.spd) {
             if(Panel.size < 100) {
                 Panel.size += 20;
             } else {
                 if (Panel.spd < 30) {
                     Panel.spd++;
                  }
                 }
            Panel.appleGenerateScope = true;
        }

        System.out.println(Panel.x + ", " + Panel.appleX + ", " + Panel.y + ", " + Panel.appleY + ", " + Panel.spd + " ," + getWidth());
    }
}

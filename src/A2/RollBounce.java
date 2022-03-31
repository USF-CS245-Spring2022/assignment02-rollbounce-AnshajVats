package A2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Properties;
import java.util.Random;

public class RollBounce extends JPanel implements ActionListener {

    protected Timer tm;

    // TODO: Consider removing the next two lines (coordinates for two balls)
    protected int canvasWidth, canvasHeight;
    protected int radius;
    protected int gravity;
    protected int friction;
    protected ListNode ls;
    protected int balls;


    public RollBounce (String propertyFileName)  {
        // TODO: insert your code to read from configuration file here.
        try ( FileReader fr =new FileReader("RollBounce.prop")){
            Properties p = new Properties();
            p.load(fr);
            gravity = Integer.parseInt(p.getProperty("gravity"));
            friction = Integer.parseInt(p.getProperty("friction"));
            tm = new Timer( Integer.parseInt(p.getProperty("timerDelay")),this);
            canvasWidth = Integer.parseInt(p.getProperty("window_width"));
            canvasHeight = Integer.parseInt(p.getProperty("window_height"));
            radius = Integer.parseInt(p.getProperty("ball_radius"));
            balls =  Integer.parseInt(p.getProperty("balls"));
        }
        catch (IOException e) {
            System.out.println(e);
        }


         // TODO: Replace the first argument with delay with value from config file.
        Random rand = new Random();
        // TODO: Consider removing the next two lines (coordinates) for random starting locations.


        ls = new ListNode();
        for (int i = 0; i < balls ; i++) {


            int posX1 = rand.nextInt();
            int posY1 = rand.nextInt();
            int valX = rand.nextInt(0, 100);

            int valY = 0;
            BounceBalls bb = new BounceBalls(posX1, posY1, valX, valY, gravity, friction, canvasWidth, canvasHeight, radius);


            ls.add(bb);
            addColor(i);
        }
    }

    public void addColor(int i) {

        int r = (int)Math.round(Math.random() * 255);
        int bl = (int)Math.round(Math.random() * 255);
        int b = (int)Math.round(Math.random() * 255);

        Color col = new Color(r, bl, b);
        ls.get(i).setCol(col);
    }

        public void paintComponent(Graphics g) {
        super.paintComponent(g); // Probably best you leave this as is.

        // TODO: Paint each ball. Here's how to paint two balls, one after the other:
            for (int i = 0; i < ls.getSize(); i++) {
                g.setColor(ls.get(i).getCol());
                g.fillOval(ls.get(i).getPosX1(), ls.get(i).getPosY1(), 20, 20);
            }

        // Recommend you leave the next line as is
        tm.start();
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // TODO: Change the location of each ball. Here's an example of them moving across the screen:
        //       ... but to be clear, you should change this.
        for (int i = 0; i < ls.getSize(); i++) {
            ls.get(i).move();
        }



        // Keep this at the end of the function (no matter what you do above):
        repaint();
    }

    public static void main(String[] args) {
        RollBounce rb = new RollBounce(args[0]);

        JFrame jf = new JFrame();
        jf.setTitle("Roll Bounce");
        jf.setSize(rb.canvasWidth ,rb.canvasHeight);
        jf.add(rb);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


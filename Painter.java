// import java.awt.Color;
// import java.awt.Graphics;
// import java.awt.Graphics2D;
// import java.awt.Point;
import java.awt.*;
// import javax.swing.JComponent;
// import javax.swing.JFrame;
import javax.swing.*;

public class Painter extends JPanel {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Point ballPt = new Point(175, 0);  //%calculate from top left x and y :: ball location 5,2 at left top, 175,402 at middle bottom
    private Point ballSize = new Point(50,50);   //%ball radius size width and height
    private String height;
    private String velocity;
    private String energylost;
    private Boolean isEnd = false;
    private final double WINDOW_HEIGHT_OFFSET = 98;
    private final double WINDOW_WIDTH_OFFSET = 73;
    private JFrame window;
    
    public Painter(JFrame window) {
        this.window = window;
    }
    
    public void paintComponent(Graphics g) {
        //------gfx back buffer image for smoother graphics----
        /*removed back buffer for optimization. only drawing one object (the ball)
          so it doesnt make sense to render seperate frames.
          7/23/16               
        */
        
       // Image backBuffer = createImage(window.getWidth(), window.getHeight());
        Graphics2D g2 = (Graphics2D) g;//backBuffer.getGraphics();
         
        //---background--------
        g2.setColor(Color.black);
        g2.fillRect(0, 0, window.getWidth(), window.getHeight());
        
        //----------draw Ball-------
        g2.setColor(Color.blue);
        // g.fillOval(ballPt.x, ballPt.y, ballSize.x, ballSize.y);
        if(getEnd()==true){
            g2.fillOval(ballPt.x, ballPt.y, ballSize.x, ballSize.y);
        }else if (getBallLoc().x == 0){
            g2.fillOval(ballPt.x, ballPt.y, 20, ballSize.y);
        }else if(getBallLoc().x == window.getWidth() - WINDOW_WIDTH_OFFSET){
            g2.fillOval(ballPt.x, ballPt.y, 20, ballSize.y);
        }else if (getBallLoc().y == 0){
            g2.fillOval(ballPt.x, ballPt.y, ballSize.x, 20);
        }else if(getBallLoc().y >= window.getHeight() - WINDOW_HEIGHT_OFFSET+5){
            g2.fillOval(ballPt.x, ballPt.y, ballSize.x, 20);
        }else {
            g2.fillOval(ballPt.x, ballPt.y, ballSize.x, ballSize.y);
        }
   
        //----display ball information---
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Courier New", Font.PLAIN, 12));

        g2.drawString(height, 20, 30);
        g2.drawString(velocity, 20, 50);
        g2.drawString(energylost, 20, 70);
        
        System.out.println("Window height: "+ window.getHeight());
        System.out.println("Window width: "+ window.getWidth());
        System.out.println("Component height: "+ getHeight());
        System.out.println("Component width: "+ getWidth());
        System.out.println("Ball location: "+ getBallLoc());
        //g.drawImage(backBuffer, 0, 0, this); //update screen
    }
    public void setBallLoc(Point in){
        ballPt = in;
    }
    public void setBallLoc(int x, int y){
        ballPt.x = x;
        ballPt.y = y;
    }
    public void setBallSize(Point in){
        ballSize = in;
    }
    public Point getBallLoc(){
        return ballPt;
    }
    public Point getBallSize(){
        return ballSize;
    }
    public JFrame getWindow(){
        return window;
    }

    public void setHeight(Double label){
        height = "Height(m): " + String.format("%.2f", label);
    }
    public void setVelocity(Double label){
        velocity = "Velocity(m/s): " + String.format("%.2f", label);
    }
    public void setEnergyLost(Double string){
        energylost = "Energy Lost(m/s): " + String.format("%.2f", string);
    }
    public void setEnd (Boolean label){
        isEnd = label;
    }
    public Boolean getEnd (){
        return isEnd;
    }

}
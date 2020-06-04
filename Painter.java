
import java.awt.*;
import javax.swing.*;

public class Painter extends JPanel {
    

    private static final long serialVersionUID = 1L;
    private Point ballPt = new Point(175, 0);    // assign ball location at middle top
    private Point ballSize = new Point(50,50);   // set ball width and height
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
     
        Graphics2D g2 = (Graphics2D) g;
         
        //-----background setting------
        g2.setColor(Color.black);
        g2.fillRect(0, 0, window.getWidth(), window.getHeight());
        
        //-----draw Ball-------
        g2.setColor(Color.lightGray);

        //-----deformed------
        if(getEnd()==true){
            g2.fillOval(ballPt.x, ballPt.y, ballSize.x, ballSize.y);
        }else if (getBallLoc().x == 0){
            g2.fillOval(ballPt.x, ballPt.y, ballSize.x/2, ballSize.y);
        }else if(getBallLoc().x == window.getWidth() - WINDOW_WIDTH_OFFSET){
            g2.fillOval(ballPt.x, ballPt.y, ballSize.x/2, ballSize.y);
        }else if (getBallLoc().y == 0){
            g2.fillOval(ballPt.x, ballPt.y, ballSize.x, ballSize.y/2);
        }else if(getBallLoc().y == window.getHeight() - WINDOW_HEIGHT_OFFSET+5){
            g2.fillOval(ballPt.x, ballPt.y, ballSize.x, ballSize.y/2);
        }else {
            g2.fillOval(ballPt.x, ballPt.y, ballSize.x, ballSize.y);
        }

        //----display ball information---
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Courier New", Font.PLAIN, 12));

        g2.drawString(height, 20, 30);
        g2.drawString(velocity, 20, 50);
        g2.drawString(energylost, 20, 70);
        
        System.out.println("Ball location: "+ getBallLoc());
    }

    public void drawBallWithShader(Graphics grap, Color color, int x1, int y1, int w, int h){
        int intervals = Math.max(w, h); // number of interval from the color to white color
        // location of the light center
        int lightX1 = x1 + w * 3/10, lightY1 = y1 + h* 3/10, lightX2 = lightX1 + w/10, lightY2 = lightY1 + h/10;

        int x2 = x1 + w;
        int y2 = y1 + h;
        int cR = color.getRed(), cG = color.getGreen(), cB = color.getBlue();
        int wR = 255, wG = 255, wB = 255;

        // for each interval, we color the oval from outside to the light center, gradually changing the color to white
        for(int i = 0; i <= intervals; i++){
            // calculate the color for the current interval
            int r = cR + i * (wR - cR) / intervals, g = cG + i * (wG - cG) / intervals, b = cB + i * (wB - cB) / intervals;
            grap.setColor(new Color(r, g, b));

            // calculate the oval to fill for the current interval
            int newX1 = x1 + i * (lightX1 - x1) / intervals, newY1 = y1 + i * (lightY1 - y1) / intervals,
                    newX2 = x2 + i * (lightX2 - x2) / intervals, newY2 = y2 + i * (lightY2 - y2) / intervals;
            grap.fillOval(newX1, newY1, newX2 - newX1, newY2 - newY1);
        }
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
    public void setEnergyLost(Double label){
        energylost = "Energy Lost(m/s): " + String.format("%.2f", label);
    }
    public void setEnd (Boolean label){
        isEnd = label;
    }
    public Boolean getEnd (){
        return isEnd;
    }
    
}
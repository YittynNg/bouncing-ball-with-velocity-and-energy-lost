import javax.swing.JFrame;

public class Ball {
    static JFrame window = new JFrame("Ball");
    static Painter paint = new Painter(window);
    static Listener listen = new Listener(paint, window);
    
    public static void main(String[] args) {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(700, 200, 400, 500);  //container location x, container location y, width, height
        window.setResizable(true);
        
        window.addMouseListener(listen);
        window.addMouseMotionListener(listen);
        window.addComponentListener(listen);    
        window.add(paint);
    
        window.setVisible(true);
    }
}

import javax.swing.JFrame;

public class Main {
    static JFrame window = new JFrame("Ball");
    static Painter paint = new Painter(window);
    static Listener listen = new Listener(paint, window);
    
    public static void main(String[] args) {
        System.out.println("Window height: "+ window.getHeight());
        System.out.println("Window width: "+ window.getWidth());
        System.out.println("Component height: "+ paint.getHeight());
        System.out.println("Component width: "+ paint.getWidth());

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(800, 300, 400, 500);  // set window location x, window location y, window width, window height
        window.setResizable(true);             // window can be adjust 

        window.addMouseListener(listen);
        window.addMouseMotionListener(listen);
        window.addComponentListener(listen);    
        window.add(paint);                     // add UI design
        window.setVisible(true);

    }
}

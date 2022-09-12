package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;

public class KingFrame extends JFrame{
    public static int WIDTH=1008;
    public static int HEIGHT=1075;
    public KingFrame(String framename){
        super(framename);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1008, 1075);
        setResizable(false);
        add(new KingPanel());
        setVisible(true);
    }
    //public void componentResized(ComponentEvent e) {

    //componentResized(e);
      //  setSize(new Dimension(1000, getHeight()));
    //}
}

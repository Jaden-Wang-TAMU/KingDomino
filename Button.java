package Classes;

import java.awt.*;

public class Button {
    int x,y;
    int width, height;
    Rectangle rect;
    public Button(int x,int y){
        this.x=x;
        this.y=y;
        width=75;
        height=75;
        rect=new Rectangle(x,y,width,height);
    }
    public boolean contains(Point p){
        return rect.contains(p);
    }
}

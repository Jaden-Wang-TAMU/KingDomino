package Classes;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Painting {
    int sizeX;
    int sizeY;
    int placeX;
    int placeY;
    BufferedImage b;
    Color a;
    public Painting(int size1,int size2,int place1,int place2,BufferedImage bfrdr){
        sizeX=size1;
        sizeY=size2;
        placeX=place1;
        placeY=place2;
        this.a=null;
        this.b=bfrdr;
    }
    public Painting(int size1,int size2,int place1,int place2,Color col){
        sizeX=size1;
        sizeY=size2;
        placeX=place1;
        placeY=place2;
        this.a=col;
        this.b=null;
    }
    public int getSizeX(){
        return sizeX;
    }
    public int getSizeY(){
        return sizeY;
    }
    public int getPlaceX(){
        return placeX;
    }
    public int getPlaceY(){
        return placeY;
    }
    public BufferedImage getImage(){
        return b;
    }
    public Color getColor(){
        return a;
    }
}

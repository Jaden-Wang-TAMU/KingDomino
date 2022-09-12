package Classes;

import java.awt.*;
import java.awt.image.*;

public class Domino{
    private Tile tile1;
    private Tile tile2;
    private int value;
    private Player playerOwner;
    private BufferedImage front;
    private BufferedImage back;
    private Location location;
    private String rotate;
    public Domino(BufferedImage h)
    {
        tile1 = new Tile(h);
        tile2 = new Tile(h);
        value = 0;
        playerOwner =new Player();
        front = h;
        back = h;
        rotate="";
        location=new Location();
    }

    public Domino(Tile t1, Tile t2, int v, BufferedImage f, BufferedImage b)
    {
        tile1=t1;
        tile2=t2;
        value=v;
        playerOwner=new Player();
        front=f;
        back=b;
        rotate="";
        location=new Location();
    }

    public int getValue()
    {
        return value;
    }
    public void drawFront(Graphics g)
    {
        g.drawImage(front, location.getX(), location.getY(), 80,  40, null);
    }
    public void drawBack(Graphics g)
    {
        g.drawImage(back, location.getX(), location.getY(), 80, 40, null);
    }
    public void setPlayer(Player p)
    {
        playerOwner=p;
    }
    public Player getPlayer()
    {
        return playerOwner;
    }
    public boolean isClicked(Point p)
    {
        if(tile1.isClicked(p)||tile2.isClicked(p))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Tile getClickedTile(Point p)
    {
        if(tile1.isClicked(p))
        {
            return tile1;
        }
        else if(tile2.isClicked(p))
        {
            return tile2;
        }
        else
        {
            return null;
        }
    }

    public Tile getTile1()
    {
        return tile1;
    }

    public Tile getTile2()
    {
        return tile2;
    }

    public void setTile1(Tile t1)
    {
        tile1=t1;
    }

    public void setTile2(Tile t2)
    {
        tile2=t2;
    }

    public boolean equals(Domino d)
    {
        if(this.front==d.front)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String toString()
    {
        String s="Value: "+value+" LantTypes: "+tile1.getLandType()+" "+tile2.getLandType();
        return s;
    }

    public BufferedImage getFront()
    {
        return front;
    }

    public BufferedImage getBack()
    {
        return back;
    }
    public void setLocation(int x, int y)
    {
        location=new Location(x, y);
    }
    public int getX(){
        return location.getX();
    }
    public int getY(){
        return location.getY();
    }
    public void setRotate(String r)
    {
        rotate=r;
    }
    public String getRotate()
    {
        return rotate;
    }
    public Location getLocation()
    {
        return location;
    }
}


package Classes;

import java.awt.*;

public class Location {
    private Point p = new Point();
    private int gridX;//0-8
    private int gridY;//0-8
    private Rectangle space;//(X, Y, tileWidth, tileWidth);
    public Location()
    {
    	 p.x = -1;
         p.y = -1;
         gridX = -1;
         gridY = -1;
         space = new Rectangle(p.x,p.y, 39, 39);
    }
    
    public Location(int x, int y)//KingDomino location
	{
		p.x=x;
		p.y=y;
		gridX=4;//All kingTiles will have a grid X and Y at 4,4
		gridY=4;
		space=new Rectangle(x, y, 39, 39);//Add dimensions
	}
    public Location(int x, int y, int gridX, int gridY)
    {
        p.x=x;
        p.y=y;
        space=new Rectangle(x, y, 39, 39);
        this.gridX = gridX;
        this.gridY = gridY;
    }
    public void setLocation(int x, int y)
    { 
    	setX(x);
    	setY(y); 
    }
    public void setGridLocation(int x, int y)
    {
    	setGridX(x);
    	setGridY(y);
    }
    public void setX(int x) { p.x = x; }
    public void setY(int y) { p.y = y; }
    public int getX(){return p.x;}
    public int getY(){return p.y;}
    public void setGridX(int x) { gridX = x; }
    public void setGridY(int y) { gridY = y; }
    public int getGridX() { return gridX; }
    public int getGridY() { return gridY; }
    public Rectangle getRectangle(){return space;}
    public Boolean contains(Point p) { return(space.contains(p)); }
    public boolean equals(Location l)
	{
		if(this.p.x==l.p.x&&this.p.y==l.p.y&&this.gridX==l.gridX&&this.gridY==l.gridY)
			return true;
		else
			return false;
	}
}

package Classes;
import java.awt.Point;
import java.awt.image.*;

public class Tile {
	private int landType;
	private int numOfCrowns;
	private Location location;
	private Location proposedGridLocation;
	private boolean isPlaced;
	private boolean isScored;
	private boolean hasAdjacentChecked;
	private BufferedImage image;
	private String side;
	public Tile(BufferedImage h)
	{
		landType = -1;
    	numOfCrowns = 0;
    	location = new Location();
    	isPlaced = false;
    	isScored = false;
    	hasAdjacentChecked = false;
    	image=h;
    	side="";
	}
	public Tile(int l, int n, BufferedImage i, String s)//empty Tiles created with landType 7, for placing purposes
	{
		landType=l;
		numOfCrowns=n;
		location=new Location();
		isPlaced=false;
		isScored=false;
		hasAdjacentChecked=false;
		image=i;
		side=s;
	}
	
	public Tile(int x, int y, String s)
	{
		//King Tile
		landType=0;
		numOfCrowns=0;
		location=new Location(x, y, 4, 4);
		isPlaced=true;
		isScored=true;
		hasAdjacentChecked=true;
	}
	
	public void setLocation(Location l)
	{
		location=l;
	}
	
	public Location getLocation()
	{
		return location;
	}
	
	public boolean isClicked(Point p)
	{
		if (location.getRectangle().contains(p.getLocation()))
			return true;
		else
			return false;
	}
	
	public int getX()
	{
		return location.getX();
	}
	
	public int getY()
	{
		return location.getY();
	}
	
	public int getGridX()
	{
		return location.getGridX();
	}
	
	public int getGridY()
	{
		return location.getGridY();
	}
	
	public boolean isPlaced()
	{
		return isPlaced;
	}
	
	public int getLandType()
	{
		return landType;
	}
	
	public void setPlaced(boolean b)
	{
		isPlaced=b;
	}
	
	public Location getProposedLocation()
	{
		return proposedGridLocation;
	}
	
	public void setProposedLocation(Location l)
	{
		proposedGridLocation=l;
	}
	
	public void setIsScored(boolean b)
	{
		isScored=b;
	}
	
	public int getNumOfCrowns()
	{
		return numOfCrowns;
	}
	
	public void setHasAdjacentChecked(boolean b)
	{
		hasAdjacentChecked=b;
	}
	
	public boolean getHasAdjacentChecked()
	{
		return hasAdjacentChecked;
	}
	
	public boolean getIsScored()
	{
		return isScored;
	}
	
	public BufferedImage getImage()
	{
		return image;
	}
	
	public void setImage(BufferedImage i)
	{
		image=i;
	}
	
	public String getSide()
	{
		return side;
	}
}


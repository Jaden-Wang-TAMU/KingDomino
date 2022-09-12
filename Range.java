package Classes;

public class Range {
	private int minX;
	private int minY;
	private int maxX;
	private int maxY;
	public Range(int mx, int my, int mX, int mY)
	{
		minX=mx;
		minY=my;
		maxX=mX;
		maxY=mY;
	}
	public void setMinX(int mx)
	{
		minX=mx;
	}
	public void setMinY(int my)
	{
		minY=my;
	}
	public void setMaxX(int mX)
	{
		maxX=mX;
	}
	public void setMaxY(int mY)
	{
		maxY=mY;
	}
	
	public int getMinX()
	{
		return minX;
	}
	public int getMinY()
	{
		return minY;
	}
	public int getMaxX()
	{
		return maxX;
	}
	public int getMaxY()
	{
		return maxY;
	}
	public boolean contains(Location target)
	{
		if(target.getGridX()>=minX&&target.getGridX()<=maxX&&target.getGridY()>=minY&&target.getGridY()<=maxY)
			return true;
		else
			return false;	
	}
	public String toString()
	{
		return("minX: "+minX+", maxX: "+maxX+", minY: "+minY+", maxY:"+maxY);
	}
}

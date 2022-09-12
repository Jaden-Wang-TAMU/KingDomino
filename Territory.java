package Classes;
import java.util.ArrayList;
import java.util.Iterator;

public class Territory {
	private ArrayList<Tile> territoryDeck;
	private int numOfTiles;
	private int numOfCrowns;
	private boolean allAdjacentFound;
	private int landType;
	public Territory()
	{
		territoryDeck=new ArrayList<>();
		numOfTiles=0;
		numOfCrowns=0;
		allAdjacentFound=false;
		landType=0;
	}
	
	public void clear()
	{
		territoryDeck=new ArrayList<>();
		numOfTiles=0;
		numOfCrowns=0;
		allAdjacentFound=false;
		landType=0;
	}
	
	public void setLandType(int l)
	{
		landType=l;
	}
	
	public int getLandType()
	{
		return landType;
	}
	
	public void setNumOfTiles()
	{
		numOfTiles=territoryDeck.size();
	}
	
	public void add(Tile t)
	{
		territoryDeck.add(t);
	}
	
	public int getTerritoryScore()
	{
		setNumOfTiles();
		setNumOfCrowns();
		return numOfTiles*numOfCrowns;
	}
	
	public void setNumOfCrowns()
	{
		Iterator<Tile> ite=territoryDeck.iterator();
		int temp=0;
		while(ite.hasNext())
		{
			Tile t=ite.next();
			int crown=t.getNumOfCrowns();
			temp+=crown;
		}
		numOfCrowns=temp;
	}
	
	public boolean getAllAdjacentFound()
	{
		return allAdjacentFound;
	}
	
	public void setallAdjacentFound(boolean b)
	{
		allAdjacentFound=b;
	}
	
	public ArrayList<Tile> getTerritoryDeck()
	{
		return territoryDeck;
	}
	
	public int getNumOfTiles()
	{
		return numOfTiles;
	}
	public int getNumOfCrowns()
	{
		return numOfCrowns;
	}
}

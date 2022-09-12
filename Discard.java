package Classes;

import java.util.ArrayList;

public class Discard extends Button{
    public Discard(int x,int y){
        super(x,y);
    }
    public boolean discardDomino(Domino d){
        Player p=d.getPlayer();
        Grid g=p.getGrid();
        Range avail=g.getAvailableRange();
        if(!g.kingCovered()){
        	if((Math.abs(g.getKingdomRange().getMaxX()-g.getKingdomRange().getMinX())==4)&&(Math.abs(g.getKingdomRange().getMaxY()-g.getKingdomRange().getMinY())==4))
        	{
        		System.out.println("\n king is not covered and out of bounds");
        	}
        	else
        	{
        		System.out.println("\n king is not covered but in bounds");
        		return false;
        	}
        }
        //(avail.getMinX()==4&&avail.getMinY()==4)||(avail.getMaxX()==4&&avail.getMaxY()==4)
        Tile t1,t2;
        t1=d.getTile1();
        t2=d.getTile2();
        if(t1.isPlaced()||t2.isPlaced()){
        	System.out.println("\nA tile has been placed");
            return false;
        }
        /*for(int i=avail.getMinX();i<avail.getMaxX();i++){
            for(int j=avail.getMinY();j<avail.getMaxY();j++){
                if(g.getTile(i,j).getLandType()==t1.getLandType()){
                    ArrayList<Location> locArr=g.getAdjacentEmptyLocation(g.getTile(i,j).getLocation());
                    if(locArr!=null){
                        for(Location l:locArr){
                            ArrayList<Location> locArr2=g.getAdjacentEmptyLocation(l);
                            if(locArr2.size()>0){
                                //make sure to remove from currentDomino
                            	System.out.println("\nAdjacnet empty location with more adjacent empty locations for tile1");
                                return false;
                            }
                        }
                    }
                }
                if(g.getTile(i,j).getLandType()==t2.getLandType()){
                    ArrayList<Location> locArr=g.getAdjacentEmptyLocation(g.getTile(i,j).getLocation());
                    if(locArr.size()>0){
                        for(Location l:locArr){
                            ArrayList<Location> locArr2=g.getAdjacentEmptyLocation(l);
                            if(locArr2.size()>0){
                                //make sure to remove from currentDomino
                            	System.out.println("\nAdjacnet empty location with more adjacent empty locations for tile2");
                                return false;
                            }
                        }
                    }
                }
            }
        }*/
        boolean checking=true;
        for(Tile t: g.getGridDeck())
        {
        	if(t.getLandType()==t1.getLandType())
        	{
        		ArrayList<Location> locArr=g.getAdjacentEmptyLocation(t.getLocation());
        		if(locArr!=null)
        		{
	        		for(Location l:locArr)
	        		{
	        			ArrayList<Location> locArr2=g.getAdjacentEmptyLocation(l);
	        			if(locArr2!=null)
	        			{
	        				System.out.println("\nAdjacnet empty location with more adjacent empty locations for tile1");
	        				checking=false;
	        			}
	        		}
        		}
        	}
        	if(t.getLandType()==t2.getLandType())
        	{
        		ArrayList<Location> locArr=g.getAdjacentEmptyLocation(t.getLocation());
        		if(locArr!=null)
        		{
	        		for(Location l:locArr)
	        		{
	        			ArrayList<Location> locArr2=g.getAdjacentEmptyLocation(l);
	        			if(locArr2!=null)
	        			{
	        				System.out.println("\nAdjacnet empty location with more adjacent empty locations for tile1");
	        				checking=false;
	        			}
	        		}
        		}
        	}
        }
        //clear currentDomino and set boolean discarded to true, discardDeck is useless
        if(checking)
        {
        	System.out.println("\nNo adjacent empty locations with matching land type");
        }
        return checking;
    }
}

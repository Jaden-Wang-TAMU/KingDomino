package Classes;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.ListIterator;
import java.awt.*;
//GridY=new Grid(4, 4);
//GridB=new Grid(619, 4);
//GridG=new Grid(4, 529);
//GridR=new Grid(619, 529)
public class Grid {
    private ArrayList<Tile> gridDeck;
    private Deck dominoDeck;
    private Location[][] gridLocations;
    private Range kingdomRange;
    private Range availableRange;
    private Territory[][] allTerritories;
    private Rectangle space;
    private int score;
    private boolean gotMiddle;
    private boolean gotHarmony;
    private int treeScore;
    private int farmScore;
    private int seaScore;
    private int mineScore;
    private int wasteScore;
    private int meadowScore;
    public Grid()
    {
        gridDeck=new ArrayList<>();
        dominoDeck=new Deck();
        gridLocations=new Location[9][9];
        kingdomRange=new Range(4, 4, 4, 4);
        availableRange=new Range(3, 3, 5, 5);
        allTerritories=new Territory[9][9];
        space=new Rectangle(0, 0, 360, 360);
        score=0;
        gotMiddle=false;
        gotHarmony=false;
    }
    public Grid(int x, int y)
    {
        gridDeck=new ArrayList<>();
        gridDeck.add(new Tile(x+162, y+162, "king"));
        dominoDeck=new Deck();
        gridLocations=new Location[9][9];
        for(int i=0; i<gridLocations.length; i++)
        {
            for(int j=0; j<gridLocations[0].length; j++)
            {
                gridLocations[i][j]=new Location(x+40*i, y+40*j, i, j);
            }
        }
        kingdomRange=new Range(4, 4, 4, 4);
        availableRange=new Range(3, 3, 5, 5);
        allTerritories=new Territory[9][9];
        for(int i=0; i<allTerritories.length; i++)
        {
            for(int j=0; j<allTerritories[0].length; j++)
            {
                allTerritories[i][j]=new Territory();
            }
        }
        space=new Rectangle(x, y, 360, 360);
        score=0;
    }
    public Tile getTileByLocation(Location target)
    {
        Iterator<Tile> ite=gridDeck.iterator();
        while(ite.hasNext())
        {
            Tile t=ite.next();
            if(t.getLocation().equals(target))
                return t;
        }
        return null;
    }

    public void draw(Graphics g)
    {
        for (Domino d:dominoDeck.getDeck())
        {
            d.drawFront(g);
        }
    }

    public void setAvailableRange()
    {
        if(kingdomRange.getMaxX()-kingdomRange.getMinX()<4)
        {
            availableRange.setMinX(kingdomRange.getMinX()-1);
            availableRange.setMaxX(kingdomRange.getMaxX()+1);
        }
        else
        {
            availableRange.setMinX(kingdomRange.getMinX());
            availableRange.setMaxX(kingdomRange.getMaxX());
        }

        if(kingdomRange.getMaxY()-kingdomRange.getMinY()<4)
        {
            availableRange.setMinY(kingdomRange.getMinY()-1);
            availableRange.setMaxY(kingdomRange.getMaxY()+1);
        }
        else
        {
            availableRange.setMinY(kingdomRange.getMinY());
            availableRange.setMaxY(kingdomRange.getMaxY());
        }
    }

    public Range getAvailableRange()
    {
        return availableRange;
    }

    public void setKingdomRange()
    {
        Iterator<Tile> ite=gridDeck.iterator();
        Tile first=ite.next();
        int minX=first.getGridX();
        int maxX=first.getGridX();
        int minY=first.getGridY();
        int maxY=first.getGridY();
        while(ite.hasNext())
        {
            Tile next=ite.next();
            int currX=next.getGridX();
            int currY=next.getGridY();

            if(currX<minX)
            {
                minX=currX;
            }

            if(currX>maxX)
            {
                maxX=currX;
            }

            if(currY<minY)
            {
                minY=currY;
            }

            if(currY>maxY)
            {
                maxY=currY;
            }
        }

        kingdomRange.setMinX(minX);
        kingdomRange.setMaxX(maxX);
        kingdomRange.setMinY(minY);
        kingdomRange.setMaxY(maxY);
        setAvailableRange();
    }

    public Range getKingdomRange()
    {
        return kingdomRange;
    }

    public ArrayList<Location> getAdjacentLocations(Location target)
    {
        ArrayList<Location> locs=new ArrayList<>();
        int gX=target.getGridX();
        int gY=target.getGridY();
        //System.out.println("gx-1="+(gX-1)+" availableRange.getMinX() gx-1>=availableRange.getMinX()"+((gX-1)>=availableRange.getMinX()));
        if(gX-1>=availableRange.getMinX())
        {
            Location left=new Location(0, 0, gX-1, gY);
            locs.add(left);
            //System.out.println("added "+(gX-1)+" "+gY);
        }

        if(gX+1<=availableRange.getMaxX())
        {
            Location right=new Location(0, 0, gX+1, gY);
            locs.add(right);
            //System.out.println("added "+(gX+1)+" "+gY);
        }

        if(gY-1>=availableRange.getMinY())
        {
            Location up=new Location(0, 0, gX, gY-1);
            locs.add(up);
            //System.out.println("added "+gX+" "+(gY-1));
        }

        if(gY+1<=availableRange.getMaxY())
        {
            Location down=new Location(0, 0, gX, gY+1);
            locs.add(down);
            //System.out.println("added "+gX+" "+(gY+1));
        }
        return locs;
    }

    public ArrayList<Tile> getAdjacentTiles(Location target)
    {
        //System.out.println("Getting adjacent Tiles");
        ArrayList<Tile> tiles=new ArrayList<>();
        ArrayList<Location> locs=getAdjacentLocations(target);
        for(Location l: locs)
        {
            int lX=l.getGridX();
            int lY=l.getGridY();
            for(Tile t: gridDeck)
            {
                int gX=t.getLocation().getGridX();
                int gY=t.getLocation().getGridY();
                if(lX==gX && lY==gY)
                {
                    tiles.add(t);
                }
            }
        }
        if(tiles.size()>0)
            return tiles;
        else
            return null;
    }

    public ArrayList<Location> getAdjacentEmptyLocation(Location target)
    {
        ArrayList<Location> locs=getAdjacentLocations(target);
        ArrayList<Location> fin=new ArrayList<>();

        for(Location l: locs)
        {
            int lX=l.getGridX();
            int lY=l.getGridY();
            boolean notFound=true;
            for(Tile t: gridDeck)
            {
                int gX=t.getLocation().getGridX();
                int gY=t.getLocation().getGridY();
                if(lX==gX && lY==gY && (!(gX==4&&gY==4)))
                {
                    notFound=false;
                }
            }
            if(notFound&&!(l.getGridX()==4&&l.getGridY()==4))
            {
                fin.add(l);
            }
        }

        if(fin.size()>0)
        {
            return fin;
        }
        else
            return null;
    }

    //isValid will now return integer in order to change ErrorMessage accordingly. If return 0, treat as true;
    //every other number will dictate what ErrorMessage should be
    public int isValidLocation(Tile Tile1, Location target)
    {
        //System.out.println("1st target: "+target.getGridX()+" "+target.getGridY());
        //check if either one of domino's tiles are placed yet, will have to do this in game state
        //also set ErrorMessage to True;
        if(getTileByLocation(target)!=null)
        {
            //System.out.println(printGridDeck());
            return 1;
        }
        else
        {
            Range r=getAvailableRange();
            if(!r.contains(target))
            {
                return 2;
            }
            else
            {
                ArrayList<Tile> aT=getAdjacentTiles(target);
                if(aT!=null)
                {

                    boolean match=false;
                    for(Tile t:aT)
                    {
                        if(t.getLandType()==Tile1.getLandType()||t.getLandType()==0)
                        {
                            match=true;
                        }
                    }
                    if(match)
                    {
                        ArrayList<Location> eL=getAdjacentEmptyLocation(target);
                        System.out.println("Printing the adjacent empty locations:");

                        if(eL==null)
                        {
                            return 4;
                        }
                        else
                        {
                            for(Location l:eL)
                            {
                                System.out.println(l.getGridX()+" "+l.getGridY());
                            }
                            return 0;
                        }
                    }
                    else
                    {
                        //System.out.println("No matching tiles found, Tiles found: ");
                    	/*for(int i=0; i<aT.size(); i++)
                        {
                            System.out.println("Adjacent Tile "+aT.get(i).getGridX()+" "+aT.get(i).getGridY()+" "+aT.get(i).getLandType());
                        }*/
                        return 3;
                    }
                }
                else
                {
                    //System.out.println("no adjacentTiles Found");
                    return 5;
                }
            }
        }
    }

    public int isValidLocation(Tile Tile1, Tile Tile2, Location target)
    {
        //System.out.println("2nd Target: "+target.getGridX()+" "+target.getGridY());
        if(getTileByLocation(target)!=null)
            return 1;
        else
        {
            Range r=getAvailableRange();
            if(!r.contains(target))
            {
                return 2;
            }
            else
            {
                ArrayList<Location> aT=getAdjacentEmptyLocation(Tile1.getLocation());
                /*if(aT!=null)
                {
                    System.out.println("Printing Adjacent Empty Locations!");
                    for(int i=0; i<aT.size(); i++)
                    {
                        System.out.println("Adjacent Empty Location "+aT.get(i).getGridX()+" "+aT.get(i).getGridY());
                    }
                }
                else
                {
                    System.out.println("aT is null");
                }*/
                boolean match=false;
                if(aT!=null)
                {
                    for(Location l:aT)
                    {
                        if(l.getGridX()==target.getGridX()&&l.getGridY()==target.getGridY())
                        {
                            match=true;
                        }
                    }
                }
                if(match)
                {
					/*Tile2.setPlaced(true);
					Tile2.setLocation(Tile2.getProposedLocation());
					gridDeck.add(Tile2);
					setKingdomRange();*/
                    return 0;
                }
                else
                    return 6;
            }
        }
    }

    public Tile getTile(int x, int y)
    {
        Location l=gridLocations[x][y];
        Tile t=getTileByLocation(l);
        return t;
    }

    public boolean kingCovered()
    {
        Tile t1=getTile(3, 4);
        Tile t2=getTile(4, 3);
        Tile t3=getTile(4, 5);
        Tile t4=getTile(5, 4);
        if(!(t1==null)&&!(t2==null)&&!(t3==null)&&!(t4==null))
        {
            //System.out.println(t1.getLandType()+"\n"+t2.getLandType()+"\n"+t3.getLandType()+"\n"+t4.getLandType());
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean contains(Point p)
    {
        return space.contains(p);
    }

    public int score()
    {
        int score=0;
        Iterator<Tile> iteG=gridDeck.iterator();
        while(iteG.hasNext())
        {
            Tile currentTile=iteG.next();

            if(currentTile.getIsScored()==false)
            {
                currentTile.setIsScored(true);
                int x=currentTile.getGridX();
                int y=currentTile.getGridY();
                Territory currentTerritory=allTerritories[x][y];
                currentTerritory.add(currentTile);
                //System.out.println("addedCurrentTile "+currentTile.getLandType()+" to Territory at "+x+", "+y);
                currentTerritory.setLandType(currentTile.getLandType());
                while(!currentTerritory.getAllAdjacentFound())
                {
                    currentTerritory.setallAdjacentFound(true);
                    ArrayList<Tile> teList=currentTerritory.getTerritoryDeck();
                    ListIterator<Tile> iteT=teList.listIterator();
                    while(iteT.hasNext())
                    {
                        Tile ogTerritoryTile=iteT.next();
                        if(!ogTerritoryTile.getHasAdjacentChecked())
                        {
                            ArrayList<Tile> adj=getAdjacentTiles(ogTerritoryTile.getLocation());
                            if(adj!=null)
                            {
                                for(Tile territoryTile:adj)
                                {
                                    if(territoryTile.getLandType()==ogTerritoryTile.getLandType()&&territoryTile.getIsScored()==false)
                                    {
                                        territoryTile.setIsScored(true);
                                        iteT.add(territoryTile);
                                        currentTerritory.setallAdjacentFound(false);
                                    }
                                }
                            }
                        }
                        ogTerritoryTile.setHasAdjacentChecked(true);
                    }
                }
                currentTerritory.setNumOfTiles();
                score+=currentTerritory.getTerritoryScore();
                currentTile.setHasAdjacentChecked(true);
            }
        }
        getTotalTerritoryScore(1);
        getTotalTerritoryScore(2);
        getTotalTerritoryScore(3);
        getTotalTerritoryScore(4);
        getTotalTerritoryScore(5);
        getTotalTerritoryScore(6);
        this.score=score;
        this.score+=harmony();
        this.score+=middle();
        for(int i=0; i<allTerritories.length; i++)
        {
            for(int j=0; j<allTerritories[i].length; j++)
            {
                if(allTerritories[i][j].getNumOfTiles()>0)
                {
                    System.out.println("Territory number:"+i+", "+j+", landType: "+allTerritories[i][j].getLandType()+", size "+allTerritories[i][j].getNumOfTiles()+" crowns: "+allTerritories[i][j].getNumOfCrowns()+", score: "+allTerritories[i][j].getTerritoryScore());
                    allTerritories[i][j].clear();
                }
            }
        }

        System.out.println("Player's score: "+this.score);
        Iterator<Tile> iteG2=gridDeck.iterator();
        while(iteG2.hasNext())
        {
            Tile t=iteG2.next();
            t.setHasAdjacentChecked(false);
            t.setIsScored(false);
        }
        return this.score;
    }

    public void setScore(int s)
    {
        score=s;
    }

    public int getTotalTerritoryScore(int x)
    {
        int tot=0;
        for(int i=0; i<allTerritories.length; i++)
        {
            for(int j=0; j<allTerritories[i].length; j++)
            {
                if(allTerritories[i][j].getLandType()==x)
                {
                    tot+=allTerritories[i][j].getTerritoryScore();
                }
            }
        }
        if(tot!=0)
        {
            if(x==1)
                treeScore=tot;
            if(x==2)
                farmScore=tot;
            if(x==3)
                seaScore=tot;
            if(x==4)
                mineScore=tot;
            if(x==5)
                wasteScore=tot;
            if(x==6)
                meadowScore=tot;
        }
        return tot;
    }

    public int getTreeScore()
    {
        return treeScore;
    }

    public int getFarmScore()
    {
        return farmScore;
    }

    public int getSeaScore()
    {
        return seaScore;
    }

    public int getMineScore()
    {
        return mineScore;
    }

    public int getWasteScore()
    {
        return wasteScore;
    }

    public int getMeadowScore()
    {
        return meadowScore;
    }

    public int getBiggestTerritorySize()
    {
        int big=0;
        for(int i=0; i<allTerritories.length; i++)
        {
            for(int j=0; j<allTerritories[i].length; j++)
            {
                int curr=allTerritories[i][j].getNumOfTiles();
                if(big<curr)
                {
                    big=curr;
                }
            }
        }
        return big;
    }

    public int getScore()
    {
        return score;
    }

    public ArrayList<Tile> getGridDeck()
    {
        return gridDeck;
    }

    public Location[][] getGridLocations()
    {
        return gridLocations;
    }

    public String printLocations()
    {
        String s="";
        for(int i=0; i<gridLocations.length; i++)
        {
            for(int y=0; y<gridLocations[i].length; y++)
            {
                s+="Grid Location: "+gridLocations[i][y].getX()+" "+gridLocations[i][y].getY()+" ";
            }
            s+="\n";
        }
        return s;
    }

    public String printGridDeck()
    {
        String s="";
        for(int i=0; i<gridDeck.size(); i++) {
            String temp="Land Type:"+gridDeck.get(i).getLandType()+", gridX: "+gridDeck.get(i).getGridX()+", gridY: "+gridDeck.get(i).getGridY();
            s+=temp;
        }

        return s;
    }
    public Tile getTileByGrids(int i, int j)
    {
        Iterator<Tile> ite=gridDeck.iterator();
        while(ite.hasNext())
        {
            Tile t=ite.next();
            if(t.getLocation().getGridX()==i&&t.getLocation().getGridY()==j)
            {
                return t;
            }
        }
        return null;
    }
    public int harmony()
    {
        if(gridDeck.size()==25)
        {
            if(Math.abs(kingdomRange.getMaxX()-kingdomRange.getMinX())==4&&Math.abs(kingdomRange.getMaxY()-kingdomRange.getMinY())==4)
            {
                boolean noGaps=true;
                for(int i=kingdomRange.getMinX(); i<kingdomRange.getMaxX(); i++)
                {
                    for(int j=kingdomRange.getMinY(); j<kingdomRange.getMaxY(); j++)
                    {
                        Tile t=getTileByGrids(i, j);
                        if(t==null)
                        {
                            noGaps=false;
                        }
                    }
                }
                if(noGaps)
                {
                    System.out.println("\nPlayer got harmony");
                    gotHarmony=true;
                    return 5;
                }
            }
        }
        System.out.println("\nPlayer did not get harmony");
        gotHarmony=false;
        return 0;
    }
    public int middle()
    {
        double i=(kingdomRange.getMinX()+kingdomRange.getMaxX());
        double y=(kingdomRange.getMinY()+kingdomRange.getMaxY());
        System.out.println("\n    i and y: "+i+" "+y);
        i=i/2;
        y=y/2;
        System.out.println("\n    new i and y: "+i+" "+y);
        if(i==4&&y==4)
        {
            System.out.println("\nPlayer got middle");
            gotMiddle=true;
            return 10;
        }
        else
        {
            System.out.println("average: "+i+", "+y);
        }
        System.out.println("\nPlayer did not get middle");
        gotMiddle=false;
        return 0;
    }
    public void addTile(Tile t)
    {
        gridDeck.add(t);
    }
    public void addDomino(Domino d){
        dominoDeck.add(d);
    }
    public Deck getDominoDeck(){
        return dominoDeck;
    }
    public boolean gotHarmony()
    {
        return gotHarmony;
    }
    public boolean gotMiddle()
    {
        return gotMiddle;
    }
}

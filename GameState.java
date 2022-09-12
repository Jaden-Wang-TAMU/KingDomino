package Classes;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Random;

public class GameState {
    private boolean allowChoosing;//
    private boolean allowEnding;//
    private boolean allowPlacing;//
    private boolean allowPlace1;
    private boolean allowPlace2;
    private String errorMessage;//
    private String prompt;//
    private int chosenDomino;//
    private Domino currentDomino;//
    private Tile currentTile;//
    private Deck optionDeck;//
    private Iterator optionIter;//to iterate through optionDeck in order
    private Deck nextRoundDeck;//
    private Iterator nextRoundIter;//
    private Player currentPlayer;//
    private ArrayList<Player> allPlayers;//
    private Player playerY;//
    private Player playerB;//
    private Player playerG;//
    private Player playerR;//

    private boolean isFirstRound;//
    private boolean isLastRound;//
    private int roundCount;//
    private Location[] highlightLocations;//
    private Deck mainDeck;//
    private BufferedImage holder;//
    private int playerTurnCounter;
    public GameState() {
        allowChoosing = true;
        allowEnding = false;
        allowPlacing = false;
        allowPlace1=false;
        allowPlace2=false;
        errorMessage = "";
        prompt = "";
        chosenDomino = 4;
        try {
            holder = ImageIO.read(KingPanel.class.getResource("/Images/DominoFront1.png"));
        } catch (Exception e) {
            System.out.print(e);
            System.out.println(" in gameState");
        }
        currentDomino = new Domino(holder);
        optionDeck = new Deck();
        nextRoundDeck = new Deck();
        optionIter = optionDeck.getDeck().iterator();
        nextRoundIter = nextRoundDeck.getDeck().iterator();
        playerY = new Player("Yellow", 6, 6);
        System.out.println("\nPlayerY Grid: "+playerY.getGrid().printLocations());

        playerB = new Player("Blue", 621, 6);
        System.out.println("PlayerB Grid: "+playerB.getGrid().printLocations());
        
        playerG = new Player("Green", 6, 531);
        System.out.println("PlayerG Grid: "+playerG.getGrid().printLocations());
        
        playerR = new Player("Red", 621, 531);
        System.out.println("PlayerR Grid: "+playerR.getGrid().printLocations());
        
        currentPlayer = new Player();
        allPlayers = new ArrayList<>();
        isFirstRound = true;
        isLastRound = false;
        roundCount = 1;
        highlightLocations = new Location[2];
        mainDeck = new Deck();
        playerTurnCounter = 0;
        try {
            for (int i = 1; i < 49; i++) {
                String f = "/Images/DominoFront" + i + ".png";
                BufferedImage front = ImageIO.read(KingPanel.class.getResource(f));
                String b = "/Images/DominoBack" + i + ".png";
                BufferedImage back = ImageIO.read(KingPanel.class.getResource(b));
                Tile t1 = new Tile(holder);
                Tile t2 = new Tile(holder);
                Domino dom = new Domino(t1, t2, i, front, back);
                mainDeck.add(dom);
            }
            currentTile=new Tile(holder);
        } catch (Exception e) {
            System.out.print(e);
            System.out.println(" in gameState");
        }
        {
            ArrayList<Tile> tile1s = new ArrayList<>();
            ArrayList<Tile> tile2s = new ArrayList<>();
            Tile t1_1 = new Tile(1, 0, holder, "left");
            tile1s.add(t1_1);
            Tile t2_1 = new Tile(1, 0, holder, "right");
            tile2s.add(t2_1);

            Tile t1_2 = new Tile(1, 0, holder, "left");
            tile1s.add(t1_2);
            Tile t2_2 = new Tile(1, 0, holder, "right");
            tile2s.add(t2_2);

            Tile t1_3 = new Tile(2, 0, holder, "left");
            tile1s.add(t1_3);
            Tile t2_3 = new Tile(2, 0, holder, "right");
            tile2s.add(t2_3);

            Tile t1_4 = new Tile(2, 0, holder, "left");
            tile1s.add(t1_4);
            Tile t2_4 = new Tile(2, 0, holder, "right");
            tile2s.add(t2_4);

            Tile t1_5 = new Tile(3, 0, holder, "left");
            tile1s.add(t1_5);
            Tile t2_5 = new Tile(3, 0, holder, "right");
            tile2s.add(t2_5);

            Tile t1_6 = new Tile(3, 0, holder, "left");
            tile1s.add(t1_6);
            Tile t2_6 = new Tile(3, 0, holder, "right");
            tile2s.add(t2_6);

            Tile t1_7 = new Tile(1, 0, holder, "left");
            tile1s.add(t1_7);
            Tile t2_7 = new Tile(1, 0, holder, "right");
            tile2s.add(t2_7);

            Tile t1_8 = new Tile(1, 0, holder, "left");
            tile1s.add(t1_8);
            Tile t2_8 = new Tile(1, 0, holder, "right");
            tile2s.add(t2_8);

            Tile t1_9 = new Tile(5, 0, holder, "left");
            tile1s.add(t1_9);
            Tile t2_9 = new Tile(5, 0, holder, "right");
            tile2s.add(t2_9);

            Tile t1_10 = new Tile(6, 0, holder, "left");
            tile1s.add(t1_10);
            Tile t2_10 = new Tile(6, 0, holder, "right");
            tile2s.add(t2_10);

            Tile t1_11 = new Tile(6, 0, holder, "left");
            tile1s.add(t1_11);
            Tile t2_11 = new Tile(6, 0, holder, "right");
            tile2s.add(t2_11);

            Tile t1_12 = new Tile(3, 0, holder, "left");
            tile1s.add(t1_12);
            Tile t2_12 = new Tile(3, 0, holder, "right");
            tile2s.add(t2_12);

            Tile t1_13 = new Tile(2, 0, holder, "left");
            tile1s.add(t1_13);
            Tile t2_13 = new Tile(5, 0, holder, "right");
            tile2s.add(t2_13);

            Tile t1_14 = new Tile(2, 0, holder, "left");
            tile1s.add(t1_14);
            Tile t2_14 = new Tile(6, 0, holder, "right");
            tile2s.add(t2_14);

            Tile t1_15 = new Tile(2, 0, holder, "left");
            tile1s.add(t1_15);
            Tile t2_15 = new Tile(3, 0, holder, "right");
            tile2s.add(t2_15);

            Tile t1_16 = new Tile(2, 0, holder, "left");
            tile1s.add(t1_16);
            Tile t2_16 = new Tile(1, 0, holder, "right");
            tile2s.add(t2_16);

            Tile t1_17 = new Tile(2, 1, holder, "left");
            tile1s.add(t1_17);
            Tile t2_17 = new Tile(3, 0, holder, "right");
            tile2s.add(t2_17);

            Tile t1_18 = new Tile(2, 1, holder, "left");
            tile1s.add(t1_18);
            Tile t2_18 = new Tile(1, 0, holder, "right");
            tile2s.add(t2_18);

            Tile t1_19 = new Tile(1, 0, holder, "left");
            tile1s.add(t1_19);
            Tile t2_19 = new Tile(6, 0, holder, "right");
            tile2s.add(t2_19);

            Tile t1_20 = new Tile(1, 0, holder, "left");
            tile1s.add(t1_20);
            Tile t2_20 = new Tile(3, 0, holder, "right");
            tile2s.add(t2_20);

            Tile t1_21 = new Tile(1, 1, holder, "left");
            tile1s.add(t1_21);
            Tile t2_21 = new Tile(2, 0, holder, "right");
            tile2s.add(t2_21);

            Tile t1_22 = new Tile(2, 1, holder, "left");
            tile1s.add(t1_22);
            Tile t2_22 = new Tile(4, 0, holder, "right");
            tile2s.add(t2_22);

            Tile t1_23 = new Tile(2, 1, holder, "left");
            tile1s.add(t1_23);
            Tile t2_23 = new Tile(5, 0, holder, "right");
            tile2s.add(t2_23);

            Tile t1_24 = new Tile(2, 1, holder, "left");
            tile1s.add(t1_24);
            Tile t2_24 = new Tile(6, 0, holder, "right");
            tile2s.add(t2_24);

            Tile t1_25 = new Tile(1, 1, holder, "left");
            tile1s.add(t1_25);
            Tile t2_25 = new Tile(3, 0, holder, "right");
            tile2s.add(t2_25);

            Tile t1_26 = new Tile(1, 1, holder, "left");
            tile1s.add(t1_26);
            Tile t2_26 = new Tile(2, 0, holder, "right");
            tile2s.add(t2_26);

            Tile t1_27 = new Tile(1, 1, holder, "left");
            tile1s.add(t1_27);
            Tile t2_27 = new Tile(2, 0, holder, "right");
            tile2s.add(t2_27);

            Tile t1_28 = new Tile(1, 1, holder, "left");
            tile1s.add(t1_28);
            Tile t2_28 = new Tile(2, 0, holder, "right");
            tile2s.add(t2_28);

            Tile t1_29 = new Tile(3, 1, holder, "left");
            tile1s.add(t1_29);
            Tile t2_29 = new Tile(1, 0, holder, "right");
            tile2s.add(t2_29);

            Tile t1_30 = new Tile(3, 1, holder, "left");
            tile1s.add(t1_30);
            Tile t2_30 = new Tile(2, 0, holder, "right");
            tile2s.add(t2_30);

            Tile t1_31 = new Tile(3, 1, holder, "left");
            tile1s.add(t1_31);
            Tile t2_31 = new Tile(2, 0, holder, "right");
            tile2s.add(t2_31);

            Tile t1_32 = new Tile(1, 1, holder, "left");
            tile1s.add(t1_32);
            Tile t2_32 = new Tile(6, 0, holder, "right");
            tile2s.add(t2_32);

            Tile t1_33 = new Tile(2, 0, holder, "left");
            tile1s.add(t1_33);
            Tile t2_33 = new Tile(6, 1, holder, "right");
            tile2s.add(t2_33);

            Tile t1_34 = new Tile(3, 1, holder, "left");
            tile1s.add(t1_34);
            Tile t2_34 = new Tile(1, 0, holder, "right");
            tile2s.add(t2_34);

            Tile t1_35 = new Tile(3, 1, holder, "left");
            tile1s.add(t1_35);
            Tile t2_35 = new Tile(1, 0, holder, "right");
            tile2s.add(t2_35);

            Tile t1_36 = new Tile(3, 1, holder, "left");
            tile1s.add(t1_36);
            Tile t2_36 = new Tile(1, 0, holder, "right");
            tile2s.add(t2_36);

            Tile t1_37 = new Tile(4, 1, holder, "left");
            tile1s.add(t1_37);
            Tile t2_37 = new Tile(2, 0, holder, "right");
            tile2s.add(t2_37);

            Tile t1_38 = new Tile(6, 0, holder, "left");
            tile1s.add(t1_38);
            Tile t2_38 = new Tile(5, 1, holder, "right");
            tile2s.add(t2_38);

            Tile t1_39 = new Tile(2, 0, holder, "left");
            tile1s.add(t1_39);
            Tile t2_39 = new Tile(5, 1, holder, "right");
            tile2s.add(t2_39);

            Tile t1_40 = new Tile(3, 0, holder, "left");
            tile1s.add(t1_40);
            Tile t2_40 = new Tile(6, 1, holder, "right");
            tile2s.add(t2_40);

            Tile t1_41 = new Tile(6, 0, holder, "left");
            tile1s.add(t1_41);
            Tile t2_41 = new Tile(5, 2, holder, "right");
            tile2s.add(t2_41);

            Tile t1_42 = new Tile(2, 0, holder, "left");
            tile1s.add(t1_42);
            Tile t2_42 = new Tile(5, 2, holder, "right");
            tile2s.add(t2_42);

            Tile t1_43 = new Tile(3, 0, holder, "left");
            tile1s.add(t1_43);
            Tile t2_43 = new Tile(6, 2, holder, "right");
            tile2s.add(t2_43);

            Tile t1_44 = new Tile(2, 0, holder, "left");
            tile1s.add(t1_44);
            Tile t2_44 = new Tile(6, 2, holder, "right");
            tile2s.add(t2_44);

            Tile t1_45 = new Tile(2, 0, holder, "left");
            tile1s.add(t1_45);
            Tile t2_45 = new Tile(4, 3, holder, "right");
            tile2s.add(t2_45);

            Tile t1_46 = new Tile(5, 0, holder, "left");
            tile1s.add(t1_46);
            Tile t2_46 = new Tile(4, 2, holder, "right");
            tile2s.add(t2_46);

            Tile t1_47 = new Tile(5, 0, holder, "left");
            tile1s.add(t1_47);
            Tile t2_47 = new Tile(4, 2, holder, "right");
            tile2s.add(t2_47);

            Tile t1_48 = new Tile(4, 2, holder, "left");
            tile1s.add(t1_48);
            Tile t2_48 = new Tile(2, 0, holder, "right");
            tile2s.add(t2_48);

            for (int i = 0; i < 48; i++) {
                tile1s.get(i).setImage(mainDeck.getDeck().get(i).getFront().getSubimage(0, 0, mainDeck.getDeck().get(i).getFront().getWidth() / 2, mainDeck.getDeck().get(i).getFront().getHeight()));
                tile2s.get(i).setImage(mainDeck.getDeck().get(i).getFront().getSubimage(mainDeck.getDeck().get(i).getFront().getWidth() / 2, 0, mainDeck.getDeck().get(i).getFront().getWidth() / 2, mainDeck.getDeck().get(i).getFront().getHeight()));
                mainDeck.getDeck().get(i).setTile1(tile1s.get(i));
                mainDeck.getDeck().get(i).setTile2(tile2s.get(i));
            }

        }

        //Trees=1;
        //Farms=2;
        //Sea=3;
        //Mines=4;
        //Wasteland=5
        //Meadows=6
        //new Tile(int landType, int numOfCrowns)

        //player1=yellow
        //player2=blue
        //player3=green
        //player4=red
        int randValue = (int)(Math.random()*1000000000+1);
        randomizeOrder(randValue);

        mainDeck.Shuffle();
        //getting top 4 dominoes from mainDeck and putting into optionDeck
        for (int i = 0; i < 4; i++) {
            optionDeck.add(mainDeck.getDeck().get(0));
            mainDeck.getDeck().remove(0);
        }

        //getting next 4 dominoes from mainDeck and putting into nextRoundDeck
        for (int i = 0; i < 4; i++) {
            nextRoundDeck.add(mainDeck.getDeck().get(0));
            mainDeck.getDeck().remove(0);
        }

        prompt = "Choose domino";
        optionDeck.sort();
        nextRoundDeck.sort();
        {
            //set currentDomino to optionIter.next, set discarded to true after discard has been placed

            //before calling isValidLocation(Tile tile1), check if either tiles have been placed yet, set ErrorMessage to "";
            //before calling isValidLocation(Tile tile1, Tile tile2), check which tile has been placed and pass in that one as tile1, set ErrorMessage to "";
            //Location(int x, int y) is used for creating locations for king
            //Location(int x, int y, int gridX, int gridY) is used for creating other locations
            //Tile(int x, int y) is used for creating King Tile;
            //Tile(int l, int n, int x, int y) is used for creating other tiles, empty tiles will be created with landType(l) as 7

            //isValidLocation(Tile1, target) integer key:
            //0=true, clear ErrorMessage
            //1=chosen filled location, set ErrorMessage to "Not Empty Location"
            //2=outside of availableRange, set ErrorMessage to "Outside of Kingdom"
            //3=no matching landType, set ErrorMessage to "No Matching Land"
            //4=no empty adjacent locations to "Not enough room for Domino"
            //5=no adjacent Tiles at all, set ErrorMessage to "No adjacent Tiles"

            //isValidLocation(Tile1, Tile2, target) integer key:
            //0=true, clear ErrorMessage
            //1=chosen filled location, set ErrorMessage to "Not Empty Location"
            //2=outside of availableRange, set ErrorMessage to "Outside of Kingdom"
            //3=chosen location is not adjacent to first tile, set ErrorMessage to "Not Next to First Tile"

            //Before calling Place button's placeTile, call isValidLocation and pass in the returned int.
            //One done calling placeTile, check if curretDomino's tiles are both placed, if true set bothPlaced=true, add currentDomino to currentPlayer’s grid’s dominoDeck;

            //After calling Discard button's discard, clear currentDomino and set discarded to true.

            //Must program Highlight Location

            //Call Choose’s allowChoosing when choose is clicked and if true start:, player will click on a domino in nextRoundDeck/Domino Queue. chosenDomino will be set to that selected domino.
//Once chooseButton is clicked(we will use contains to find this out), we will iterate through nextRoundDeck/Domino Queue, find the one that matches chosenDomino, and set that one’s player to currentPlayer.
//That way, when we move all dominoes in nextRoundDeck/Domino Queue to optionDeck/Dominoes in Play, the dominoes will already have their owners assigned.

            //Call End’s allowEndTurn when endTurn is clicked and if true start:, player will click on EndTurn. We will call optionIter.next and get the next domino in optionDeck and set currentPlayer to that domino’s player. If !(optionIter.hasNext()), clear optionDeck. Using nextRoundIter, add each domino in nextRoundDeck to optinoDeck retaining the order. Clear nextRoundDeck, add the next 4 dominoes in mainDeck to nextRoundDeck. Restart optionIter and call optionIter.next() to get the first domino. Assign currentDomino to that first domino and assign currentPlayer to that domino’s player.

//Check if player is interacting with domino that does not belong to them.
        }
    }
    public void randomizeOrder(int w)
    {
        Random rand2=new Random(w);
        ArrayList<Integer> nums=new ArrayList<>();
        while(nums.size()<4)
        {
            int r=rand2.nextInt(4)+1;
            if(!nums.contains(r))
            {
                nums.add(r);
            }
        }
        for(int i=0; i<4; i++)
        {
            int n=nums.get(i);
            if(n==1)
            {
                allPlayers.add(playerY);
            }
            else if(n==2)
            {
                allPlayers.add(playerB);
            }
            else if(n==3)
            {
                allPlayers.add(playerG);
            }
            else
            {
                allPlayers.add(playerR);
            }
        }
        Collections.shuffle(allPlayers);
        currentPlayer=allPlayers.get(0);
    }

    public boolean getAllowChoosing()
    {
        return allowChoosing;
    }

    public void setAllowChoosing(boolean a)
    {
        allowChoosing=a;
    }

    public Domino getCurrentDomino()
    {
        return currentDomino;
    }

    public void setCurrentDomino(Domino a)
    {
        currentDomino=a;
    }

    public Tile getCurrentTile()
    {
        return currentTile;
    }

    public void setCurrentTile(Tile a)
    {
        currentTile=a;
    }
    public boolean getAllowPlacing()
    {
        return allowPlacing;
    }

    public void setAllowPlacing(boolean a)
    {
        allowPlacing=a;
    }

    public boolean getAllowEnding()
    {
        return allowEnding;
    }

    public void setAllowEnding(boolean a)
    {
        allowEnding=a;
    }

    public boolean getIsFirstRound()
    {
        return isFirstRound;
    }

    public void setIsFirstRound(boolean i)
    {
        isFirstRound=i;
    }

    public Player getCurrentPlayer()
    {
        return currentPlayer;
    }

    public void updateCurrentPlayer()
    {
        if(playerTurnCounter<3)
        {
            playerTurnCounter++;
            currentPlayer=allPlayers.get(playerTurnCounter);
        }
        else
        {
            playerTurnCounter=0;
            //Clear allPlayers after second round, aka not first or last round, outside of this method
            currentPlayer=allPlayers.get(playerTurnCounter);
            System.out.println("currentPlayer is "+currentPlayer.getName());
        }
    }
    
    public void clearPlayerTurnCounter()
    {
    	playerTurnCounter=0;
    }
    
    public String getAllPlayers()
    {
        String s="";
        for(int i=0; i<allPlayers.size(); i++)
        {
            s+=allPlayers.get(i).getName()+" ";
        }
        return s;
    }
    
    public String getAllPlayersCommas()
    {
        String s="";
        String temp=allPlayers.get(0).getName();
        if(temp.equals("Player Yellow"))
        {
        	s+="Yellow";
        }
        if(temp.equals("Player Blue"))
        {
        	s+="Blue";
        }
        if(temp.equals("Player Green"))
        {
        	s+="Green";
        }
        if(temp.equals("Player Red"))
        {
        	s+="Red";
        }
        for(int i=1; i<allPlayers.size(); i++)
        {
            temp=allPlayers.get(i).getName();
            if(temp.equals("Player Yellow"))
            {
            	s+=", Yellow";
            }
            if(temp.equals("Player Blue"))
            {
            	s+=", Blue";
            }
            if(temp.equals("Player Green"))
            {
            	s+=", Green";
            }
            if(temp.equals("Player Red"))
            {
            	s+=", Red";
            }
        }
        return s;
    }

    public void setChosenDomino(int d)
    {
        chosenDomino=d;
    }

    public int getChosenDomino()
    {
        return chosenDomino;
    }

    public ArrayList<Domino> getOptionDeck()
    {
        return optionDeck.getDeck();
    }

    public ArrayList<Domino> getNextRoundDeck()
    {
        return nextRoundDeck.getDeck();
    }
    
    public void sortNextRoundDeck()
    {
    	nextRoundDeck.sort();
    }

    public void setOptionDeckOwner(int i)
    {
        optionDeck.getDeck().get(i).setPlayer(currentPlayer);
    }

    public void setNextRoundDeckOwner(int i)
    {
        nextRoundDeck.getDeck().get(i).setPlayer(currentPlayer);
    }

    public void setErrorMessage(String s)
    {
        errorMessage=s;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public Deck getMainDeck()
    {
        return mainDeck;
    }

    public void clearAllPlayers()
    {
        allPlayers.clear();
    }

    public void addPlayer(Player p)
    {
        allPlayers.add(p);
    }

    public void setAllowPlace1(boolean s)
    {
        allowPlace1=s;
    }

    public boolean getAllowPlace1()
    {
        return allowPlace1;
    }

    public boolean getAllowPlace2()
    {
        return allowPlace2;
    }

    public void setAllowPlace2(boolean s)
    {
        allowPlace2=s;
    }

    public ArrayList<Player> getThePlayers(){
        return allPlayers;
    }
    
    public boolean getIsLastRound()
    {
    	return isLastRound;
    }
    
    public void setIsLastRound(boolean i)
    {
    	isLastRound=i;
    }
    
    public void setCurrentPlayer(Player p)
    {
    	currentPlayer=p;
    }
    
    public Player getPlayerY()
    {
    	return playerY;
    }
    
    public Player getPlayerR()
    {
    	return playerR;
    }
    
    public Player getPlayerG()
    {
    	return playerG;
    }
    
    public Player getPlayerB()
    {
    	return playerB;
    }
}





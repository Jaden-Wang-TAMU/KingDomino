
package Classes;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Collections;
import java.util.Timer;
import java.util.ArrayList;

public class KingPanel extends JPanel implements MouseListener{
    private static BufferedImage rpgenv,laughcry,crown2,info,details,thinking,rpgrocks,heart,team,gameconsole,rpglake,house,scroll,yCastle,bCastle,gCastle,rCastle,reset,trash,next,crown,place,scroll2,parch,blueking,redking,ywking,grnking, emptyking, trees, farms, sea, mines, wastelands, meadows, grid, nope;
    private static BufferedImage b1,b2,b3,b4,g1,g_emotion_2,g3,g4,r1,r2,r3,r4,y1,y2,y3,y4;
    private static Discard discardButton;
    private static int firstRoundCtr;
    //should be set to false once loading reimplemented in line below
    private static boolean mainMenuLoading=true,newGameLoading=true,instructionsLoading=true;
    private static boolean mainMenu=true;
    private static boolean newGame=false;
    private static boolean instructions=false;
    private static boolean loading=true;
    private static boolean emojis;
    private static boolean allNextSelected=false;
    private static String whosTurn="";
    static JLabel gif;
    Timer timer;
    private GameState gameState;
    private static boolean confirmChoice;
    private int optionDeckX;
    private int nextRoundDeckX;
    private int[] optionAndNextRoundDeckYs;
    private BufferedImage[] optionOwner;
    private BufferedImage[] nextOwner;
    private boolean tileSurrounding;
    private boolean information;
    private boolean highlight;
    private int hx, hy;
    private int clickedGridX, clickedGridY;
    private boolean cover1;
    private boolean cover2;
    private int currentTileDirection;
    private int firstTileDirection;
    private int finalhx;
    private int finalhy;
    private int finalh2x;
    private int finalh2y;
    private boolean placed1;
    private Tile lastTile;
    private int placeCounter;
    private ArrayList<Painting> paintingsh;
    private ArrayList<Domino> addedDominoes;
    private boolean firstTimeCover1;
    private boolean firstTimeCover2;
    private Tile firstTile;
    private Tile secondTile;
    private RotateDomino rotator;
    private boolean lockedp;
    private boolean lockedg;
    private boolean lockedd;
    private boolean canDrawDomino;
    private boolean lockedc;
    private int roundCounter;
    private boolean allowScoring;
    private int lastRoundMoves;
    private int pickedTileCounter;
    private boolean firstTimeScoring;
    private int[] scores;
    private int yScore;
    private int bScore;
    private int gScore;
    private int rScore;
    private boolean scoreSpecifics;
    private ArrayList<Integer> ties;
    private ArrayList<Integer> tiesScores;
    private String winner;
    private ArrayList<Player> rankPlayers;
    private int[] rankscores;
    private boolean noGrids;
    private int noGridCounter;
    public KingPanel(){
        try{
            place=ImageIO.read(KingPanel.class.getResource("/Images/place.png"));
            trash=ImageIO.read(KingPanel.class.getResource("/Images/trash.png"));
            crown=ImageIO.read(KingPanel.class.getResource("/Images/crown.png"));
            next=ImageIO.read(KingPanel.class.getResource("/Images/next.png"));
            yCastle=ImageIO.read(KingPanel.class.getResource("/Images/ywcastle.png"));
            bCastle=ImageIO.read(KingPanel.class.getResource("/Images/bluecastle.png"));
            gCastle=ImageIO.read(KingPanel.class.getResource("/Images/grncastle.png"));
            rCastle=ImageIO.read(KingPanel.class.getResource("/Images/redcastle.png"));
            scroll=ImageIO.read(KingPanel.class.getResource("/Images/scroll.png"));
            house = ImageIO.read(KingPanel.class.getResource("/Images/house.png"));
            rpgenv = ImageIO.read(KingPanel.class.getResource("/Images/tabletop1.jpg"));
            rpglake = ImageIO.read(KingPanel.class.getResource("/Images/tabletop.jpg"));
            rpgrocks = ImageIO.read(KingPanel.class.getResource("/Images/newmenu.jpg"));
            scroll2 = ImageIO.read(KingPanel.class.getResource("/Images/scroll2.png"));;
            parch = ImageIO.read(KingPanel.class.getResource("/Images/parch.png"));
            blueking=ImageIO.read(KingPanel.class.getResource("/Images/blueking.png"));
            redking=ImageIO.read(KingPanel.class.getResource("/Images/redking.png"));
            ywking=ImageIO.read(KingPanel.class.getResource("/Images/ywking.png"));
            grnking=ImageIO.read(KingPanel.class.getResource("/Images/grnking.png"));
            reset=ImageIO.read(KingPanel.class.getResource("/Images/reset.png"));
            details=ImageIO.read(KingPanel.class.getResource("/Images/details.png"));
            gameconsole=ImageIO.read(KingPanel.class.getResource("/Images/gameconsole.png"));
            trees=ImageIO.read(KingPanel.class.getResource("/Images/DominoFront1.png"));
            trees=trees.getSubimage(0, 0, trees.getWidth()/2, trees.getHeight());
            farms=ImageIO.read(KingPanel.class.getResource("/Images/DominoFront3.png"));
            farms=farms.getSubimage(0, 0, farms.getWidth()/2, farms.getHeight());
            sea=ImageIO.read(KingPanel.class.getResource("/Images/DominoFront12.png"));
            sea=sea.getSubimage(0, 0, sea.getWidth()/2, sea.getHeight());
            mines=ImageIO.read(KingPanel.class.getResource("/Images/DominoFront22.png"));
            mines=mines.getSubimage(mines.getWidth()/2, 0, mines.getWidth()/2, mines.getHeight());
            wastelands=ImageIO.read(KingPanel.class.getResource("/Images/DominoFront46.png"));
            wastelands=wastelands.getSubimage(0, 0, wastelands.getWidth()/2, wastelands.getHeight());
            meadows=ImageIO.read(KingPanel.class.getResource("/Images/DominoFront10.png"));
            meadows=meadows.getSubimage(0, 0, meadows.getWidth()/2, meadows.getHeight());
            grid=ImageIO.read(KingPanel.class.getResource("/Images/Grid.png"));
            nope=ImageIO.read(KingPanel.class.getResource("/Images/Nope.png"));
            info=ImageIO.read(KingPanel.class.getResource("/Images/information.png"));
            team=ImageIO.read(KingPanel.class.getResource("/Images/team.png"));
            heart=ImageIO.read(KingPanel.class.getResource("/Images/heart.png"));
            laughcry=ImageIO.read(KingPanel.class.getResource("/Images/laughcry.png"));
            b1=ImageIO.read(KingPanel.class.getResource("/Images/b1.png"));
            b2=ImageIO.read(KingPanel.class.getResource("/Images/b2.png"));
            b3=ImageIO.read(KingPanel.class.getResource("/Images/b3.png"));
            b4=ImageIO.read(KingPanel.class.getResource("/Images/b4.png"));
            g1=ImageIO.read(KingPanel.class.getResource("/Images/g1.png"));
            g_emotion_2=ImageIO.read(KingPanel.class.getResource("/Images/g2.png"));
            g3=ImageIO.read(KingPanel.class.getResource("/Images/g3.png"));
            g4=ImageIO.read(KingPanel.class.getResource("/Images/g4.png"));
            r1=ImageIO.read(KingPanel.class.getResource("/Images/r1.png"));
            r2=ImageIO.read(KingPanel.class.getResource("/Images/r2.png"));
            r3=ImageIO.read(KingPanel.class.getResource("/Images/r3.png"));
            r4=ImageIO.read(KingPanel.class.getResource("/Images/r4.png"));
            y1=ImageIO.read(KingPanel.class.getResource("/Images/y1.png"));
            y2=ImageIO.read(KingPanel.class.getResource("/Images/y2.png"));
            y3=ImageIO.read(KingPanel.class.getResource("/Images/y3.png"));
            y4=ImageIO.read(KingPanel.class.getResource("/Images/y4.png"));
            thinking=ImageIO.read(KingPanel.class.getResource("/Images/thinking.png"));
            confirmChoice=false;
            optionDeckX=403;
            nextRoundDeckX=515;
            optionAndNextRoundDeckYs=new int[4];
            optionAndNextRoundDeckYs[0]=425;
            optionAndNextRoundDeckYs[1]=458;
            optionAndNextRoundDeckYs[2]=491;
            optionAndNextRoundDeckYs[3]=525;
            gameState=new GameState();
            discardButton=new Discard(450, 925);
            optionOwner=new BufferedImage[4];
            nextOwner=new BufferedImage[4];
            rotator=new RotateDomino();
            emptyking=ImageIO.read(KingPanel.class.getResource("/Images/emptyking.png"));
            firstRoundCtr=0;
            tileSurrounding=false;
            currentTileDirection=-1;
            information=false;
            firstTileDirection=-1;
            placed1=false;
            for(int i=0; i<4; i++)
            {

                optionOwner[i]=emptyking;
                nextOwner[i]=emptyking;
            }
            highlight=false;
            hx=-1;
            hy=-1;
            clickedGridX=-1;
            clickedGridY=-1;
            cover1=false;
            cover2=false;
            finalhx=-1;
            finalhy=-1;
            finalh2x=-1;
            finalh2y=-1;
            scoreSpecifics=false;
            lastTile=new Tile(scroll);
            placeCounter=0;
            paintingsh=new ArrayList<>();
            addedDominoes=new ArrayList<>();
            firstTimeCover1=true;
            firstTimeCover2=true;
            firstTile=new Tile(ywking);
            secondTile=new Tile(ywking);
            lockedp=true;
            lockedg=true;
            lockedd=true;
            canDrawDomino=true;
            lockedc=true;
            roundCounter=0;
            allowScoring=false;
            lastRoundMoves=0;
            emojis=false;
            pickedTileCounter=0;
            firstTimeScoring=true;
            scores=new int[4];
            scores[0]=-1;
            scores[1]=-1;
            scores[2]=-1;
            scores[3]=-1;
            yScore=-1;
            bScore=-1;
            gScore=-1;
            rScore=-1;
            ties=new ArrayList<>();
            tiesScores=new ArrayList<>();
            winner=gameState.getPlayerY().getName();
            rankPlayers=new ArrayList<>();
            rankscores=new int[4];
            noGrids=false;
            noGridCounter=0;
        }catch(Exception e){
            System.out.println(e);
            System.out.println("in KingPanel");
            return;
        }
        addMouseListener(this);
    }
    public void paint(Graphics g){
        if(lastRoundMoves>=4)
        {
            allowScoring=true;
        }
        //allowScoring=true;
        if(gameState!=null){
            if(gameState.getAllowChoosing()) {
                lockedc = false;
            }
        }
        System.out.println("updated locker\n~~~~~~~~~~\n");
        {
            System.out.println("lockedp:"+lockedp);
            System.out.println("lockedg:"+lockedg);
            System.out.println("lockedd is"+lockedd);
            System.out.println("lockedc is"+lockedc);
        }
        System.out.println("\n~~~~~~~~~~\n");
        g.setFont(new Font("Old English Text MT",Font.PLAIN,50));
        /*JFrame myFrame=new JFrame("Please wait...");
        if(loading&&!confirmChoice){
            System.out.println("please waiting");
            myFrame.setLocation(0,0);
            myFrame.setResizable(false);
            myFrame.getContentPane().add(gif);
            myFrame.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            myFrame.pack();
            myFrame.setVisible(true);
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            myFrame.setVisible(false);
                        }
                    },
                    4200
            );
            Reminder(4);
            loading=false;
        }*/
        loading=false;
        //System.out.println("got past loading, loading is "+loading);
        //removed &&mainMenuLoading below
        if(mainMenu){
        	g.drawImage(rotator.rotate90(gameState.getCurrentDomino().getFront()), gameState.getCurrentDomino().getX(), gameState.getCurrentDomino().getY(), 39, 79, null);
            System.out.println("at main menu");
            g.drawImage(rpgrocks,0,0,2*getWidth(),(int)(1.1*getHeight()),null);
            g.setColor(new Color(0,0,128));
            g.drawImage(scroll, 300, 300, 400, 100, null);
            g.drawImage(scroll, 300, 500, 400, 100,null);
            g.drawImage(scroll, 380, 700, 240, 100,null);
            g.drawImage(scroll, 130, 300,90,90,null);
            g.drawImage(scroll, 780, 300, 90,90,null);
            g.drawImage(scroll, 130, 500, 90,90,null);
            g.drawImage(reset,150,320,50,50,null);
            g.drawImage(info,800,320,50,50,null);
            g.drawImage(thinking,150,520,50,50,null);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Old English Text MT",Font.BOLD,50));
            g.drawString("Team Adam's KingDomino",180,165);
            g.setFont(new Font("Old English Text MT", Font.PLAIN, 25));
            g.setColor(Color.CYAN);
            g.drawString("Please Set Your App Scaling in Display in Settings to 100%", 190, 50);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Old English Text MT",Font.PLAIN,50));
            g.drawString("Load Game",370,365);
            g.drawString("Instructions",365,565);
            g.setFont(new Font("Old English Text MT",Font.PLAIN,30));
            g.drawString("Made in",435,737);
            g.drawString("Java 13.0.1",417,770);
        }
        //removed &&instructionsLoading below
        if(instructions){
            g.setFont(new Font("Old English Text MT",Font.PLAIN,50));
            System.out.println("at instructions");
            g.drawImage(rpgenv,0,0,1000,1075,null);
            g.setColor(new Color(0,0,0, 47));
            g.fillRect(1000,90,800,125);
            g.fillRect(100,90,800,125);
            g.fillRect(170,230,595,790);
            g.drawImage(scroll,100,90,800,125,null);
            g.drawImage(house,140,125,50,45,null);
            g.setColor(Color.BLACK);
            g.drawString("Instructions",335,165);
            g.drawImage(rotate(scroll,-67.55),150,230,635,790,null);
            instructionsLoading=false;
            g.drawImage(house, 245,300,50,50,null);
            g.drawImage(place,245, 370,50,50, null);
            g.drawImage(trash,245,440, 50,50,null);
            g.drawImage(crown,245,510,50,50, null);
            g.drawImage(details, 245, 580, 50, 50, null);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Old English Text MT",Font.PLAIN,20));
            g.drawString("This button allows you to return to the main menu",300,325);
            g.drawString("Confirms the placement of your selected tiles (both)",300,400);
            g.drawString("Allows discarding when you cannot place",300,475);
            g.drawString("Confirms your selected domino from Dominoes ",300,535);
            g.drawString("in Play in the beginning & end and from Domino",300,555);
            g.drawString("Queue in all other rounds",300,575);
            g.drawString("Allows you to see the running total of each", 300, 605);
            g.drawString("player with the scores of each territory and bonuses",300, 625);
            g.drawString("Instruction and Error Messages should guide you to the",245, 675);
            g.drawString("correct next step!",245,695);
        }
        if(emojis){
            g.setFont(new Font("Old English Text MT",Font.PLAIN,50));
            g.drawImage(rpgenv,0,0,1000,1075,null);
            g.setColor(new Color(0,0,0, 47));
            g.fillRect(1000,90,800,125);
            g.fillRect(170,230,595,600);
            g.fillRect(100,90,800,125);
            g.drawImage(scroll,100,90,800,125,null);
            g.drawImage(house,140,125,50,45,null);
            g.setColor(Color.BLACK);
            g.drawString("Emote Explanation",305,165);
            g.drawImage(rotate(scroll,-67.55),150,230,635,600,null);
            g.setFont(new Font("Old English Text MT",Font.PLAIN,40));
            g.drawString("1st    2nd    3rd    4th",335,320);
            g.drawString("Blu",250,390);
            g.drawString("Grn",250,475);
            g.drawString("Red",250,570);
            g.drawString("Ylw",250,670);
            g.drawImage(b1,330,340,60,60,null);
            g.drawImage(b2,425,350,60,(int)(10./11.*60),null);
            g.drawImage(b3,520,350,60,(int)(10./11.*60),null);
            g.drawImage(b4,615,350,60,60,null);
            g.drawImage(g1,330,440,60,45,null);
            g.drawImage(g_emotion_2,425,440,60,48,null);
            g.drawImage(g3,520,435,60,51,null);
            g.drawImage(g4,615,440,60,48,null);
            g.drawImage(r1,330,520,60,60,null);
            g.drawImage(r2,425,520,60,(int)(21./20.5*60),null);
            g.drawImage(r3,520,520,60,60,null);
            g.drawImage(r4,615,515,60,(int)(23./21.*60),null);
            g.drawImage(y1,330,620,60,60,null);
            g.drawImage(y2,425,620,60,(int)(19./20.*60),null);
            g.drawImage(y3,520,620,60,60,null);
            g.drawImage(y4,615,620,60,(int)(14./15.*60),null);
        }
        if(information){
            g.setFont(new Font("Old English Text MT",Font.PLAIN,50));
            g.drawImage(rpgenv,0,0,1000,1075,null);
            g.setColor(new Color(0,0,0, 47));
            g.fillRect(1000,90,800,125);
            g.fillRect(170,230,595,790);
            g.fillRect(100,90,800,125);
            g.drawImage(scroll,100,90,800,125,null);
            g.drawImage(house,140,125,50,45,null);
            g.setColor(Color.BLACK);
            g.drawString("Information",335,165);
            g.drawImage(rotate(scroll,-67.55),150,230,635,790,null);
            g.setFont(new Font("Old English Text MT",Font.PLAIN,30));
            g.drawImage(team, 400,265,100,100,null);
            g.drawString("THE             TEAM",320,320);
            g.drawString("Adam Chen, Sahil Gandhi, ",250, 380);
            g.drawString("Mariano Gurfinkel, and Jaden Wang",250,410);
            g.setFont(new Font("Old English Text MT",Font.PLAIN,25));
            g.drawImage(heart, 400,465,100,100,null);
            g.drawString("Thanks to everyone who helped us beta-test",240,600);
            g.drawString("during development. Especially, we'd like to thank",240,630);
            g.drawString("Team Roger, Team Daniel, and Team Aidan.",240,660);
            g.drawString("Most of these assets don't belong to us.",240,730);
            g.drawString("The only ones we claim ownership over are:",240,760);
            g.drawString("King icons next to dominoes and Castles",240,790);
            g.drawString("Credit for the emotes goes to Supercell, Clash Royale", 240, 830);
            g.drawString("Fullscreen is not supported.",240,900);
        }
        if(scoreSpecifics){
            g.setFont(new Font("Old English Text MT",Font.PLAIN,50));
            g.drawImage(rpgenv,0,0,1000,1075,null);
            g.setColor(new Color(0,0,0, 47));
            g.fillRect(100,90,800,125);
            g.fillRect(100,230,380,400);
            g.fillRect(100,640,380,400);
            g.fillRect(525,230,380,400);
            g.fillRect(525,640,380,400);
            g.drawImage(scroll,100,90,800,125,null);
            g.drawImage(gameconsole,135,115,75,75,null);
            g.setColor(Color.BLACK);
            g.drawString("Score Specifics",350,165);
            g.drawImage(rotate(scroll,-67.55),90,230,400,400,null);
            g.drawImage(rotate(scroll,-67.55),90,640,400,400,null);
            g.drawImage(rotate(scroll,-67.55),515,230,400,400,null);
            g.drawImage(rotate(scroll,-67.55),515,640,400,400,null);
            g.setFont(new Font("Old English Text MT",Font.PLAIN,45));
            g.drawString("Player Yellow", 125, 290);
            g.drawString("Player Green", 125, 700);
            g.drawString("Player Blue", 550, 290);
            g.drawString("Player Red", 550, 700);
            g.setFont(new Font("Old English Text MT",Font.PLAIN,30));
            //Trees=1;
            //Farms=2;
            //Sea=3;
            //Mines=4;
            //Wasteland=5
            //Meadows=6, gameState.getPlayerY().getGrid().gotHarmony(), gameState.getPlayerY().getGrid().gotMiddle()
            Grid yG=gameState.getPlayerY().getGrid();
            int yScore=yG.getScore();
            g.drawString("         - "+yG.getFarmScore(), 125, 340);
            g.drawImage(farms, 135, 300, 60, 60, null);
            g.drawString("     - "+yG.getSeaScore(), 325, 340);
            g.drawImage(sea, 305, 300, 60, 60, null);
            g.drawString("         - "+yG.getMeadowScore(), 125, 410);
            g.drawImage(meadows, 135, 370, 60, 60, null);
            g.drawString("     - "+yG.getWasteScore(), 325, 410);
            g.drawImage(wastelands, 305, 370, 60, 60, null);
            g.drawString("         - "+yG.getTreeScore(), 125, 480);
            g.drawImage(trees, 135, 440, 60, 60, null);
            g.drawString("     - "+yG.getMineScore(), 325, 480);
            g.drawImage(mines, 305, 440, 60, 60, null);
            g.drawString("Total: "+yScore, 175, 600);
            g.drawString("Harmony- ", 175, 525);
            if(yG.gotHarmony())
            {
                g.setColor(Color.GREEN);
                g.fillRect(300, 502, 36, 36);
                g.setColor(Color.BLACK);
                g.drawString("5", 310, 530);
            }
            else
            {
                g.setColor(Color.RED);
                g.fillRect(300, 502, 36, 36);
                g.setColor(Color.BLACK);
                g.drawString("0", 310, 530);
            }
            g.setColor(Color.BLACK);
            g.drawString("Middle- ", 175, 560);
            if(yG.gotMiddle())
            {
                g.setColor(Color.GREEN);
                g.fillRect( 275,  540, 35, 35);
                g.setColor(Color.BLACK);
                g.drawString("10", 275, 570);
            }
            else
            {
                g.setColor(Color.RED);
                g.fillRect( 275,  540,35, 35);
                g.setColor(Color.BLACK);
                g.drawString("0", 285, 570);
            }

            g.setColor(Color.BLACK);
            Grid gG=gameState.getPlayerG().getGrid();
            int gScore=gG.getScore();
            g.drawString("         - "+gG.getFarmScore(), 125, 750);
            g.drawImage(farms, 135, 710, 60, 60, null);
            g.drawString("     - "+gG.getSeaScore(), 325, 750);
            g.drawImage(sea, 305, 710, 60, 60, null);
            g.drawString("         - "+gG.getMeadowScore(), 125, 820);
            g.drawImage(meadows, 135, 780, 60, 60, null);
            g.drawString("     - "+gG.getWasteScore(), 325, 820);
            g.drawImage(wastelands, 305, 780, 60, 60, null);
            g.drawString("         - "+gG.getTreeScore(), 125, 890);
            g.drawImage(trees, 135, 850, 60, 60, null);
            g.drawString("     - "+gG.getMineScore(), 325, 890);
            g.drawImage(mines, 305, 850, 60, 60, null);
            g.drawString("Total: "+gScore, 175, 1010);
            g.drawString("Harmony- ", 175, 935);
            if(gG.gotHarmony())
            {
                g.setColor(Color.GREEN);
                g.fillRect(300, 912, 36, 36);
                g.setColor(Color.BLACK);
                g.drawString("5", 310, 938);

            }
            else
            {
                g.setColor(Color.RED);
                g.fillRect(300, 912, 36, 36);
                g.setColor(Color.BLACK);
                g.drawString("0", 310, 938);
            }
            g.setColor(Color.BLACK);
            g.drawString("Middle- ",  175,  970);
            if(gG.gotMiddle())
            {
                g.setColor(Color.GREEN);
                g.fillRect(275, 950, 35, 35);
                g.setColor(Color.BLACK);
                g.drawString("10", 275, 975);
            }
            else
            {
                g.setColor(Color.RED);
                g.fillRect(275, 950, 35, 35);
                g.setColor(Color.BLACK);
                g.drawString("0",  285, 975);
            }

            g.setColor(Color.BLACK);
            Grid bG=gameState.getPlayerB().getGrid();
            int bScore=bG.getScore();
            g.drawString("         - "+bG.getFarmScore(), 550, 340);
            g.drawImage(farms, 560, 300, 60, 60, null);
            g.drawString("     - "+bG.getSeaScore(), 750, 340);
            g.drawImage(sea, 730, 300, 60, 60, null);
            g.drawString("         - "+bG.getMeadowScore(), 550, 410);
            g.drawImage(meadows, 560, 370, 60, 60, null);
            g.drawString("     - "+bG.getWasteScore(), 750, 410);
            g.drawImage(wastelands, 730, 370, 60, 60, null);
            g.drawString("         - "+bG.getTreeScore(), 550, 480);
            g.drawImage(trees, 560, 440, 60, 60, null);
            g.drawString("     - "+bG.getMineScore(), 750, 480);
            g.drawImage(mines, 730, 440, 60, 60, null);
            g.drawString("Total: "+bScore, 600, 600);
            g.drawString("Harmony- ", 600, 525);
            if(bG.gotHarmony())
            {
                g.setColor(Color.GREEN);
                g.fillRect( 725, 502, 36, 36);
                g.setColor(Color.BLACK);
                g.drawString("5",  735,  530);
            }
            else
            {
                g.setColor(Color.RED);
                g.fillRect(725, 502, 36, 36);
                g.setColor(Color.BLACK);
                g.drawString("0",735,  530);
            }
            g.setColor(Color.BLACK);
            g.drawString("Middle- ", 600, 560);
            if(bG.gotMiddle())
            {
                g.setColor(Color.GREEN);
                g.fillRect(700, 540, 35, 35);
                g.setColor(Color.BLACK);
                g.drawString("10", 702, 568);
            }
            else
            {
                g.setColor(Color.RED);
                g.fillRect(700, 540, 35, 35);
                g.setColor(Color.BLACK);
                g.drawString("0", 712, 568);
            }

            g.setColor(Color.BLACK);
            Grid rG=gameState.getPlayerR().getGrid();
            int rScore=rG.getScore();
            g.drawString("         - "+rG.getFarmScore(), 550, 750);
            g.drawImage(farms, 560, 710, 60, 60, null);
            g.drawString("     - "+rG.getSeaScore(), 750, 750);
            g.drawImage(sea, 730, 710, 60, 60, null);
            g.drawString("         - "+rG.getMeadowScore(), 550, 820);
            g.drawImage(meadows, 560, 780, 60, 60, null);
            g.drawString("     - "+rG.getWasteScore(), 750, 820);
            g.drawImage(wastelands, 730, 780, 60, 60, null);
            g.drawString("         - "+rG.getTreeScore(), 550, 890);
            g.drawImage(trees, 560, 850, 60, 60, null);
            g.drawString("     - "+rG.getMineScore(), 750, 890);
            g.drawImage(mines, 730, 850, 60, 60, null);
            g.drawString("Total: "+rScore, 600, 1010);
            g.drawString("Harmony- ", 600, 935);
            if(rG.gotHarmony())
            {
                g.setColor(Color.GREEN);
                g.fillRect(725, 912, 36, 36);
                g.setColor(Color.BLACK);
                g.drawString("5", 735, 938);
            }
            else
            {
                g.setColor(Color.RED);
                g.fillRect(725,912, 36, 36);
                g.setColor(Color.BLACK);
                g.drawString("0", 735, 938);
            }
            g.setColor(Color.BLACK);
            g.drawString("Middle- ", 600, 970);
            if(rG.gotMiddle())
            {
                g.setColor(Color.GREEN);
                g.fillRect(700, 950, 35, 35);
                g.setColor(Color.BLACK);
                g.drawString("10", 702, 975);
            }
            else
            {
                g.setColor(Color.RED);
                g.fillRect(700, 950, 35, 35);
                g.setColor(Color.BLACK);
                g.drawString("0", 712, 975);
            }
        }
        if(newGame){
            System.out.println("\nAlllowPlacing: "+gameState.getAllowPlacing()+"\nAllowChoosing: "+gameState.getAllowChoosing()+"\nAllowEnding: "+gameState.getAllowEnding());
            g.drawImage(rpgenv,0,0,getWidth(),getHeight(),null);

            g.setFont(new Font("Old English Text MT",Font.PLAIN,50));
            g.setColor(Color.BLACK);
            //shadows
            {
                g.setColor(new Color(0,0,0, 89));
                //grids
                {
                    g.fillRect(0, 0, 375, 375);
                    g.fillRect(610, 0,  375, 375);
                    g.fillRect(0, 520,  375,  380);
                    g.fillRect(610, 520, 375, 380);
                }
                //player tag scrolls
                {
                    g.fillRect(120, 377, 125, 40);
                    g.fillRect(120+125+1, 377, 55, 40);
                    g.fillRect(120, 477, 121,  40);
                    g.fillRect(120+121+1, 477, 55, 40);
                    g.fillRect(745, 377,  117,  40);
                    g.fillRect(745+117+1, 377, 55, 40);
                    g.fillRect(745, 477, 117,  40);
                    g.fillRect(745+117+1, 477, 55, 40);
                }
                //large scroll
                //central scrolls

                g.fillRect(380, 370, 105, 200);
                g.fillRect(495, 370, 110, 200);
                if (!allowScoring){
                    g.setColor(new Color(0,0,0, 47));
                    g.fillRect(435, 120, 110, 100);
                    g.fillRect(380, 600, 220, 90);
                    g.fillRect(380, 700, 220, 90);
                    g.fillRect(380, 800, 220, 90);
                    g.drawImage(scroll, 435, 15, 110, 100, null);
                    g.fillRect(435, 15, 110, 100);
                    g.fillRect(445, 280, 90, 80);
                    g.fillRect(390, 220, 200, 60);
                }
            }
            g.fillRect(5, 900, 980, 135);
            mainMenu=false;instructions=false;
            //basic stuff
            Graphics2D g2 = (Graphics2D) g;
            {
                g.setFont(new Font("Old English Text MT", Font.ROMAN_BASELINE, 18));
                g.setColor(new Color(35, 177, 77));
                g.setColor(new Color(203, 170, 51, 255));
                g.fillRect(5, 5, 360, 360);
                g.setColor(new Color(21, 113, 184, 255));
                g.fillRect(620, 5, 360, 360);
                g.setColor(new Color(59, 127, 26, 255));
                g.fillRect(5, 530, 360, 360);
                g.setColor(new Color(170, 40, 38, 255));
                g.fillRect(620, 530, 360, 360);
                g.setColor(new Color(102, 51, 0));
                Stroke oldStroke = g2.getStroke();
                g2.setStroke(new BasicStroke(5));
                System.out.println("    currentPlayer at beginning "+gameState.getCurrentPlayer().getName());
                if(gameState.getCurrentPlayer().getName().equals("Player Yellow")&&!allowScoring)
                    g.setColor(new Color(205, 196, 196));
                g.drawRect(2, 2, 365, 365);
                g.setColor(new Color(102, 51, 0));

                if(gameState.getCurrentPlayer().getName().equals("Player Blue")&&!allowScoring)
                    g.setColor(new Color(205, 196, 196));
                g.drawRect(617, 2, 365, 365);
                g.setColor(new Color(102, 51, 0));

                if(gameState.getCurrentPlayer().getName().equals("Player Green")&&!allowScoring)
                    g.setColor(new Color(205, 196, 196));
                g.drawRect(2, 527, 365, 365);
                g.setColor(new Color(102, 51, 0));

                if(gameState.getCurrentPlayer().getName().equals("Player Red")&&!allowScoring)
                    g.setColor(new Color(205, 196, 196));
                g.drawRect(617, 527, 365, 365);
                g.setColor(new Color(102, 51, 0));

                g.setColor(Color.BLACK);
                g2.setStroke(oldStroke);
            }

            //grid stuff
            {
                //Draws additional borders on the grids to ensure size 39, 39 works for all tiles
                g.drawRect(5, 5, 360, 360);
                g.drawRect(620,5,360,360);
                g.drawRect(5,530,360,360);
                g.drawRect(620,530,360,360);
                //base grid stuff
                if(!noGrids)
                {
                    int x1=45,x2=45,y1=5,y2=365;
                    for(int i=0;i<8;i++){
                        g.drawLine(x1,y1,x2,y2);
                        x1+=40;x2+=40;
                    }
                    y1=45;y2=45;x1=5;x2=365;
                    for(int i=0;i<8;i++){
                        g.drawLine(x1,y1,x2,y2);
                        y1+=40;y2+=40;
                    }
                    x1=660;x2=660;y1=5;y2=365;
                    for(int i=0;i<8;i++){
                        g.drawLine(x1,y1,x2,y2);
                        x1+=40;x2+=40;
                    }
                    y1=45;y2=45;x1=620;x2=980;
                    for(int i=0;i<8;i++){
                        g.drawLine(x1,y1,x2,y2);
                        y1+=40;y2+=40;
                    }
                    x1=45;x2=45;y1=530;y2=890;
                    for(int i=0;i<8;i++){
                        g.drawLine(x1,y1,x2,y2);
                        x1+=40;x2+=40;
                    }
                    y1=570;y2=570;x1=5;x2=365;
                    for(int i=0;i<8;i++){
                        g.drawLine(x1,y1,x2,y2);
                        y1+=40;y2+=40;
                    }
                    x1=660;x2=660;y1=530;y2=890;
                    for(int i=0;i<8;i++){
                        g.drawLine(x1,y1,x2,y2);
                        x1+=40;x2+=40;
                    }
                    y1=570;y2=570;x1=620;x2=980;
                    for(int i=0;i<8;i++){
                        g.drawLine(x1,y1,x2,y2);
                        y1+=40;y2+=40;
                    }
                }
            }
            //castles
            {
                g.drawImage(yCastle, 45 + 121, 45 + 121, 39, 39, null);
                g.drawImage(bCastle, 660 + 121, 45 + 121, 39, 39, null);
                g.drawImage(gCastle, 45 + 121, 570 + 121, 39, 39, null);
                g.drawImage(rCastle, 660 + 121, 570 + 121, 39, 39, null);
            }
            //player tag scrolls
            {
                ArrayList<Integer> tempScores = new ArrayList<>();
                ArrayList<Integer> listScores = new ArrayList<>();
                tempScores.add(gameState.getPlayerY().getGrid().score());
                tempScores.add(gameState.getPlayerB().getGrid().score());
                tempScores.add(gameState.getPlayerG().getGrid().score());
                tempScores.add(gameState.getPlayerR().getGrid().score());
                listScores.add(gameState.getPlayerY().getGrid().score());
                listScores.add(gameState.getPlayerB().getGrid().score());
                listScores.add(gameState.getPlayerG().getGrid().score());
                listScores.add(gameState.getPlayerR().getGrid().score());
                g.drawImage(scroll, 45 + 80, 380, 120, 35, null);
                g.drawImage(scroll, 45 + 80 + 120 + 6, 380, 50, 35, null);
                g.drawString("" + tempScores.get(0), 45 + 80 + 120 + 6 + 14, 401);
                g.drawImage(scroll, 45 + 80, 480, 116, 35, null);
                g.drawImage(scroll, 45 + 80 + 116 + 6, 480, 50, 35, null);
                g.drawString("" + tempScores.get(2), 45 + 80 + 116 + 6 + 14, 501);
                g.drawImage(scroll, 665 + 80, 380, 112, 35, null);
                g.drawImage(scroll, 665 + 80 + 112 + 8, 380, 50, 35, null);
                g.drawString("" + tempScores.get(1), 665 + 80 + 112 + 8 + 14, 401);
                g.drawImage(scroll, 665 + 80, 480, 112, 35, null);
                g.drawImage(scroll, 665 + 80 + 112 + 8, 480, 50, 35, null);
                g.drawString("" + tempScores.get(3), 665 + 80 + 112 + 8 + 4, 501);
                g.setColor(Color.CYAN);
                g.setFont(new Font("Old English Text MT", Font.PLAIN, 18));
                g.drawString("Running Score:", 45 + 80 + 100, 431);
                g.drawString("Running Score:", 45 + 80 + 100, 471);
                g.drawString("Running Score:", 665 + 80 + 92 + 2, 431);
                g.drawString("Running Score:", 665 + 80 + 92 + 2, 471);
                g.setColor(Color.BLACK);
                Collections.sort(tempScores);
                Collections.reverse(tempScores);
                //yw
                System.out.println(tempScores);
                boolean found=false;
                int i=0;
                while(!found) {
                    System.out.println("flag1");
                    if (listScores.get(0).equals(tempScores.get(i))) {
                        switch (i) {
                            //within each, we draw the number+1 image at the location of player tag
                            case 0:
                                g.drawImage(y1, 60, 375, 60, 60, null);
                                found=true;
                                break;
                            case 1:
                                g.drawImage(y2, 60, 375, 60, (int)(19./20.*60), null);
                                 found=true;
                                    break;
                                case 2:
                                    g.drawImage(y3, 60, 375, 60, 60, null);
                                    found=true;
                                    break;
                                case 3:
                                    g.drawImage(y4, 60, 375, 60, (int)(14./15.*60), null);
                                    found=true;
                                    break;
                        }
                    }
                    i++;
                }
                System.out.println("flag2");
                found=false;
                i=0;
                    while(!found) {
                        if(listScores.get(1).equals(tempScores.get(i))){
                            switch(i){
                                case 0:
                                    g.drawImage(b1,680,375,60,60,null);
                                    found=true;
                                    break;
                                case 1:
                                    g.drawImage(b2,680,375,60,(int)(10./11.*60),null);
                                    found=true;
                                    break;
                                case 2:
                                    g.drawImage(b3,680,375,60,(int)(10./11.*60),null);
                                    found=true;
                                    break;
                                case 3:
                                    g.drawImage(b4,680,375,60,(int)(0.9375*60.),null);
                                    found=true;
                                    break;
                            }
                        }

                        i++;
                    }

                found=false;

            i=0;
                    while(!found) {
                    if(listScores.get(2).equals(tempScores.get(i))){
                        switch(i){
                            //within each, we draw the number+1 image at the location of player tag
                            case 0:
                                g.drawImage(g1,60,470,60,45,null);
                                found=true;
                                break;
                            case 1:
                                g.drawImage(g_emotion_2,60,470,60,48,null);
                                found=true;
                                break;
                            case 2:
                                g.drawImage(g3,60,470,60,51,null);
                                found=true;
                                break;
                            case 3:
                                g.drawImage(g4,60,470,60,48,null);
                                found=true;
                                break;
                        }
                    }
                        i++;
                    }
                found=false;

            i=0;
                    while(!found) {
                    if(listScores.get(3).equals(tempScores.get(i))){
                        switch(i){
                            //within each, we draw the number+1 image at the location of player tag
                            case 0:
                                g.drawImage(r1,680,460,60,60,null);
                                found=true;
                                break;
                            case 1:
                                g.drawImage(r2,680,460,60,(int)(21./20.5*60),null);
                                found=true;
                                break;
                            case 2:
                                g.drawImage(r3,680,460,60,60,null);
                                found=true;
                                break;
                            case 3:
                                g.drawImage(r4,680,460,60,(int)(23./21.*60),null);
                                found=true;
                                break;
                        }
                    }
                    i++;
                    }
                g.setColor(Color.BLACK);
            }


            g.drawImage(rotate(scroll, -67.55), 380, 370, 110, 200, null);
            g.drawImage(rotate(scroll, -67.55), 490, 370, 110, 200, null);
            //central scrolls
            if(!allowScoring){
                g.drawImage(scroll, 435, 15, 110, 100, null);
                g.drawImage(scroll, 435, 120, 110, 100, null);

                g.drawImage(scroll, 380, 600, 220, 90, null);
                g.drawImage(scroll, 380, 700, 220, 90, null);

                g.drawImage(scroll, 390, 220, 200, 60, null);
                g.setFont(new Font("Old English Text MT", Font.ROMAN_BASELINE, 17));
                g.drawString("Player Order:", 399, 245);
                g.drawString(gameState.getAllPlayersCommas(), 399, 270);
                g.setFont(new Font("Old English Text MT", Font.ROMAN_BASELINE, 18));
                g.drawImage(scroll, 380, 800, 220, 90, null);


                g.drawImage(scroll, 445, 280, 90, 80, null);
                g.drawImage(grid, 446, 281, 89, 79, null);
                if(!noGrids)
                {
                    g.drawImage(nope, 456, 290, 70, 60, null);
                }
            }
            g.drawImage(scroll, 5, 900, 980, 135, null);


            if(!allowScoring)
            {
                whosTurn=gameState.getCurrentPlayer().getName();
                System.out.println("\ncurrent Player is: "+whosTurn);
                if(whosTurn.equals("Player Yellow")){
                    g.setColor(Color.BLACK);
                    g.drawString("Player",460,65);
                    g.drawString("Yellow",460,83);
                }else if(whosTurn.equals("Player Blue")){
                    g.setColor(Color.BLACK);
                    g.drawString("Player",460,65);
                    g.drawString("Blue",460,83);
                }else if(whosTurn.equals("Player Green")){
                    g.setColor(Color.BLACK);
                    g.drawString("Player",460,65);
                    g.drawString("Green",460,83);
                }else if(whosTurn.equals("Player Red")){
                    g.setColor(Color.BLACK);
                    g.drawString("Player",460,65);
                    g.drawString("Red",460,83);
                }
            }
            g2.setStroke(new BasicStroke(10));
            g.drawString("Player Yellow",130,402);
            g.drawString("Player Green",132,503);
            g.drawString("Player Blue",750,402);
            g.drawString("Player Red",754,503);
            g.drawString("Dominoes",400,400);
            g.drawString(" In Play",396,418);
            g.drawString("Domino",517,400);
            g.drawString("Queue",517,418);
            if(!allowScoring)
            {
                g.setColor(Color.BLACK);
                g.drawString("Instruction Messages",412,625);
                g.setColor(new Color(76, 67, 64, 255));
            }

            if(!allowScoring)
            {
                System.out.println("   highlight= "+highlight+", cover1: "+cover1+", firstTimeCover1: "+firstTimeCover1+", confirmChoice: "+confirmChoice);
                if(gameState.getAllowEnding())
                {
                    g.drawString(whosTurn+", end your", 392, 644);
                    g.drawString("turn", 465, 661);
                }else if(gameState.getAllowPlacing()){
                    if(!tileSurrounding&&!cover1)
                    {
                        g.drawString(gameState.getCurrentPlayer().getName()+", click on a", 392, 644);
                        g.drawString("tile below", 415, 661);
                        for(Domino i:gameState.getOptionDeck()){
                            if(gameState.getIsLastRound())
                            {
                                System.out.println("\nLastRound, currentPlayer: "+gameState.getCurrentPlayer().getName());
                            }
                            if(i.getPlayer().getName().equals(gameState.getCurrentPlayer().getName())){
                                System.out.println("Domino's value: "+i.getValue()+" and owner: "+i.getPlayer().getName());
                                g.drawImage(i.getFront(),414,810,140,70,null);
                                gameState.setCurrentDomino(i);
                            }
                        }
                    }
                    else if(!highlight||highlight&&(cover1&&firstTimeCover1))
                    {
                        g.drawString(gameState.getCurrentPlayer().getName()+", click on a",392, 644);
                        g.drawString("square on your grid", 415, 661);
                        for(Domino i:gameState.getOptionDeck()){
                            if(gameState.getIsLastRound())
                            {
                                System.out.println("\nLastRound, currentPlayer: "+gameState.getCurrentPlayer().getName());
                            }
                            if(i.getPlayer().getName().equals(gameState.getCurrentPlayer().getName())){
                                System.out.println("Domino's value: "+i.getValue()+" and owner: "+i.getPlayer().getName());
                                g.drawImage(i.getFront(),414,810,140,70,null);
                                gameState.setCurrentDomino(i);
                            }
                        }
                    }
                    else
                    {
                        g.drawString(gameState.getCurrentPlayer().getName()+", click on the", 392, 644);
                        g.drawString("place button to finalize", 415, 661);
                        for(Domino i:gameState.getOptionDeck()){
                            if(gameState.getIsLastRound())
                            {
                                System.out.println("\nLastRound, currentPlayer: "+gameState.getCurrentPlayer().getName());
                            }
                            if(i.getPlayer().getName().equals(gameState.getCurrentPlayer().getName())){
                                System.out.println("Domino's value: "+i.getValue()+" and owner: "+i.getPlayer().getName());
                                g.drawImage(i.getFront(),414,810,140,70,null);
                                gameState.setCurrentDomino(i);
                            }
                        }
                    }
                }else if(gameState.getAllowChoosing())
                {
                    if(confirmChoice)
                    {
                        g.drawString(gameState.getCurrentPlayer().getName()+", click on the", 392, 644);
                        g.drawString("choose button",415, 661);
                    }
                    else
                    {
                        if(gameState.getIsFirstRound()||gameState.getIsLastRound())
                        {
                            g.drawString(gameState.getCurrentPlayer().getName()+", choose a", 392, 644);
                            g.drawString("domino in play", 415, 661);
                        }
                        else
                        {
                            g.drawString(gameState.getCurrentPlayer().getName()+", choose a", 392, 644);
                            g.drawString("domino in queue", 415, 661);
                        }
                    }
                }

                g.setColor(Color.BLACK);
                g.drawString("Error Messages",430,725);
                g.setColor(new Color(76, 67, 64, 255));
                g.drawString(gameState.getErrorMessage(), 388, 744);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Old English Text MT",Font.PLAIN,25));
                //DECK SIZE
                String s=Integer.toString(gameState.getMainDeck().getDeckSize());
                g.drawString(s,475,165);
                g.setFont(new Font("Old English Text MT",Font.PLAIN,17));
                g.drawString("dominoes left",447,185);
                g.setFont(new Font("Old English Text MT",Font.PLAIN,18));
            }
            g.drawImage(house,50,925,75,75,null);
            g.drawString("Menu",65,1015);
            if(!allowScoring)
            {
            	g.drawImage(place,250,925,75,75,null);
                g.drawString("Place",265,1010);
            }
            if(!allowScoring)
            {
                g.drawImage(trash,450,925,75,75,null);
                g.drawString("Discard",460,1015);
            }
            if(roundCounter!=12)
            {
                g.drawImage(crown,650,925,75,75,null);
                g.drawString("Choose",660,1010);
            }

            g.drawImage(details,850,925,75,75,null);
            g.drawString("Score Details",844,1015);
            g2.setStroke(new BasicStroke(1));
            g.setColor(new Color(102, 51, 0));

            g.drawImage(gameState.getOptionDeck().get(0).getFront(), optionDeckX, optionAndNextRoundDeckYs[0], 58, 29, null);//We are testing where to draw dominoes in optionDeck
            g.drawRect(optionDeckX-1, optionAndNextRoundDeckYs[0]-1, 59, 30);
            g.drawImage(gameState.getOptionDeck().get(1).getFront(), optionDeckX, optionAndNextRoundDeckYs[1], 58, 29, null);
            g.drawRect(optionDeckX-1, optionAndNextRoundDeckYs[1]-1, 59, 30);
            g.drawImage(gameState.getOptionDeck().get(2).getFront(), optionDeckX, optionAndNextRoundDeckYs[2], 58, 29, null);
            g.drawRect(optionDeckX-1, optionAndNextRoundDeckYs[2]-1, 59, 30);
            g.drawImage(gameState.getOptionDeck().get(3).getFront(), optionDeckX, optionAndNextRoundDeckYs[3], 58, 29, null);
            g.drawRect(optionDeckX-1, optionAndNextRoundDeckYs[3]-1, 59, 30);

            if(roundCounter!=12)
            {
                g.drawImage(gameState.getNextRoundDeck().get(0).getFront(), nextRoundDeckX, optionAndNextRoundDeckYs[0], 58, 29, null);//We are testing where to draw dominoes in nextRoundDeck
                g.drawRect(nextRoundDeckX-1, optionAndNextRoundDeckYs[0]-1, 59, 30);
                g.drawImage(gameState.getNextRoundDeck().get(1).getFront(), nextRoundDeckX, optionAndNextRoundDeckYs[1], 58, 29, null);
                g.drawRect(nextRoundDeckX-1, optionAndNextRoundDeckYs[1]-1, 59, 30);
                g.drawImage(gameState.getNextRoundDeck().get(2).getFront(), nextRoundDeckX, optionAndNextRoundDeckYs[2], 58, 29, null);
                g.drawRect(nextRoundDeckX-1, optionAndNextRoundDeckYs[2]-1, 59, 30);
                g.drawImage(gameState.getNextRoundDeck().get(3).getFront(), nextRoundDeckX, optionAndNextRoundDeckYs[3], 58, 29, null);
                g.drawRect(nextRoundDeckX-1, optionAndNextRoundDeckYs[3]-1, 59, 30);
            }

            g.setFont(new Font("Old English Text MT",Font.BOLD,18));
            g.setColor(Color.BLACK);
            //Integer.toString(gameState.getOptionDeck().get(0).getValue()), optionDeckX-19, optionAndNextRoundDeckYs[0]+15
            g.drawString(Integer.toString(gameState.getOptionDeck().get(0).getValue()), optionDeckX-19, optionAndNextRoundDeckYs[0]+15);
            g.drawString(Integer.toString(gameState.getOptionDeck().get(1).getValue()), optionDeckX-19, optionAndNextRoundDeckYs[1]+15);
            g.drawString(Integer.toString(gameState.getOptionDeck().get(2).getValue()), optionDeckX-19, optionAndNextRoundDeckYs[2]+15);
            g.drawString(Integer.toString(gameState.getOptionDeck().get(3).getValue()), optionDeckX-19, optionAndNextRoundDeckYs[3]+15);

            g.drawImage(optionOwner[0],463,425,15,28,null);
            g.drawImage(optionOwner[1],463,457,15,28,null);
            g.drawImage(optionOwner[2],463,492,15,28,null);
            g.drawImage(optionOwner[3],463,525,15,28,null);

            if(roundCounter==12)
            {
                gameState.setIsLastRound(true);
            }
            if(!gameState.getIsLastRound())
            {
                g.drawString(Integer.toString(gameState.getNextRoundDeck().get(0).getValue()), nextRoundDeckX-19, optionAndNextRoundDeckYs[0]+15);
                g.drawString(Integer.toString(gameState.getNextRoundDeck().get(1).getValue()), nextRoundDeckX-19, optionAndNextRoundDeckYs[1]+15);
                g.drawString(Integer.toString(gameState.getNextRoundDeck().get(2).getValue()), nextRoundDeckX-19, optionAndNextRoundDeckYs[2]+15);
                g.drawString(Integer.toString(gameState.getNextRoundDeck().get(3).getValue()), nextRoundDeckX-19, optionAndNextRoundDeckYs[3]+15);

                g.drawString(Integer.toString(gameState.getNextRoundDeck().get(0).getValue()), nextRoundDeckX-19, optionAndNextRoundDeckYs[0]+15);
                g.drawString(Integer.toString(gameState.getNextRoundDeck().get(1).getValue()), nextRoundDeckX-19, optionAndNextRoundDeckYs[1]+15);
                g.drawString(Integer.toString(gameState.getNextRoundDeck().get(2).getValue()), nextRoundDeckX-19, optionAndNextRoundDeckYs[2]+15);
                g.drawString(Integer.toString(gameState.getNextRoundDeck().get(3).getValue()), nextRoundDeckX-19, optionAndNextRoundDeckYs[3]+15);
                g.drawImage(nextOwner[0],575,425,15,28,null);
                g.drawImage(nextOwner[1],575,457,15,28,null);
                g.drawImage(nextOwner[2],575,492,15,28,null);
                g.drawImage(nextOwner[3],575,525,15,28,null);
            }

            newGameLoading=false;
            if(allowScoring)
            {
                g.setColor(new Color(0,0,0, 47));
                g.fillRect(375, 21, 232, 300);
                g.setColor(Color.BLACK);
                g.drawImage(rotator.rotate270(scroll), 365, 19, 250, 320, null);
                g.drawImage(rotator.rotate270(scroll), 365, 19, 250, 320, null);
                g.drawImage(rotator.rotate270(scroll), 365, 19, 250, 320, null);
                g.drawImage(rotator.rotate270(scroll), 365, 19, 250, 320, null);
                g.setFont(new Font("Old English Text MT",Font.PLAIN,18));
                g.drawString("Final Scores", 400, 50);
                g.drawString("~~~~~~~~~~~~~", 400, 60);
                if(firstTimeScoring)
                {
                    System.out.println("Player Yellow's Territories:");
                    yScore=gameState.getPlayerY().getGrid().score();
                    System.out.println("Player Blue's Territories:");
                    bScore=gameState.getPlayerB().getGrid().score();
                    System.out.println("Player Green's Territories:");
                    gScore=gameState.getPlayerG().getGrid().score();
                    System.out.println("Player Red's Territories:");
                    rScore=gameState.getPlayerR().getGrid().score();
                    System.out.println("Yellow: "+scores[0]+", Blue: "+scores[1]+", Green: "+scores[2]+", Red: "+scores[3]);
                    scores[0]=yScore;
                    scores[1]=bScore;
                    scores[2]=gScore;
                    scores[3]=rScore;
                    int max=scores[0];
                    for(int i=1; i<scores.length; i++)
                    {
                        if(max<scores[i])
                        {
                            max=scores[i];
                        }
                    }
                    System.out.println("\nmax score is: "+max);
                    //Loop through players and find the ones that match max?
                    for(int i=0; i<scores.length; i++)
                    {
                        if(scores[i]==max)
                        {
                            ties.add(i);
                            tiesScores.add(scores[i]);
                        }
                    }
                    System.out.println("\nties size is: "+ties.size());
                    if(ties.size()==1)
                    {
                        //
                        int h=ties.get(0);
                        if(h==0)
                        {
                            winner="Yellow";
                        }
                        if(h==1)
                        {
                            winner="Blue";
                        }
                        if(h==2)
                        {
                            winner="Green";
                        }
                        if(h==3)
                        {
                            winner="Red";
                        }
                    }
                    else
                    {
                        int biggest=tiesScores.get(0);
                        //Go through ties and see which have the biggest territories
                        for(int i=1; i<tiesScores.size(); i++)
                        {
                            if(tiesScores.get(i)>biggest)
                            {
                                biggest=tiesScores.get(i);
                            }
                        }
                        ArrayList<String> biggestPlayers=new ArrayList<>();
                        for(int i=0; i<tiesScores.size(); i++)
                        {
                            String s="";
                            if(tiesScores.get(i)==biggest)
                            {
                                if(ties.get(i)==0)
                                {
                                    s="Yellow";
                                }
                                if(ties.get(i)==1)
                                {
                                    s="Blue";
                                }
                                if(ties.get(i)==2)
                                {
                                    s="Green";
                                }
                                if(ties.get(i)==3)
                                {
                                    s="Red";
                                }
                            }
                            biggestPlayers.add(s);
                        }
                        winner=biggestPlayers.get(0);
                        for(int i=1; i<biggestPlayers.size(); i++)
                        {
                            winner+=", "+biggestPlayers.get(i);
                        }

                    }
                    firstTimeScoring=false;
                    System.out.println("\nscores: "+scores[0]+" "+scores[1]+" "+scores[2]+" "+scores[3]+"\n");
                    //rank from greatest to least
                    max=0;
                    int hold=0;
                    for(int i=0; i<scores.length; i++)
                    {
                        if(max<scores[i])
                        {
                            max=scores[i];
                            hold=i;
                        }
                    }
                    rankscores[0]=max;
                    scores[hold]=0;
                    max=0;
                    for(int i=0; i<scores.length; i++)
                    {
                        if(max<scores[i])
                        {
                            max=scores[i];
                            hold=i;
                        }
                    }
                    rankscores[1]=max;
                    scores[hold]=0;
                    max=0;
                    for(int i=0; i<scores.length; i++)
                    {
                        if(max<scores[i])
                        {
                            max=scores[i];
                            hold=i;
                        }
                    }
                    rankscores[2]=max;
                    scores[hold]=0;
                    max=0;
                    for(int i=0; i<scores.length; i++)
                    {
                        if(max<scores[i])
                        {
                            max=scores[i];
                            hold=i;
                        }
                    }
                    rankscores[3]=max;
                    scores[hold]=0;
                    max=0;
                    System.out.println("rank scores: "+rankscores[0]+" "+rankscores[1]+" "+rankscores[2]+" "+rankscores[3]);
                    for(int i=0; i<4; i++)
                    {
                        if(gameState.getThePlayers().get(i).getGrid().getScore()==rankscores[0])
                        {
                            rankPlayers.add(gameState.getThePlayers().get(i));
                            break;
                        }
                    }
                    System.out.println("rankPlayers.size: "+rankPlayers.size());
                    //System.out.println("rankPlayers first: "+rankPlayers.get(0).getName());
                    for(int i=0; i<4; i++)
                    {
                        if(gameState.getThePlayers().get(i).getGrid().getScore()==rankscores[1])
                        {
                            if(!rankPlayers.contains(gameState.getThePlayers().get(i)))
                            {
                                rankPlayers.add(gameState.getThePlayers().get(i));
                                break;
                            }
                        }
                    }
                    for(int i=0; i<4; i++)
                    {
                        if(gameState.getThePlayers().get(i).getGrid().getScore()==rankscores[2])
                        {
                            if(!rankPlayers.contains(gameState.getThePlayers().get(i)))
                            {
                                rankPlayers.add(gameState.getThePlayers().get(i));
                                break;
                            }
                        }
                    }
                    for(int i=0; i<4; i++)
                    {
                        if(gameState.getThePlayers().get(i).getGrid().getScore()==rankscores[3])
                        {
                            if(!rankPlayers.contains(gameState.getThePlayers().get(i)))
                            {
                                rankPlayers.add(gameState.getThePlayers().get(i));
                                break;
                            }
                        }
                    }
                }

                if(ties.size()==1)
                {
                    g.drawString("No Ties", 400, 308);
                }
                System.out.println("      made it here");
                /*
                This code works fine, keep it safe.
                g.drawString("Player Yellow Score: "+scores[0], 400, 339);
                g.drawString("Player Blue Score: "+scores[1], 400, 389);
                g.drawString("Player Green Score: "+scores[2], 400, 439);
                g.drawString("Player Red Score: "+scores[3], 400, 489);*/

                g.drawString(rankPlayers.get(0).getName()+" Score: "+rankscores[0], 400, 79);
                g.drawString(rankPlayers.get(1).getName()+" Score: "+rankscores[1], 400, 129);
                g.drawString(rankPlayers.get(2).getName()+" Score: "+rankscores[2], 400, 179);
                g.drawString(rankPlayers.get(3).getName()+" Score: "+rankscores[3], 400, 229);
                g.drawString("Winner:", 400, 260);
                g.drawString(winner, 400, 278);

                lockedp=true;
                lockedg=true;
                lockedd=true;
                lockedp=true;
                gameState.setAllowPlacing(false);
                gameState.setAllowPlace1(false);
                gameState.setAllowPlace2(false);
                gameState.setAllowChoosing(false);
                gameState.setAllowEnding(false);
            }
            if(confirmChoice&&newGame)
            {
                System.out.println("confirmChoice");
                g.setColor(Color.RED);
                if(gameState.getIsFirstRound())
                {
                    System.out.println("\nFirst Round, choosing in optionDeck");
                    int x=optionDeckX;
                    int y=optionAndNextRoundDeckYs[gameState.getChosenDomino()];
                    g.drawRect(x-1, y-1, 59, 30);
                    for(int i=0; i<4; i++)
                    {
                        g.setColor(new Color(102, 51, 0));
                        if(i!=gameState.getChosenDomino())
                        {
                            int x2=optionDeckX;
                            int y2=optionAndNextRoundDeckYs[i];
                            g.drawRect(x2-1, y2-1, 59, 30);
                        }
                    }
                    g.setColor(Color.RED);
                    if(canDrawDomino)
                    {
                        g.drawImage(gameState.getOptionDeck().get(gameState.getChosenDomino()).getFront(), 414, 810, 140, 70, null);
                    }
                    g.drawRect(413,809,141,71);
                    g.setColor(new Color(102, 51, 0));
                }
                else if(roundCounter!=12)
                {
                    System.out.println("\nroundCounter is not 12, choosing in nextRound");
                    int x=nextRoundDeckX;
                    int y=optionAndNextRoundDeckYs[gameState.getChosenDomino()];
                    g.drawRect(x-1, y-1, 59, 30);
                    System.out.println("drew Rect");
                    for(int i=0; i<4; i++)
                    {
                        g.setColor(new Color(102, 51, 0));
                        if(i!=gameState.getChosenDomino())
                        {
                            int x2=nextRoundDeckX;
                            int y2=optionAndNextRoundDeckYs[i];
                            g.drawRect(x2-1, y2-1, 59, 30);
                        }
                    }
                }
                //confirmChoice=false;
            }
            if(tileSurrounding)
            {
                System.out.println("\nTileSurrounding");
                g.setColor(Color.RED);
                if(placed1==false)
                {
                    if(currentTileDirection==0){
                        g.drawRect(413,809,70,70);
                        //pickedTile1=true;
                    }else if(currentTileDirection==1){
                        g.drawRect(483,809,70,70);
                        //pickedTile1=false;
                    }
                }
                else
                {
                    if(gameState.getCurrentTile().getSide().equals("left")){
                        g.drawRect(413,809,70,70);
                        //pickedTile1=true;
                    }else if(gameState.getCurrentTile().getSide().equals("right")){
                        g.drawRect(483,809,70,70);
                        //pickedTile1=false;
                    }
                }
                lockedg=false;
            }
            if(cover1)
            {
                System.out.println("\ncover1");
                g.setColor(new Color(0, 0, 0, 186));
                if(firstTileDirection==0){
                    g.fillRect(413,809,71,71);
                }
                else if(firstTileDirection==1){
                    g.fillRect(483,809,71,71);
                }
                if(firstTimeCover1)
                {
                    //adding tile to painting
                    Painting e=new Painting(39, 39, finalhx, finalhy, g.getColor());
                    paintingsh.add(e);
                    firstTimeCover1=false;
                    highlight=false;
                    firstTile=gameState.getCurrentTile();
                    lastTile=gameState.getCurrentTile();
                    System.out.println("1 lastTile's gridX, gridY, and landtype:"+lastTile.getGridX()+", "+lastTile.getGridY()+", "+lastTile.getLandType());
                    gameState.setErrorMessage("");
                    placed1=true;
                    lockedd=true;
                    System.out.println("\n updated placed1 is: "+placed1+"\n");
                    System.out.println("\nCurrentTile's side is "+gameState.getCurrentTile().getSide());
                    if(gameState.getCurrentTile().getSide().equals("left"))
                    {
                        gameState.setCurrentTile(gameState.getCurrentDomino().getTile2());
                        //On last round, if second player places, this line is never reached
                        System.out.println("\nPlaced currentTile successfully, other tile is right");
                    }
                    else if(gameState.getCurrentTile().getSide().equals("right"))
                    {
                        //On last round, if second player places, this line is never reached
                        gameState.setCurrentTile(gameState.getCurrentDomino().getTile1());
                        System.out.println("\nPlaced currentTile successfully, other tile is left");
                    }
                    else
                    {
                        System.out.println("other tile has side of blank, not left or right");
                    }
                    //You've placed the firstTile
                    placeCounter++;
                    gameState.setAllowPlace1(false);
                }
                //Unable to place second tile on some occasions
                tileSurrounding=false;
            }
            if(cover2)
            {
                System.out.println("\ncover2");
                g.setColor(new Color(0, 0, 0, 186));
                if(gameState.getCurrentTile().getSide().equals("left")){
                    g.fillRect(413,809,71,71);
                }
                else if(gameState.getCurrentTile().getSide().equals("right")){
                    g.fillRect(483,809,71,71);
                }
                gameState.setErrorMessage("");
                if(firstTimeCover2)
                {
                    Painting e=new Painting(39, 39, finalh2x, finalh2y, g.getColor());
                    paintingsh.add(e);
                    firstTimeCover2=false;
                    cover2=false;
                    highlight=false;
                    secondTile=gameState.getCurrentTile();
                    System.out.println("first tile x is at "+firstTile.getX()+" \nsecond tile x is at"+secondTile.getX());
                    //180
                    if(gameState.getCurrentDomino().getTile1().getX()>gameState.getCurrentDomino().getTile2().getX()){
                        gameState.getCurrentDomino().setLocation(gameState.getCurrentDomino().getTile2().getX(), gameState.getCurrentDomino().getTile2().getY());
                        gameState.getCurrentDomino().setRotate("180");
                        addedDominoes.add(gameState.getCurrentDomino());
                    }//no rotate
                    else if(gameState.getCurrentDomino().getTile1().getX()<gameState.getCurrentDomino().getTile2().getX()){
                        gameState.getCurrentDomino().setLocation(gameState.getCurrentDomino().getTile1().getX(), gameState.getCurrentDomino().getTile1().getY());
                        gameState.getCurrentPlayer().getGrid().addDomino(gameState.getCurrentDomino());
                        addedDominoes.add(gameState.getCurrentDomino());
                    }//90
                    else if(gameState.getCurrentDomino().getTile1().getY()>gameState.getCurrentDomino().getTile2().getY()){
                        gameState.getCurrentDomino().setLocation(gameState.getCurrentDomino().getTile2().getX(), gameState.getCurrentDomino().getTile2().getY());
                        gameState.getCurrentDomino().setRotate("90");
                        addedDominoes.add(gameState.getCurrentDomino());
                    }//270
                    else if(gameState.getCurrentDomino().getTile1().getY()<gameState.getCurrentDomino().getTile2().getY()){
                        gameState.getCurrentDomino().setLocation(gameState.getCurrentDomino().getTile1().getX(), gameState.getCurrentDomino().getTile1().getY());
                        gameState.getCurrentDomino().setRotate("270");
                        addedDominoes.add(gameState.getCurrentDomino());
                    }

                    //addedDominoes.add(gameState.getCurrentDomino());
                    if(gameState.getIsLastRound())
                    {
                        lastRoundMoves++;
                    }

                    //You've placed secondTile
                    placeCounter++;
                    gameState.setAllowPlace2(false);
                    gameState.setAllowPlacing(false);
                    cover1=false;
                }
                //draw domino on grid rotated
                if(!gameState.getIsLastRound())
                {
                    System.out.println("not last round, allowChoosing");
                    gameState.setAllowChoosing(true);
                    lockedc=false;
                }
                else
                {
                    System.out.println("last round, do not allowChoosing");
                    gameState.setAllowChoosing(false);
                    lockedc=true;
                    gameState.setAllowEnding(true);
                }
            }
            if(highlight)
            {
                System.out.println("\nHighlight");
                g.setColor(new Color(0, 0, 0, 89));
                g.fillRect(hx, hy, 39, 39);
            }
            for(Painting p:paintingsh)
            {
                g.setColor(p.getColor());
                g.fillRect(p.getPlaceX(),p.getPlaceY(), p.getSizeX(), p.getSizeY());
            }
            for(Domino d:addedDominoes)
            {
                if(d.getRotate().equals(""))
                {
                    //System.out.println("\nno rotation\n");
                    g.drawImage(d.getFront(), d.getX(), d.getY(), 79, 39, null);
                }
                if(d.getRotate().equals("90"))
                {
                    //System.out.println("\n90\n");
                    g.drawImage(rotator.rotate90(d.getFront()), d.getX(), d.getY(), 39, 79, null);
                }
                if(d.getRotate().equals("180"))
                {
                    //System.out.println("\n180\n");
                    g.drawImage(rotator.rotate180(d.getFront()), d.getX(), d.getY(), 79, 39, null);
                }
                if(d.getRotate().equals("270"))
                {
                    //System.out.println("\n270\n");
                    g.drawImage(rotator.rotate270(d.getFront()), d.getX(), d.getY(), 39, 79, null);
                }
            }
            if(gameState.getIsLastRound())
            {
                System.out.println("LastRoundMoves: "+lastRoundMoves);
            }
            g.setFont(new Font("Old English Text MT",Font.PLAIN,18));
            g.setColor(new Color(76, 67, 64, 255));
            g.drawString(gameState.getErrorMessage(), 388, 744);
            g2.setStroke(new BasicStroke(1));
            g.drawLine(6, 6, 6, 365);
        }
    }
    public void mousePressed(MouseEvent e){
        //String filepath = "Images/click.wav";
        //music musicObject = new music();
        //musicObject.playMusic(filepath);
        int x = e.getX();
        int y = e.getY();
        Point p=new Point(x, y);
        if(e.getButton() == MouseEvent.BUTTON1){
            if(newGame&&x>50&&x<125&&y>925&&y<1000){
                System.out.println("mainmenu");
                loading=true;
                newGame=false;
                instructions=false;
                mainMenu=true;
                repaint();
                return;
            }
            if(scoreSpecifics&&x>135&&x<210&&y>115&&y<190){
                newGame=true;
                scoreSpecifics=false;
                repaint();
                return;
            }
            if(mainMenu&&x>780&&x<870&&y>300&&y<390){
                System.out.println("info page");
                mainMenu=false;
                information=true;
                repaint();
                return;
            }
            if(mainMenu&&x>130&&x<210&&y>500&&y<590){
                mainMenu=false;
                emojis=true;
                repaint();
                return;
            }
            //resetter
            if(mainMenu&&x>130&&x<220&&y>300&&y<390){
                System.out.println("reset");
                gameState=new GameState();
                paintingsh.clear();
                addedDominoes.clear();
                {
                    confirmChoice=false;
                    optionDeckX=403;
                    nextRoundDeckX=515;
                    optionAndNextRoundDeckYs=new int[4];
                    optionAndNextRoundDeckYs[0]=425;
                    optionAndNextRoundDeckYs[1]=458;
                    optionAndNextRoundDeckYs[2]=491;
                    optionAndNextRoundDeckYs[3]=525;
                    gameState=new GameState();
                    discardButton=new Discard(450, 925);
                    optionOwner=new BufferedImage[4];
                    nextOwner=new BufferedImage[4];
                    rotator=new RotateDomino();
                    firstRoundCtr=0;
                    tileSurrounding=false;
                    currentTileDirection=-1;
                    firstTileDirection=-1;
                    placed1=false;
                    for(int i=0; i<4; i++)
                    {

                        optionOwner[i]=emptyking;
                        nextOwner[i]=emptyking;
                    }
                    highlight=false;
                    hx=-1;
                    hy=-1;
                    clickedGridX=-1;
                    clickedGridY=-1;
                    cover1=false;
                    cover2=false;
                    finalhx=-1;
                    finalhy=-1;
                    finalh2x=-1;
                    finalh2y=-1;
                    lastTile=new Tile(scroll);
                    placeCounter=0;
                    paintingsh=new ArrayList<>();
                    addedDominoes=new ArrayList<>();
                    firstTimeCover1=true;
                    firstTimeCover2=true;
                    firstTile=new Tile(ywking);
                    secondTile=new Tile(ywking);
                    lockedp=true;
                    lockedg=true;
                    lockedd=true;
                    canDrawDomino=true;
                    lockedc=true;
                    roundCounter=0;
                    allowScoring=false;
                    lastRoundMoves=0;
                    pickedTileCounter=0;
                    firstTimeScoring=true;
                    scores=new int[4];
                    scores[0]=-1;
                    scores[1]=-1;
                    scores[2]=-1;
                    scores[3]=-1;
                    yScore=-1;
                    bScore=-1;
                    gScore=-1;
                    rScore=-1;
                    ties=new ArrayList<>();
                    tiesScores=new ArrayList<>();
                    winner=gameState.getPlayerY().getName();
                    rankPlayers=new ArrayList<>();
                    rankscores=new int[4];
                    noGrids=false;
                    noGridCounter=0;
                }
                //
                return;
            }
            if(newGame&&x>850&&x<925&&y>925&&y<1000){
                scoreSpecifics=true;
                newGame=false;
                repaint();
                return;
            }
            if(mainMenu&&x>300&&x<700&&y>300&&y<400){
                System.out.println("newGame");
                loading=true;
                newGame=true;
                instructions=false;
                mainMenu=false;
                lockedc=false;
                repaint();
                return;
            }
            if(mainMenu&&x>300&&x<700&&y>500&&y<600){
                System.out.println("instructions");
                loading=true;
                newGame=false;
                instructions=true;
                mainMenu=false;
                repaint();
                return;
            }
            if(instructions&&x>70&&x<195&&y>80&&y<205){
                System.out.println("instructions");
                loading=true;
                newGame=false;
                instructions=false;
                mainMenu=true;
                repaint();
                return;
            }
            if(emojis&&x>70&&x<195&&y>80&&y<205){
                emojis=false;
                newGame=false;
                information=false;
                mainMenu=true;
                repaint();
                return;
            }
            if(information&&x>70&&x<195&&y>80&&y<205){
                loading=true;
                newGame=false;
                information=false;
                mainMenu=true;
                repaint();
                return;
            }
            if(newGame&&!allowScoring&&x>445&&x<445+90&&y>280&&y<360)
            {
                noGridCounter++;
                if(noGridCounter%2==1)
                {
                    noGrids=true;
                }
                else
                {
                    noGrids=false;
                }
                repaint();
                return;
            }
            if(gameState.getAllowPlacing()&&placeCounter!=2){
                //System.out.println("\n prior placed1 is"+placed1+"\n");
                lockedd=false;

                if(x>414&&x<484&&y>810&&y<880 && !placed1) {
                    gameState.setCurrentTile(gameState.getCurrentDomino().getTile1());
                    System.out.println("Picked Left Tile");
                    tileSurrounding=true;
                    gameState.setErrorMessage("");
                    lockedg=false;
                    currentTileDirection=0;
                    pickedTileCounter++;
                    if(pickedTileCounter%2==0)
                    {
                        gameState.getCurrentTile().setProposedLocation(new Location(-1, -1, -1, -1));
                        highlight=false;
                    }
                    else
                    {
                        gameState.getCurrentTile().setProposedLocation(new Location(hx, hy, clickedGridX, clickedGridY));
                    }
                    System.out.println("\nSetting proposed location to: "+clickedGridX+", "+clickedGridY);
                    lockedp=true;
                    repaint();
                    return;
                }else if(x>484&&x<554&&y>810&&y<880&& !placed1){
                    gameState.setCurrentTile(gameState.getCurrentDomino().getTile2());
                    System.out.println("Picked Right Tile");
                    tileSurrounding=true;
                    gameState.setErrorMessage("");
                    lockedg=false;
                    currentTileDirection=1;
                    pickedTileCounter++;
                    if(pickedTileCounter%2==0)
                    {
                        gameState.getCurrentTile().setProposedLocation(new Location(-1, -1, -1, -1));
                        highlight=false;
                    }
                    else
                    {
                        gameState.getCurrentTile().setProposedLocation(new Location(hx, hy, clickedGridX, clickedGridY));
                    }
                    System.out.println("\nSetting proposed location to: "+clickedGridX+", "+clickedGridY);
                    lockedp=true;
                    repaint();
                    return;
                }
                else
                {
                    gameState.setErrorMessage("Click on a tile below");
                }
                repaint();

                Grid g=gameState.getCurrentPlayer().getGrid();


                if(!lockedg)
                {
                    if(g.contains(p))
                    {

                        Location[][] locs=g.getGridLocations();
                        for(int i=0; i<locs.length; i++)
                        {
                            for(int q=0; q<locs[i].length; q++)
                            {
                                if(locs[i][q].contains(p))
                                {
                                    if(!(i==4&&q==4))
                                    {
                                        int check=-1;
                                        if(placed1)
                                        {
                                            check=g.isValidLocation(lastTile, gameState.getCurrentTile(), locs[i][q]);
                                        }
                                        else
                                        {
                                            check=g.isValidLocation(gameState.getCurrentTile(), locs[i][q]);
                                        }
                                        if(check==0&&!lockedg)
                                        {
                                            hx=locs[i][q].getX();
                                            hy=locs[i][q].getY();
                                            highlight=true;
                                            clickedGridX=i;
                                            clickedGridY=q;
                                            gameState.getCurrentTile().setProposedLocation(new Location(hx, hy, clickedGridX, clickedGridY));
                                            if(placed1)
                                            {
                                                gameState.setAllowPlace2(true);
                                                System.out.println("set allowPlace2 to true");
                                            }
                                            else
                                            {
                                                gameState.setAllowPlace1(true);
                                            }
                                            lockedp=false;
                                            lockedd=true;
                                            gameState.setErrorMessage("");
                                            repaint();
                                            return;
                                        }
                                        else if(check==1)
                                        {
                                            gameState.setErrorMessage("Already has tile");
                                            lockedp=true;
                                            highlight=false;
                                            repaint();
                                            return;
                                        }
                                        else if(check==2)
                                        {
                                            gameState.setErrorMessage("Out of Bounds");
                                            lockedp=true;
                                            highlight=false;
                                            repaint();
                                            return;
                                        }
                                        else if(check==3)
                                        {
                                            gameState.setErrorMessage("No matching land type");
                                            lockedp=true;
                                            highlight=false;
                                            repaint();
                                            return;
                                        }
                                        else if(check==4)
                                        {
                                            gameState.setErrorMessage("No room for whole domino");
                                            System.out.println("AvailableRange: "+gameState.getCurrentPlayer().getGrid().getAvailableRange().getMinX()+", "+gameState.getCurrentPlayer().getGrid().getAvailableRange().getMinY()+", "+gameState.getCurrentPlayer().getGrid().getAvailableRange().getMaxX()+", "+gameState.getCurrentPlayer().getGrid().getAvailableRange().getMaxY());
                                            lockedp=true;
                                            highlight=false;
                                            repaint();
                                            return;
                                        }
                                        else if(check==5)
                                        {
                                            gameState.setErrorMessage("No adjacent Tiles");
                                            lockedp=true;
                                            highlight=false;
                                            repaint();
                                            return;
                                        }
                                        else if(check==6)
                                        {
                                            gameState.setErrorMessage("Not adjacent to first Tile");
                                            lockedp=true;
                                            highlight=false;
                                            repaint();
                                            return;
                                        }
                                        else if(check==7)
                                        {
                                            gameState.setErrorMessage("Cannot go beyond 5 x 5");
                                            lockedp=true;
                                            highlight=false;
                                            repaint();
                                            return;
                                        }
                                    }
                                    //isValidLocation(Tile1, target) integer key:
                                    //0=true, clear ErrorMessage
                                    //1=chosen filled location, set ErrorMessage to "Not Empty Location"
                                    //2=outside of availableRange, set ErrorMessage to "Outside of Kingdom"
                                    //3=no matching landType, set ErrorMessage to "No Matching Land"
                                    //4=no empty adjacent locations to "Not enough room for Domino"
                                }
                            }
                        }
                    }
                    else if(!(!tileSurrounding&&!cover1)&&!(!highlight||highlight&&(cover1&&firstTimeCover1)))
                    {
                        gameState.setErrorMessage("Click the place button");
                    }
                    else
                    {
                        gameState.setErrorMessage("Click in your grid");
                    }
                }
            }
            if(x>450&&x<525&&y>925&&y<1000)
            {
                if(!lockedd)
                {
                    if(discardButton.discardDomino(gameState.getCurrentDomino()))
                    {
                        gameState.setAllowPlacing(false);
                        if(gameState.getIsLastRound())
                        {
                            cover1=false;
                            cover2=false;
                            gameState.setErrorMessage("");
                            gameState.setAllowPlacing(true);
                            gameState.setAllowChoosing(false);
                            lockedp=true;
                            lockedc=true;
                            lockedd=false;
                            lockedg=true;
                            tileSurrounding=false;
                            currentTileDirection=-1;
                            firstTileDirection=-1;
                            placed1=false;
                            finalhx=-1;
                            finalhy=-1;
                            finalh2x=-1;
                            finalh2y=-1;
                            lastTile=new Tile(scroll);
                            placeCounter=0;
                            firstTimeCover1=true;
                            firstTimeCover2=true;
                            firstTile=new Tile(ywking);
                            secondTile=new Tile(ywking);
                            clickedGridX=-1;
                            clickedGridY=-1;
                            pickedTileCounter=0;
                            gameState.updateCurrentPlayer();
                            System.out.println("\n   updated CurrentPlayer after discard in last round, currentPlayer: "+gameState.getCurrentPlayer().getName());
                            confirmChoice=false;
                            lastRoundMoves++;
                            repaint();
                            return;
                        }
                        else
                        {
                            gameState.setAllowChoosing(true);
                            lockedc=false;
                        }
                        canDrawDomino=false;
                        tileSurrounding=false;
                    }
                    else
                    {
                    	if(!allowScoring)
                    	{
                        gameState.setErrorMessage("You cannot discard this");
                        System.out.println("\nYou cannot discard this");
                    	}
                    }
                    repaint();
                    return;
                }
                else
                {
                	System.out.println("\n mmmmmm allowScoring is: "+allowScoring);
                	if(!allowScoring)
            		{
                    gameState.setErrorMessage("You cannot discard now");
                    repaint();
                    return;
            		}
                }
            }

            if(x>250&&x<325&&y>925&&y<1000)
            {
                if(!lockedp)
                {
                    if(gameState.getAllowPlace1())
                    {
                        firstTileDirection=currentTileDirection;
                        cover1=true;
                        finalhx=hx;
                        finalhy=hy;
                        lockedp=true;
                        System.out.println("\n set cover1 to true");
                        gameState.getCurrentTile().setLocation(gameState.getCurrentTile().getProposedLocation());
                        System.out.println("current Tile's location is: "+gameState.getCurrentTile().getGridX()+" "+gameState.getCurrentTile().getGridY()+" land type:"+gameState.getCurrentTile().getLandType());
                        gameState.getCurrentPlayer().getGrid().addTile(gameState.getCurrentTile());
                        //System.out.println("\nadded currentTile with landType"+gameState.getCurrentTile().getLandType()+"and at location: "+gameState.getCurrentTile().getGridX()+", "+gameState.getCurrentTile().getGridY()+"\n");
                        gameState.setErrorMessage("");
                        //System.out.println("Confirm Location: "+gameState.getCurrentTile().getLocation().getGridX()+" "+gameState.getCurrentTile().getLocation().getGridY());
                        gameState.getCurrentPlayer().getGrid().setKingdomRange();
                        repaint();
                        return;
                    }
                    System.out.println("gameState.getAllowPlace2: "+gameState.getAllowPlace2());
                    if(gameState.getAllowPlace2())
                    {
                        cover2=true;
                        finalh2x=hx;
                        finalh2y=hy;
                        lockedp=true;
                        System.out.println("\n set cover2 to true");
                        gameState.getCurrentTile().setLocation(gameState.getCurrentTile().getProposedLocation());
                        System.out.println("current Tile's location is: "+gameState.getCurrentTile().getGridX()+" "+gameState.getCurrentTile().getGridY()+" land type:"+gameState.getCurrentTile().getLandType());
                        gameState.getCurrentPlayer().getGrid().addTile(gameState.getCurrentTile());
                        System.out.println("\nadded currentTile with landType"+gameState.getCurrentTile().getLandType()+"and at location: "+gameState.getCurrentTile().getGridX()+", "+gameState.getCurrentTile().getGridY()+"\n");
                        gameState.setErrorMessage("");
                        gameState.getCurrentPlayer().getGrid().setKingdomRange();
                        firstTimeCover2=true;
                        System.out.println("\ncover2");
                        gameState.setErrorMessage("");
                        if(firstTimeCover2)
                        {
                            firstTimeCover2=false;
                            cover2=false;
                            highlight=false;
                            secondTile=gameState.getCurrentTile();
                            System.out.println("first tile x is at "+firstTile.getX()+" \nsecond tile x is at"+secondTile.getX());
                            //180
                            if(gameState.getCurrentDomino().getTile1().getX()>gameState.getCurrentDomino().getTile2().getX()){
                                gameState.getCurrentDomino().setLocation(gameState.getCurrentDomino().getTile2().getX(), gameState.getCurrentDomino().getTile2().getY());
                                gameState.getCurrentDomino().setRotate("180");
                                addedDominoes.add(gameState.getCurrentDomino());
                            }//no rotate
                            else if(gameState.getCurrentDomino().getTile1().getX()<gameState.getCurrentDomino().getTile2().getX()){
                                gameState.getCurrentDomino().setLocation(gameState.getCurrentDomino().getTile1().getX(), gameState.getCurrentDomino().getTile1().getY());
                                gameState.getCurrentPlayer().getGrid().addDomino(gameState.getCurrentDomino());
                                addedDominoes.add(gameState.getCurrentDomino());
                            }//90
                            else if(gameState.getCurrentDomino().getTile1().getY()>gameState.getCurrentDomino().getTile2().getY()){
                                gameState.getCurrentDomino().setLocation(gameState.getCurrentDomino().getTile2().getX(), gameState.getCurrentDomino().getTile2().getY());
                                gameState.getCurrentDomino().setRotate("90");
                                addedDominoes.add(gameState.getCurrentDomino());
                            }//270
                            else if(gameState.getCurrentDomino().getTile1().getY()<gameState.getCurrentDomino().getTile2().getY()){
                                gameState.getCurrentDomino().setLocation(gameState.getCurrentDomino().getTile1().getX(), gameState.getCurrentDomino().getTile1().getY());
                                gameState.getCurrentDomino().setRotate("270");
                                addedDominoes.add(gameState.getCurrentDomino());
                            }

                            //addedDominoes.add(gameState.getCurrentDomino());
                            if(gameState.getIsLastRound())
                            {
                                lastRoundMoves++;
                            }

                            //You've placed secondTile
                            placeCounter++;
                            gameState.setAllowPlace2(false);
                            gameState.setAllowPlacing(false);
                            cover1=false;
                        }
                        //draw domino on grid rotated
                        if(!gameState.getIsLastRound())
                        {
                            System.out.println("not last round, allowChoosing");
                            gameState.setAllowChoosing(true);
                            lockedc=false;
                        }
                        else
                        {
                            System.out.println("last round, do not allowChoosing");
                            gameState.setAllowChoosing(false);
                            lockedc=true;
                        }
                        repaint();
                        System.out.println("repainted, cover2 was: "+cover2);
                        if(gameState.getIsLastRound())
                        {
                            cover1=false;
                            cover2=false;
                            gameState.setErrorMessage("");
                            gameState.setAllowPlacing(true);
                            gameState.setAllowChoosing(false);
                            lockedp=true;
                            lockedc=true;
                            lockedd=false;
                            lockedg=true;
                            tileSurrounding=false;
                            currentTileDirection=-1;
                            firstTileDirection=-1;
                            placed1=false;
                            finalhx=-1;
                            finalhy=-1;
                            finalh2x=-1;
                            finalh2y=-1;
                            lastTile=new Tile(scroll);
                            placeCounter=0;
                            firstTimeCover1=true;
                            firstTimeCover2=true;
                            firstTile=new Tile(ywking);
                            secondTile=new Tile(ywking);
                            clickedGridX=-1;
                            clickedGridY=-1;
                            pickedTileCounter=0;
                            gameState.updateCurrentPlayer();
                            System.out.println("\n   updated CurrentPlayer after place in last round, currentPlayer: "+gameState.getCurrentPlayer().getName());
                            confirmChoice=false;
                            repaint();
                            return;
                        }
                        repaint();
                        return;
                    }
                }
                else
                {
                	if(!allowScoring)
	                {
	                    gameState.setErrorMessage("You cannot place now");
	                    repaint();
	                    return;
                	}
                }
            }
            if(newGame&&gameState.getAllowChoosing())
            {
                if(gameState.getIsFirstRound())
                {
                    if(x>=403&&x<=461&&y>=425&&y<=454)
                    {
                        if(gameState.getOptionDeck().get(0).getPlayer().getName().equals("Player Blank"))
                        {
                            gameState.setChosenDomino(0);
                            gameState.setErrorMessage("");
                            confirmChoice=true;
                            System.out.println("Chose the first domino");
                        }else{
                            gameState.setErrorMessage("That's already taken!");
                        }
                    }
                    else if(x>=403&&x<=461&&y>=458&&y<=487)
                    {
                        if(gameState.getOptionDeck().get(1).getPlayer().getName().equals("Player Blank"))
                        {
                            gameState.setChosenDomino(1);
                            gameState.setErrorMessage("");
                            confirmChoice=true;
                            System.out.println("Chose the second domino");
                        }else{
                            gameState.setErrorMessage("That's already taken!");
                        }
                    }
                    else if(x>=403&&x<=461&&y>=491&&y<=520)
                    {
                        if(gameState.getOptionDeck().get(2).getPlayer().getName().equals("Player Blank"))
                        {
                            gameState.setChosenDomino(2);
                            gameState.setErrorMessage("");
                            confirmChoice=true;
                            System.out.println("Chose the third domino");
                        }else{
                            gameState.setErrorMessage("That's already taken!");
                        }
                    }
                    else if(x>=403&&x<=461&&y>=525&&y<=554)
                    {
                        if(gameState.getOptionDeck().get(3).getPlayer().getName().equals("Player Blank"))
                        {
                            gameState.setChosenDomino(3);
                            gameState.setErrorMessage("");
                            confirmChoice=true;
                            System.out.println("Chose the fourth domino");
                        }else{
                            gameState.setErrorMessage("That's already taken!");
                        }
                    }
                    else if(confirmChoice)
                    {
                        gameState.setErrorMessage("Click on choose button");
                    }
                    else
                    {
                        gameState.setErrorMessage("Click on a domino in play");
                    }
                }
                else
                {
                    //System.out.println("\nNot first round\n");
                    //nextRoundDeckX, optionAndNextRoundDeckYs[0], 58, 29
                    if((x>=nextRoundDeckX&&x<=nextRoundDeckX+58&&y>=optionAndNextRoundDeckYs[0]&&y<=optionAndNextRoundDeckYs[0]+29))
                    {
                        if(gameState.getNextRoundDeck().get(0).getPlayer().getName().equals("Player Blank"))
                        {
                            gameState.setChosenDomino(0);
                            gameState.setErrorMessage("");
                            confirmChoice=true;
                        }
                        else
                        {
                            gameState.setErrorMessage("That's already taken!");
                        }
                    }
                    else if(x>=515&&x<=573&&y>=458&&y<=487)
                    {
                        if(gameState.getNextRoundDeck().get(1).getPlayer().getName().equals("Player Blank"))
                        {
                            gameState.setChosenDomino(1);
                            gameState.setErrorMessage("");
                            confirmChoice=true;
                        }
                        else
                        {
                            gameState.setErrorMessage("That's already taken!");
                        }
                    }
                    else if(x>=515&&x<=573&&y>=491&&y<=520)
                    {
                        if(gameState.getNextRoundDeck().get(2).getPlayer().getName().equals("Player Blank"))
                        {
                            gameState.setChosenDomino(2);
                            gameState.setErrorMessage("");
                            confirmChoice=true;
                        }
                        else
                        {
                            gameState.setErrorMessage("That's already taken!");
                        }
                    }
                    else if (x>=515&&x<=573&&y>=525&&y<=554)
                    {
                        if(gameState.getNextRoundDeck().get(3).getPlayer().getName().equals("Player Blank"))
                        {
                            gameState.setChosenDomino(3);
                            gameState.setErrorMessage("");
                            confirmChoice=true;
                        }
                        else
                        {
                            gameState.setErrorMessage("That's already taken!");
                        }
                    }
                    else if(confirmChoice)
                    {
                        gameState.setErrorMessage("Click on the choose button");
                    }
                    else
                    {
                        gameState.setErrorMessage("Click on a domino in queue");
                    }
                }
                repaint();
            }
            if(gameState.getAllowChoosing())
            {
                if(newGame&&x>=650&&x<=725&&y>=925&&y<=1000&&gameState.getAllowChoosing())
                {
                    gameState.setErrorMessage("");
                    if(confirmChoice)
                    {
                        int i=gameState.getChosenDomino();
                        System.out.println("\ngameState.getChosenDomino() is "+gameState.getChosenDomino()+"\n");
                        if(gameState.getIsFirstRound())
                        {
                            String name="";
                            if(i==0||i==1||i==2||i==3)
                            {
                                gameState.setOptionDeckOwner(i);
                                name=gameState.getOptionDeck().get(i).getPlayer().getName();
                                System.out.println("Changed Owner is "+name);
                                gameState.setErrorMessage("");
                                if(name.equals("Player Yellow"))
                                    optionOwner[i]=ywking;
                                if(name.equals("Player Green"))
                                    optionOwner[i]=grnking;
                                if(name.equals("Player Red"))
                                    optionOwner[i]=redking;
                                if(name.equals("Player Blue"))
                                    optionOwner[i]=blueking;
                                System.out.println("\nis first round"+gameState.getIsFirstRound()+" , lockedc is false");
                                lockedc=false;
                                firstRoundCtr++;
                                if(firstRoundCtr==4){
                                    gameState.setIsFirstRound(false);
                                    gameState.setAllowChoosing(false);
                                    gameState.setAllowPlacing(true);
                                    lockedd=false;
                                    roundCounter=1;
                                    System.out.println("\nroundCounter is 1");
                                    gameState.updateCurrentPlayer();
                                    System.out.println("\n   updated CurrentPlayer after choose, end of first round, currentPlayer: "+gameState.getCurrentPlayer().getName());
                                    confirmChoice=false;
                                    repaint();
                                    return;
                                }
                                gameState.updateCurrentPlayer();
                                System.out.println("\n   updated CurrentPlayer after choose in first round, currentPlayer: "+gameState.getCurrentPlayer().getName());
                                gameState.setAllowChoosing(true);
                                repaint();
                                confirmChoice=false;
                                return;
                            }
                            //System.out.println("optionOwner is: "+name);
                        }
                        else if(!gameState.getIsLastRound()&&!gameState.getIsFirstRound())
                        {
                            if(i==0||i==1||i==2||i==3)
                            {
                                gameState.setNextRoundDeckOwner(i);
                                String name=gameState.getNextRoundDeck().get(i).getPlayer().getName();
                                System.out.println("Changed Owner is "+name);
                                gameState.setErrorMessage("");
                                if(name.equals("Player Yellow"))
                                    nextOwner[i]=ywking;
                                if(name.equals("Player Green"))
                                    nextOwner[i]=grnking;
                                if(name.equals("Player Red"))
                                    nextOwner[i]=redking;
                                if(name.equals("Player Blue"))
                                    nextOwner[i]=blueking;
                                gameState.setAllowPlacing(true);
                                System.out.println("currentPlayer is: "+gameState.getCurrentPlayer().getName());
                                cover1=false;
                                cover2=false;
                                gameState.setErrorMessage("");
                                gameState.setAllowPlacing(true);
                                gameState.setAllowChoosing(false);
                                lockedp=true;
                                lockedd=false;
                                lockedg=true;
                                tileSurrounding=false;
                                currentTileDirection=-1;
                                firstTileDirection=-1;
                                placed1=false;
                                finalhx=-1;
                                finalhy=-1;
                                finalh2x=-1;
                                finalh2y=-1;
                                lastTile=new Tile(scroll);
                                placeCounter=0;
                                firstTimeCover1=true;
                                firstTimeCover2=true;
                                firstTile=new Tile(ywking);
                                secondTile=new Tile(ywking);
                                clickedGridX=-1;
                                clickedGridY=-1;
                                pickedTileCounter=0;
                                if(roundCounter!=12)
                                {
                                    boolean allClaimed=true;
                                    for(Domino d:gameState.getNextRoundDeck())
                                    {
                                        if(d.getPlayer().getName().equals("Player Blank"))
                                        {
                                            allClaimed=false;
                                        }
                                    }
                                    if(allClaimed)
                                    {
                                        gameState.getOptionDeck().clear();
                                        gameState.clearAllPlayers();
                                        for(int q=0; q<4; q++)
                                        {
                                            gameState.addPlayer(gameState.getNextRoundDeck().get(q).getPlayer());
                                        }
                                        for(Domino d:gameState.getNextRoundDeck())
                                        {
                                            gameState.getOptionDeck().add(d);
                                        }
                                        gameState.getNextRoundDeck().clear();
                                        roundCounter++;
                                        System.out.println("\nUpdated RoundCounter is "+roundCounter);
                                        if(roundCounter==12)
                                        {
                                            gameState.setIsLastRound(true);
                                            System.out.println("\nNow it's Last Round, Current Player order"+gameState.getAllPlayers());
                                            ArrayList<Player> finalOrder=gameState.getThePlayers();
                                            for(int q=0; q<4; q++)
                                            {
                                                if(finalOrder.get(q).getName().equals("Player Yellow"))
                                                {
                                                    optionOwner[q]=ywking;
                                                }
                                                else if(finalOrder.get(q).getName().equals("Player Blue"))
                                                {
                                                    optionOwner[q]=blueking;
                                                }
                                                else if(finalOrder.get(q).getName().equals("Player Green"))
                                                {
                                                    optionOwner[q]=grnking;
                                                }
                                                else if(finalOrder.get(q).getName().equals("Player Red"))
                                                {
                                                    optionOwner[q]=redking;
                                                }
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("\nNot Last Round, drawing next 4");
                                            for(int q=0; q<4; q++)
                                            {
                                                gameState.getNextRoundDeck().add(gameState.getMainDeck().getDeck().get(0));
                                                gameState.getMainDeck().getDeck().remove(0);
                                            }
                                            gameState.sortNextRoundDeck();
                                            //new Player order
                                            gameState.clearAllPlayers();
                                            for(int q=0; q<4; q++)
                                            {
                                                gameState.addPlayer(gameState.getOptionDeck().get(q).getPlayer());
                                            }
                                            System.out.println("\nNew order: "+gameState.getAllPlayers()+"\n");
                                            for(int q=0; q<4; q++)
                                            {
                                                optionOwner[q]=nextOwner[q];
                                                nextOwner[q]=emptyking;
                                            }
                                            gameState.updateCurrentPlayer();
                                            System.out.println("\n   updated CurrentPlayer after choose in end of round, currentPlayer: "+gameState.getCurrentPlayer().getName());
                                            confirmChoice=false;
                                            repaint();
                                            return;
                                        }
                                    }
                                    gameState.updateCurrentPlayer();
                                    System.out.println("\n   updated CurrentPlayer after choose, not end of round, currentPlayer: "+gameState.getCurrentPlayer().getName());
                                    confirmChoice=false;
                                    repaint();
                                    return;
                                }
                            }
                        }
                    }
                    else
                    {
                    	if(!allowScoring)
                    	{
                        gameState.setErrorMessage("You cannot choose now");
                        repaint();
                        return;
                    	}
                    }
                    repaint();
                }
                else
                {
                    if(!confirmChoice)
                        if(gameState.getIsFirstRound()||gameState.getIsLastRound())
                        {
                            gameState.setErrorMessage("Choose a domino in play");
                        }
                        else
                        {
                            gameState.setErrorMessage("Choose a domino in queue");
                        }
                    repaint();
                    return;
                }
            }

            if(mainMenu&&x>300&&x<700&&y>700&&y<800){
                System.out.println("instructions");
                loading=true;
                newGame=false;
                instructions=true;
                mainMenu=false;
                repaint();
            }
            if(instructions&&x>70&&x<195&&y>80&&y<205){
                System.out.println("instructions");
                loading=true;
                newGame=false;
                instructions=false;
                mainMenu=true;
                repaint();
            }


            //System.out.println("\nnewGame: "+newGame+", gameState allow Choosing: "+gameState.getAllowChoosing());
            //System.out.println("confirm choice is "+confirmChoice);
            if(newGame&&x>=650&&x<=725&&y>=925&&y<=1000)
            {
                if(confirmChoice)
                {
                    int i=gameState.getChosenDomino();
                    System.out.println("\ngameState.getChosenDomino() is "+gameState.getChosenDomino()+"\n");
                    if(gameState.getIsFirstRound())
                    {
                        String name="";
                        if(i==0||i==1||i==2||i==3)
                        {
                            gameState.setOptionDeckOwner(i);
                            gameState.setAllowEnding(true);
                            name=gameState.getOptionDeck().get(i).getPlayer().getName();
                            System.out.println("Changed Owner is "+name);
                            gameState.setErrorMessage("");
                            if(name.equals("Player Yellow"))
                                optionOwner[i]=ywking;
                            if(name.equals("Player Green"))
                                optionOwner[i]=grnking;
                            if(name.equals("Player Red"))
                                optionOwner[i]=redking;
                            if(name.equals("Player Blue"))
                                optionOwner[i]=blueking;
                            gameState.setAllowChoosing(false);
                        }
                        //System.out.println("optionOwner is: "+name);
                    }
                    else
                    {
                        if(i==0||i==1||i==2||i==3)
                        {
                            gameState.setNextRoundDeckOwner(i);
                            gameState.setAllowEnding(true);
                            String name=gameState.getNextRoundDeck().get(i).getPlayer().getName();
                            System.out.println("Changed Owner is "+name);
                            gameState.setErrorMessage("");
                            if(name.equals("Player Yellow"))
                                nextOwner[i]=ywking;
                            if(name.equals("Player Green"))
                                nextOwner[i]=grnking;
                            if(name.equals("Player Red"))
                                nextOwner[i]=redking;
                            if(name.equals("Player Blue"))
                                nextOwner[i]=blueking;
                            gameState.setAllowChoosing(false);
                        }
                    }
                    confirmChoice=false;
                }
                else
                {
                	if(!allowScoring)
	                {
	                    gameState.setErrorMessage("You cannot choose now");
	                    repaint();
	                    return;
                	}
                }
                repaint();
            }
            //System.out.println("repainting after clicking");
        }
    }
    public void mouseReleased(MouseEvent e){};
    public void mouseEntered(MouseEvent e){};
    public void mouseExited(MouseEvent e){};
    public void mouseClicked(MouseEvent e) {
    }
    private static GraphicsConfiguration getDefaultConfiguration() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        return gd.getDefaultConfiguration();
    }
    //-67.55//-202.65
    public static BufferedImage rotate(BufferedImage image, double angle) {
        if(angle==0){
            return image;
        }
        double sin = Math.abs(Math.sin(angle));
        double cos = Math.abs(Math.cos(angle));
        int w = image.getWidth();
        int h = image.getHeight();
        int neww = (int) Math.floor(w * cos + h * sin), newh = (int) Math.floor(h * cos + w * sin);
        GraphicsConfiguration gc = getDefaultConfiguration();
        BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
        Graphics2D g = result.createGraphics();
        g.translate((neww - w) / 2, (newh - h) / 2);
        g.rotate(angle, w / 2, h / 2);
        g.drawRenderedImage(image, null);
        g.dispose();
        return result;
    }
}



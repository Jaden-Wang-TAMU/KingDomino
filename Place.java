package Classes;

public class Place extends Button{
    public Place(int x, int y){
        super(x,y);
    }
    public void placeTile(Tile t, int valid, Grid g, int a){
        System.out.println("This is checking tile "+a);
        //valid=grid.isValidLocation(t1, target);
        if(valid==0){
            t.setPlaced(true);
            t.setLocation(t.getProposedLocation());
            g.getGridDeck().add(t);
            g.setKingdomRange();
        }
    }
}

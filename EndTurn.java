package Classes;

public class EndTurn extends Button{
    public EndTurn(int x, int y){
        super(x,y);
    }
    public boolean allowEndTurn(boolean a){
        if(a==true){
            return true;
        }else{
            return false;
        }
    }
}

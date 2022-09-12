package Classes;

public class Choose extends Button{
    public Choose(int x,int y){
        super(x,y);
    }
    public boolean allowChoosing(boolean a, boolean b){
        if(a||b){
            return true;
        }else{
            return false;
        }
    }
}

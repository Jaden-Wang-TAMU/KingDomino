package Classes;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Domino> dominoDeck;

    public Deck()
    {
         dominoDeck = new ArrayList<>();
    }

    public void add(Domino domino)
    {
        dominoDeck.add(domino);
    }

    public void Shuffle()
    {
        Collections.shuffle(dominoDeck);
    }

    public int getDeckSize()
    {
        return dominoDeck.size();
    }

    public ArrayList<Domino> getDeck()
    {
        return dominoDeck;
    }
    
    public void sort()
    {
    	Domino minDom;
    	int min;
    	ArrayList<Domino> sorted=new ArrayList<>();
    	int initialSize=dominoDeck.size();
    	while(sorted.size()<initialSize)
    	{
    		minDom=dominoDeck.get(0);
    		min=minDom.getValue();
	    	for(int i=1; i<dominoDeck.size(); i++)
	    	{
	    		Domino currDom=dominoDeck.get(i);
	    		int currNum=currDom.getValue();
	    		if(min>currNum)
	    		{
	    			minDom=currDom;
	    			min=currNum;
	    		}
	    	}
	    	sorted.add(minDom);
	    	dominoDeck.remove(minDom);
    	}
    	dominoDeck=sorted;
    }
    
    public String toString()
    {
    	String s=""+dominoDeck.get(0).toString();
    	for(int i=1; i<dominoDeck.size(); i++)
    	{
    		s+=", "+dominoDeck.get(i).toString();
    	}
    	return s;
    }
    

}

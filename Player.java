package Classes;

public class Player {
	private String name;
	private Grid playerGrid;
	public Player()
	{
		name="Blank";
		playerGrid=new Grid();
	}
	public Player(String n, int x, int y)
	{
		name=n;
		playerGrid=new Grid(x, y);
	}
	public Grid getGrid()
	{
		return playerGrid;
	}
	public String getName()
	{
		return ("Player "+name);
	}
}

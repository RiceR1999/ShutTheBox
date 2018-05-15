/**
 * Player class that outlines basic player functions 
 * @author Rice
 * @version 3.29.2017
 */
public class Player {
	
	private String name;
	private int score;
	private int turn;
	private boolean winner;
	
	/**
	 * Constructor for class player
	 * @param name
	 */
	public Player(String name) {
		winner = false;
		score = 0;
		turn = 0;
		this.name = name;
	}
	
	/**
	 * Accessor method for winner
	 * @return winner
	 */
	public boolean getWinner()
	{
		return winner;
	}
	
	/**
	 * Mutator method that changes boolean to true for winner then returns it
	 * @return winner
	 */
	public boolean setWinner()
	{
		winner = true;
		return winner;
	}
	
	/**
	 * Accessor for turn
	 * @return turn
	 */
	public int getTurn()
	{
		return turn;
	}
	
	/**
	 * Changes turn to 1 for finished turn
	 */
	public void setTurn() 
	{
		turn = 1;
	}
	
	/**
	 * Accessor for name
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 *  Mutator that sets score
	 * @param score
	 */
	public void setScore(int score)
	{
		this.score = score;
	}
	
	/**
	 * Accessor that returns score
	 * @return score
	 */
	public int getScore()
	{
		return score;
	}
			
	

}

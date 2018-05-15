import java .util.Random;
/**
 * Die class that defines a dice
 * @author Rice
 * @version 3.29.2018
 */
public abstract class Die {
	
	int numSides;
	private static Random generator = new Random();
	
	/**
	 * Constructor for die class that takes a param for sides
	 * @param s
	 */
	public Die (int s)
	{
		numSides = s;
	}
	
	/**
	 * Method that rolls the die
	 * @return num
	 */
	public int roll()
	{
		return generator.nextInt(6) + 1;
	}
	
	/**
	 * Overidable method that displays die
	 * @param side
	 */
	abstract public void display(int side);
}

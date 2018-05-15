/**
 * Inherited class from die defining a die with six sides
 * @author Rice
 * @version 3.29.2018
 */
public class SixSidedDie extends Die {
	
	/**
	 * Constructor which uses the Die class constructor to create a six sided die
	 */
	public SixSidedDie()
	{
		super(6);
	}
	
	/**
	 * print method that displays die
	 */
	public void display(int sides)
	{
		System.out.println("*******");
		System.out.println("*     *");
		System.out.println("*  " + sides + "  *");
		System.out.println("*     *");
		System.out.println("*******");
	}
}

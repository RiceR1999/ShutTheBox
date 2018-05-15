/**
 * Class that defines a box that can be open or closed and has a number
 * @author Rice
 * @version 3.29.2018
 */
public class Box {
	
	private int num;
	private boolean state;
	
	/**
	 * Constructor for box class
	 * @param num
	 */
	public Box(int num)
	{
		state = true;
		this.num = num;
	}
	
	/**
	 * Accessor method for num
	 * @return num
	 */
	public int getNum()
	{
		return num;
	}
	
	/**
	 * returns the state of the boolean var
	 * @return state
	 */
	public boolean getBoo() {
		if(state == true){
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * returns the boo state as a string where true denotes open and false denotes closed
	 * @return string
	 */
	public String getState() 
	{
		if(state == true) {
			return "Open";
		}
		else {
			return "Closed";
		}
	}
	
	/**
	 * depending on boo's current state, change it.
	 * @return state
	 */
	public boolean changeState()
	{
		if(state == true) {
			state = false;
			return state;
		}
		else {
			state = true;
			return state;
		}
	}

}

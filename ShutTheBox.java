import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * Main game class that contains all game logic and start method
 * @author Ryan Rice
 * @version 3.29.2018
 */
public class ShutTheBox {
	
	private boolean game;
	private ArrayList<Box> board;
	private	ArrayList<Player> Players;
	private ArrayList<Die> Die;
	private int turn;
	/**
	 * Constructor of class	
	 */
	public ShutTheBox(){
			
		    turn = 0;
			game = true;
			Players = new ArrayList<>();
			board = new ArrayList<>();
			board.add(new Box(1));
			board.add(new Box(2));
			board.add(new Box(3));
			board.add(new Box(4));
			board.add(new Box(5));
			board.add(new Box(6));
			board.add(new Box(7));
			board.add(new Box(8));
			board.add(new Box(9));
			Die = new ArrayList<>();
			Die.add(new SixSidedDie());
			Die.add(new SixSidedDie());
	}
	/**
	 * Void method that initializes all players and adds them to players array
	 */
	public void initPlayer() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the amount of players: ");
		int x = scan.nextInt();
		
		while(x > 0){
			
			System.out.println("Input player type(Human or AI): ");
			String player = scan.next();
			
			if(player.equalsIgnoreCase("Human")) {
				
				System.out.println("Please enter player name: ");
				String name = scan.next();
				Players.add(new HumanPlayer(name));
				x--;
			}
			if(player.equalsIgnoreCase("AI")){
				
				Players.add(new AIPlayer());
				x--;
			}
	    }
		System.out.println("Players:");
		for(Player p : Players) {
			System.out.println(p.getName());
		}
	}
	/**
	 * Start method that handles game function and logic
	 */
	public void start() {
		int x = 0;
		initPlayer();
		 Collections.shuffle(Players);
		 System.out.println(Players.get(0).getName() + " Goes first");
		
		 do {
			for(Player p : Players) {
				if(Players.get(turn) instanceof HumanPlayer && Players.get(turn).getTurn() != 1) {
					playerTurn();
					if(Players.get(turn).getWinner() == true) {
						System.out.println(Players.get(turn).getName() + "has won the game");
						game = false;
						break;
					}
					turn++;
				 }
			}
				if(game != false){
					Player y = findWinner();
					System.out.println(y.getName() + " has won the game!");
					game = false;
					}      
	   }while(game);
	}
	/**
	 * Compares scores of all players in player array to find lowest score, lowest score is declared winner
	 * @return Player p
	 */
	public Player findWinner()
	{
		int x = Players.size()-1;
		int y = 0;
		Player p = null;
	    boolean searching = true;
			while(searching) {
				if(Players.get(x).getScore() < Players.get(y).getScore()) {
					p = Players.get(x);
					searching = false;
				}
			}
		p.setWinner();
		return p;
	}
	
	/**
	 * Handles player turn (non AI) logic and function
	 */
	public void playerTurn()
	{
		Scanner scan = new Scanner(System.in);
		boolean active = true;
		Player p = Players.get(turn);
		int x = dieRoll();
		displayBoard();
		System.out.println(p.getName() + " Rolled:" + x);
		System.out.println("Choose a combination of boxes(1-9) that add up to: " + x);
		System.out.println("(If no available boxes remain that work then enter 0 for both inputs)");
		System.out.println("Input box 1: ");
		int num1 = scan.nextInt();
		System.out.println("Input box 2: ");
		int num2 = scan.nextInt();
			
			if(num1 + num2 == x && p.getTurn() != 1)
				if(board.get(num1).getBoo() == true || board.get(num2).getBoo() == true){
				board.get(num1-1).changeState();
				board.get(num2-1).changeState();
				System.out.println("Box " + num1 + " and box " + num2 + " have been closed.");
				playerTurn();
			}
			if(num1 + num2 == 0) {
				p.setScore(findScore());
					if(p.getScore() == 0) {
						System.out.println(p.getName() +" has shut all the boxes and is the winner!");
						p.setWinner();
					}
			    System.out.println(p.getName() + "'s turn is over, score: " + p.getScore());
				p.setTurn();
				resetBoard();
		
			}
			if(num1 + num2 != 0 && num1 + num2 !=x){
				System.out.println("Given numbers did not equal a box combination");
				System.out.println("Input box 1: ");
				num1 = scan.nextInt();
				System.out.println("Input box 2: ");
			    num2 = scan.nextInt();
			    playerTurn();
			}
		
	}
	
	/**
	 * Helper method that resets all boolean vars to true
	 */
	public void resetBoard()
	{
		for(Box b: board){
			if(b.getBoo() == false){
				b.changeState();
			}
		}
	}
	/**
	 * calculates score for a player instance
	 * @return sum
	 */
	public int findScore(){
		
		int sum = 0;
		
		for(Box b: board){
			if(b.getBoo() == true) {
			   sum += b.getNum();
			}	
		}
		return sum;
	}
	/**
	 * Print method that displays board state and index
	 */
	public void displayBoard()
	{
		System.out.println("******************************************************************");
		System.out.println("* 1       2       3      4     5      6      7       8      9    *");
		System.out.println("* " + board.get(0).getState() + "   " + board.get(1).getState() + "   " + 
	    board.get(2).getState()+ "   " + board.get(3).getState()+ "   " + board.get(4).getState()+ "   " + 
		board.get(5).getState()+ "   " + board.get(6).getState()+ "   " + board.get(7).getState()+ "   " + 
		board.get(8).getState()+ "   " + "*");
		System.out.println("******************************************************************");
	}
	/**
	 *  calculates die roll for a player instance
	 * @return roll
	 */
	public int dieRoll()
	{
		return Die.get(0).roll() + Die.get(1).roll();
	}
		
	
}

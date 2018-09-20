import java.util.ArrayList;

public class Player{
	
	private ArrayList<Card> playerHand;  
	public Player() {
		this.playerHand = new ArrayList<Card>();
		
		
		}
	
	public ArrayList<Card> getHand(){
		return this.playerHand;
	}
	
	public void addHand(Card card){
		this.playerHand.add(card);
	}
	
public void printHand() {
		System.out.println("Your hand is: ");
		for(Card c : playerHand) {
			c.print();
		}
	}
}
	
	


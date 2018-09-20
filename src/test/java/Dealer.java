import java.util.ArrayList;

public class Dealer {
	private Deck deck;
	private ArrayList<Card> dealerHand; 
	
	public Dealer() {
		this.deck = new Deck();
		this.dealerHand = new ArrayList<Card>();
	}
	
	public void deal(Player p) {
		p.addHand(this.deck.drawCard());
	}
	

//	public void addHand(Card card){
//		this.dealerHand.add(card);
//	}
//	
//	public void deal(Dealer d) {
//		d.addHand(this.deck.drawCard());
//	}
	
	public void getCard() {
		this.dealerHand.add(this.deck.drawCard());
	}
	
//	public void printHand() {
//		System.out.println("Dealer hand is: ");
//		for(Card c : dealerHand) {
//			c.print();
//		}
//	}
	
	public ArrayList<Card> getHand(){
		return this.dealerHand;
	}
}

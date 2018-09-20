
public class Card {
	
	private String suits;
	private String rank;
	
	public Card(String suits, String rank) {
		this.suits = suits;
		this.rank = rank;
		
	}
	
	public  String getSuits() {
		return suits;
	}
	
	public String getRank() {
		return rank;
	}
	
	public void print() {
		System.out.println(rank + " of " + suits);
	}
}

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	private ArrayList<Card> deck; 
	String[] suits = new String[]{"Hearts", "Diamonds", "Spades", "Clubs"};
	String[] rank = new String[]{"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
	
	public Deck() {
		this.deck = new ArrayList<Card>();
		//look through deck, assign each card a suit and rank until the 52nd card
		for(int i = 0; i < suits.length; ++i)
		{
			for(int j = 0; j <  rank.length; ++j) 
			{
				deck.add(new Card(suits[i],rank[j]));
			}			
		}
		
	}
	
	//add a card back to the deck
	public void addCard(Card card) 
	{
		deck.add(card);
	}
	
	//Returns random card from deck
	public Card drawCard() 
	{
		Random randomNum = new Random();
		return this.deck.remove(
				randomNum.nextInt(this.deck.size()
				));
		
	}
	
	public int size() {
		return this.deck.size();
	}
	
}

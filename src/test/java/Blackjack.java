import java.util.*;

public class Blackjack {
	private boolean gameOver;
	private boolean stay;
	private boolean dealerPlays;
	private Scanner scanner = new Scanner(System.in);
	private Player player;
	private Dealer dealer;

	public Blackjack() {
		this.player = new Player();
		this.dealer = new Dealer();
		this.gameOver = false;
		this.dealerPlays = true; 
		this.stay = false;
	}
	

	public Blackjack(String fileName) {
		
	}
	public void run() {
		
		for(int i = 0; i < 2; i++) {
			dealer.deal(this.player);
			dealer.getCard();
		}
		
//		for(int j = 0; j < 2; j++) {
//			dealer.deal(this.dealer);
//			dealer.getCard();
//		}
		
		while(!gameOver) {
			
			if(handSummer(player.getHand()) == 21) {
				System.out.println("Dealer wins you were given 21");
				this.dealerPlays = false; 
				stay = true;
			}
			
			while(!stay) {
				String input = "H";
				this.player.printHand();
				System.out.println("Hand Value is currently: \n" + handSummer(this.player.getHand()));
			//	System.out.println("Dealer hand is currently: \n" + handSummer(this.dealer.getHand()));
				System.out.println("Do you want to Hit (H) or Stay (S)?");
				input = this.scanner.nextLine();
				
				if( input.equals("S") ) {
					this.stay = true;
					break;
				}else if(!input.equals("H")){
					System.out.println("Please Enter Valid Input");
				}else {
					dealer.deal(player);
					int currentTotal = handSummer(this.player.getHand());
					if(currentTotal == 21) {
						System.out.println("YOUR A WEENOR");
						this.dealerPlays = false; 
						this.stay = true;
						break;
					}else if (currentTotal > 21) {
						System.out.println("Hand Value is currently: \n" + handSummer(this.player.getHand()));
						System.out.println("You went over 21, Dealer wins");
						this.dealerPlays = false; 
						this.stay = true;
						break;
					}
				}
			}
			
			if(this.dealerPlays) {
				dealerPlay();
				int dealerTotal = handSummer(dealer.getHand());
				if(dealerTotal > 21) {
					System.out.println("Dealer Loses with a total of: " + dealerTotal);
					
				}if(dealerTotal >= handSummer(player.getHand()) && dealerTotal <= 21) {
					System.out.println("Dealer Wins: " + dealerTotal);
				}else {
					System.out.println("Dealer has: " + dealerTotal + " Player Wins!");
				}
			}
			
			
			System.out.println("GAME OVER");
			this.gameOver = true;
		}
	}
	
	private void dealerPlay()
	{
		boolean cont = true;
		while(cont) {
			int total = 0;
			boolean hasAce = false;
			for(Card c : dealer.getHand()) {
				if(c.getRank().equals("Ace")){
					hasAce = true;
				}else {
					total += cardInterpreter(c);
				}
			}
			if(hasAce && total > 6) {
				cont = false;
			}else if(total > 16) {
				cont = false;
			}else {
				dealer.getCard();
			}	
		}
		
		
	}
	private int handSummer(ArrayList<Card> hand) {
		int total = 0;
		int aceCount = 0;
		boolean hasAce = false;
		
		for(Card c : hand) {
			if(c.getRank().equals("Ace")) {
				hasAce = true;
				aceCount++;
			}else {
				total += cardInterpreter(c); 
			}
		}
		if(hasAce && total <= 10 && aceCount == 1){
			total += 11; 
		}else if(hasAce && total > 10 && aceCount == 1) {
			total += 1;
		}else if (hasAce && total > 10 && aceCount > 1) {
			total += aceCount;
		}else if(hasAce && aceCount > 1 && total < 9 - (aceCount-1)) {
			total += (11 + (aceCount - 1));
		}
		
		return total;
	}
	
	private int cardInterpreter(Card card) {
		switch(card.getRank()) {
			case "Ace": 
				return 1;
			case "2":
				return 2;
			case "3": 
				return 3;
			case "4":
				return 4;
			case "5":
				return 5;
			case "6":
				return 6;
			case "7":
				return 7;
			case "8":
				return 8;
			case "9":
				return 9;
			case "10":
				return 10;				
			case "Queen":
				return 10;
			case "King":
				return 10;
			case "Jack":
				return 10;
			default:
				return 0;
		}
	}
}

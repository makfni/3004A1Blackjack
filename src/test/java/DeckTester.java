import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DeckTester {

	@Test
	public void testDeck() {
		
		Deck testDeck = new Deck();
		
		int init_Size = testDeck.size();
		assertEquals(52, init_Size);
	
	}
	
	@Test
	public void test_drawCard() {
		
		Deck testDeck = new Deck();
		testDeck.drawCard();
		int new_Size = testDeck.size();
		
		assertEquals(51, new_Size);
	}
}

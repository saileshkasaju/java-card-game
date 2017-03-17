package np.com.saileshkasaju.Cards;

public class Card {
	public static final String[] RANKS = {
		null, "Ace", "2", "3", "4", "5", "6", "7",
		"8", "9", "10", "Jack", "Queen", "King"};
		
	public static final String[] SUITS = {
		"Clubs", "Diamonds", "Hearts", "Spades"};
	private final int rank;
	private final int suit;

	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public int getRank() {
		return this.rank;
	}

	public int getSuit() {
		return this.suit;
	}
	public String toString() {		
		return RANKS[this.rank] + " of "+ SUITS[this.suit];
	}
	
	public boolean equals(Card that) {
		return this.rank == that.rank
			&& this.suit == that.suit;
	}
	
	public int compareTo(Card that) {
		if (this.suit < that.suit) {
			return -1;
		}
		if (this.suit > that.suit) {
			return 1;
		}
		if (this.rank < that.rank) {
			return -1;
		}
		if (this.rank > that.rank) {
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		//Card card = new Card(11, 1);

		Card[] cards = new Card[52];
		int index = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				cards[index] = new Card(rank, suit);
				index++;
			}
		}
		System.out.println("hello, world");
	}

	public static printDeck(Card[] cards) {
		for (int i = 0; i < cards.length; i++) {
			System.out.println(cards[i]);
		}
	}

	public static int search(Card[] cards, Card target) {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].equals(target)) {
				return i;
			}
		}
		return -1;
	}

	public static int binarySearch(Card[] cards, Card target) {
		int low = 0;
		int high = cards.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			int comp = cards[mid].compareTo(target);

			if (comp == 0) {
				return mid;
			} else if (comp < 0) {
				low = mid + 1;
			} else if (comp > 0) {
				high = mid - 1;
			}
		}
		return -1;
	}
}

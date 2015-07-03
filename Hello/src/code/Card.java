package code;

import java.util.Random;

public class Card {
	private final Integer NUM = 54;
	private Integer[] cards = new Integer[NUM];
	public Integer[] getCards() {
		return cards;
	}

	public void setCards(Integer[] cards) {
		this.cards = cards;
	}
	
	public Card(){
		for(int i=0;i<NUM;i++){
			cards[i] = i+1;
		}
	}
	public void next(){
		Random r = new Random();
		int count = 54;
		while(count>0){
			int x = r.nextInt(count);
			int a = cards[x]^cards[count-1];
			cards[x] = a^cards[x];
			cards[count-1] = a^cards[count-1];
			count--;
		}
	}
	public void getCard(){
		for(int i=0;i<cards.length-1;i++){
			System.out.print(cards[i]+",");
		}
		System.out.println(cards[cards.length-1]);
	}
	public void reset(){
		for(int i=0;i<NUM;i++){
			cards[i] = i+1;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card c = new Card();
		c.getCard();
		c.next();
		c.getCard();
		c.next();
		c.getCard();
		c.next();
		c.getCard();
	}

}

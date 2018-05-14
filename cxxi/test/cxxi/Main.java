package cxxi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Locale.Category;

public class Main {

	public static void main(String[] args) {

		char[] suite = { 'S', 'H', 'D', 'C' };

			int players = getRandom(10);
			int cards = getRandom(10);

			int deck = getRandom(200) + players*cards;

			System.out.println(players + " " + cards + " " + deck);

			
			List<Card> cartas = new ArrayList<>();
			for (int i = 0; i < players; i++) {
				for (int j = 0; j < cards; j++) {
					Card carta = new Card();
					carta.setValue(getRandom(13));
					carta.setSuite(suite[getRandom(4) - 1]);
					cartas.add(carta);
					System.out.println(getRandom(13) + " " + suite[getRandom(4) - 1]);
				}
			}

			for (int i = players * cards; i < deck; i++) {
				System.out.println(getRandom(13) + " " + suite[getRandom(4) - 1]);
				Card carta = new Card();
				carta.setValue(getRandom(13));
				carta.setSuite(suite[getRandom(4) - 1]);
				cartas.add(carta);
			}
			
			Collections.sort(cartas);
			for(Card c: cartas) {
			//	System.out.println(c.getValue() + "*"+c.getSuite());
			}
		System.out.println("0 0 0");
	}

	private static int getRandom(int size) {
		return new Random().nextInt(size) + 1;
	}

}


class Card implements Comparable<Card> {

	private int value;
	private char suite;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public char getSuite() {
		return suite;
	}

	public void setSuite(char suite) {
		this.suite = suite;
	}

	@Override
	public int compareTo(Card o) {

		if (o.getValue() == this.getValue()) {
			return o.getSuite() - this.getSuite();
		}
		return o.getValue() - this.getValue();
	}

	@Override
	public String toString() {
		return this.value + " " + this.suite;
	}
}


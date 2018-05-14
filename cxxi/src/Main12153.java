import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
*	12153 - Bora Bora
*
*	Submission:	21312163
*	Date:		2018-05-14 23:43:50
*	Runtime:	0.120
*	Ranking:	43
*/
public class Main12153 {

	static boolean clockwise, puedeJugar, jack;
	static int howManyNextCards;

	/**
	 * - Simulación
	 * - Juegos
	 * - Cartas
	 *
	 * Seguir las reglas del juego para determinar quién es el ganador
	 */
	public static void main(String[] args) throws IOException {

		StringBuffer output = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int p, m, n;
		String line;
		while (!(line = br.readLine()).equals("0 0 0")) {

			args = line.split(" ");
			p = Integer.parseInt(args[0]);
			m = Integer.parseInt(args[1]);
			n = Integer.parseInt(args[2]);

			Player[] players = new Player[p];
			for (int i = 0; i < p; i++) {
				players[i] = new Player(i + 1);
				for (int j = 0; j < m; j++) {
					Card card = new Card();
					args = br.readLine().split(" ");
					card.setValue(Integer.parseInt(args[0]));
					card.setSuite(args[1].charAt(0));
					players[i].getCards().add(card);
				}
			}

			Queue<Card> deck = new LinkedList<Card>();

			for (int i = p * m; i < n; i++) {
				Card card = new Card();
				args = br.readLine().split(" ");
				card.setValue(Integer.parseInt(args[0]));
				card.setSuite(args[1].charAt(0));
				deck.add(card);
			}

			output.append(startGame(players, deck));
			output.append("\n");
		}
		System.out.print(output);
	}

	private static int startGame(Player[] players, Queue<Card> deck) {
		boolean continuar = true;
		puedeJugar = true;
		jack = false;
		clockwise = false;

		Card top = deck.poll();
		int actualPlayer = 0;
		howManyNextCards = 1;

		evaluateNext(top.getValue());

		while (continuar) {

			Player player = players[actualPlayer];
			if (puedeJugar) {

				Card nextCard = buscar(player.getCards(), top);

				if (nextCard != null) {
					if (player.getCards().size() == 0) {
						return player.getNumber();
					}
					top = nextCard;
					evaluateNext(nextCard.getValue());
				} else {

					if (deck.size() > 0) {
						player.getCards().add(deck.poll());

						nextCard = buscar(player.getCards(), top);
						if (nextCard != null) {
							if (player.getCards().size() == 0) {
								return player.getNumber();
							}
							top = nextCard;
							evaluateNext(nextCard.getValue());
						}

					}
				}

			} else {
				puedeJugar = true;

				if (jack) { // si es por el 11
					jack = false;
				} else { // si es 7 o 1
					for (int i = 0; i < howManyNextCards; i++) {
						if (deck.size() > 0) {
							player.getCards().add(deck.poll());
						}

					}
					howManyNextCards = 1;
				}

			}

			if (clockwise) {
				actualPlayer--;
				if (actualPlayer < 0) {
					actualPlayer += players.length;
				}

			} else {
				actualPlayer++;
				if (actualPlayer >= players.length) {
					actualPlayer = actualPlayer % players.length;
				}
			}

		}
		return 0;

	}

	private static void evaluateNext(int value) {
		switch (value) {
		case 12:
			clockwise = !clockwise;
			break;

		case 7:
			howManyNextCards = 2;
			puedeJugar = false;
			break;

		case 1:
			puedeJugar = false;
			break;

		case 11:
			puedeJugar = false;
			jack = true;
			break;
		default:

			break;
		}

	}

	private static Card buscar(List<Card> cards, Card top) {

		Collections.sort(cards);
		for (Card card : cards) {
			if (top.getSuite() == card.getSuite() || top.getValue() == card.getValue()) {
				cards.remove(card);
				return card;
			}
		}
		return null;
	}

}

class Player {
	private List<Card> cards;
	private int number;

	public Player(int number) {
		cards = new ArrayList<Card>();
		this.setNumber(number);
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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

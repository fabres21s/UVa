import java.io.*;
import java.util.*;

/**
*	10205 - Stack 'em Up
*
*
*	Submission:	9306643
*	Date:		2011-09-27 19:53:16
*	Runtime:	0.180
*	Ranking:	2458
*/
public class Main10205 {

	int read() throws IOException {
		return System.in.read();
	}

	String ReadLn(int maxLg) // utility function to read from stdin
	{
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;
		try {
			while (lg < maxLg) {
				car = read();
				if ((car < 0) || (car == '\n'))
					break;
				lin[lg++] += car;
			}
		} catch (IOException e) {
			return (null);
		}

		if ((car < 0) && (lg == 0))
			return (null); // eof
		return (new String(lin, 0, lg));
	}

	/**
	 * - Simulaci�n
	 */
	public static void main(String args[]) // entry point from OS
	{
		new MyClass(new Main10205()); // create a dinamic instance
	}
}

class MyClass {

	static final String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
	static final String[] values = { "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "Jack", "Queen", "King", "Ace" };

	int[] doShuffling(int[] deck, int[] shuffle) {
		int[] res = new int[52];
		for (int j = 0; j < 52; j++)
			res[j] = deck[shuffle[j]];
		return res;
	}

	void print(int[] deck) {
		for (int i = 0; i < 52; i++) {
			System.out.print(values[deck[i] % 13]);
			System.out.print(" of ");
			System.out.print(suits[deck[i] / 13]);
			System.out.println();
		}
	}

	MyClass(Main10205 m) {
		String input;
		StringTokenizer idata;
		int n, s, i, cur, k;

		int sh[][];

		input = m.ReadLn(255);
		idata = new StringTokenizer(input);
		n = Integer.parseInt(idata.nextToken());

		input = m.ReadLn(255);

		while (n > 0) {
			input = m.ReadLn(255);
			idata = new StringTokenizer(input);
			s = Integer.parseInt(idata.nextToken());
			sh = new int[s][52];
			for (cur = 0; cur < s; cur++) {
				for (i = 0; i < 52; i++) {
					if (!idata.hasMoreTokens()) {
						input = m.ReadLn(255);
						idata = new StringTokenizer(input);
					}
					sh[cur][i] = Integer.parseInt(idata.nextToken()) - 1;
				}
			}

			int[] deck = new int[52];

			for (i = 0; i < 52; i++)
				deck[i] = i;

			input = m.ReadLn(255);
			idata = new StringTokenizer(input);
			while (idata.hasMoreTokens()) {
				k = Integer.parseInt(idata.nextToken());
				deck = doShuffling(deck, sh[k - 1]);

				input = m.ReadLn(255);
				if (input == null)
					break;
				idata = new StringTokenizer(input);
			}
			;

			print(deck);
			n--;
			if (n > 0)
				System.out.println();
		}
	}
}
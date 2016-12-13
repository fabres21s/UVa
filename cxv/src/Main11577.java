import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	11577 - Letter Frequency
*
*
*	Submision:	10342046
*	Date:		2012-07-16 15:03:08
*	Runtime:	0.672
*	Ranking:	2564
*/
public class Main11577 {

	/**
	 * Cadena de caracteres
	 */
	public static void main(String[] args) throws IOException {

		// Scanner input=new Scanner(System.in);
		char[] p;
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		int t = Integer.parseInt(reader.readLine()), i, arreglo[], max;

		// input.close();

		while (t > 0) {
			p = reader.readLine().toLowerCase().toCharArray();
			t--;
			arreglo = new int[26];

			for (i = 0; i < p.length; i++)
				if (p[i] > 96 && p[i] < 123)
					arreglo[p[i] - 97]++;
			max = -1;
			for (i = 0; i < 26; i++)
				if (arreglo[i] > max)
					max = arreglo[i];
			for (i = 97; i < 123; i++)
				if (arreglo[i - 97] == max)
					System.out.print((char) i);
			System.out.println();
		}
	}
}

import java.util.Scanner;

/**
*	10921 - Find the Telephone
*
*
*	Submission:	9703994
*	Date:		2012-02-03 02:38:04
*	Runtime:	0.116
*	Ranking:	10882 / 11322
*/
public class Main10921 {

	/**
	 * - Simulaci�n
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char array[];
		int i;
		while (input.hasNext()) {
			StringBuffer buffer = new StringBuffer();
			array = input.next().toCharArray();
			for (i = 0; i < array.length; i++) {
				if (array[i] == '0' || array[i] == '1' || array[i] == '-') {
					buffer.append(array[i]);
				} else if (array[i] == 'A' || array[i] == 'B'
						|| array[i] == 'C') {
					buffer.append(2);
				} else if (array[i] == 'D' || array[i] == 'E'
						|| array[i] == 'F') {
					buffer.append(3);
				} else if (array[i] == 'G' || array[i] == 'H'
						|| array[i] == 'I') {
					buffer.append(4);
				} else if (array[i] == 'J' || array[i] == 'K'
						|| array[i] == 'L') {
					buffer.append(5);
				} else if (array[i] == 'M' || array[i] == 'N'
						|| array[i] == 'O') {
					buffer.append(6);
				} else if (array[i] == 'P' || array[i] == 'Q'
						|| array[i] == 'R' || array[i] == 'S') {
					buffer.append(7);
				} else if (array[i] == 'T' || array[i] == 'U'
						|| array[i] == 'V') {
					buffer.append(8);
				} else if (array[i] == 'W' || array[i] == 'X'
						|| array[i] == 'Y' || array[i] == 'Z') {
					buffer.append(9);
				}
			}
			System.out.println(buffer);
		}
		input.close();
	}
}

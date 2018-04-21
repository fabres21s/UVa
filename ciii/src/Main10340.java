import java.util.Scanner;

/**
*	10340 - All in All
*
*
*	Submission:	9618698
*	Date:		2012-01-05 00:40:45
*	Runtime:	0.240
*	Ranking:	11739
*/
public class Main10340 {

	/**
	 * - Cadena de caracteres
	 */
	//TODO String - Poner categoria
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i, j, k, ck = -1;
		char a[], s[];
		while (input.hasNext()) {
			k = 0;
			a = input.next().toCharArray();
			s = input.next().toCharArray();
			for (i = 0; i < a.length; i++) {
				ck = 0;
				for (j = k; j < s.length; j++) {
					if (a[i] == s[j]) {
						k = j + 1;
						ck = 1;
						break;
					}
				}
				if (ck == 0) {
					break;
				}
			}
			if (ck != 0) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
		input.close();
	}
}

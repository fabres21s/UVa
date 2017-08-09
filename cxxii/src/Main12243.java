import java.util.Scanner;

/**
*	12243 - Flowers Flourish from France
*
*
*	Submision:	9323374
*	Date:		2011-10-02 00:16:58
*	Runtime:	0.388
*	Ranking:	1330
*/
public class Main12243 {

	/**
	 * - Cadena de caracteres
	 */
	//TODO String - Poner categoria
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s;
		while (input.hasNext()) {
			s = input.nextLine();
			if (s.equals("*")) {
				break;
			}
			int i = 0, n = s.length() - 1;
			char ch = ops(s.charAt(0));
			boolean flag = true;
			while (s.charAt(i) != ' ' && i < n) {
				i++;
			}
			while (i < n) {
				i++;
				if (ch != ops(s.charAt(i))) {
					flag = false;
				}
				while (s.charAt(i) != ' ' && i < n) {
					i++;
				}
			}
			if (flag) {
				System.out.println("Y");
			} else {
				System.out.println("N");
			}
		}

		input.close();
	}

	static char ops(char ch) {
		if (ch < 'a') {
			return (char) (ch + 32);
		}
		return ch;
	}

}

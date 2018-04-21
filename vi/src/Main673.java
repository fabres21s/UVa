import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
*	673 - Parentheses Balance
*
*
*	Submission:	16455613
*	Date:		2015-11-18 15:46:23
*	Runtime:	0.439
*	Ranking:	9656
*/
public class Main673 {

	/**
	 * - Stack
	 * 
	 * Verificar si una cadena de ()[] est� bien conformada, si abre 
	 * y cierran correctamente todos los caracteres
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(br.readLine());

		int x;
		String answer;
		while (casos-- > 0) {
			Stack<Integer> stack = new Stack<Integer>();
			answer = "Yes";
			while ((x = (Integer) br.read()) != '\n') {
				// System.out.println(x);
				if (x == 40 || x == 91) {
					stack.push(x);
				} else {

					if (x != 32) {// que no sea espacios
						if (stack.size() > 0) {
							int y = stack.pop();
							if (x == 41) {// )
								if (y != 40) {
									answer = "No";
								}
							} else if (x == 93) {
								if (y != 91) {
									answer = "No";
								}
							}
						} else {
							answer = "No";
						}
					}
				}
			}
			if (stack.size() > 0) {
				answer = "No";
			}
			System.out.println(answer);
		}
	}

}

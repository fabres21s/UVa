import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
*	514 - Rails
*
*
*	Submision:	16510323
*	Date:		2015-11-29 13:14:12
*	Runtime:	2.715
*	Ranking:	5914
*/
public class Main514 {

	/**
	 * - Simulación
	 * - Stack
	 * 
	 * El ejercicio consiste en analizar si es posible poner y sacar de una pila
	 * números en un determinado orden ej, si estaba 4,2,5,1,3
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int n;

		while ((n = input.nextInt()) != 0) {

			int ordenSalida[] = new int[n];

			while (true) {
				boolean nuevo = true;
				for (int i = 0; i < n; i++) {
					ordenSalida[i] = input.nextInt();
					if (ordenSalida[i] == 0) {
						nuevo = false;
						break;
					}
				}

				if (!nuevo) {
					break;
				}
				Stack<Integer> stack = new Stack<Integer>();

				List<Integer> salidas = new ArrayList<Integer>();
				boolean success = true;
				for (int i = 1; i < (n + 1); i++) {

					int sacar = ordenSalida[i - 1];

					if (!stack.empty()) {
						if (stack.peek() == sacar) {
							stack.pop();
							salidas.add(sacar);
							continue;
						}
					}

					if (sacar == i) {
						salidas.add(sacar);

						continue;
					}

					int index = i;
					while (sacar != index && index < (n + 1)) {
						if (!salidas.contains(index) && !stack.contains(index)) {
							stack.push(index);
						}
						index++;
					}

					if (index > n) {
						success = false;
						break;
					}
					salidas.add(sacar);
				}

				if (success) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
			System.out.println();
		}
		input.close();
	}

}

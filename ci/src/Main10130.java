import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	10130 - SupersSale
*	Submission:	19580317
*	Date:		2017-06-28 19:00:44
*	Runtime:	0.250
*	Ranking:	6755 / 9816
*/
public class Main10130 {

	
	static int [][] array = {
			{64,85,52,99,39,54},
			{26,22,4,18,13,9}
	};
	
	static int [][] memory;
	static int columns;
	
	/**
	 * - Arreglos
	 * - Recursividad
	 *
	 * Dados unos pesos y valores de ciertos productos y el peso que puede cargar un grupo de personas
	 * determinar el valor máximo de los productos que puede comprar, teniendo en cuenta que cada
	 * persona solo puede comprar un producto por cada tipo
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		int i, persons, sum;
		StringBuffer output = new StringBuffer();
		while (testCases --> 0) {
			columns = Integer.parseInt(br.readLine());
			array = new int[2][columns];
			
			memory = new int [40][columns];
			
			for (i = 0; i < columns; i++) {
				args = br.readLine().split(" ");
				array[0][i] = Integer.parseInt(args[0]);
				array[1][i] = Integer.parseInt(args[1]);
			}
			persons = Integer.parseInt(br.readLine());
			sum = 0;
			while (persons --> 0) {
				sum += calculate(Integer.parseInt(br.readLine()), 0);
			}
			output.append(sum+"\n");
			
		}
		
		System.out.print(output);

	}

	private static int calculate(int totalWeight, int j) {
		
		if (j == columns) {
			return 0;
		}
		if (memory[totalWeight][j] != 0) {
			return memory[totalWeight][j];
		}
		if (totalWeight >= array[1][j]) {
			return memory[totalWeight][j] =  Math.max( calculate(totalWeight - array[1][j], j+1) + array[0][j], calculate(totalWeight, j + 1) );
		}

		return memory[totalWeight][j] = calculate(totalWeight, j + 1);
	}

}

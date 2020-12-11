import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	11136 - Hoax or what
*
*	Submission:	25836118
*	Date:		2020-12-11 11:50:41
*	Runtime:	0.590
*	Ranking:	448 / 3325
*/
public class Main11136 {

	/**
	 *  - Arreglos
	 *  
	 *  Hallar la máxima diferencia enn un arreglo, no se usa un tree porque se
	 *  pueden repetir los valores
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int days, value, max, min;
		long sum;

		while ((days = Integer.parseInt(br.readLine())) != 0) {
			sum = 0;
			max = 0;
			min = 1000001;
			int array[] = new int[min];
			for (int i = 0; i < days; i++) {
				args = br.readLine().split(" ");
				for (int j = 1; j < args.length; j++) {
					value = Integer.parseInt(args[j]);
					max = Math.max(max, value);
					min = Math.min(min, value);
					array[value]++;
				}

				while (array[min] == 0) {
					min++;
				}

				while (array[max] == 0) {
					max--;
				}
				
				sum += max - min;
				array[max]--;
				array[min]--;
			}
			output.append(String.format("%d\n", sum));
		}
		System.out.print(output);

	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11235 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;

		StringBuffer output = new StringBuffer();
		int n, queryes, i, count, end, value, start, j, originalValue;
		while (!(line = br.readLine()).equals("0")) {
			args = line.split(" ");
			n = Integer.parseInt(args[0]);
			queryes = Integer.parseInt(args[1]);

			int array[] = new int[n + 1];
			args = br.readLine().split(" ");

			for (i = 0; i < n; i++) {
				array[i] = Integer.parseInt(args[i]);
			}

			
			count = 1;
			end = 0;
			value = array[0];
			start = 0;
			int frequentValues[] = new int[n];
			
			
			for (i = 1; i < n; i++) {
				while (value == array[i] && i < n) {
					count++;
					i++;
				}
				end = start + count;
				for (j = start; j < end; j++) {
					frequentValues[j] = count;
				}
				start = end;
				value = array[i];
				count = 1;

			}

			while (queryes-- > 0) {
				args = br.readLine().split(" ");
				start = Integer.parseInt(args[0]) - 1;
				end = Integer.parseInt(args[1]) - 1;

				count = 0;

				int frequentValuesAdjusted[] = frequentValues.clone();

				
				
				// ajuste a la derecha
				
				
				count = 1;
				value = frequentValues[start];
				originalValue = array[start];
				for (i = start + 1; i <= end; i++) {
					if (frequentValues[i] != value || originalValue != array[i]) {
						break;
					}
					count++;

				}

				if (count < value) {
					for (i = start; i < (start + count); i++) {
						frequentValuesAdjusted[i] = count;
					}
				}

				// ajuste a la izquierda
				
				count = 1;
				value = frequentValuesAdjusted[end];
				originalValue = array[end];
				for (i = end - 1; i >= start; i--) {
					if (frequentValuesAdjusted[i] != value || originalValue != array[i]) {
						break;
					}
					count++;

				}

				if (count < value) {
					for (i = end; i > (end - count); i--) {
						frequentValuesAdjusted[i] = count;
					}
				}

				count = 1;
				for (i = start; i <= end; i++) {
					count = Math.max(count, array[i]);
				}

				output.append(count+ "\n");

			}

		}
		System.out.print(output);

	}

}

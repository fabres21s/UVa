import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO TLE - Potentiometers
public class Main12086 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int resistencias;
		
		int arreglo[][];
		int sum, i, a,b, value;
		String line;
		int testCases = 0;
		StringBuffer output = new StringBuffer();
		while ( (resistencias = Integer.parseInt(br.readLine())) != 0 ) {
			sum = 0;
			
			arreglo = new int[resistencias+2][2];
			for (i = 1; i <= resistencias; i++) {
				value = Integer.parseInt(br.readLine());
				sum += value;
				arreglo[i][1] = sum;
				arreglo[i][0] = value;
			}
			if (testCases > 0) {
				output.append("\n");
			}
			testCases++;
			
			output.append("Case "+testCases+":\n");
			while (!(line = br.readLine()).equals("END")) {
				args = line.split(" ");
				a = Integer.parseInt(args[1]) - 1;
				b = Integer.parseInt(args[2]);
				if (args[0].equals("M")) {
					output.append((arreglo[b][1] - arreglo[a][1]) +"\n");
				} else {
					a++;
					value =  b - arreglo[a][0] ;//diferencia
					arreglo[a][0] = b;
					
					for (i = a; i <= resistencias; i++) {
						arreglo[i][1] += value;
					}
				}
			}
		}
		System.out.print(output);
		
	}

}

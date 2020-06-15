import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	661 - Blowing Fuses
*
*	Submission:	25143371
*	Date:		2020-06-15 19:11:54
*	Runtime:	0.060
*	Ranking:	5916
*/
public class Main661 {

	/**
	 * - Validaciones
	 * 
	 * Encontrar si un fusible se quema o no dependiendo de la capacidad del transformador
	 * y que se prendan o apaguen ciertos dispositivos
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringBuffer output = new StringBuffer();
		int n, m,c, device, partialConsumption, maxConsumption;
		boolean blown;
		int testCases = 0;
		while (!(line = br.readLine()).equals("0 0 0") ) {
			
			args = line.split(" ");
			partialConsumption = maxConsumption = 0;
			blown = false;
			
			n = Integer.valueOf(args[0]);
			m = Integer.valueOf(args[1]);
			c = Integer.valueOf(args[2]);
			int consumptiosns[] = new int[n + 1];
			boolean states [] = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				consumptiosns[i] = Integer.valueOf(br.readLine());  
			}
			
			
			for (int i =0; i < m; i++) {
				device = Integer.valueOf(br.readLine());
				
				states[device] = !states[device];
				
				if (states[device]) {
					partialConsumption += consumptiosns[device];
					maxConsumption = Math.max(maxConsumption, partialConsumption);
					
					if (partialConsumption > c) {
						blown = true;
					}
				} else {
					partialConsumption -= consumptiosns[device];
				}
			}
			
			output.append("Sequence "+ (++testCases) +"\n");
			
			if (blown) {
				output.append("Fuse was blown.\n\n");
			} else {
				output.append("Fuse was not blown.\n");
				output.append("Maximal power consumption was "+maxConsumption+" amperes.\n\n");
			}
		}
		
		System.out.print(output);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


/*
 * 12207 - That is your queue
 * Dada una cantidad de personas y una serie de comandos
 * encontrar el orden de atención de cada una de ellas
 * 
 * - Listas
 */
public class Main {

	public static void main(String[] args) throws IOException {

		List<Long> list = new ArrayList<Long>();
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		int personas, comandos;
		long e;
		int testCases = 0;
		while (true) {
			testCases++;
			args = br.readLine().split(" ");
			personas = Integer.parseInt(args[0]);
			comandos = Integer.parseInt(args[1]);
			if (personas == 0) {
				break;
			}
			int min = Math.min(comandos, personas);
			for (long i = 1; i<= min; i++) {
				list.add(i);
			}
			output.append("Case "+testCases+":\n");
			for (int i = 0; i < comandos; i++) {
				line = br.readLine();
				
				if (line.equals("N")) {
					output.append(list.get(0) + "\n");
					list.add(list.get(0));
					list.remove(0);
				} else {
					args = line.split(" ");
					e = Long.valueOf(args[1]);
					
					list.remove(e);
					list.add(0,e);
				}
				
			}
			
			list.clear();
		}
		
		System.out.print(output);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
*	1584 - Circular Sequence
*
*	Submission:	25729028
*	Date:		2020-11-16 15:11:02
*	Runtime:	0.070
*	Ranking:	2641
*/
public class Main1584 {

	/**
	 *  - TreeSet
	 *  
	 *  Hallar en una secuencia de ADN dada en desorden, la menor secuencia posible ordenada alfabéticamente
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		
		int testCases = Integer.valueOf(br.readLine());
		String line;
		while (testCases -- > 0) {
			line = br.readLine();
			char array [] = line.toCharArray();
			List<Integer> positionsToStart = new ArrayList<Integer>();
			TreeSet<String> answer = new TreeSet<String>();
			
			int start = 0;
			
			if (line.contains("A")) {
				start = 65;
			} else if (line.contains("C")) {
				start = 67;
			} else if (line.contains("G")) {
				start = 71;
			} else {
				start = 84;
			}
			
			for (int i =0 ; i < array.length; i++) {
				if (array[i] == start) {
					positionsToStart.add(i);
				}
			}
			
			for (int s: positionsToStart) {
				answer.add(line.substring(s).concat(line.substring(0, s)));
			}
			
			output.append(answer.first());
			output.append("\n");
		}
		System.out.print(output);
	}

}

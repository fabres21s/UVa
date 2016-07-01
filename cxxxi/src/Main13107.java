import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
*	13107 - Royale With Cheese
*
*
*	Submision:	17600783
*	Date:		2016-06-30 19:23:15
*	Runtime:	0.240
*	Ranking:	25
*/
public class Main13107 {

	/*
	 * - Set
	 * - Map
	 * 
	 * Cada letra, a medidad que va apareciendo, se le es asignado un valor
	 * los 2 cambian por 5, los 6 por 9 y viceversa
	 */
	public static void main(String[] args) throws IOException {
		int [] values = {-1, 1, 5, 3,4,2,9,7,8,6,10,11,15,13,14,12,19,17,18,
				16,50,51,55,53,54,52,59,57,58,56,30};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word ;
		int index;
		char [] array;
		Set<Character> set = new HashSet<Character>();
		StringBuffer output = new StringBuffer();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		while ((word = br.readLine()) != null) {
			array = word.toCharArray();
			
			index = 1;
			
			for (char c : array) {
				if (set.add(c)) {
					map.put(c, values[index]);
					index++;
				} 
				output.append(map.get(c));
					
			}
			output.append("\n");
			map.clear();
			set.clear();
			

		}
		System.out.print(output);
	}

}

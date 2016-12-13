import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
*	1449 - Dominating Patterns
*
*
*	Submision:	17462749
*	Date:		2016-06-03 16:20:11
*	Runtime:	0.460
*	Ranking:	254
*/
public class Main1449 {

	/**
	 * - Patrones
	 * 
	 * Encontrar el número de veces que se repite un patrón en una cadena de texto
	 */
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int words;
		StringBuffer output = new StringBuffer();
		while ( (words = Integer.parseInt(br.readLine() ))!= 0) {
		
			String [] array = new String[words];
			for (int i = 0; i<words; i++) {
				array[i] = br.readLine();
			}
			
			String text = br.readLine();
			int max = 0;
			Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
			
			List<String> list ;
			for (String w : array) {
				Pattern pattern = Pattern.compile(w);
				int count = countMatches(pattern, text);
				
				if (map.get(count) == null) {
					list = new ArrayList<String>();
				} else {
					list = map.get(count);
				}
				list.add(w);
				map.put(count, list);
				max = Math.max(count, max);
			}
			list = map.get(max);
			output.append(max+"\n");
			for (String w : list) {
				output.append(w+"\n");
			}
		}
		System.out.print(output);
	}
	
	static int countMatches(Pattern pattern, String string)
	{
	    Matcher matcher = pattern.matcher(string);

	    int count = 0;
	    int pos = 0;
	    while (matcher.find(pos))
	    {
	        count++;
	        pos = matcher.start() + 1;
	    }

	    return count;
	}
}

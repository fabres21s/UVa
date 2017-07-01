import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
*	644 - 	Immediate Decodability
*	Submision:	18685137
*	Date:		2017-01-27 15:11:42
*	Runtime:	0.370
*	Ranking:	2859
*/
public class Main644 {

	/**
	 * - Cadena de caracteres
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = "";
		int set = 0;
		while ( (line = br.readLine() ) != null) {
			set++;
			List<String> bits = new ArrayList<String>();
			bits.add(line);
			
			while ( !(line = br.readLine()).equals("9")) {
				bits.add(line);
			}
			
			boolean deco = true;
			for (int i = 0; i < bits.size(); i++ ) {
				String s = bits.get(i);
				for (int j = i + 1; j < bits.size(); j++) {
					if (bits.get(j).startsWith(s) || s.startsWith(bits.get(j))) {
						deco = false;
						break;
					}
				}
				if (!deco) {
					break;
				}
			}
			
			
			System.out.println("Set "+set+ " is"+(deco ? "" : " not") + " immediately decodable");
		}
	}

}

/*
Set 1 is not immediately decodable
Set 2 is not immediately decodable
Set 3 is not immediately decodable
Set 4 is not immediately decodable
Set 5 is not immediately decodable
Set 6 is immediately decodable
*/

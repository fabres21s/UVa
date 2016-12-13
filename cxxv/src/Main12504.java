import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
*	12504 - Updating a Dictionary
*
*
*	Submision:	17457161
*	Date:		2016-06-02 15:56:30
*	Runtime:	0.220
*	Ranking:	455
*/
public class Main12504 {

	/**
	 * - Simulación
	 * - Expresiones Regulares
	 * - Map
	 * - List
	 * 
	 *  Dado un diccionario origninal y un segundo diccionario, 
	 *  determinar qué cambios tiene el primero con respecto al segundo
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCases; i++) {
			Map<String, String> originalDictionary = new HashMap<String, String>();
			List<String> originalKeys = new ArrayList<String>();
			args = br.readLine().replaceAll("[{|}]", "").split(",");
			
			for (String pair : args) {
				String array [] = pair.split(":");
				if (array.length > 1) {
					originalKeys.add(array[0]);
					originalDictionary.put(array[0], array[1]);
				}
			}
			
			Map<String, String> secondDictionary = new HashMap<String, String>();
			List<String> secondKeys = new ArrayList<String>();
			args = br.readLine().replaceAll("[{|}]", "").split(",");
			
			for (String pair : args) {
				String array [] = pair.split(":");
				if (array.length > 1) {
					secondKeys.add(array[0]);
					secondDictionary.put(array[0], array[1]);
				}
			}
			
			List<String> news = new ArrayList<String>();
			//analizar si se agregó un nuevo registro
			
			for (String record : secondKeys) {
				if (!originalKeys.contains(record)) {
					news.add(record);
				}
			}
			
			List<String> deleteds = new ArrayList<String>();
			//analizar si se agregó un nuevo registro
			
			for (String record : originalKeys) {
				if (!secondKeys.contains(record)) {
					deleteds.add(record);
				}
			}
			
			List<String> updateds = new ArrayList<String>();
			//analizar si se agregó un nuevo registro
			
			for (String record : originalKeys) {
				if (secondDictionary.get(record) != null) {
					if (!secondDictionary.get(record).equals(originalDictionary.get(record))) {
						updateds.add(record);
					}
				}
			}
			
			if (updateds.size() == 0 && deleteds.size() == 0 && news.size() == 0) {
				System.out.println("No changes");
			} else {
				if (news.size() > 0) {
					Collections.sort(news);
					System.out.println("+"+Arrays.toString(news.toArray()).replaceAll(" ", "").replace("[", "").replace("]", ""));
				}
				if (deleteds.size() > 0) {
					Collections.sort(deleteds);
					System.out.println("-"+Arrays.toString(deleteds.toArray()).replaceAll(" ", "").replace("[", "").replace("]", ""));
				}
				if (updateds.size() > 0) {
					Collections.sort(updateds);
					System.out.println("*"+Arrays.toString(updateds.toArray()).replaceAll(" ", "").replace("[", "").replace("]", ""));
				}
			}
			System.out.println();
		}
	}
}

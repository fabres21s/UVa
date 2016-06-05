import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
*	417 - Word Index
*
*
*	Submision:	16423658
*	Date:		2015-11-11 14:09:08
*	Runtime:	0.135
*	Ranking:	3303
*/
public class Main417 {

	/**
	 * - Pregenerados
	 * - Map
	 */
	public static void main(String[] args) {
		long t=System.currentTimeMillis();
		Map<String, Integer> map = new HashMap<String, Integer>();
		int sum=0;
		for (int i=97; i<123; i++){
			sum++;
			map.put(String.valueOf((char)i), sum);
		}
		
		for (int i=97; i<122; i++){
			for(int j = i+1; j< 123; j++){
				sum++;
				map.put((char)i+""+(char)(j), sum);

			}
		}
		
		for (int i=97; i<121; i++){
			for(int j = i+1; j< 122; j++){
				for(int k=j+1; k<123; k++) {
					sum++;
					map.put((char)i+""+(char)(j)+""+(char)(k), sum);

				}
			}
		}
		
		for (int i=97; i<120; i++){
			for(int j = i+1; j< 121; j++){
				for(int k=j+1; k<122; k++) {
					for(int x = k+1; x<123;x++){
						sum++;
						map.put((char)i+""+(char)(j)+""+(char)(k)+""+(char)(x), sum);

					}
				}
			}
		}
		
		
		for (int i=97; i<119; i++){
			for(int j = i+1; j< 120; j++){
				for(int k=j+1; k<121; k++) {
					for(int x = k+1; x<122;x++){
						for(int y =x+1; y<123;y++){
							sum++;
							map.put((char)i+""+(char)(j)+""+(char)(k)+""+(char)(x)+""+(char)(y), sum);

						}
					}
				}
			}
		}
		Scanner input = new Scanner(System.in);
		String word="";
		Integer result=0;
		while(input.hasNext()){
			word = input.next();
			result = map.get(word);
			System.out.println((result == null)?"0":result);
		}
	}

}

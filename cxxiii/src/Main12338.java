import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//TODO TLE - Anti-Rhyme Pairs
public class Main12338 {

	
	/**
	 * Plantearlo con una búsqueda binaria, y si persiste el TLE, en C++
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases  = Integer.parseInt(br.readLine());
		int words;
		int x,y;
		List<char[]> list;
		for (int i = 1 ; i <= testCases; i++) {
			
			words = Integer.parseInt(br.readLine());
			list = new ArrayList<char[]>();
			
			while (words -- > 0) {
				list.add(br.readLine().toCharArray());
			}
			
			words = Integer.parseInt(br.readLine());
			System.out.printf("Case %d:\n", i);
			while (words -- > 0) {
				args = br.readLine().split(" " );
				char [] arreglo1 = list.get(Integer.parseInt(args[0]) - 1);
				char [] arreglo2 = list.get(Integer.parseInt(args[1] )- 1);
				y = 0;
				for (x = 0; (x < arreglo1.length && x < arreglo2.length); x++) {
					if (arreglo1[x] != arreglo2[x]) {
						break;
					}
					y++;
				}
				System.out.println(y);
			}
			
		}
	}

}

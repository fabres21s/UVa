import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
*	11340 - Newspaper
*
*
*	Submision:	16424449
*	Date:		2015-11-11 16:59:08
*	Runtime:	0.189
*	Ranking:	1497
*/
public class Main11340 {

	/**
	 * - Cadena de caracteres
	 * - Map
	 * 
	 * Leer l�neas de caracteres y hacer una sumatoria
	 * de acuerdo al valor establecido para cada caracter
	 */
	//TODO String - Poner categoria
	public static void main(String[] args) throws NumberFormatException,
			IOException {

		/*
		 * Scanner input = new Scanner(System.in);
		 * 
		 * int casos = input.nextInt(); int values = 0, i; String letter; double
		 * value; double sum = 0; Double v; Map<Byte, Double> map;
		 * //StringBuffer buffer; StringBuffer ans = new StringBuffer();
		 * 
		 * DecimalFormat format = new DecimalFormat("#.00$"); while (casos-- >
		 * 0) { map = new HashMap<Byte, Double>();
		 * 
		 * for ( i = 0; i<256; i++){ map.put((byte)i, 0.0); } values =
		 * input.nextInt(); // regularExpresion = "[^"; for (i = 1; i <= values;
		 * i++) { letter = input.next();
		 * 
		 * value = input.nextDouble(); map.put((byte) letter.charAt(0), value);
		 * 
		 * }
		 * 
		 * values = input.nextInt(); input.nextLine(); //
		 * System.out.println(regularExpresion); sum = 0; byte x; for (i = 0; i
		 * < values; i++) {
		 * 
		 * while ((x = (byte) br.read()) != '\n') { ans += map.get(x); } }
		 * 
		 * // char [] a = buffer.toString().toCharArray(); // Arrays.sort(a); //
		 * System.out.println(a);
		 * 
		 * ans.append(format.format(sum / 100) + "\n");
		 * 
		 * } System.out.print(ans); input.close();
		 */
		// System.out.println(System.currentTimeMillis()-t);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int K = Integer.parseInt(br.readLine());
			HashMap<Byte, Integer> map = new HashMap<Byte, Integer>();
			for (int i = 0; i <= 255; i++) {
				map.put((byte) i, 0);
			}
			String s;
			for (int i = 0; i < K; i++) {
				s = br.readLine().trim();
				map.put((byte) s.charAt(0), Integer.parseInt(s.substring(2)));
			}
			int n = Integer.parseInt(br.readLine());
			double ans = 0;
			byte x;
			for (int i = 0; i < n; i++) {
				while ((x = (byte) br.read()) != '\n') {
					ans += map.get(x);
				}
			}
			System.out.format("%.2f$\n", ans / 100);

		}
	}

}

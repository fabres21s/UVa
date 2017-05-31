import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = 1;
//		List<Integer> cuadrados = new ArrayList<Integer>();
//		while (n*n <= 100000000 ) {
//			cuadrados.add(n*n);
//			n++;
//		}
//		int x=1;
//		n = 1;
//		while (x <= 100000000 ) {
//			x = n*n*n;
//			
//			if (cuadrados.contains(x)) {
//				System.out.println(x+",");
//			}
//			n++;
//		}
		
		int []especiales = {1,
				64,
				729,
				4096,
				15625,
				46656,
				117649,
				262144,
				531441,
				1000000,
				1771561,
				2985984,
				4826809,
				7529536,
				11390625,
				16777216,
				24137569,
				34012224,
				47045881,
				64000000,
				85766121};
		
		int n;
		while ((n  = Integer.parseInt(br.readLine())) != 0) {
			if (Arrays.binarySearch(especiales, n) > -1) {
				System.out.println("Special");
			} else {
				System.out.println("Ordinary");
			}
		}
	}

}

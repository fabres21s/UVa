import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main13194 {

	// TODO No enviado - DPA Numbers II
	//Dará TLE, optimizar
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(br.readLine());
		long n = -1, cont;
		StringBuffer buf = new StringBuffer();
		while (testCases-- > 0) {
			cont = 1;
			n = Long.parseLong(br.readLine());

			Set<Long> divisors = new HashSet<Long>();
			for (long i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					divisors.add(i);
					divisors.add(n / i);
				}
			}

			for (Long divisor : divisors) {
				cont += divisor;
			}

			if (n == 1) {
				buf.append("deficient\n");
			} else if (cont == n) {
				buf.append("perfect\n");
			} else if (cont > n) {
				buf.append("abundant\n");
			} else {
				buf.append("deficient\n");
			}
		}
		System.out.print(buf);
	}

}

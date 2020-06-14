package concept;

import java.util.Set;
import java.util.TreeSet;

public class MainTorneoConexia {
	public static void main(String... args) {
		long t = System.currentTimeMillis();
		int A[] = { 7, 11, 15, 10, 3, 2147483647 };
		int B[] = { 49, 121, 75, 30, 5, 2147483645 };
		System.out.println(solution(A, B));
		System.out.println((System.currentTimeMillis() - t));
	}

	public static int solution(int[] A, int[] B) {
		int respuesta = 0;
		for (int i = 0; i < A.length; i++) {

			if (A[i] == B[i]) {
				respuesta++;
			} else {
				Set<Integer> divisoresA = obtenerDivisores(A[i]);

				Set<Integer> divisoresB = obtenerDivisores(B[i]);

				if (divisoresA.equals(divisoresB)) {
					// System.out.println(A[i] + " "+B[i]);
					respuesta++;
				}
			}

		}
		return respuesta;
	}

	public static Set<Integer> obtenerDivisores(int n) {

		// long t = System.currentTimeMillis();
		Set<Integer> divisores = new TreeSet<>();

		if (n % 2 == 0) {
			n = descomponer(n, 2);
			divisores.add(2);
		}
		int divisor = 3;

		int sqrt = (int) Math.sqrt(n) + 1;

		while (n != 1) {

			if (n % divisor == 0) {
				divisores.add(divisor);
				n = descomponer(n, divisor);
			}
			divisor += 2;
			if (divisor > sqrt && divisores.size() == 0) {
				divisores.add(n);
				break;
			}
		}

		// System.out.println("tiempo para "+n +" "+(System.currentTimeMillis() - t));
		return divisores;
	}

	public static int descomponer(int n, int divisor) {

		while (n % divisor == 0) {
			n /= divisor;
		}
		return n;
	}

}
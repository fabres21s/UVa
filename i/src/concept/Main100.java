package concept;
import java.util.Scanner;

public class Main100 {

	/**
	 * - Prueba a ver si era necesario calcular todas las iteraciones,
	 * sí es necesario, no hay cómo almacenarlas
	 */
	
	static int iteraciones [] = new int [707000000];
	
	public static void main(String[] args) {
		iteraciones[1] = 1;
		int a, b;
		long t = System.currentTimeMillis();
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			a = input.nextInt();
			b = input.nextInt();
			t = System.currentTimeMillis();
			System.out.println(a + " " + b + " " + numCicloMax(Math.min(a, b), Math.max(a, b)));
			System.out.println("time = "+(System.currentTimeMillis() - t));
		}
		input.close();
	}
	
	
	static int calcularIteraciones(int n) {
		if (iteraciones[n] == 0) {
			int next = (n % 2 == 0) ? n / 2: n *3 + 1;
			iteraciones[n]  = 1 + calcularIteraciones(next);
		}
		return iteraciones[n];
	}

	static int numCicloMax(int a, int b) {
		int cicloMax = -1;
		for (int i = a; i <= b; i++) {
			calcularIteraciones(i);
			cicloMax= Math.max(cicloMax, iteraciones[i]);
		}
		
		return cicloMax;
	}

	static int numIteraciones(int n) {
		int cont = 1;
		while (n > 1) {
			if (n % 2 == 1) {
				n = (3 * n) + 1;
			} else {
				n = n / 2;
			}
			cont++;
		}
		return cont;
	}
}

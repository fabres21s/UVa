import java.util.Scanner;


/**
 * Matemáticas - Fórmulas - Triángulos, sumatoria de pares, sumatoria de cuadrados - pregenerados
 * Dado n, representando n varas de tamaño desde 1 hasta n, encontrar la cantidad de triángulos diferentes
 * que se pueden armar, teniendo en cuenta, que un triángulo válido es aquel en las que sus medidas
 * a, b y c cumplen que (a+b)>c, (a+c)>b y (b+c) >a
 * 
 * 
 * Haciendo la prueba por fuerza bruta, de la condición de las medidas de los triángulos, se notó que 
 * la cantidad de triángulos válidos para n varas,  cumple la siguiente sucesión
 * 
 * 1^2 + 1*2 + 2^2 + 2*3 + 3^2 +3*4 + ...n^2 + (n)*(n+1)
 * 
 * La sumatoria de los cuadrados es (n)(n+1)(2n+1)/6, no hay problema
 * Para la sumatoria del 1*2 + 2*3 +  3*4 + 4*5 +... tocó ayudarse de la sumatoria de pares e ir almacenando
 * @author fabio
 *
 */
public class Main {

	
	static long sumPares[] = new long[1000005];
	public static void main(String[] args) {

		sumPares[0] = 0;
		
		
	//	long t = System.currentTimeMillis();
		long x, pares, cuadrados;
		int index;
		for (int n = 2; n < 1000005; n+=2){
			
		//	int x = n/2 +  n%2;
			//System.out.println("************ "+n);
	//		int cuadrados = (x*(x+1)*(2*x+1)/6);
		//	System.out.println("cuadrados >> "+cuadrados);
			
			 x = n /2;
			 pares = ((x)*(x+1));
		//	if (n%2 == 0){
				sumPares[n] = sumPares[n-2] + pares; 
		//	} 
			
			//int index = n - n%2;
			//sumCuadrados [x] = sumCuadrados[n-1] + pares;
			//System.out.println("pares        >> "+pares);
			//System.out.println("suma        >> "+(sumCuadrados[index] + cuadrados));
			//System.out.println();
		}
	//	System.out.println(System.currentTimeMillis() - t);
		Scanner input = new Scanner(System.in);
		int n;
		while( (n = input.nextInt()) > 2){
			n = n-3;
			x = n/2 +n%2;
			cuadrados =(x*(x+1)*(2*x+1)/6);
			index = n -n%2;
			System.out.println(sumPares[index] + cuadrados);
		}
		input.close();	
		
	}

}

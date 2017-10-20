import org.junit.Test;

public class TestCases {

	
	@Test
	public void generatePrimes() {
		int n = 32768;
		int i, c = 2, aux;
		int j;
		int [] primos = new int[1000000];
		
		primos[0] = 2;
		for (i = 3; i <= n; i += 2) {
			j = 3;
			aux = 1;
			while (i % j != 0 && j <= i / j) {
				j = primos[aux];
				aux++;
			}

			if (j > i / j) {
				primos[c - 1] = i;
				System.out.print(primos[c-1] +",");
				c++;
				if (c % 100 == 0) {
					System.out.println();
				}
			}
			
			

		}
	}
}

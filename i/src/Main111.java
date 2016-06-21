import java.util.Scanner;

public class Main111 {

	/*
	 * TODO - No enviado
	 * Debe ser Como 10405 Longest Common Subsequence 
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while ( true ) {
			int n = input.nextInt();
			
			int [] correct = new int [n];
			
			for (int i = 0; i < n; i ++) {
				correct[i] = input.nextInt();
			}
			
			int students = input.nextInt();
			
			for (int i = 0; i < students; i++) {
				int result = 0, maxResult = 0;
				int pos  =0;
				
				for (int j = 0; j < n; j++) {
					int proposed []= new int[n];
					for (int k = 0; k < n; k++) {
						proposed [k] = input.nextInt();
					}
					//4 2 3 1
					for (int k = 0; k < n; k++) {
						pos = k;
						System.out.println("para "+correct[k]);
						int ultimaPosicion  = 0;
						result = 0;
						while (pos != n) {
							System.out.println("buscar = "+correct[pos]);
							for (int x = ultimaPosicion; x <n; x++) {
								System.out.println("comparando "+correct[pos] + " "+proposed[x]);
								if (proposed[x] == correct[pos]) {
									ultimaPosicion = x+1;
									result++;
									break;
								}
							}
							pos++;
						}
						maxResult = Math.max(maxResult, result);
					}
					System.out.println(maxResult);
//					for (int k = j; k < n; k++) {
//						if (correct[k] == proposed) {
//							pos = k+1;
//							result++;
//							break;
//						}
//					}
				}
				
			}
		}
	}

	

}

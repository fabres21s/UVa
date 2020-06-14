package concept;

public class MainFinalConexia {

	public static void main(String[] args) {
		//int array[] = { 2, 1, 5, 1, 2, 2, 2 };
		int array[] = { 2, 3, 5, 1, 2, 2, 2 };
		System.out.println(solution(3, 5, array));

		// int array[] = { 1, 4, 2, 8, 5, 7, 3 };
		// System.out.println(solution(2, 8, array));
	}

	public static int solution(int K, int M, int[] A) {

		int N = A.length;
		int sumArray[] = new int[N];
		int sum = 0;
		int blocks = N / K;

		int[] sizes = new int[K];
		sizes[0] = blocks;

		for (int i = 1; i < K; i++) {
			sizes[i] = sizes[i - 1] + blocks;
		}
		sizes[K - 1] = N % K > 0 ? N : sizes[K - 2] + blocks;

		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			sumArray[i] = sum;

		}

		int max = evaluar(sizes, sumArray, K);

		if (max == M) {
			return max;
		}

		int min = max;
		/*for (int i = 0; i < K; i++) {
			

			int original = sizes[i];
			if (i == 0) {
				
				sizes[i]--;
				while (sizes[i] > 0) {// falta un &&
					min = Math.min(min, evaluar(sizes, sumArray, K));
					sizes[i]--;
				}

			} else if (i == K - 1) {
				
				sizes[i] = original + 1;
				while (sizes[i] < K) {// falta un &&
					min = Math.min(min, evaluar(sizes, sumArray, K));
					sizes[i]++;
				}
			} else {
				
				int lowerOriginal = sizes[i - 1];

				sizes[i - 1]++;
				sizes[i]--;

				while (sizes[i - 1] <= sizes[i]) {
					min = Math.min(min, evaluar(sizes, sumArray, K));
					sizes[i - 1]++;
					sizes[i]--;
				}

				sizes[i - 1] = lowerOriginal;

			}

			sizes[i] = original;

		}
*/
		return min;
	}

	private static int evaluar(int[] sizes, int[] sumArray, int K) {
		int max = -1;
		// TODO - si va incrementando no me sirve de nada
		for (int i = 1; i < K; i++) {
			max = Math.max((sumArray[sizes[i] - 1] - (sumArray[sizes[i - 1] - 1])), max);

		}
		return max;
	}

	/**
	 * Ya no se me ocurre más nada 
	 */
}

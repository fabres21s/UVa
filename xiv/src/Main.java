import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int max = 20001;
		long[][] array = new long[2][max];

		array[0][1] = array[1][1] = 1;

		for (int i = 2; i < max; i++) {
			array[0][i] = i + array[0][i - 1];
			array[1][i] = array[0][i] + array[1][i - 1];
		}

		Scanner input = new Scanner(System.in);

		int test = input.nextInt();
		for (int i = 0; i < test; i++) {
			System.out.println(array[1][input.nextInt() - 2]);
			input.nextLine();
		}
	}

}

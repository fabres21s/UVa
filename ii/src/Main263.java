import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
*	263 - Number Chains
*
*
*	Submision:	9302602
*	Date:		2011-09-26 19:32:25
*	Runtime:	2.460
*	Ranking:	2295
*/
public class Main263 {

	//TODO - Asignar categoría
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		String input;
		Scanner ls;
		int chain[] = new int[2000];
		int length, number, number1, number2;
		boolean distinct;
		input = s.nextLine();
		ls = new Scanner(input);
		number = ls.nextInt();
		int num_digits;

		while (number > 0) {
			StringBuffer buff = new StringBuffer();
			// long t=System.nanoTime();
			buff.append("Original number was " + number + "\n");
			// System.out.println("Original number was " + number);
			distinct = true;
			length = 0;
			while (distinct == true) {
				num_digits = (int) Math.ceil(Math.log10((double) number + 1));
				if (number == 0) {
					num_digits = 1;
				}
				int digits[] = new int[num_digits];
				extract_digit(number, digits, num_digits);
				Arrays.sort(digits);
				number1 = get_value(digits, num_digits, 0);
				number2 = get_value(digits, num_digits, 1);
				number = number2 - number1;
				// System.out.println(number2 + " - " + number1 + " = " +
				// number);
				buff.append(number2 + " - " + number1 + " = " + number + "\n");
				chain[length++] = number;
				distinct = check_distinct(length, chain);
			}
			buff.append("Chain length " + length);
			// System.out.println("Chain length " + length);
			System.out.println(buff);
			// t=System.nanoTime()-t;
			System.out.println();
			input = s.nextLine();
			ls = new Scanner(input);
			number = ls.nextInt();
		}
		ls.close();
		s.close();
	}

	// return true if the last number does not appear before
	// in the array, and false otherwise
	static boolean check_distinct(int len, int array[]) {
		boolean is_distinct = true;
		for (int i = 0; i < len - 1; i++) {
			if (array[i] == array[len - 1])
				is_distinct = false;
		}
		return is_distinct;
	}

	// convert a sequence of digits into a base 10 number
	// flag = 1 means converting reverse sequence
	static int get_value(int digits[], int num, int flag) {
		int number = 0;
		if (flag == 1) {
			reverse_array(digits, num);
		}
		for (int i = 0; i < num; i++) {
			number = number * 10 + digits[i];
		}
		return number;
	}

	// reverse the content of an array
	static void reverse_array(int array[], int size) {
		int temp;
		for (int i = 0; i < size / 2; i++) {
			temp = array[i];
			array[i] = array[size - i - 1];
			array[size - i - 1] = temp;

		}
	}

	// extract digits from a number and store each digit
	// into consecutive entries in the array
	static void extract_digit(int input, int output[], int size) {
		for (int i = size - 1; i >= 0; i--) {
			output[i] = input % 10;
			input = input / 10;
		}
	}
}

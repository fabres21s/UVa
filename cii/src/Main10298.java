import java.util.Scanner;

//TODO No enviado - Power Strings
public class Main10298 {

	/**
	 * no enviado
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i, j, m, n;
		char s[];
		while (input.hasNext()) {
			s = input.next().toCharArray();
			if (s[0] == '.') {
				break;
			}
			m = n = s.length;
			for (i = 2; i < n; i++) {
				while (n % i == 0) {
					n /= i;
					for (j = 0; j < (m - m / i) && s[j] == s[j + m / i]; j++) {
						if (j == m - m / i) {
							m /= i;
						}
					}
				}
			}
			System.out.println(s.length / m);
		}
		input.close();
	}
}

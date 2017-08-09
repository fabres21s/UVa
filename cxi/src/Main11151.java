import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main11151 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Next - No enviado - Longest Palindrome
		//No coincide salida con el UDebug
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases = Integer.parseInt(br.readLine());
		String word;
		for (int i = 0; i < testCases; i++) {
			word = br.readLine();
			int length = word.length();
			char array [] = word.toCharArray();
			System.out.println(longesPalindrome(array, length-1));
		}
	}

	private static int longesPalindrome(char[] array, int length) {

		int max = 1;
		for (int i = 0; i <= length; i++) {
			for (int j = length; j>i; j--) {
				if (array[i] == array[j]) {
					if (isPalindrome(array, i, j)) {
						max = Math.max(max, j - i + 1);
						//System.out.println(j+" "+i);
						break;
					}
				}
			}
		}
			
		return max;
	}

	private static boolean isPalindrome(char [] array, int start, int end) {
		int middle = (end - start)/2;
		for (int i = start; i <= middle +1; i++) {
			if (array[i] != array[end]) {
				return false;
			}
			end--;
		}
		//System.err.println(start + " "+end);
		return true;
	}

}
//TYVZZYOVHIGPRVUWPWDYGFPCWFBIIPOEOLDPLTKSDTJVQERHCUGKBXNAEQKNFARVLWKXPXRTSBQIHHPJDXWHVLHZBROIRFEEBQDTPVOHYERFNHQSGOZBZIDABRLUXRZAJCVZXJIXPAEEHV 46
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	12467 - Secret word
*
*
*	Submision:	20402615
*	Date:		2017-11-26 12:28:08
*	Runtime:	1.180
*	Ranking:	441
*/
public class Main12467 {

	/**
	 * - Cadena de caracteres
	 * 
	 * Buscar el substring más largo que sea el contrario de cómo empieza la palabra 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		int testCases = Integer.parseInt(br.readLine());
		int k;
		char [] word;
		while (testCases-- > 0) {
			word = br.readLine().toCharArray();
			
			k = maxMatchedPrefix(word);
			while (k-- >0) {
				output.append(word[k]);
			}
			output.append("\n");
		}
		
		System.out.print(output);
	}
	
	static int maxMatchedPrefix(char[] t)
	{
		int n = t.length * 2 + 1, pi[] = new int[n];
		char[] s = new char[n];
		for(int i = 0; i < t.length; ++i)
			s[i] = s[n - i - 1] = t[i];
		for(int i = 1, j = 0; i < n; ++i)
		{
			while(j > 0 && s[i] != s[j])
				j = pi[j-1];
			if(s[i] == s[j])
				++j;
			pi[i] = j;
		}
		int ret = 0;
		for(int i = t.length + 1; i < n; ++i)
			ret = Math.max(ret, pi[i]);
		return ret;
	}
	
}

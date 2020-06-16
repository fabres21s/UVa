import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
*	490 - Rotating Sentences
*
*
*	Submission:	9488671
*	Date:		2011-11-19 21:30:14
*	Runtime:	0.168
*	Ranking:	8623
*/
public class Main490 
{

	/**
	 * - Cadena de caracteres
	 */
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> list = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		String line;
		int max = 0;
		while ((line = in.readLine()) != null)
		{
			list.add(line);
			if (line.length() > max)
				max = line.length();
		}

		for (int m=0; m<max; m++)
		{
			for (int i=list.size()-1; i>=0; i--)
			{
				line = list.get(i);
				if (line.length() > m)
				{
					sb.append(line.charAt(m));
				}
				else
				{
					sb.append(" ");
				}
			}
			System.out.println(sb.toString());
			sb.delete(0, sb.length());
		}
	}
}

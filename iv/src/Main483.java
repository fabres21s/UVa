import java.io.IOException;
import java.util.Scanner;

/**
*	483 - Word Scramble
*
*
*	Submision:	9387778
*	Date:		2011-10-19 14:58:28
*	Runtime:	0.188
*	Ranking:	12561
*/
public class Main483 {

	/**
	 * - Cadena de caracteres
	 */
	public static void main(String[] args) throws IOException
	{
		Scanner input=new Scanner(System.in);
		while(input.hasNext())
		{
			String linea=input.nextLine();
			String [] tokens=linea.split(" ");
			StringBuffer buf =new StringBuffer();	
			StringBuffer buf2 =new StringBuffer();	
			//buf.append(tokens[0]);
			int i=0;
			for(i=0;i<tokens.length-1;i++)
			{
				buf.append(tokens[i]);
				buf2.append(buf.reverse()+" ");
				buf=new StringBuffer();
			}
			buf.append(tokens[i]);
			buf2.append(buf.reverse());
			System.out.println(buf2);
		}

	}

}

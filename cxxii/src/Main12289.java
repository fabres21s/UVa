import java.util.Scanner;

/**
*	12289 - One-Two-Three
*
*
*	Submision:	9573650
*	Date:		2011-12-19 02:58:24
*	Runtime:	0.120
*	Ranking:	6312
*/
public class Main12289 {

	/**
	 * - Cadena de caracteres
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int casos=input.nextInt();
		char [] p;
		while(casos>0)
		{
			casos--;
			p=input.next().toCharArray();
			if(p.length==5)
			{
				System.out.println(3);
				continue;
			}
			if((p[0]=='t' && p[1]=='w'))
			{
				System.out.println(2);
				continue;
			}
			if(p[0]=='t' && p[2]=='o')
			{
				System.out.println(2);
				continue;
			}
			if(p[1]=='w' && p[2]=='o')
			{
				System.out.println(2);
				continue;
			}
			System.out.println(1);			
		}
	}
}

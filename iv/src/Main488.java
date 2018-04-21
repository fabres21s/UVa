import java.util.Scanner;

/**
*	488 - Triangle Wave
*
*
*	Submission:	9499739
*	Date:		2011-11-23 17:53:28
*	Runtime:	1.176
*	Ranking:	8874
*/
public class Main488 
{
	static StringBuffer buffer;

	/**
	 * - Simulaci�n
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int casos=input.nextInt();	
		for(int i=0;i<casos;i++)
		{			
			int a=input.nextInt(), f=input.nextInt();
			StringBuffer buffer=new StringBuffer();				
			for (int j = 0; j < f; j++)
			{
				if (j > 0 || i > 0)
					buffer.append("\n");
				for (int k = 0; k < a; k++)
				{
					for (int l = 0; l < k+1; l++)
					{
						buffer.append( (k%a) + 1);
					}
					buffer.append("\n");
				}		 
				for (int k = 0; k < a-1; k++)
				{
					for (int l = 0; l < a-1-k; l++)
					{
						buffer.append( a-1-k);
					}
					buffer.append("\n");
				}
			}
			System.out.print(buffer);
		}
		input.close();
	}
	
	

}

import java.util.Scanner;


/**
*	494 - Kindergarten Counting Game
*
*
*	Submision:	9483993
*	Date:		2011-11-19 01:07:53
*	Runtime:	0.180
*	Ranking:	20589
*/
public class Main494 
{
	/**
	 * - Cadena de caracteres
	 */
	//TODO String - Poner categoria
	public static void main(String[] args) 
	{
		Scanner input=new Scanner (System.in);
		while(input.hasNext())
		{			
			int cont=0;
			boolean letter =false;
			char [] p=input.nextLine().toCharArray();
			for(int i=0;i<p.length;i++)
			{
				if(Character.isLetter(p[i]))
				{
					if(!letter)
					{
						cont++;
						letter=true;
					}
				}
				else
				{
					letter=false;
				}
			}
			System.out.println(cont++);
		}
		input.close();
	}

}

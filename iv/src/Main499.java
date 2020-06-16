import java.util.Scanner;


/**
*	499 - What's The Frequency, Kenneth?
*
*
*	Submission:	9709973
*	Date:		2012-02-05 01:09:20
*	Runtime:	0.332
*	Ranking:	8805
*/
public class Main499 {

	/**
	 * - Cadena de caracteres
	 */
	public static void main(String[] args) 
	{
		String abc="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Scanner input=new Scanner (System.in);
		String linea;	
		int posicion, mayor,i;
		while(input.hasNext())
		{
			linea=input.nextLine();
			int []arreglo=new int[53];
			for(i=0;i<linea.length();i++)
			{
				posicion=abc.indexOf(linea.charAt(i));
				if(posicion>-1)
				{
					arreglo[posicion]++;
				}
			}
			//System.out.println(Arrays.toString(arreglo));
			mayor=-1;
			for(i=0;i<53;i++)
			{
				if(arreglo[i]>mayor)
				{
					mayor=arreglo[i];
				}
			}
			for(i=0;i<53;i++)
			{
				if(arreglo[i]==mayor)
				{
					System.out.print(abc.charAt(i));
				}
			}
			System.out.println(" "+mayor);
		}	
		input.close();
	}

}

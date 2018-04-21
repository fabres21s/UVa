import java.util.Scanner;


/**
*	486 - English-Number Translator
*
*
*	Submission:	9384560
*	Date:		2011-10-18 15:14:29
*	Runtime:	1.780
*	Ranking:	1844
*/
public class Main486 
{
	static String []valores={"zero","one","two","three","four","five", "six", "seven", "eight", "nine", "ten",
		"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
		"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	
	static int []numeros={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90};

	/**
	 * - Cadena de caracteres
	 */
	//TODO String - Poner categoria
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		String palabra;		
		while(input.hasNext())
		{
			palabra=input.nextLine();
			int n=0, z=1;
			String []tokens;
			if(palabra.contains("negative"))
			{
				z=-1;
				palabra=palabra.substring(9);
			}
			palabra+=" ";			
			if(palabra.contains("million"))
			{
				tokens=palabra.split("million");
				palabra=tokens[1];
				n=cientos(tokens[0])*1000000;
			}
			if(palabra.contains("thousand"))
			{
				tokens=palabra.split("thousand");
				palabra=tokens[1];
				n+=cientos(tokens[0])*1000;
			}
			n+=cientos(palabra);
			if(z==-1)
			{
				n*=-1;
			}
			System.out.println(n);			
		}
		input.close();
	}
	
	static int cientos(String palabra)
	{
		String tokens[];
		int x=0;
		if(palabra.contains("hundred"))
		{
			tokens=palabra.split("hundred");
			palabra=tokens[1];
			x=buscar(tokens[0])*100;
		}
		if(!palabra.trim().equals(""))
		{
			tokens=palabra.split(" ");
			for(int i=0; i<tokens.length;i++)
			{
				if(tokens[i].trim().isEmpty())
				{
					continue;
				}
				x+=buscar(tokens[i]);
			}
		}
		return x;
	}
	
	static int buscar(String p)
	{
		p=p.trim();
		int i=0;
		while(!valores[i].equals(p))
		{
			i++;
		}
		return numeros[i];
	}

}

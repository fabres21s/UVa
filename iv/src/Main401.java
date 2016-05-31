import java.util.Scanner;

/**
*	401 - Palindromes
*
*
*	Submision:	9321673
*	Date:		2011-10-01 14:33:09
*	Runtime:	0.780
*	Ranking:	11521
*/

public class Main401 
{
	static String caracter="AEHIJLMOSTUVWXYZ12358";
	static String reves=   "A3HILJMO2TUVWXY51SEZ8";

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{

		Scanner input=new Scanner(System.in);
		String palabra="";
		while(input.hasNext())
		{
			palabra=input.nextLine();
			boolean p=(palindromo(palabra));
			boolean e=(espejo(palabra));
			if(p && e)
			{
				System.out.println(palabra+" -- is a mirrored palindrome.");
			}
			else if(p)
			{
				System.out.println(palabra+" -- is a regular palindrome.");

			}
			else if(e)
			{
				System.out.println(palabra+" -- is a mirrored string.");
			}
			else
			{
				System.out.println(palabra+" -- is not a palindrome.");
			}
			System.out.println();
		}

	}
	
	static boolean palindromo (String palabra)
	{
		int i=0;
		for( i=0;i<palabra.length()/2;i++)
		{
			if(palabra.charAt(i)!=palabra.charAt(palabra.length()-1-i))
			{
				return false;
			}
		}
		
		return true;
	}
	
	static boolean espejo(String palabra)
	{
		for(int i=0; i<=palabra.length()/2;i++)
		{
			if(caracter.indexOf(palabra.charAt(i))!=reves.indexOf(palabra.charAt(palabra.length()-1-i)) || caracter.indexOf(palabra.charAt(i))==-1)
			{
				return false;
			}
		}
		return true;
	}
}


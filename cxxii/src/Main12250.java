import java.util.Arrays;
import java.util.Scanner;

/*
 * Fabio Andrés Sierra
 * Language Detection
 * UVa: 12250
 */

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		final String []languages={"FRENCH","ITALIAN","GERMAN","ENGLISH","SPANISH","RUSSIAN"};
		final String []saludos={"BONJOUR","CIAO","HALLO","HELLO","HOLA","ZDRAVSTVUJTE"};
		Scanner input=new Scanner(System.in);
		int busq, i=1;
		String p;
		while(input.hasNext())
		{
			p=input.next();
			if(p.equals("#"))
			{
				break;
			}
			busq=Arrays.binarySearch(saludos,p);
			if(busq>-1){
			System.out.println("Case "+i+": "+languages[busq]);
			}
			else
			{
				System.out.println("Case "+i+": UNKNOWN");
			}
			i++;
		}
		// TODO Auto-generated method stub
	}
}

import java.util.Scanner;

public class Main 
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int n, cont, valor;
		while(input.hasNext())
		{
			n = input.nextInt();
			cont = 2;
			valor = 11;
			while(valor % n !=0)
			{

				valor = valor%n;
		    	valor = valor*10 + 1;
		    	cont ++;
		    }
			System.out.println(cont);
		}
		input.close();
		// TODO Auto-generated method stub
	}	
}

import java.util.Scanner;
import java.util.Vector;

/*
 *   Fabio Andrés Sierra Jaraba
 *   Bingo!   
 *   UVa:  12239
 *    
 */

public class Main 
{
	static Vector <Integer> numeros=new Vector <Integer>();

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner lectura=new Scanner(System.in);
		//BufferedReader lectura=new BufferedReader(new FileReader("bingo.in.txt"));
		//PrintWriter escritura=new PrintWriter(new FileWriter("bingo.out.txt"));
		String linea;
		while(!(linea=lectura.nextLine().trim()).equals("0 0"))
		{
			String []tokens =linea.split(" ");
			int n=Integer.valueOf(tokens[0]);
			tokens=lectura.nextLine().split(" ");
			for(int i=0; i<tokens.length-1; i++)
			{
				for(int j=i+1; j<tokens.length;j++)
				{
					int dif=Math.abs(Integer.valueOf(tokens[i])-Integer.valueOf(tokens[j]));
					if(!numeros.contains(dif))
					{
						numeros.add(dif);
					}
				}
			}
			if(numeros.size()==n)
			{
				System.out.println("Y");
			}
			else
			{
				System.out.println("N");
			}
			numeros.removeAll(numeros);
		}
		// TODO Auto-generated method stub

	}

}

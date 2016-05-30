import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/*
 *   Fabio Andrés Sierra Jaraba
 *   Jollo   
 *   UVa:  12247
 */


public class Main 
{
	static Vector <Integer> principe=new Vector <Integer>();
	static Vector <Integer> princesa=new Vector <Integer>();

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		while(input.hasNext())
		{
			principe.removeAll(principe);
			princesa.removeAll(princesa);
			princesa.add(input.nextInt());
			princesa.add(input.nextInt());
			princesa.add(input.nextInt());
			principe.add(input.nextInt());
			principe.add(input.nextInt());
			if(principe.get(1)==0)
			{
				break;
			}
			Collections.sort(principe);
			Collections.sort(princesa);
			int aux=-1,p=1;
			if(principe.get(0)>princesa.get(2))
			{
				while(princesa.contains(p) || principe.contains(p))
				{
					p++;
				}
				aux=p;
			}

			else
			{
				if(principe.get(0)>princesa.get(1) && principe.get(1)>princesa.get(1))
				{
					aux=princesa.get(1)+1;					
				}			
				else
				{
					if(principe.get(1)>princesa.get(2))
					{
						aux=princesa.get(2)+1;
					}					
				}
				if(aux!=-1)
				{
					while(princesa.contains(aux) || principe.contains(aux))
					{
						aux++;
					}			
				}
			}
			if(aux>52)
			{
				aux=-1;
			}
			System.out.println(aux);
		}
		// TODO Auto-generated method stub
	}
}

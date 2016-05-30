import java.util.Arrays;
import java.util.Scanner;

/*
 *   Fabio Andrés Sierra Jaraba
 *   In Braille
 *   UVa:  12364
 */


public class Main 
{
	static int a,b,c;
	
	public static void main(String[] args) 
	{		
		Scanner input = new Scanner(System.in);
		a = input.nextInt();
		b = input.nextInt();
		c = input.nextInt();
		//ordenar
		int temp;
		if(a==c && b!=c)
		{
			temp=b;
			b=c;
			c=temp;
		}
		if(b==c && a!=c)
		{
			temp=a;
			a=c;
			c=temp;
		}
		while(a!=0 && b!=0 && c!=0)
		{
			//3 diferentes
			if(a!=b && b!=c && c!=a)
			{
				System.out.println("1 1 2");
			}
			//3 cartas iguales
			if(a==b && b==c)
			{				
				if(a!=13)
				{
					a++;
					System.out.println(a+" "+a+" "+a);
				}
				else
					System.out.println("*");
			}
			//Parejas
			else if(a==b)
			{
				if(a<=13 && c<13)
				{
					c++;					
					 if(a==c)
					 {
						 c++;
						 if(c==14)
						 {
							a=1;
							b=1;
							c=1;
						}
					}
					ordenar();
				}
				else if(a==13 && c==12)
				{
					System.out.println("1 1 1");
				}
				else if(c==13)
				{
					c=1;
					a++;
					b++;
					ordenar();
				}
			}
			a = input.nextInt();
			b = input.nextInt();
			c = input.nextInt();
			//ordenar
			if(a==c && b!=c)
			{
				temp=b;
				b=c;
				c=temp;
			}
			if(b==c && a!=c)
			{
				temp=a;
				a=c;
				c=temp;
			}
		}		
	}

	static void ordenar() 
	{
		int array[] = {a,b,c};
		Arrays.sort(array);
		System.out.println(array[0]+" "+array[1]+" "+array[2]);
	}
}

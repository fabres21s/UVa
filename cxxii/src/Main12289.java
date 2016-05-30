import java.util.Scanner;

/*
 *  Fabio Andrés Sierra	
 *  One-Two-Three
 *  UVa: 12289
 */

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int casos=input.nextInt();
		char [] p;
		while(casos>0)
		{
			casos--;
			p=input.next().toCharArray();
			if(p.length==5)
			{
				System.out.println(3);
				continue;
			}
			if((p[0]=='t' && p[1]=='w'))
			{
				System.out.println(2);
				continue;
			}
			if(p[0]=='t' && p[2]=='o')
			{
				System.out.println(2);
				continue;
			}
			if(p[1]=='w' && p[2]=='o')
			{
				System.out.println(2);
				continue;
			}
			System.out.println(1);			
		}
		// TODO Auto-generated method stub
	}
}

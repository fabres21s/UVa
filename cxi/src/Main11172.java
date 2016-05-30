import java.util.Scanner;

public class Main {


	/*
		11172 - Relational Operator
		- Muy fácil
		Validar si un número es mayor, menor o igual a otro
	*/

	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int casos=input.nextInt(), a,b;
		while(casos>0)
		{
			casos--;
			a=input.nextInt();
			b=input.nextInt();
			if(a>b)
			{
				System.out.println(">");
			}
			else if(a<b)
			{
				System.out.println("<");
			}
			else
			{
				System.out.println("=");
			}
		}
		input.close();
		// TODO Auto-generated method stub
	}
}

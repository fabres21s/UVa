import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int aux,n,cuadrado,diagonal;
		while((n=input.nextInt())!=0)
		{
			aux=(int)Math.sqrt(n);
			if(aux*aux==n)
			{
				if(aux%2==0)
				{
					System.out.printf("%d 1\n",aux);
				}
				else
				{
					System.out.printf("1 %d\n",aux);
				}
				continue;
			}
			aux++;
			cuadrado=aux*aux;
			diagonal=cuadrado-aux+1;
			if(n==diagonal)
			{
				System.out.printf("%d %d\n",aux,aux);
				continue;
			}
			if(aux%2==0)
			{
				if(n>diagonal)
				{
					System.out.printf("%d %d\n",aux,(aux+diagonal-n));
				}
				else
				{
					System.out.printf("%d %d\n",(n+aux-diagonal),aux);
				}
			}
			else
			{
				if(n>diagonal)
				{
					System.out.printf("%d %d\n",(aux+diagonal-n),aux);
				}
				else
				{
					System.out.printf("%d %d\n",aux,(n+aux-diagonal));
				}
			}
		}
		input.close();
		// TODO Auto-generated method stub
	}
}

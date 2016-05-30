import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		String valor;
		BigInteger a;
		int x;
		while(input.hasNext())
		{
			valor=input.next();
			try
			{
				x=Integer.valueOf(valor);
				if(x<0)
				{
					break;
				}
			}
			catch(Exception e)
			{				
			}
			if(valor.contains("0x"))
			{
				valor=valor.substring(2, valor.length());
				a=new BigInteger(valor,16);
				valor=a.toString(10);
				System.out.println(valor);
			}
			else
			{
				a=new BigInteger(valor,10);
				valor=a.toString(16).toUpperCase();
				System.out.println("0x"+valor);
			}
		}		
		input.close();
		// TODO Auto-generated method stub
	}	
}

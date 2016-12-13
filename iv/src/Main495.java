import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;


/**
*	495 - Fibonacci Freeze
*
*
*	Submision:	9411044
*	Date:		2011-10-26 14:29:30
*	Runtime:	1.864
*	Ranking:	7450
*/
public class Main495 {

	/**
	 * - Pregenerados
	 * - Fibonacci
	 * - Big Numbers
	 */
	public static void main(String[] args) throws IOException
	{
		BigInteger[] fibos = new BigInteger[5005];  
		Scanner input=new Scanner (System.in);
        
        int i;
        fibos[0]=BigInteger.ZERO;
        fibos[1]=BigInteger.ONE;
        for(i=2;i<5005;i++)
        {
        	//System.out.println(fibos[i-1]);
        	fibos[i] = fibos[i - 1].add(fibos[i - 2]);  
        	//System.out.println(fibos[i]);
        }
        while(input.hasNext())
        {

        	i=input.nextInt();

        	if(i<0)
        	{
        		continue;
        	}
        	System.out.println("The Fibonacci number for "+i+" is "+fibos[i]);
        }
     

        
        input.close();
	}

}
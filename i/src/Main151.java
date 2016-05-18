import java.util.Scanner;

/*
 *   Fabio Andr�s Sierra Jaraba
 *   Power Crisis
 *   UVa:  156
 *    
 */

public class Main151 
{
	static boolean k[]=new boolean[100];
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int N, count ;
	    
	    Scanner input=new Scanner(System.in);
	    boolean t ;

	    while(input.hasNext())
	    {
	    	N=input.nextInt();
	        if(N == 0)
	            break;
	        for(int i = 1; i < N; i++)
	        {
	            init(k);
	            int j = 1;
	            count = 0;
	            t = true;
	            for( ; ; )
	            {
	                if(j > N)
	                    j -= N;
	                if(k[j] == false)
	                {
	                    if(count == i)
	                    {
	                        k[j] = true;
	                        count = 0;
	                    }
	                    j++;
	                    count++;
	                    k[1] = true;
	                }
	                else
	                    j++;
	                if(k[13] == true)
	                    break;
	            }
	            for(int m = 1; m <= N; m++)
	            {
	                if(k[m] == false)
	                {
	                    t = false;
	                    break;
	                }
	            }
	            if(t == true)
	            {
	                System.out.println(i);
	                break;
	            }
	        }
	    }
		// TODO Auto-generated method stub
	}
	
	static void init(boolean k[])
	{
	     for(int i = 1; i < 100; i++)
	         k[i] = false;
	}

}

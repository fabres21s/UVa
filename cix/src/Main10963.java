import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int N;
	    int print = 0;
	    while( input.hasNext())
	    {
	    	N=input.nextInt();
	        int i;

	        for( i = 0 ; i < N ; i++ )
	        {
	            if( print>0 )
	                System.out.printf( "\n" );
	            print = 1;
	            
	            int W=input.nextInt();
	            //scanf( "%d", &W );

	            int y1=input.nextInt(), y2=input.nextInt();
	            int ok = 1;
	            //scanf( "%d%d", &y1, &y2 );
	            
	            int gap = y1-y2;
	            int j;
	            
	            for( j = 1 ; j < W ; j++ )
	            {
	            	y1=input.nextInt();
	            	y2=input.nextInt();
	                //scanf( "%d%d", &y1, &y2 );
	                if( y1-y2 != gap )
	                    ok = 0;
	            }
	            if( ok >0)
	                System.out.printf( "yes\n" );
	            else
	                System.out.printf( "no\n" );
	        }
	    }
	    input.close();
		// TODO Auto-generated method stub
	}
}

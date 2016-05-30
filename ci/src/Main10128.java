/**
*	10128 - Queue
*
*
*	Submision:	9306832
*	Date:		2011-09-27 20:45:43
*	Runtime:	0.588
*	Ranking:	1417
*/
public class Main10128 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int cases = readUint();
        for (int i = 1; i <= cases; i++)
        {  
         int N = readUint();
         int P = readUint();
         int R = readUint();
         System.out.println(q(N,P,R));
        }
		// TODO Auto-generated method stub
	}
	
	static int factorial (int n)
    {
       int fact = 1;
       int i;

       if (n <= 1)
          {  return fact;  }
       for (i = 2; i<=n; i++)
           fact *= i;

       return fact;
    }

    static int binomial (int n, int k)
    {
       int result = 1;
       int i;
    
       if ((n-k) < k)
            {  k = n-k;  }
       for (i = n - k + 1; i<= n; i++)
            {  result *= i;  }
       for (i = 1; i <= k; i++)
            {  result /= i;  }
    
       return result;
    }

    static int q (int N, int P, int R)
    {
      int result = 0;
      int k;

      //*  check for "invalid" input, i.e. queues for which
      //*     there is no solution
      if ((N == 1) && ((P != 1) || (R != 1)))
         {  return 0;  }
      if ((N >= 2) && ((P+R) < 3))
         {  return 0;  }
      if ((N >= 2) && ((P+R) > N+1))
         {  return 0;  }
      //*  we will assume that P >= R, else we will switch and try again
      if (R > P)  
         {  return q (N, R, P);  }
      //*  check for more special boundary cases
      if (N == P)
         {  return 1;  }
      if ((P == 2) && (R == 1))
         {  return factorial(N-2);  }
      if (R == 1)
         {  for (k=P-1; k <= N-1; k++)
                result += q (k, P-1, 1)*binomial(N-2, k-1)* factorial(N-k-1);
            return result;
         }
      //*  if we get to here, this is the most general case
      for(k = P; k <= N-R+1; k++)
           result += q (k, P, 1)*q (N-k+1, R, 1)*binomial(N-1, k-1);
      return result;

    }

    static int readUint()
    {
          int val = 0;
          int pos = 0;
          int character = 0;

          try {

                while ((character = System.in.read()) > -1)
                      {
                      if ((character >= '0') && (character <= '9') )
                            {
                            val = (val*10)+(character - '0' );
                            pos ++;
                            }
                      if (character == ' ' || character == '\n')
                            {
                            if (pos > 0)
                                  return val;
                            return -1;
                            }
                      }
             }catch (Exception e) {}
          return -1;
     }
}

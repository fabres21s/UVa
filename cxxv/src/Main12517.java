import java.util.Scanner;



public class Main {

	/**12517 - Digit Sum
	 * Recursividad, Proceso matemático
	 * Encontrar la sumatoria de los digitos hasta n, 
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
        while(true)
        {
        	
        	int a = sc.nextInt() ;
        	int b = sc.nextInt();
        	
        	if (a== b && b == 0) {
        		break;
        	}
            long [] digita=new long[10];
            long [] digitb=new long[10];
            //int a=sc.nextInt();
            a--;
            
            recurse(digita,0,1);
            recurse(digitb,a,1);
            int i;
            long sum = 0;
            for(i=1;i< 10;i++)
            {
            	sum -= Math.abs(digitb[i]-digita[i]) *i;
            }
          //  System.out.println(sum);
            
             digita=new long[10];
             digitb=new long[10];
            
            recurse(digita,0,1);
            recurse(digitb,b,1);
            for(i=1;i< 10;i++)
            {
            	sum += Math.abs(digitb[i]-digita[i]) *i;
            }
            System.out.println(sum);
        }     	
        // TODO Auto-generated method stub
    }	
	
	static void recurse(long [] digit,int n,long count)
	{
		if(n<=0) return;
		int oneNo=n%10,tenNo;
		int m=n/10;
		tenNo=m;
		for(int i=0;i<=oneNo;i++)
		{
			digit[i]+=count;
		}
		while(tenNo!=0)
		{
			digit[tenNo%10]+=(oneNo+1)*count;
			tenNo/=10;			
		}
		for(int i=0;i< 10;i++)
		{
			digit[i]+=count*m;
		}
		digit[0]-=count;
		recurse(digit,m-1,10*count);
	}	
}

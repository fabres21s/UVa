import java.util.Scanner;


//TODO No enviado - Professor Lazy, Ph,D
public class Main12464 {

	/**
	 * no enviado
	 */
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
        long a, b, n, valor/*, ant1, ant2*/;
        while(true)
        {
            a=input.nextLong();
            b=input.nextLong();
            n=input.nextLong();
            if(a==0 && b==0 && n==0)
                break;
            else if(n == 0)
                System.out.println(a);
            else if(n==1)
                System.out.println(b);
            else
            {
                valor=-1;
                for(long i=2;i<=n;i++)
                {
                    if(i%2==0)
                    {
                        valor=(1+b)/a;
          
                    }
                    else
                    {
                        valor=(1+valor)/b;

                    }
                }
                System.out.println(valor);
            }
        }
        input.close();


	}

}

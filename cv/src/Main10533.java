import java.io.IOException;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		int c,i,sum,x;
		int arreglo[]=new int[1000005];
		Scanner input=new Scanner(System.in);
		c = 0;
		long t=System.currentTimeMillis();
		for (i = 1; i <1000002; i+=2) {
			//System.out.println(i);
			arreglo[i-1]=c;
			if (esprimo(i)) {
				x = i;
				sum = 0;
				while (x > 0) {
					sum += x % 10;
					x /= 10;
				}
				if(sum%2!=0 ){
					if (esprimo(sum)){
						c++;						
					}
				}
			}				
			arreglo[i]=c;			
		}
		System.out.println(System.currentTimeMillis()-t);
		c=input.nextInt();
		while(c-->0)
			System.out.println((arreglo[input.nextInt()]-arreglo[input.nextInt()])*-1);
		input.close();
		}
	

		// TODO Auto-generated method stub

	
	
	static boolean esprimo(int valor)
	{

		for(int i=3;i<Math.sqrt(valor)+1;i+=2)
		{
			if(valor%i==0)
			{
				return false;
			}
		}				
		return true;
	}
	


}

/*
 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        boolean[] primes = new boolean[61];
        for (int i = 2; i < 61; i++) {
            primes[i] = isPrime(i);
        }
        int[] range = new int[1000 * 1000 + 1];
        int temp = 0;
        for (int i = 0; i < 1000 * 1000 + 1; i++) {
            if (isPrime(i)) {
                if (primes[numtoInt(i)]) {
                    temp++;
                }
            }
            range[i] = temp;

        }
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        int cases = Integer.parseInt(br.readLine());
        StringBuilder out = new StringBuilder("");
        for (int i = 0; i < cases; i++) {
            StringTokenizer m=new StringTokenizer(br.readLine());
            int x = Integer.parseInt(m.nextToken());
            int y = Integer.parseInt(m.nextToken());
            int counter = range[y]-range[x-1];
            out.append(counter);
            out.append("\n");
        }
        System.out.print(out);
    }

    static int numtoInt(int x) {
        if (x > 9) {
            return x % 10 + numtoInt(x / 10);
        }
        return x % 10;
    }

    static boolean isPrime(int x) {
        if (x == 2) {
            return true;
        }
        for (int i = 2; i < Math.sqrt(x) + 1; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
*/

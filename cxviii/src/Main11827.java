import java.util.Arrays;
import java.util.Scanner;


public class Main {

	/**
	 * runtime error
	 */
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String linea;
		int casos=Integer.valueOf(input.nextLine());
		int i,j,x,gcd,max;
		while(casos-->0){
			int []arreglo=new int[100000];
			x=0;
			args = input.nextLine().split(" ");
			for (String s : args){
				arreglo[x] = Integer.valueOf(s);
				x++;
			}

			//System.out.println(Arrays.toString(arreglo));
			max=-1;
			for(i=0;i<x;i++){
				for(j=i+1;j<x;j++){
					//System.out.println(arreglo[i]+" "+arreglo[j]);
					gcd=gcd(arreglo[i],arreglo[j]);
					if(gcd>max){
						max=gcd;
					}
				}
			}
			System.out.println(max);
		}
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

}

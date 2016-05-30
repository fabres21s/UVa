import java.util.Scanner;
import java.util.Vector;


public class Main {
	
	static int [] a;
	static boolean solucionado;
	static int target;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt(),  sum;
	//	int [] bars ;
		boolean exito;
		StringBuffer buffer = new StringBuffer();
		while (cases -- > 0) {
			solucionado = false;
			target = input.nextInt();
			a = new int[input.nextInt()];
			sum = 0;
			exito = target == sum;
			for (int i = 0; i < a.length; i++) {
				a [i] = input.nextInt();
				if (!exito){
					sum += a[i];
					exito = (sum == target || target == a[i]) ;
				}
			}
			
			if (exito) {
				buffer.append("YES\n");
				
			} else {
				solucionar();
				buffer.append(solucionado?"YES":"NO");
				buffer.append("\n");
			}
			
			
		}
		System.out.print(buffer);
	}
	
	static void encontrar(int sum, int pos)
	{
		int s;
		for(int i=pos+1; ( i<a.length-1 && !solucionado);i++)
		{
			s=sum+a[i];
			buscar(s,i);

			encontrar(s,i);
		}		
	}
	
	static void solucionar()
	{
		int i, j;

		int sum;		
		for(i=0;( i<a.length-1 && !solucionado); i++)
		{

			buscar(a[i],i);

			for(j=i+1; (j<a.length-1 && !solucionado); j++)
			{
				sum=a[i]+a[j];
				buscar(sum,j);

				encontrar(sum,j);
			}
		}		
				
	}
	
	static void buscar(int valor, int pos)
	{
		for(int i=pos+1; (i<a.length && !solucionado); i++)
		{
			solucionado = (valor + a[i]) == target;
			

		}
	}

}

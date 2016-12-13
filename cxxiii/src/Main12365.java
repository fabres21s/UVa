import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO TLE - Jupiter Atacks! - En C++ también
public class Main12365 
{

	/**
	 * @param args
	 * @throws IOException 
	 * JAVA HEAP SPACE -replantear
	 */
	public static void main(String[] args) throws IOException 
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String letra;
		int i,x,y;
		int base,primo,n;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> usados = new ArrayList<Integer>();
		long sum,  value;
		while(true)
		{
			
			map.clear();
			usados.clear();
			args = br.readLine().split(" ");
			base= Integer.parseInt(args[0]);
			primo=Integer.parseInt(args[1]);;
			n=Integer.parseInt(args[3]);
			if(n==0 && base==0)
			{
				break;
			}

			
			for(i=0;i<n;i++)
			{
				args = br.readLine().split(" ");
				letra=args[0];
				x=Integer.parseInt(args[1]);
				y=Integer.parseInt(args[2]);
				if(letra.equals("H"))
				{
				//	long t = System.currentTimeMillis();
					 sum = 0;
					 value=0;
					 
					 Collections.sort(usados);
					 
					 for (Integer index : usados) {
						 if ( index >= x && index <= y) {
							 value = fastPow(base, y - index , primo);
								System.out.println("value = "+value);
								sum += value*map.get(index);
								sum = sum%primo;
								System.out.println("sum = "+sum);
						 }
					 }
					 System.out.println(sum);
				/*	 sum = exp =0;
					for ( a = y; a >= x; a--) {
						if (map.get(a) != null) {
							value = modular(base, exp, primo);
							
								sum += value*map.get(a);
								sum = sum%primo;
							}
							
						exp++;
					}
					System.out.println(sum +" "+(System.currentTimeMillis() -t));*/
				}
				else
				{
					usados.add(x);
					map.put(x, y);
					
				}
			}
			System.out.println("-");
		}	
	}

	
	static long fastPow(long B, long P, long M) {
		if (P == 0) return 1;
		if (P == 1) return B % M;
		if (P % 2 == 0) return fastPow(((B % M) * (B % M)) % M, P / 2, M);
		else return ((B % M) * fastPow(((B % M) * (B % M)) % M, (P - 1) / 2, M) % M) % M;
	}
}


/*
20 139 5 7
E 1 12
E 5 4
E 2 14
E 4 2
E 3 2
H 2 5
E 2 14

999999935 999999937 100000 7
E 100000 6
E 1 7
H 1 100000
E 50000 8
H 1 100000
H 25000 75000
H 23987 23987

10 1000003 6 11
E 1 3
E 2 4
E 3 5
E 4 6
E 5 7
E 6 8
H 1 6
E 3 0
E 3 9
H 1 3
H 4 6

*/

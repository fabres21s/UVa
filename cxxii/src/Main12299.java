import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//TODO TLE - RMQ with Shifts
public class Main12299 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		int n,q,i, a,b,j,min, aux;
		while ( (line = br.readLine()) != null ){
			args = line.split(" ");
			n = Integer.parseInt(args[0]);
			q = Integer.parseInt(args[1]);
			
			int arreglo[] =new int[n+2];
			args = br.readLine().split(" ");
			for (i = 1; i <=n; i++) {
				arreglo[i] =Integer.parseInt(args[i-1]);
			}
			
			for (i = 0; i <q; i++) {
				line = br.readLine();
				args = line.replaceAll("query", "").replaceAll("[(]", "").replaceAll("[)]", "").replaceAll("shift", "").split(",");
				
				if (line.startsWith("q")) {
					min =Integer.MAX_VALUE;
					a = Integer.parseInt(args[0]);
					b = Integer.parseInt(args[1]);
					
					for (j = a; j <=b; j++) {
						min = Math.min(min, arreglo[j]);
					}
					System.out.println(min);
				} else {
					for ( j = 0; j <args.length -1; j++) {
						a = Integer.parseInt(args[j]);
						b = Integer.parseInt(args[j+1]);
						
						aux = arreglo[a];
						arreglo[a] = arreglo[b];
						arreglo[b] = aux;
 					}
				}
			}
		}
	}

}
/*
7 5 
6 2 4 8 5 1 4
query(3,7)

*/
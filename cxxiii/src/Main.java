import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int soldiers, loss;
		int left, right, j,l,r, i;
		
		StringBuffer output = new StringBuffer();
		while (true) {
			args = br.readLine().split(" ");
			soldiers = Integer.parseInt(args[0]);
			loss = Integer.parseInt(args[1]);
			
			if (soldiers == 0 && soldiers == loss) {
				break;
			}

			int [][] list = new int[soldiers +2][2];

			
			for ( i = 0; i <= soldiers +1 ; i++) {
				list[i][0] = i;
			}
			for ( i = 0; i < loss; i++) {
				args = br.readLine().split(" ");
				left = Integer.parseInt(args[0]);
				right = Integer.parseInt(args[1]);
				
				//int l = list.indexOf(left) - 1 , r = list.indexOf(right);
//				for ( j = left; j <= right; j++) {
//					list[j][0] = 0;
//				}
				list
				
				 l = 0; r = soldiers + 1;
//				for ( j = left -1; j > -1; j--) {
//					if (list[j] > 0) {
//						l = j;
//						break;
//					}
//				}
//				
//				for ( j = right ; j <= soldiers; j++) {
//					if (list[j] > 0) {
//						r = j;
//						break;
//					}
//				}
				
				//r -=  right - left;
				
				
				
				
				if (l == 0) {
					output.append("*");
				} else {
					output.append(l);
				}
				
				
				if (r > soldiers) {
					output.append(" *\n");
				} else {
					output.append(" "+r+"\n");
				}
					
				
			}
			output.append("-\n");
		}
		System.out.print(output);
	}

}

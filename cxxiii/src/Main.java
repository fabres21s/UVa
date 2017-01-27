import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int soldiers, loss;
		Integer left, right;
		
		StringBuffer output = new StringBuffer();
		while (true) {
			args = br.readLine().split(" ");
			soldiers = Integer.parseInt(args[0]);
			loss = Integer.parseInt(args[1]);
			
			if (soldiers == 0 && soldiers == loss) {
				break;
			}

			List<Integer> list = new ArrayList<Integer>();

			
			for (int i = 0; i <= soldiers +1 ; i++) {
				list.add(i);
			}
			for (int i = 0; i < loss; i++) {
				args = br.readLine().split(" ");
				left = Integer.parseInt(args[0]);
				right = Integer.parseInt(args[1]);
				
				int l = list.indexOf(left) - 1 , r = list.indexOf(right);
				for (Integer j = left; j <= right; j++) {
					list.remove(j);
				}
				
				r -=  right - left;
				
				
				
				
				if (l == 0) {
					output.append("*");
				} else {
					output.append(list.get(l));
				}
				
				
				if (list.get(r) > soldiers) {
					output.append(" *\n");
				} else {
					output.append(" "+list.get(r)+"\n");
				}
					
				
			}
			output.append("-\n");
		}
		System.out.print(output);
	}

}

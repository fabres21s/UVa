import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuffer output = new StringBuffer();
		
		int cards, i, n;
		boolean continuar = true;
		
		List<Integer> listCards = new ArrayList<Integer>();
		while (continuar){
			
			cards = input.nextInt();
			if (cards > 0){
				for ( i = 3; i <= cards; i++) {
					listCards.add(i);
				}
				
				if (cards > 1){
					listCards.add(2);
					output.append("Discarded cards: 1");
				} else {
					output.append("Discarded cards:");
					listCards.add(1);
				}
				while (listCards.size() > 1){
					
					n = listCards.get(0);
					output.append(", "+n);
					listCards.remove(0);
					n = listCards.get(0);
					listCards.remove(0);
					listCards.add(n);
					
				}
				output.append("\nRemaining card: "+listCards.get(0)+"\n");
				
				
				listCards.clear();
			} else {
				continuar = false;
			}
			
			
		}
		System.out.print(output);
		input.close();
	}

}

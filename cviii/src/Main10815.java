import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


public class Main {

	public static void main(String[] args) {
		String text = "fabio ausa 83979	wr.,><>!!3$6ndres Sierra jaraba 1992/03/31";
		
		Scanner input = new Scanner(System.in);
		
		StringBuffer entrada = new StringBuffer();
		while (input.hasNext()){
			text = input.nextLine().toLowerCase();
			entrada.append(text+" ");

		}
		
		text = entrada.toString().replaceAll("[^a-zA-Z\\s]", " ");
		
		SortedSet<String> dictionary = new TreeSet<String>();
		input.close();
		
		input = new Scanner(text);
		while (input.hasNext()){
			dictionary.add(input.next());
		}
		
		for (String palabra : dictionary){
			System.out.println(palabra);
		}
		input.close();
		
		
	}

}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	/*
	 * Validaciones
	 * 
	 * Validar que todos cantaran y no dejar la canción a medias
	 */
	
	public static void main(String[] args) {

		List<String> song = new ArrayList<String>();
		song.add("Happy");
		song.add("birthday");
		song.add("to");
		song.add("you");
		song.add("Happy");
		song.add("birthday");
		song.add("to");
		song.add("you");
		song.add("Happy");
		song.add("birthday");
		song.add("to");
		song.add("Rujia");
		song.add("Happy");
		song.add("birthday");
		song.add("to");
		song.add("you");

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		List<String> persons = new ArrayList<String>();
		while (n-- > 0) {
			persons.add(input.next());
		}
		input.close();

		boolean completedSong = false;
		boolean completedPersons = false;
		n = persons.size();
		int index = 0;
		if (n > 0) {
			while (!completedPersons || !completedSong) {
				try {
					System.out.printf("%s: %s\n", persons.get(index % n), song.get(index % 16));
				} catch (Exception exc){
					//sin este try catch da re - esto est� muy raro - tal vez por el package
				}
				index++;
				if (index >= n) {
					completedPersons = true;
				}

				completedSong = (index % 16 == 0);
				// System.out.println(index % 16 + " "+completedPersons+ " "+
				// completedSong );

			}
		}
	}

}

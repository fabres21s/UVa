import java.util.Scanner;

/**
 * 11988 - Broken KeyBoard (a.k.a Beiju Text)
 * @author fabio
 * No lo entiendo bien, no era esto lo que había que hacer
 *
 */
//TODO No enviado - Broken KeyBoard (a.k.a Beiju Text)
public class Main11988 {

	public static void main(String[] args) {
		String text = "This_is_a_[Beiju]_text";
		Scanner input = new Scanner(System.in);

		while (input.hasNext()) {
			text = input.nextLine();
			System.out.println(text.replaceAll("\\[.*\\]", ""));

		}

		input.close();

	}

}

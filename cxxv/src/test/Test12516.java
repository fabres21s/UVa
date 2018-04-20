package test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Test12516 {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			int rows = getRandom(16);// 26
			int columns = getRandom(16);// 99
			System.out.println(rows + " " + columns);
			int persons = getRandom(rows * columns - 1);
			System.out.println(persons);

			Set<String> ocupados = new HashSet<String>();

			for (int x = 0; x < persons; x++) {
				char letter = (char) (getRandom(rows) + 64);
				int position = getRandom(columns);

				if (ocupados.add(letter + "" + position)) {
					System.out.println(letter + "" + position + " " + (getRandom(1000) % 2 == 0 ? "-" : "+"));
				} else {
					x--;
				}
			}

			int friends = getRandom(rows * columns - persons);
			System.out.println(friends);
			for (int x = 0; x < friends; x++) {
				char letter = (char) (getRandom(rows) + 64);
				int position = getRandom(columns);

				if (ocupados.add(letter + "" + position)) {
					System.out.println(letter + "" + position);
				} else {
					x--;
				}
			}

		}
		System.out.println("0 0");

	}

	private static int getRandom(int size) {
		return new Random().nextInt(size) + 1;
	}

}

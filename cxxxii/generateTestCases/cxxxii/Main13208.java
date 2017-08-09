package cxxxii;

import java.util.Random;

public class Main13208 {
	public static void main(String[] args) {

		int testCases = getRandom(100);
		System.out.println(testCases);
		for (int x = 0; x < testCases; x++) {
			long bottom = getRandom(1000);
			int divisions = getRandom(10);

			System.out.println(bottom + " " + divisions);
			for (int i = 0; i < divisions; i++) {
				System.out.print(getRandom(1000) + " ");
			}
			System.out.println();
			for (int i = 0; i < divisions + 1; i++) {
				System.out.print(getRandom(1000) + " ");
			}
			System.out.println();
		}
	}

	private static int getRandom(int size) {
		return new Random().nextInt(size) + 1;
	}
}

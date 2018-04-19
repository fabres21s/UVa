import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main11039 {

	//TODO Poner información
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		int testCases = Integer.parseInt(br.readLine());
		int floors, index;
		int sizeFloors[];
		while (testCases-- > 0) {

			floors = Integer.parseInt(br.readLine());
			sizeFloors = new int[floors];
			int maxFloors = 0;
			if (floors > 0) {
				for (int i = 0; i < floors; i++) {
					sizeFloors[i] = Integer.parseInt(br.readLine());
				}

				Arrays.sort(sizeFloors);
				index = 0;

				Queue<Integer> queue = new LinkedList<Integer>();
				while (sizeFloors[index] < 0) {
					queue.add(sizeFloors[index]);
					index++;
					if (index == floors) {
						break;
					}
				}

				Queue<Integer> stack = new LinkedList<Integer>();
				index = floors - 1;
				while (sizeFloors[index] > 0) {
					stack.add(sizeFloors[index]);
					index--;
					if (index < 0) {
						break;
					}
				}

				boolean continuar = true;
				maxFloors = 1;
				int maxAbs = Math.max(Math.abs(sizeFloors[0]), sizeFloors[floors - 1]), max = 0;

				if (Math.abs(sizeFloors[0]) > sizeFloors[floors - 1]) {
					max = sizeFloors[0];
				} else {
					max = maxAbs;
				}
				int next = 0;
				while (continuar) {
					continuar = false;
					if (max > 0) {
						while (!queue.isEmpty()) {
							continuar = true;
							next = queue.poll();
							if (maxAbs > Math.abs(next)) {
								maxFloors++;
								max = next;
								maxAbs = Math.abs(next);
								break;
							}
						}
					} else {
						while (!stack.isEmpty()) {
							continuar = true;
							next = stack.poll();
							if (maxAbs > next) {
								maxFloors++;
								maxAbs = max = next;
								break;
							}
						}
					}

				}
			}

			output.append(maxFloors);
			output.append("\n");
		}
		System.out.print(output);

	}

}

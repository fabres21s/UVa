import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
*	119 - Greedy Gift Givers
*
*
*	Submission:	17591578
*	Date:		2016-06-29 02:30:02
*	Runtime:	0.030
*	Ranking:	6030
*/
public class Main119 {

	/*
	 * - Map
	 * - List
	 * 
	 * Dado un grupo de amigos que dan y reciben regalos, determinar la diferencia entre lo que ganan y lo que gastan
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;
		int persons;
		int testCases = 0;
		while ((line = br.readLine()) != null) {

			Map<String, Person> map = new HashMap<String, Person>();
			List<Person> list = new ArrayList<Person>();
			persons = Integer.parseInt(line);
			if (testCases > 0) {
				System.out.println();
			}
			testCases++;
			args = br.readLine().split(" ");
			for (int i = 0; i < persons; i++) {
				Person person = new Person(args[i], i);
				map.put(person.getName(), person);
				list.add(person);
			}

			for (int i = 0; i < persons; i++) {
				args = br.readLine().split(" ");
				Person person = map.get(args[0]);
				int gasto = Integer.parseInt(args[1]);
				int qty = Integer.parseInt(args[2]);
				if (qty > 0) {
					person.setGive(person.getGive() + (gasto / qty) * qty);
				}
				for (int j = 0; j < qty; j++) {
					Person personReceive = map.get(args[j + 3]);
					personReceive.setReceive(personReceive.getReceive() + gasto / qty);
				}
			}

			for (Person person : list) {
				System.out.println(person);
			}

		}
	}

}

class Person {
	private String name;
	private int give;
	private int receive;
	private int order;

	public Person(String name, int order) {
		this.name = name;
		this.give = 0;
		this.receive = 0;
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGive() {
		return give;
	}

	public void setGive(int give) {
		this.give = give;
	}

	public int getReceive() {
		return receive;
	}

	public void setReceive(int receive) {
		this.receive = receive;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return this.name + " " + (this.receive - this.give);
	}
}

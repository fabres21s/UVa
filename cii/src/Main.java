import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Map<Integer, Team> map = new HashMap<Integer, Team>();
		List<Team> teams = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		int testCases = Integer.parseInt(input.nextLine());
		String line = input.nextLine();
		int numberTeam;
		while (input.hasNext()) {

			line = input.nextLine();

			if (line.compareTo("") == 0) {

				printResult(teams);
				System.out.println();
				teams.clear();
				map.clear();
				continue;
			}

			args = line.split(" ");
			numberTeam = Integer.parseInt(args[0]);

			Team team = map.get(numberTeam);

			if (team == null) {
				team = new Team(numberTeam);
				teams.add(team);
				map.put(numberTeam, team);
			}

			if (args[3].equals("I")) {
				if (!team.getSolvedProblems().contains(Integer.valueOf(args[1]))) {
					team.getIncorrectSubmissions().add(Integer.valueOf(args[1]));
				}
			} else if (args[3].equals("C")) {
				if (team.getSolvedProblems().add(Integer.valueOf(args[1]))) {
					team.setTime(team.getTime() + Integer.valueOf(args[2]));
				}
			}

		}

	}

	private static void printResult(List<Team> teams) {
		for (Team team : teams) {
			team.calculatePenalty();
		}

		Collections.sort(teams, new Comparator<Team>() {

			@Override
			public int compare(Team o1, Team o2) {
				int compare = o2.getSolvedProblems().size() - o1.getSolvedProblems().size();
				if (compare == 0) {

					compare = o1.getTime() - o2.getTime();

					if (compare == 0) {
						return o1.getNumber() - o2.getNumber();
					}

					return compare;

				}

				return compare;
			}
		});
		for (Team team : teams) {
			System.out.println(team);
		}

	}

}

class Team {
	private int number;
	private Set<Integer> solvedProblems;
	private List<Integer> incorrectSubmissions;
	private int time;

	public Team(int number) {
		this.number = number;
		this.solvedProblems = new HashSet<Integer>();
		this.time = 0;
		this.incorrectSubmissions = new ArrayList<>();
	}

	public void calculatePenalty() {
		for (Integer i : incorrectSubmissions) {
			if (solvedProblems.contains(i)) {
				this.time += 20;
			}
		}
	}

	@Override
	public String toString() {
		return this.number + " " + this.solvedProblems.size() + " " + this.time;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Set<Integer> getSolvedProblems() {
		return solvedProblems;
	}

	public void setSolvedProblems(Set<Integer> solvedProblems) {
		this.solvedProblems = solvedProblems;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public List<Integer> getIncorrectSubmissions() {
		return incorrectSubmissions;
	}

	public void setIncorrectSubmissions(List<Integer> incorrectSubmissions) {
		this.incorrectSubmissions = incorrectSubmissions;
	}
}

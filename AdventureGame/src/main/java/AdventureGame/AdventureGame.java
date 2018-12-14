package AdventureGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdventureGame {
	private float curNS = 25;
	private float curEW = 25;
	private List<FeatureOfInterest> features = new ArrayList<>();

	public List<FeatureOfInterest> addFeature(FeatureOfInterest a) {
		features.add(a);
		return features;
	}

	public List<FeatureOfInterest> removeFeature(FeatureOfInterest a) {
		features.remove(a);
		return features;
	}

	public String play(FeatureOfInterest goal) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String input = "";

		System.out.print("You wake up suddenly in a large grey swamp. "
				+ "\nAround you there are few distinguising features other than the fact it is large and dreary. "
				+ "\nBefore you on the ground is a watch." + "\nYou pick it up and on the screen it reads: "
				+ findDist() + "m. " + "\nYou must decide which way to go, 'NORTH', 'SOUTH', 'EAST' or 'WEST'. \n");

		while (!input.toUpperCase().equals("END") && goal(goal) == false) {
			System.out.print(">");
			input = sc.next();

			if (input.toUpperCase().equals("END"))
				return "Ended";

			if (move(input.toUpperCase()) == false)
				continue;

			System.out.println("You travel further " + input.toLowerCase() + ".");

			features.stream().filter(n -> n.getLocNS() == curNS && n.getLocEW() == curEW)
					.forEach(s -> System.out.println("You have found a " + s.getName() + ".\n" + s.getDescription()));

			if (goal(goal) != true)
				System.out.println("The watch reads: " + findDist() + "m");
		}

		return "CONGRATULATIONS, CHRISTMAS IS SAVED!!!";
	}

	private float findDist() {
		float lowDist = 1000000;
		for (FeatureOfInterest i : features) {
			if (i.pythagDist(curNS, curEW) < lowDist) {
				lowDist = i.pythagDist(curNS, curEW);
			}
		}
		return lowDist;
	}

	private boolean goal(FeatureOfInterest goal) {
		for (FeatureOfInterest i : features) {
			if (curNS == i.getLocNS() && curEW == i.getLocEW())
				if (i.equals(goal))
					return true;
		}
		return false;
	}

	private boolean move(String dir) {
		if (dir.equals("NORTH") || dir.equals("SOUTH") || dir.equals("EAST") || dir.equals("WEST")) {
			if (dir.equals("NORTH"))
				curNS++;
			else if (dir.equals("SOUTH"))
				curNS--;
			else if (dir.equals("EAST"))
				curEW++;
			else if (dir.equals("WEST"))
				curEW--;
			return true;
		}
		System.out.println("Invalid Input");
		return false;
	}
}

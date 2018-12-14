package AdventureGame;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdventureGame game = new AdventureGame();
		FeatureOfInterest goal = new FeatureOfInterest("Huge Sack","It's a treasure trove of christmas presents.",51,51);
		FeatureOfInterest sleigh = new FeatureOfInterest("Crashed Sleigh","It's a crashed sleigh.");
		FeatureOfInterest tree = new FeatureOfInterest("Decorated Tree","It's a tree covered in lights and baubles.");
		FeatureOfInterest rHat = new FeatureOfInterest("Red Hat","It's a strange red hat with a fluffy bobble on the end.");
		game.addFeature(goal);
		game.addFeature(sleigh);
		game.addFeature(tree);
		game.addFeature(rHat);
		
		System.out.println(game.play());
	}

}

package AdventureGame;

public class FeatureOfInterest {
	private String name;
	private String description;
	private int locNS;
	private int locEW;

	public FeatureOfInterest(String name, String description, int locNS, int locEW) {
		this.name = name;
		this.description = description;
		this.locNS = locNS;
		this.locEW = locEW;
	}

	public FeatureOfInterest(String name, String description) {
		this.name = name;
		this.description = description;
		this.locNS = (int) (Math.random() * 50);
		this.locEW = (int) (Math.random() * 50);

	}

	public FeatureOfInterest() {

	}

	public float pythagDist(float currentNS, float currentEW) {
			float distNS = locNS - currentNS;
			float distEW = locEW - currentEW;
			//testing line
			//System.out.println(name + " - " + locNS +"NS/" + locEW +"EW - " + (int) Math.sqrt(((distNS * distNS) + (distEW * distEW))) + "m away");
			return (float) Math.sqrt(((distNS * distNS) + (distEW * distEW)));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getLocNS() {
		return locNS;
	}

	public void setLocNS(int locNS) {
		this.locNS = locNS;
	}

	public float getLocEW() {
		return locEW;
	}

	public void setLocEW(int locEW) {
		this.locEW = locEW;
	}

}

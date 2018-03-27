
public class impToMet {

	public double milesToKilom(double distance) {
		return distance * 1.60934;
	}
	
	public double yardToMetre(double distance) {
		return distance * 0.9144;
	}

	public double feetToMetres(double distance) {
		return distance * 0.3048;
	}
	public double poundsToKilog(double weight) {
		return weight * 0.453592;
	}
	public double tonToTonne(double weight) {
		return weight * 0.907185;
	}
	public double feetAndInchToCent(String distance) {
		String[] split = distance.split("\\s+");
		double feet = Double.parseDouble(split[0]);
		double inches = Double.parseDouble(split[1]);
		inches = feet * 12 + inches;
		inches = inches * 2.54;
		return  inches;
	}
	
	public double ozToMl(double volume) {
		return volume * 29.5735;
	}
	public double farenToCel(double temp) {
		return ((temp - 32) * (5/9));
	}
	
	public double gallonToLitre(double volume ) {
		return volume *3.78541;
	}
	public double inchToCent(double distance) {
		return distance * 2.54;
	}
	public double pintToLitre(double volume) {
		return volume *473.176;
	}
}

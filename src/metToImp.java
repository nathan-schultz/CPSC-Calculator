
public class metToImp {

	public double kilomToMiles(double distance) {
		return distance * 0.621371;
	}
	
	public double metresToYard(double distance) {
		return distance * 1.09361;
	}
	
	public double metresToFeet(double distance) {
		return distance * 3.28084;
	}
	
	public double kilogToPounds(double weight) {
		return weight * 2.20462;
	}
	
	public double tonneToTon(double weight) {
		return weight * 1.10231;
	}
	public String centToFeetandInche(double distance) {
		distance = distance / 2.54;
		int feet = (int)distance / 12;
		int inches = (int)distance % 12; 
		String answer = (feet +" foot " + inches + " inches");
		return answer;
	}
	
	public double mlToOz(double volume) {
		return volume * 0.033814;
	}
	
	public double celToFaren(double temp) {
		return (temp * 9/5 + 32);
	}
	
	public double litreToGallon(double volume) {
		return volume* 0.264172;
	}
	
	public double centToInch(double distance) {
		return distance * 0.393701;
	}
	
	public double litreToPint(double volume) {
		return volume * 2.11338;
	}
}

import java.util.*;
import java.lang.Math;

public class StatisticsLogic{
	// mean[x], median[x], standard deviation, maximum[x], minimum[x], quartile 1 [x], quartile 3 [x]
	private String independantVar;
	private String dependantVar;
	private ArrayList<Double> list1 = new ArrayList<Double>();
	private ArrayList<Double> list2 = new ArrayList<Double>();

	/**
	 * Method that is used to identify variables and what they represent
	 */
	public void variableInput(){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter your Independant Variable name:");
		independantVar = keyboard.nextLine();
		System.out.println("Please enter your Dependant Variable:");
		dependantVar = keyboard.nextLine();
	}

	public ArrayList<Double> getList1() {
		return list1;
	}

	/**
	 * Method used for receiving the independent variable and storing them in an ArrayList
	 */
	public void valueIndependantInput(){
		System.out.println("Enter your Independant Variable values separating them with spaces. When finished hit enter");
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		List<String> Varlist1 = new ArrayList<String>(Arrays.asList(input.split("\\s+")));
		for (String s: Varlist1) {
			double newVal = Double.valueOf(s);
			list1.add(newVal);
		}
	}

	/**
	 * Method used for receiving the dependent variables and storing them in an ArrayList
	 */
	public void valueDependantInput(){
		System.out.println("Enter your Dependant Variable values separating them with spaces. When finished hit enter");
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		List<String> Varlist2 = new ArrayList<String>(Arrays.asList(input.split("\\s+")));
		for (String s: Varlist2) {
			double newVal = Double.valueOf(s);
			list2.add(newVal);
		}
		System.out.println(list2);
	}

	/** Method used for calculating the mean of the list given
	 * @param list of type ArrayList<Double>
	 * @return a double of the mean of the list
	 */
	public String calculateMean(ArrayList<Double> list) {
		double mean = 0;
		for (double d: list) {
			mean += d;
		}
		mean = mean/list.size();
		return ("The mean is: " + mean);	
	}

	/** Method used for calculating the Median, Quartile1 and Quartile3 of the list given
	 * @param list of type ArrayList<Double>
	 * @return a String of the values of median, Q1 and Q3
	 */
	public String calculateMedian(ArrayList<Double> list) {
		list.sort(Comparator.naturalOrder());
		System.out.println(list);
		double mid=0;
		double q1=0;
		double q3=0;
		int lq = list.size() * 1/4;
		int uq = list.size() * 3/4;
		// even size lists
		if (list.size() % 2 == 0) {
			mid = ((list.get(list.size()/2-1) + list.get((list.size()/2)) )/2);
			// if half of the list is odd
			if ((list.size()/2) %2 == 1) {
				q1 = list.get(lq);
				q3 = list.get(uq);
				// if half of the list is even	
			} else if ((list.size()/2) % 2 == 0 ) {
				q1 = ((list.get((lq)) + list.get((lq)-1) ) /2 );
				q3 = ((list.get((uq)) + list.get((uq)-1) ) /2 );
			}
			// odd size lists	
		} else if (list.size() % 2 == 1) {
			mid = list.get(list.size()/2);
			// if half of the list is odd
			if ((list.size()-1)/2 %2 == 1) {
				q1 = list.get(lq); 
				q3 = list.get(uq); 
			// if half of the list is even
			} else if ((list.size()-1)/2 %2 == 0) {
				q1 = ((list.get(lq) + (list.get(lq-1))) / 2);
				q3 = ((list.get(uq) + (list.get(uq+1))) / 2);
			}
		}
		return ("The median is: " + mid + "\nThe Q1 is: " + q1 + "\nThe Q3 is: " + q3);
	}

	/** Method used for calculating the maximum and minimum values of the list given
	 * @param list of type ArrayList<Double>
	 * @return a String of the minimum and maximum values
	 */
	public String calculateMaxMin(ArrayList<Double> list) {
		list.sort(Comparator.naturalOrder());
		double min = list.get(0);
		double max = list.get(list.size()-1);
		return ("The minimum is: " + min + " and the maximum is: " + max + "\nThe size of the list is: " + list.size());
	}

	public String calculateStandDev(ArrayList<Double> list) {
		double sumOne = 0.0;
		double sumTwo = 0.0;
		double stdev = 0.0;
		for (int i=0; i < list1.size(); i++) 
		{
			sumOne += list.get(i);
			//			System.out.println(list.get(i));
		}
		sumOne = (sumOne/list.size());
		for (int i=0; i < list.size(); i++) 
		{
			sumTwo += Math.pow(list.get(i) - sumOne, 2);
			//			System.out.println(list.get(i));
		}
		stdev = Math.sqrt(sumTwo/list.size());
		return ("The standard deviation is: " + stdev);
	}



}

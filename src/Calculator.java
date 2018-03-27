import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
	// still add conversions (metric to imperial[x], distances[x], temperatures[x] (C, F, K) etc, weight[x], monetary(?) ) 
	// ask for math or conversions then go to either one
	private MathFunctions mf = new MathFunctions();
	private metToImp mi = new metToImp();
	private impToMet im = new impToMet();
	private StatisticsLogic sl = new StatisticsLogic();
	Scanner keyboard = new Scanner(System.in);
	private boolean isRunning = true;
	private double distance;


	public void mathFuncs() {
		char end = 'k';
		char ans = 'k';
		double num1 = 0.0;
		double solved = 0.0;
		while (end != 'q') {
			int valid = 0;
			if (solved == 0.0) {
			System.out.println("Enter the number you would like ");
			Scanner nums = new Scanner(System.in);
			num1 = nums.nextDouble();
			} else {
			System.out.println("The answer is "+ solved);
			}
			while (valid < 1) {
			System.out.println("Would you like to Add (1) Subtract (2) Multiply (3) Divide (4)? To clear answer (C) or Quit (Q)");	
			Scanner reader = new Scanner(System.in);
			ans = reader.next().charAt(0);
			ans = Character.toUpperCase(ans);
			if (ans == '1' || ans == '2' || ans == '3' || ans == '4' || ans == 'Q' || ans == 'C') {
				valid = 1;
			}else{
				System.out.println("Sorry that is not valid input");
				valid = 0;
			}
			}
			if (ans == 'C'){
			solved = 0.0;
			}
			if(ans == '1') {
			if (solved == 0.0) {
				System.out.println("Enter the number you want to add");
				Scanner nums = new Scanner(System.in);
				double num2 = nums.nextDouble();
				solved = mf.add(num1, num2);
				System.out.println(solved);
				} else {
				System.out.println("Enter the number you want to add");
				Scanner nums = new Scanner(System.in);
				double num2 = nums.nextDouble();
				solved = mf.add(num2, solved);
				}
			} else if (ans == '2') {
			if (solved == 0.0) {
				System.out.println("Enter the number you want to subtract");
					Scanner nums = new Scanner(System.in);
					double num2 = nums.nextDouble();
					solved = mf.subt(num1, num2);
					System.out.println(solved);
					} else {
					System.out.println("Enter the number you want to subtract");
					Scanner nums = new Scanner(System.in);
					double num2 = nums.nextDouble();
					solved = mf.subt(solved,num2);
					}
			} else if (ans == '3') {
			if (solved == 0.0) {
				System.out.println("Enter the number you want to multiply");
					Scanner nums = new Scanner(System.in);
					double num2 = nums.nextDouble();
					solved = mf.mult(num1, num2);
					System.out.println(solved);
					} else {
					System.out.println("Enter the number you want to multiply");
					Scanner nums = new Scanner(System.in);
					double num2 = nums.nextDouble();
					solved = mf.mult(solved,num2);
					}
			} else if (ans == '4') {
				if (solved == 0.0) {
				System.out.println("Enter the number you want to divide");
				Scanner nums = new Scanner(System.in);
				double num2 = nums.nextDouble();
				solved = mf.divide(num1, num2);
				System.out.println(solved);
				} else {
					System.out.println("Enter the number you want to divide");
					Scanner nums = new Scanner(System.in);
					double num2 = nums.nextDouble();
					solved = mf.divide(solved,num2);
				}
			} else if (ans == 'Q') {
			end = 'q';
			}
				
			}
		
		run();
		
	}
	
	public void conversionFuncs() {
		System.out.println("Would you like to convert Metric --> Imperial (1) or Imperial --> Metric (2)? or quit (0)");
		int secondChoice = keyboard.nextInt();
		if (secondChoice == 1) {
			m2i();
		} else if (secondChoice == 2) {
			i2m();
		} else if (secondChoice == 0) {
			isRunning = false;
		} else {
			System.out.println("Please enter either (1) or (2)");
		}
	}

	public void m2i() {
		System.out.println("Please choose from the following: \n(1): Kilometers to Miles\n(2): Metres to Yards\n(3): Metres to Feet\n(4): Kilograms to Pounds\n(5): Tonnes to Tons\n(6): Centimeters to Feet and Inches\n(7): Millileters to Ounces\n(8): Celcius to Farenheit\n(9): Litres to Gallons\n(10): Centimetres to Inches\n(11): Litres to Pints");
		int choice = keyboard.nextInt();
		switch (choice) {
		case 1: System.out.println("Please enter the number you want to convert");
				distance = keyboard.nextDouble();
				distance = mi.kilomToMiles(distance);
				System.out.println(distance + " miles");
				break;
		case 2: System.out.println("Please enter the number you want to convert");
				distance = keyboard.nextDouble();
				distance = mi.metresToYard(distance);
				System.out.println(distance + " yards");
				break;
		case 3: System.out.println("Please enter the number you want to convert");
				distance = keyboard.nextDouble();
				distance = mi.metresToFeet(distance);
				System.out.println(distance + " feet");
				break;
		case 4: System.out.println("Please enter the number you want to convert");
				distance = keyboard.nextDouble();
				distance = mi.kilogToPounds(distance);
				System.out.println(distance + " pounds");
				break;
		case 5: System.out.println("Please enter the number you want to convert");
				distance = keyboard.nextDouble();
				distance = mi.tonneToTon(distance);
				System.out.println(distance + " tons");
				break;
		case 6: System.out.println("Please enter the number you want to convert");
				distance = keyboard.nextDouble();
				String solved = mi.centToFeetandInche(distance);
				System.out.println(solved);
				break;
		case 7: System.out.println("Please enter the number you want to convert");
				distance = keyboard.nextDouble();
				distance = mi.mlToOz(distance);
				System.out.println(distance + " ounces");
				break;
		case 8: System.out.println("Please enter the number you want to convert");
				distance = keyboard.nextDouble();
				distance = mi.celToFaren(distance);
				System.out.println(distance + " degrees Farenheit");
				break;
		case 9: System.out.println("Please enter the number you want to convert");
				distance = keyboard.nextDouble();
				distance = mi.litreToGallon(distance);
				System.out.println(distance + " gallons");
				break;
		case 10: System.out.println("Please enter the number you want to convert");
				distance = keyboard.nextDouble();
				distance = mi.centToInch(distance);
				System.out.println(distance + " inches");
				break;
		case 11: System.out.println("Please enter the number you want to convert");
				distance = keyboard.nextDouble();
				distance = mi.litreToPint(distance);
				System.out.println(distance + " pints");
				break;
		}
		
	}
	
	public void i2m() {
		System.out.println("Please choose from the following: \n(1): Miles to Kilometers\n(2): Yards to Metres\n(3): Feet to Metres\n(4): Pounds to Kilograms\n(5): Tons to Tonnes\n(6): Feet and Inches to Centimeters\n(7): Ounces to Millileters\n(8): Farenheit to Celcius\n(9): Gallons to Litres\n(10): Inches to Centimetres\n(11): Pints to Litres");
		int choice = keyboard.nextInt();
		switch (choice) {
		case 1: System.out.println("Please enter the number you want to convert");
				distance = keyboard.nextDouble();
				distance = im.milesToKilom(distance);
				System.out.println(distance + " kilometers");
				break;
		case 2: System.out.println("Please enter the number you want to convert");
				distance = keyboard.nextDouble();
				distance = im.yardToMetre(distance);
				System.out.println(distance + " metres");
				break;
		case 3: System.out.println("Please enter the number you want to convert");
				distance = keyboard.nextDouble();
				distance = im.feetToMetres(distance);
				System.out.println(distance + " metres");
				break;
		case 4: System.out.println("Please enter the number you want to convert");
				distance = keyboard.nextDouble();
				distance = im.poundsToKilog(distance);
				System.out.println(distance + " kilograms");
				break;
		case 5: System.out.println("Please enter the number you want to convert");
				distance = keyboard.nextDouble();
				distance = im.tonToTonne(distance);
				System.out.println(distance + " tonnes");
				break;
		case 6: System.out.println("Please enter the number you want to convert");
				String solved = keyboard.nextLine();
				distance = im.feetAndInchToCent(solved);
				System.out.println(distance + " centimetres");
				break;
		case 7: System.out.println("Please enter the number you want to convert");
				distance = keyboard.nextDouble();
				distance = im.ozToMl(distance);
				System.out.println(distance + " millilitres");
				break;
		case 8: System.out.println("Please enter the number you want to convert");
				distance = keyboard.nextDouble();
				distance = im.farenToCel(distance);
				System.out.println(distance + " degrees celcius");
				break;
		case 9: System.out.println("Please enter the number you want to convert");
				distance = keyboard.nextDouble();
				distance = im.gallonToLitre(distance);
				System.out.println(distance + " litres");
				break;
		case 10: System.out.println("Please enter the number you want to convert");
				distance = keyboard.nextDouble();
				distance = im.inchToCent(distance);
				System.out.println(distance + " centimetres");
				break;
		case 11: System.out.println("Please enter the number you want to convert");
				distance = keyboard.nextDouble();
				distance = im.pintToLitre(distance);
				System.out.println(distance + " litres");
				break;
		}
	}
	
	public void stats() {
		ArrayList<Double> list1 =  sl.getList1();
		sl.valueIndependantInput();
		System.out.println(sl.calculateMean(list1));
		//System.out.println(sl.calculateMedian(list1));
		System.out.println(sl.calculateMaxMin(list1));
		System.out.println(sl.calculateStandDev(list1));
	}
	
	public void run() {
		while (isRunning) {
			System.out.println("Would you like to use the calculator (1) or converter (2) or statistics calculator (3) or quit (0)");
			int choice = keyboard.nextInt();
			if (choice == 1) {
				mathFuncs();
			} else if (choice == 2) {
				conversionFuncs();
			} else if (choice == 3) {
				stats();
			} else if (choice == 0) {
				isRunning = false;
			}

		}
	}
}

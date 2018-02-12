import java.util.Date;
import java.util.Scanner;

public class App {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		final int EXIT = 0;
		int answer;
		Company theCompany = new Company();
	
		do {

			System.out.println();
			System.out.println("Choose one of the following options:\n");
			System.out.println("(1)  Add bus");
			System.out.println("(2)  Clear bus");
			System.out.println("(3)  Add line");
			System.out.println("(4)  Change line");
			System.out.println("(5)  Show all lines and Busses.");
			System.out.println("(" + EXIT + ")  to exit");
			System.out.println("Enter your choice -->  ");
		
			answer = s.nextInt();

			switch (answer) {
				case 1:
					addBussesToCompany(theCompany);
					break;
				case 2:
					clearBusses(theCompany);
					break;
				case 3:
					addLinesToCompany(theCompany);
					break;
				case 4:
					changeLines(theCompany);
					break;
				case 5:
					System.out.println(theCompany.toString());
					break;
				default:
					System.out.println("wrong key");
					break;
			}

		} while (answer != EXIT);
	}


	private static void addBussesToCompany(Company theCompany) {
		bus theBus = new bus(0 , 0);
		int licensePlate = 0, numOfSeats = 0;

		theBus.setLicensePlate(licensePlate);
		theBus.setNumOfSeats(numOfSeats);
		
	    theCompany.addBus(theBus);
	    System.out.print("New bus:");
	    System.out.println(theBus.toString());
	
	}

	private static void clearBusses(Company theCompany) {
		int licensePlateToClear;
		
		System.out.println("Enter license plate of the bus you want to clear:");
		licensePlateToClear = s.nextInt();
		
		bus theBus = theCompany.getBusByLicensePlate(licensePlateToClear);
		if (theBus == null) {
			System.out.println("There is no bus with that license plate in you'r data.");
		return;
		}
		else {
			theBus = null;
			System.out.println("Bus number " + licensePlateToClear + " has been cleared from data.");
		}
		
	}

	private static void addLinesToCompany(Company theCompany) {
		Line theLine = new Line(null , null , null , null , null);
		String origin, destination, costumer;
	    Date date1 = null;
		bus theBus = new bus(0 , 0);
		theBus = null;
		
		s.nextLine();
		System.out.println("Enter name of costumer:");
		costumer = s.nextLine();
		theLine.setCostumer(costumer);

		System.out.println("Enter line origin:");	
		origin = s.nextLine();
		theLine.setOrigin(origin);
		
		System.out.println("Enter line destination:");
		destination = s.nextLine();
		theLine.setDestination(destination);
		
		theLine.setDate(date1);

		int licensePlateToAdd;

		while(theBus == null) {
			System.out.println("Enter license plate of the bus:");
			licensePlateToAdd = s.nextInt();
		
			theBus = theCompany.getBusByLicensePlate(licensePlateToAdd);
			if (theBus == null) {
				System.out.println("There is no bus with that license plate in you'r data.");
				theLine = null;
			return;
			}
			else {
				theLine.setBus(theBus);
			}
		}
		theCompany.addLine(theLine);
		
		System.out.println("New line:");
		System.out.println(theLine.toString());

		
	}

	private static void changeLines(Company theCompany) {
		String origin, destination, costumer;
	    Date date1 = null;		
		bus theBus = new bus(0 , 0);
		int licensePlateToChange;
		
		System.out.println("Search line by costumer name:");
		costumer = s.next();
		Line theLine = theCompany.getLineByCostumer(costumer);
		
		if (theLine == null) {
			System.out.println("There is no line for that customer.");
			return;
		}
		int answer1;
		System.out.println(theLine.toString());
		System.out.println();
		System.out.println("Choose what detail to change:");
		System.out.println("(1)  Origin");
		System.out.println("(2)  Destination");
		System.out.println("(3)  Date");
		System.out.println("(4)  Bus ");
		System.out.println("(0)  Clear line");
		
		answer1 = s.nextInt();
		
		switch (answer1) {
		
		case 1:
				System.out.println("Enter new origin:");
				s.nextLine();
				origin = s.nextLine();
				theLine.setOrigin(origin);
				break;
		
			case 2:
				System.out.println("Enter new destination:");
				s.nextLine();
				destination = s.nextLine();
				theLine.setDestination(destination);
				break;
		
			case 3:
				theLine.setDate(null);
				System.out.println("Enter new Date:");
				theLine.setDate(date1);
				break;
				
		
			case 4:
				theBus = null;
				while(theBus == null) {
					System.out.println("Enter new bus plate:");
					licensePlateToChange = s.nextInt();
				
					theBus = theCompany.getBusByLicensePlate(licensePlateToChange);
					if (theBus == null) {
						System.out.println("There is no bus with that license plate in you'r data."
								+ "\nPlease enter again or enter old one:");	
					}
					else {
						theLine.setBus(theBus);
					}
				}
				break;
		
			case 0:
				theLine = null;
				System.out.println("Line cleared from data.");
				break;
		
			default:
				System.out.println("Wrong key");
				break;
		}	
		if (theLine != null) {
			System.out.println("After change:");
			System.out.println(theLine.toString());
		}
	}
}

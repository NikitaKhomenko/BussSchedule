import java.util.Scanner;

public class bus {
	private static Scanner s = new Scanner(System.in);
	private int licensePlate, numOfSeats;
	
	public bus (int licensePlate, int numOfSeats) {

	}
	
	public bus(bus other) {
		this(other.licensePlate, other.numOfSeats);
	}

	
	public void setNumOfSeats(int numOfSeats) {
		System.out.println("Enter num of seats on bus:");
		numOfSeats = s.nextInt();
		this.numOfSeats = numOfSeats;
	}
	
	public void setLicensePlate(int licensePlate) {
		
		System.out.println("Enter bus license plate (8 digits):");
		licensePlate = s.nextInt();
		
		while(String.valueOf(licensePlate).length() != 8) {	
				System.out.println("License plate number is invaild, please enter again:");
				licensePlate = s.nextInt();
		}
		this.licensePlate = licensePlate;
	}
	
	public int getNumOfSeats() {
		return numOfSeats;
	}
	
	public int getLicensePlate() {
		return licensePlate;
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer ("\nLicense plate: " + licensePlate + "\nSeats number: " + numOfSeats);
		return str.toString();
	}


}




public class Company {
	private bus[] allBusses;
	private int numOfBusses;
	private Line[] allLines;
	private int numOfLines;
	private static final int ALL_BUSSES_NUM  = 100;
	private static final int ALL_LINES_NUM  = 50;

	public Company() {
		allBusses = new bus[ALL_BUSSES_NUM];
		numOfBusses = 0;
		
		allLines = new Line[ALL_LINES_NUM];
		numOfLines = 0;	
	}
	
	public Line getLineByCostumer(String costumer) {
		for (int i = 0; i <  numOfLines; i++) {
			if (allLines[i].getCostumer().equals(costumer))
				return allLines[i];
		}
		return null;
	}
	
	public bus getBusByLicensePlate(int licensePlate) {
		for (int i = 0; i < numOfBusses; i++) {
			if (allBusses[i].getLicensePlate() == licensePlate)   
				return allBusses[i];
		}
		return null;
	}
	
	public void addBus(bus theBus) {
		if (numOfBusses == allBusses.length)
			System.out.println("You have reached already full capacity - 100 busses. ");
		else {
			allBusses[numOfBusses++] = theBus;		
		}
	}
	
	public void addLine(Line theLine) {
		if (numOfLines == allLines.length)
			System.out.println("You have reached already full capacity - 50 lines. ");
		else {
			allLines[numOfLines++] = theLine;

		}
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Busses in possession: " + numOfBusses + "\nNum of orders: " + numOfLines + "\n\n");
		for (int i = 0; i < numOfBusses ; i++ ) {
			str.append((i+1) + "- " + allBusses[i].toString() + "\n");
		}
		for (int i = 0; i < numOfLines ; i++ ) {
			str.append((i+1) + "- " + allLines[i].toString() + "\n");
		}
		return str.toString();
		
	}
	

}

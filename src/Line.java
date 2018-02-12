import java.util.Scanner;
import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Line {
	private String origin, destination, costumer;
	private Date date;
	private bus B;
	
	public Line (String costumer, String origin, String destination, bus B, Date date) {
		setCostumer(costumer);
		setOrigin(origin);
		setDestination(destination);
		setBus(B);
		setDate(date);
	}
	
	public Line(Line other) {
		this(other.costumer, other.origin, other.destination, other.B, other.date);
	}

	public void setCostumer(String costumer) {
		this.costumer = costumer;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public void setBus(bus theBus) {
		B = theBus;
	}
	
	public void setDate(Date date) {
		if (date == null) {
			Scanner s = new Scanner(System.in);
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.US);
			System.out.println("Enter date and time in the format yyyy-MM-ddTHH:mm");
			System.out.println("For example, it is now " + format.format(new Date()));
			while (date == null) {
	    		String line = s.nextLine();
	    		try {
	    			date = format.parse(line);
	    		} catch (ParseException e) {
	    			System.out.println("Sorry, that's not valid. Please try again.");
	    		}
			}
		}
	}

	public String getCostumer() {
		return costumer;
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer ("\nReservation details:" + "\nCostumer: " + costumer + "\nDate: " +
				date + "\nfrom: " + origin + "\nTo: " + destination + "\nBus: " + B.getLicensePlate());
		return str.toString();
	}

}

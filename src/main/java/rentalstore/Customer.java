package rentalstore;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg){
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement(){
        Enumeration rentals = this.rentals.elements();
        String result = getHeaderString();
        while(rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();

            result += getEachRentalString(each);
        }

        result += getFooterString();
        return result;
    }

    private String getFooterString() {
        return "Amount owed is " + String.valueOf(this.getTotalAmount()) + "\n" + "You earned " + String.valueOf(this.getTotalFrequentRenterPoints()) + " frequent renter points";
    }

    private String getEachRentalString(Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getAmount()) + "\n";
    }

    private String getHeaderString() {
        return "Rental Record for " + getName() + "\n";
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            totalAmount += each.getAmount();
        }
        return totalAmount;
    }

    private int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }
}

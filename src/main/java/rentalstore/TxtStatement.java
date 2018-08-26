package rentalstore;

import java.util.Enumeration;

public class TxtStatement {
    public String value(Customer customer){
        Enumeration rentals = customer.getRentals().elements();
        String result = getHeaderString(customer);
        while(rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();

            result += getEachRentalString(each);
        }

        result += getFooterString(customer);
        return result;
    }

    private String getFooterString(Customer customer) {
        return "Amount owed is " + String.valueOf(customer.getTotalAmount()) + "\n" + "You earned " + String.valueOf(customer.getTotalFrequentRenterPoints()) + " frequent renter points";
    }

    private String getEachRentalString(Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getAmount()) + "\n";
    }

    private String getHeaderString(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }
}

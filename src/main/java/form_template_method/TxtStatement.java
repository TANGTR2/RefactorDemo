package form_template_method;

import java.util.Enumeration;

public class TxtStatement extends Statement {

    protected String getFooterString(Customer customer) {
        return "Amount owed is "
                + String.valueOf(customer.getTotalCharge()) + "\n"
                + "You earned "
                + String.valueOf(customer.getTotalFrequentRenterPoints())
                + " frequent renter points";
    }

    protected String getEachRentalString(Rental each) {
        return "\t"
                + each.getMovie().getTitle() + "\t"
                + String.valueOf(each.getCharge())
                + "\n";
    }

    protected String getHeaderString(Customer customer) {
        return "Rental Record for "
                + customer.getName() + "\n";
    }
}

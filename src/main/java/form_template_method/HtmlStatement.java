package form_template_method;

import java.util.Enumeration;

public class HtmlStatement {

    private String getFooterString(Customer customer) {
        return "<P>You owe<EM>"
                + String.valueOf(customer.getTotalCharge())
                + "</EM><P>\n"
                + "On this rental you earned <EM>"
                + String.valueOf(customer.getTotalFrequentRenterPoints())
                + "</EM> frequent renter points<P>";
    }

    private String getEachRentalString(Rental each) {
        return each.getMovie().getTitle()
                + ": "
                + String.valueOf(each.getCharge())
                + "<BR>\n";
    }

    private String getHeaderString(Customer customer) {
        return "<H1>Rentals for <EM>"
                + customer.getName()
                + "</EM></H1><P>\n";
    }
}

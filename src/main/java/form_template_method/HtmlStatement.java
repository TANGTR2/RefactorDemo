package form_template_method;

import java.util.Enumeration;

public class HtmlStatement {
    public String value(Customer customer) {
        Enumeration rentals = customer.getRentals().elements();
        String result = getHeaderString(customer);
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += getEachRentalString(each);
        }
        //add footer lines
        result += getFooterString(customer);
        return result;
    }

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

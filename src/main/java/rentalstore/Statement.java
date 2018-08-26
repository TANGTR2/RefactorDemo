package rentalstore;

import java.util.Enumeration;

public abstract class Statement {
    public String value(Customer customer) {
        Enumeration rentals = customer.getRentals().elements();
        String result = getHeaderString(customer);
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += getEachRentalString(each);
        }
        result += getFooterString(customer);
        return result;
    }

    protected abstract String getFooterString(Customer customer);

    protected abstract String getEachRentalString(Rental each);

    protected abstract String getHeaderString(Customer customer);
}

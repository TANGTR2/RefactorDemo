package rentalstore;

public class Rental {
    private Movie movie;
    private int dayRented;

    public Rental(Movie movie, int dayRented) {
        this.movie = movie;
        this.dayRented = dayRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDayRented() {
        return dayRented;
    }

    public double getAmount() {
        double result = 0;
        switch (this.getMovie().getPriceCode()){
            case Movie.REGULAR:
                result += 2;
                if(this.getDayRented() > 2){
                    result += (this.getDayRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += this.getDayRented()*3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if(this.getDayRented() > 3){
                    result += (this.getDayRented() -3)*1.5;
                }
                break;
        }
        return result;
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        //add frequent renter points
        frequentRenterPoints ++;
        //add bonus for a two day new release rental
        if((this.getMovie().getPriceCode() == Movie.NEW_RELEASE) && this.getDayRented() > 1){
            frequentRenterPoints ++;
        }
        return frequentRenterPoints;
    }
}

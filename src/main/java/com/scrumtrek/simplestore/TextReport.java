package com.scrumtrek.simplestore;

/**
 * Reporter for text format
 */
public class TextReport extends AbstractReporter<String> {
    @Override
    protected String generate(ReportData data) {
        String result = "AbstractRental record for " + data.customer + "\n";
        if (reportType == ReportType.FULL || reportType == ReportType.MEDIUM) {
            for (RentalData rentalData : data.rentals) {
                result += "\tRental " + rentalData.days + " days\t" + "sum " + rentalData.price + "\n";
                if (reportType == ReportType.FULL) {
                    for (MovieData movieData : rentalData.movies) {
                        result += "\t\t" + movieData.name + "\t" + movieData.price + "\n";
                    }
                }
            }
        }
        result += "Amount owed is " + data.getTotalPrice() + "\n";
        result += "You earned " + data.frequentRenterPoints + " frequent renter points.";

        return result;
    }
}

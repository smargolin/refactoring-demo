package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for reporters
 * @param <T> Report result type
 */
public abstract class AbstractReporter<T> {
    protected ReportType reportType = ReportType.FULL;

    /**
     * Set report type
     * @param reportType level of output data
     */
    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }

    /**
     * Create report
     * @param customer Customer for which report to be generated
     * @return report output data
     */
    public T report(Customer customer) {
        ReportData data = new ReportData();
        data.customer = customer.getName();
        data.discount = customer.getDiscount();
        for (Rental rental : customer.getRentals()) {
            RentalData rentalData = new RentalData();
            rentalData.days = rental.getDaysRented();
            data.rentals.add(rentalData);
            for (Movie movie : rental.getMovie()) {
                double moviePrice = movie.getPriceCode().getAmount(rental.getDaysRented());
                MovieData movieData = new MovieData();
                rentalData.movies.add(movieData);
                movieData.price = moviePrice;
                movieData.name = movie.getTitle();
                rentalData.price += moviePrice;
                data.totalPrice += moviePrice;
                data.frequentRenterPoints += movie.getPriceCode().getFrequentRenterPoints(rental.getDaysRented());
            }
        }

        return generate(data);
    }

    /**
     * Each reporter must generate report in this method
     * @param data calculated data
     * @return report output data
     */
    abstract protected T generate(ReportData data);

    protected class ReportData {
        String customer;
        List<RentalData> rentals = new ArrayList<>();
        double totalPrice = 0;
        double discount = 0;
        int frequentRenterPoints;

        public String getCustomer() {
            return customer;
        }

        public List<RentalData> getRentals() {
            return rentals;
        }

        public double getTotalPrice() {
            return discount > 0 && discount < 100 ? totalPrice - totalPrice*discount/100 : totalPrice;
        }

        public int getFrequentRenterPoints() {
            return frequentRenterPoints;
        }
    }

    protected class RentalData {
        int days;
        double price;
        List<MovieData> movies = new ArrayList<>();

        public int getDays() {
            return days;
        }

        public List<MovieData> getMovies() {
            return movies;
        }

        public double getPrice() {
            return price;
        }
    }

    protected class MovieData {
        String name;
        double price;

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    /**
     * Report type
     */
    public enum ReportType {
        FULL,
        MEDIUM,
        SHORT
    }
}

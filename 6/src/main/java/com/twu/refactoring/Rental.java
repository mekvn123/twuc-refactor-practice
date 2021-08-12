package com.twu.refactoring;

public class Rental {

    protected static final int NEW_RELEASE_FREQUENT_RENTAL_TIME = 1;
    protected static final int NEW_RELEASE_FREQUENT_POINTS_MORE_THAN_2_DAYS = 2;
    protected static final int NEW_RELEASE_FREQUENT_POINTS = 1;
    protected Movie movie;

    protected int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double getThisAmount() {
        System.out.println(movie.getTitle() + "  " + movie.getRentalPrice(daysRented));
        return movie.getRentalPrice(daysRented);
    }

    @Override
    public String toString() {
        return "\t" + movie.getTitle() + "\t"
                + getThisAmount() + "\n";
    }

    public int getFrequentRenterPoints() {
        return movie.getPriceCode() == Movie.NEW_RELEASE && daysRented > NEW_RELEASE_FREQUENT_RENTAL_TIME ? NEW_RELEASE_FREQUENT_POINTS_MORE_THAN_2_DAYS : NEW_RELEASE_FREQUENT_POINTS;
    }

}



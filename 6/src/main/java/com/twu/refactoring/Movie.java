package com.twu.refactoring;

public abstract class Movie {
    protected static final int CHILDRENS = 2;
    protected static final int REGULAR = 0;
    protected static final int NEW_RELEASE = 1;

    protected static final double PRICE_ZERO = 0.0;
    protected static final double RENTAL_EXPIRE_CHARGE_RATE = 1.5;

    private String title;

    public int getPriceCode() {
        return priceCode;
    }

    protected int priceCode;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Double getRentalPrice(Integer daysRented) {
        return Double.NEGATIVE_INFINITY;
    }
}

class RegularMovie extends Movie {


    private static final int REGULAR_RENTAL_AMOUNT = 2;
    private static final int REGULAR_RENTAL_TIME = 2;

    public RegularMovie(String title) {
        super(title);
        priceCode = REGULAR;
    }

    @Override
    public Double getRentalPrice(Integer daysRented) {
        Double amount = PRICE_ZERO;
        amount += REGULAR_RENTAL_AMOUNT;
        if (daysRented > REGULAR_RENTAL_TIME)
            amount += (daysRented - REGULAR_RENTAL_TIME) * RENTAL_EXPIRE_CHARGE_RATE;
        return amount;
    }
}

class ChildrenMovie extends Movie {
    private static final double CHILDREN_RENTAL_AMOUNT = 1.5;
    private static final int CHILDREN_RENTAL_TIME = 3;

    public ChildrenMovie(String title) {
        super(title);
        priceCode = CHILDRENS;
    }

    @Override
    public Double getRentalPrice(Integer daysRented) {

        Double amount = PRICE_ZERO;

        amount += CHILDREN_RENTAL_AMOUNT;
        if (daysRented > CHILDREN_RENTAL_TIME)
            amount += (daysRented - CHILDREN_RENTAL_TIME) * RENTAL_EXPIRE_CHARGE_RATE;
        return amount;
    }
}

class NewReleaseMovie extends Movie {
    private static final int NEW_RELEASE_RENTAL_AMOUNT = 3;

    public NewReleaseMovie(String title) {
        super(title);
        priceCode = NEW_RELEASE;
    }

    @Override
    public Double getRentalPrice(Integer daysRented) {
        Double amount = PRICE_ZERO;
        amount += daysRented * NEW_RELEASE_RENTAL_AMOUNT;

        return amount;
    }
}

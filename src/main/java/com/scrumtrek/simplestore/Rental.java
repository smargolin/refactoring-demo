package com.scrumtrek.simplestore;

import java.util.List;

public class Rental {
    private List<Movie> m_Movie;
    private int m_DaysRented;

    public Rental(List<Movie> movie, int daysRented) {
        m_Movie = movie;
        m_DaysRented = daysRented;
    }

    public int getDaysRented() {
        return m_DaysRented;
    }

    public List<Movie> getMovie() {
        return m_Movie;
    }
}


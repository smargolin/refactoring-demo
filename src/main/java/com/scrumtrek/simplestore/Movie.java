package com.scrumtrek.simplestore;

public class Movie {
    private String m_Title;
    private AbstractPriceCode m_PriceCode;

    public Movie(String title, AbstractPriceCode priceCode) {
        m_Title = title;
        m_PriceCode = priceCode;
    }

    public AbstractPriceCode getPriceCode() {
        return m_PriceCode;
    }

    public void setPriceCode(AbstractPriceCode value) {
        m_PriceCode = value;
    }

    public String getTitle() {
        return m_Title;
    }
}


package com.scrumtrek.simplestore;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

public class Rental {
    private String customerName;
    private String orderId;
    private String movieTitle;
    private PriceCode priceCode;
    private int daysRented;

    @SuppressWarnings("unused")
    private Rental() {
    }

    /**
     * Создает запись об аренде фильма.
     *
     * @param customerName ID покупателя
     * @param orderId ID заказа
     * @param movieTitle название фильма
     * @param priceCode тип тарификации
     * @param daysRented количество дней аренды
     */
    public Rental(String customerName, String orderId, String movieTitle, PriceCode priceCode,
                  int daysRented) {
        this.customerName = customerName;
        this.orderId = orderId;
        this.movieTitle = movieTitle;
        this.priceCode = priceCode;
        this.daysRented = daysRented;
    }

    /**
     * Возаращает ID покупателя
     * @return ID покупателя
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Возвращает название фильма
     *
     * @return название фильма
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /**
     * Возаращает тип тарификации
     * @return ID покупателя
     */
    public PriceCode getPriceCode() {
        return priceCode;
    }

    /**
     * Возаращает количество дней аренды
     * @return ID покупателя
     */
    public int getDaysRented() {
        return daysRented;
    }

    public String getOrderId() {
        return orderId;
    }

    public String toString () {
        StringBuilder result = new StringBuilder();
        result.append("\t");
        result.append(getMovieTitle());
        result.append("\t");
        result.append(getPriceCode().getPrice(getDaysRented()));
        result.append("\n");
        return  result.toString();
    }

    public String toJSON () {
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder()
                .add("title", getMovieTitle())
                .add("price", getPriceCode().getPrice(getDaysRented()));
        return  jsonBuilder.build().toString();
    }
}


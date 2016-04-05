package com.scrumtrek.simplestore;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Reporter for JSON format
 */
public class JsonReport extends AbstractReporter<String> {
    private ObjectMapper objectMapper;

    public JsonReport() {
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Override
    protected String generate(ReportData data) {
        try {
            if (reportType == ReportType.SHORT) {
                data.rentals = null;
            } else if (reportType == ReportType.MEDIUM) {
                for (RentalData rentalData : data.rentals) {
                    rentalData.movies = null;
                }
            }
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

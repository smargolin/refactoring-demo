package com.scrumtrek.simplestore;

public enum PriceCode {
    Regular,
    NewRelease {
        @Override
        public double getPrice(int days) {
            return (days <= 0) ? 0 : days * 3;
        }

        @Override
        public double getRentalPoints(int days) {
            return (days > 1) ? super.getRentalPoints(days) + 1 : super.getRentalPoints(days);
        }
    },
    Childrens {
        @Override
        public double getPrice(int days) {
            return (days > 3) ? (days - 3) * 1.5 : (days <= 0) ? 0 : 1.5;
        }
    };

    public double getPrice(int days) {
        return (days > 2) ? 2 + (days - 2) * 1.5 : (days <= 0) ? 0 : 2;
    }

    public double getRentalPoints(int days) {
        return (days <= 0) ? 0 : 1;
    }
}

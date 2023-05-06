package com.example.risingwave.views;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Timestamp;

@Getter
@Setter
public class RestaurantOrdersView {

    private Timestamp windowStart;
    private Long restaurantId;
    private BigInteger totalOrder;
}

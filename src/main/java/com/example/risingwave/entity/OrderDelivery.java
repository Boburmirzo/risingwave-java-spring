package com.example.risingwave.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "restaurant_orders_view")
public class OrderDelivery implements Serializable {

    @Id
    @Column(name = "restaurant_id")
    private Long restaurantId;

    @Column(name = "window_start")
    private Timestamp windowStart;

    @Column(name = "total_order")
    private BigInteger totalOrder;
}

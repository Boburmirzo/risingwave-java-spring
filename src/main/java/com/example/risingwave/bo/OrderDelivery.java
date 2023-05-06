package com.example.risingwave.bo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "delivery_orders_source")
public class OrderDelivery implements Serializable {

    @Id
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "restaurant_id")
    private Long restaurantId;

    @Column(name = "order_state")
    private String orderState;

    @Column(name = "order_timestamp")
    private Timestamp orderTimestamp;
}

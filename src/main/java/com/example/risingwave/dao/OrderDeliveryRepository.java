package com.example.risingwave.dao;

import com.example.risingwave.entity.RestaurantOrdersView;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDeliveryRepository {

    List<RestaurantOrdersView> countTotalRestaurantOrders();
}

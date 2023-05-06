package com.example.risingwave.service.facade;

import com.example.risingwave.entity.RestaurantOrdersView;

import java.util.List;

public interface OrderDeliveryService {

    List<RestaurantOrdersView> countTotalRestaurantOrders();
}

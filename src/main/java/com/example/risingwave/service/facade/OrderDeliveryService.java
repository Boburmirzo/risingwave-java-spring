package com.example.risingwave.service.facade;

import com.example.risingwave.views.RestaurantOrdersView;

import java.util.List;

public interface OrderDeliveryService {

    List<RestaurantOrdersView> countTotalRestaurantOrders();
}

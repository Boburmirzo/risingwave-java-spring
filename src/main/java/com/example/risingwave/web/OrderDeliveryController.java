package com.example.risingwave.web;


import com.example.risingwave.service.facade.OrderDeliveryService;
import com.example.risingwave.views.RestaurantOrdersView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class OrderDeliveryController {


    private final OrderDeliveryService orderDeliveryService;

    @GetMapping("/count-total-restaurant-orders")
    @CrossOrigin(value = "*", allowedHeaders = "*")
    public List<RestaurantOrdersView> getCountTotalRestaurantOrders() {
        return orderDeliveryService.countTotalRestaurantOrders();
    }
}

package com.example.risingwave.service.impl;

import com.example.risingwave.dao.OrderDeliveryRepository;
import com.example.risingwave.entity.RestaurantOrdersView;
import com.example.risingwave.service.facade.OrderDeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDeliveryServiceImpl implements OrderDeliveryService {

    private final OrderDeliveryRepository orderDeliveryRepository;

    @Override
    public List<RestaurantOrdersView> countTotalRestaurantOrders() {
       return orderDeliveryRepository.countTotalRestaurantOrders();
    }
}

package com.example.risingwave.dao.impl;

import com.example.risingwave.dao.OrderDeliveryRepository;
import com.example.risingwave.entity.RestaurantOrdersView;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class OrderDeliveryRepositoryImpl implements OrderDeliveryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RestaurantOrdersView> countTotalRestaurantOrders() {
        Query query = entityManager.createNativeQuery("SELECT * FROM restaurant_orders_view WHERE restaurant_id = 1");
        return query.getResultList();
    }
}

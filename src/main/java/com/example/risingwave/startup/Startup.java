package com.example.risingwave.startup;

import com.example.risingwave.views.MaterializeView;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@Component
@RequiredArgsConstructor
@Slf4j
public class Startup implements CommandLineRunner {
    private final JdbcTemplate jdbcTemplate;
    public static final String CREATE_MATERIALIZED_VIEW = "CREATE MATERIALIZED VIEW %s AS %s";
    public static final String CREATE_RISINGWAVE_SOURCE_TABLE = "CREATE TABLE delivery_orders_source (\n" +
        "    order_id BIGINT,\n" +
        "    restaurant_id BIGINT,\n" +
        "    order_state VARCHAR,\n" +
        "    order_timestamp TIMESTAMP\n" +
        ") WITH (\n" +
        "    connector = 'kafka',\n" +
        "    topic = 'delivery_orders',\n" +
        "    properties.bootstrap.server = 'message_queue:29092',\n" +
        "    scan.startup.mode = 'earliest'\n" +
        ") ROW FORMAT JSON;";

    @Override
    public void run(String... args) {
        createDeliveryOrdersSourceTable();
        createMaterializeViews();
    }

    public void createDeliveryOrdersSourceTable() {
        jdbcTemplate.execute(CREATE_RISINGWAVE_SOURCE_TABLE);
    }

    public void createMaterializeViews() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<MaterializeView>> typeReference = new TypeReference<>() {
        };
        InputStream inputStream = Startup.class.getResourceAsStream("/view.json");

        try {
            List<MaterializeView> materializeViews = mapper.readValue(inputStream, typeReference);
            materializeViews.forEach(materializeView -> {
                String sql = String.format(CREATE_MATERIALIZED_VIEW, materializeView.getName(), materializeView.getQuery());
                jdbcTemplate.execute(sql);
            });
        } catch (IOException e) {
            log.error("Unable to create view: " + e.getMessage());
        }
    }
}

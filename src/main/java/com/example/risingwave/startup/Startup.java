package com.example.risingwave.startup;

import com.example.risingwave.bo.MaterializeView;
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
    public static final String CREATE_MATERIALIZED_VIEW = "CREATE MATERIALIZED VIEW IF NOT EXISTS %s AS %s";

    @Override
    public void run(String... args) throws Exception {
        createMaterializeViews();
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

-- Define a materialized view

CREATE MATERIALIZED VIEW restaurant_orders_view AS
SELECT
    window_start,
    restaurant_id,
    COUNT(*) AS total_order
FROM
    HOP(delivery_orders_source, order_timestamp, INTERVAL '1' MINUTE, INTERVAL '15' MINUTE)
WHERE
        order_state = 'CREATED'
GROUP BY
    restaurant_id,
    window_start;

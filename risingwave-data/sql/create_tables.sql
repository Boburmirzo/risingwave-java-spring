-- Create a data stream Source for Kafka and persist data in RisingWave

CREATE TABLE delivery_orders_source (
    order_id BIGINT,
    restaurant_id BIGINT,
    order_state VARCHAR,
    order_timestamp TIMESTAMP
) WITH (
    connector = 'kafka',
    topic = 'delivery_orders',
    properties.bootstrap.server = 'message_queue:29092',
    scan.startup.mode = 'earliest'
) ROW FORMAT JSON;

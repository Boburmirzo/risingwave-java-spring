# Query materialized views with Java, Spring, and streaming database

Let's assume we have a materialized view named [restaurant_orders_view](https://github.com/Boburmirzo/risingwave-java-spring/blob/main/risingwave-data/sql/create_materialized_view.sql) that calculates the number of total orders created from different restaurants within the last 15 mins in real-time. 
Now our task is to expose this materialized view result as an [API endpoint](https://github.com/Boburmirzo/risingwave-java-spring/blob/main/src/main/java/com/example/risingwave/web/OrderDeliveryController.java) in an Order service to `/orders/count-total-restaurant-orders`.  
In Java, you can query materialized views using JDBC, which is a Java API for connecting to databases. Additionally, you can leverage the Spring Framework to simplify the process of working with JDBC and build a REST API.

### Before You Begin

This tutorial consists of setting up two projects:

- We will spin up on our local environment the existing RisingWave fully-featured [demo cluster](https://github.com/risingwavelabs/risingwave/tree/main/integration_tests/delivery) on GitHub which is composed of multiple RisingWave components. To simplify this task, it leverages [docker-compose.yaml](Docker Compose) file which includes additional containers for Kafka message broker, and data generation service.
- Spring boot application, a Maven project with the necessary dependencies and we will also run it locally.

To complete this tutorial, you need the following:

- Ensure you have [Docker](https://docs.docker.com/get-docker/) and [Docker Compose](https://docs.docker.com/compose/install/) installed in your environment.
- Ensure that the [PostgreSQL](https://www.postgresql.org/docs/current/app-psql.html) interactive terminal, psql, is installed in your environment. For detailed instructions, see [Download PostgreSQL](https://www.postgresql.org/download/).
- [Java 11 SDK](https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html) or above.
- Your favorite editor, in my case I used [Intellij Idea](https://www.jetbrains.com/idea/download/#section=windows).

### Step 1: Setting Up the demo cluster

First, clone the [RisingWave](https://github.com/risingwavelabs/risingwave) repository to your local environment.

```bash
git clone https://github.com/risingwavelabs/risingwave.git
```

Then, navigate to the `integration_tests/delivery` directory and start the demo cluster from the [docker compose file](https://github.com/risingwavelabs/risingwave/blob/main/integration_tests/delivery/docker-compose.yml).

```bash
cd risingwave/integration_tests/delivery
docker compose up -d
```

Make sure that all containers are up and running!

### Step 2: Copy and open the Spring Boot app.

Once the streaming database is set up, we will run our Spring Boot app. Also, fork/clone the project and open it in your Java editor.

```bash
git clone https://github.com/Boburmirzo/risingwave-java-spring.git
```

### Step 3: Install the project.

Then do `mvn clean install` from the project root folder. In the maven `pom.xml` file, we added the `postgresql` dependency and the `spring-boot-starter-jdbc` driver dependency to our project. These dependencies will provide the necessary classes and interfaces to work with JDBC in Spring.

### Step 4: Run the demo RisingWave application.

Now we can run our main [DemoRisingWaveApplication.java](https://github.com/Boburmirzo/risingwave-java-spring/blob/main/src/main/java/com/example/risingwave/DemoRisingWaveApplication.java) from the editor. After you run the application, you access the endpoint on port `8080` or open this URL on your browser. [http://localhost:8080/orders/count-total-restaurant-orders](http://localhost:8080/orders/count-total-restaurant-orders). You will get the materialized view response from RisingWave.

```bash
[["2023-05-06T05:28:00.000+00:00",1,1],["2023-05-06T05:33:00.000+00:00",1,3...]]
```

# Spring Boot MongoDB Default Mapping

This repository showcase the default mapping when writing to and read from `MongoDB`

See this [blogpost](https://bwgjoseph.com/default-mapping-behavior-for-spring-data-mongodb) for detailed explanation

# Assumption

You have a local instance of `MongoDB` installed, with the following details

```properties
spring.data.mongodb.host=localhost
spring.data.mongodb.database=mapping
spring.data.mongodb.username=root
spring.data.mongodb.password=password
spring.data.mongodb.authentication-database=admin
```

# Run Project

```sh
./mvnw spring-boot:run
```

# Run Test

```sh
./mvnw test
```
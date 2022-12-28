# Spring Boot Polymorphic Java Record DTO with Jackson

This repository showcase how to use a polymorphic DTO class using Java Record and Jackson

See this [blogpost](https://bwgjoseph.com/polymorphic-java-record-dto-with-jackson) for detailed explanation

# Run Project

```sh
./mvnw spring-boot:run
```

# Send Request via curl

## Deduction Based

```sh
curl -X POST -H "Content-Type: application/json" -d "@address.deduction.json" localhost:8080/deduction/addresses | jq '.'
```

## Name Based

```sh
curl -X POST -H "Content-Type: application/json" -d "@address.name.json" localhost:8080/name/addresses | jq '.'
```

## Enum Based

```sh
curl -X POST -H "Content-Type: application/json" -d "@address.enum.json" localhost:8080/enum/addresses | jq '.'
```
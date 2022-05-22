# Spring MVC RestTemplate

This repository showcase that `RestTemplate` bean is not provided by default by `Spring Boot`. If we do not configure a `RestTemplate` bean in `WebConfig`, you will encounter an exception when starting the application

See this [blogpost](https://bwgjoseph.com/spring-boot-does-not-provide-auto-configured-resttemplate-bean) for detailed explanation

# Run project

```sh
./gradlew bootRun
```
# Spring Logback

This repository showcase how we can

- Override default Spring logback config
- Use `Spring Profile` to configure different rules per profile
- Use `logstash-logback-encoder` library to pipe logs as `JSON` format

See this [blogpost](https://bwgjoseph.com/how-to-configure-spring-logback-to-pipe-logs-to-different-appenders-using-profile-specific-configuration-extension) for detailed explanation

# Run project

```sh
./gradlew bootRun
```
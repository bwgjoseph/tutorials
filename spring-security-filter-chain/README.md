# Spring Security Filter Chain

This repository showcase how `Filter @Bean` get registered into `Servlet Filter` by default, and not part of `SecurityFilterChain`

See this [blogpost](https://bwgjoseph.com/why-requestheaderauthenticationfilter-is-not-registered-as-part-of-spring-security-filter-chain) for detailed explanation

# Run project

```bash
./mvnw spring-boot:run
```
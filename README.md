# webshop

# Requirements
- Docker (and docker-compose)
- JDK 11
- Maven

# Install and run the project
```bash
docker-compose up -d
mvn clean install
mvn spring-boot:run
```

# Database
Run the project once, then be sure not to forget to change the `application.properties`:
```
spring.datasource.initialization-mode=always
```

to
```
# spring.datasource.initialization-mode=always
```
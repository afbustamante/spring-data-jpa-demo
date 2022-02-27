# spring-data-jpa-demo

Demo project using Spring Data JPA on Spring Boot. It is about an authorization system using users and roles stored in database.

This project uses:

- Spring Boot 2.5
- Spring Data JPA
- Spring Framework 5.3
- Liquibase 4.3
- Embedded HSQLDB / H2 database
- Built on Maven

It requires Java 14.

## Spring Data JPA and Spring Boot

This project contains some examples about:

- How to build entities and collections on JPA
- How to use a generic class shared between entities
- How to use the auditing feature from Spring Data
- How to use Spring Boot Test in order to test reading and writing interactions with the database

## Maven subprojects

This project is separated into subprojects in order to keep best practices on layers in Spring:

- *myproject-api*: Contains entities, enums and services declarations
- *myproject-db*: Contains the scripts and dependencies needed to build the database
- *myproject-core*: Contains the repositories and services implementations, it is, the business core of the application
- *myproject-web*: Contains the Web controllers and the DTO definitions for the HTTP layer.

## Building and running this project

In order to build this project for the first time, use the following command:

    $ ./mvnw clean install
  
 After that, you can run the Spring Boot application using the following command:
 
    $ java -jar myproject-web/target/myproject-web.jar

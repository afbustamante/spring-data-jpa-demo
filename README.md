# spring-data-jpa-demo

Demo project using Spring Data JPA on Spring Boot. It works using the Sakila sample database structure from MySQL.

Here it is the [database model](https://dev.mysql.com/doc/sakila/en/sakila-structure.html) of this application.

This project uses:

- Spring Boot 3.3
- Spring Data JPA 3.3
- Spring Framework 6.1
- Spring Batch 5.1
- Flyway 10.10 (only for MySQL and MariaDB)
- Embedded H2 Database 2.2
- Built-on Maven

It requires Java 17+ and optionally a MariaDB Server 10+ / MySQL Server 8.0+ in order to deploy the application with a
database server. You must use one of the Spring profiles available for these servers: `mysql` to start with a MySQL
database or `mariadb` to start with a MariaDB database.

## Spring Data JPA and Spring Boot

This project contains some examples about:

- How to build entities and collections on JPA
- How to use a generic class shared between entities
- How to use the auditing feature from Spring Data
- How to use Spring Boot Test in order to test reading and writing interactions with the database

## Maven subprojects

This project is separated into subprojects in order to keep best practices on layers in Spring:

- *myproject-api*: Contains model, enums and services declarations
- *myproject-db*: Contains the scripts and dependencies needed to build the database
- *myproject-core*: Contains the entities, repositories and services implementations, it is, the business core of the application
- *myproject-web*: Contains the Web controllers and the DTO definitions for the HTTP layer.
- *myproject-batch*: Contains batch configuration and jobs

## Building and running this project

In order to build this project for the first time, use the following command:

    $ ./mvnw clean install
  
 After that, you can run the Spring Boot Web application using the following command:
 
    $ java -jar myproject-web/target/myproject-web.jar

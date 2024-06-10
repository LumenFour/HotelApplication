# Hotel API

## Description

This is a RESTful API application for working with hotels. The application provides the following methods:

### GET /property-view/hotels

Retrieves a list of all hotels with their brief information.

### GET /property-view/hotels/{id}

Retrieves detailed information about a specific hotel.

### GET /property-view/search

Search and retrieve a list of all hotels with their brief information based on the following parameters: name, brand, city, county, amenities.

### POST /property-view/hotels

Creates a new hotel.

### POST /property-view/hotels/{id}/amenities

Adds a list of amenities to the hotel.

### GET /property-view/histogram/{param}

Retrieves the number of hotels grouped by each value of the specified parameter. Parameter: brand, city, county, amenities.

## Launching the Application

The application is launched from the console using the command:


### Technologies Used
*Maven
*Java 17+
*Spring Boot
*Spring JPA
*Liquibase
*H2 (as a database)

### Additional Features
*Tests
*Swagger Documentation
*Use of design patterns
*Layer separation
*Ability to “quickly” switch from H2 to another database (MySQL, PostgreSQL, Mongo, etc.)

```bash
mvn spring-boot:run

Launch port: 8092



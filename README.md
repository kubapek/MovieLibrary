# MovieLibrary
Simple movie library CRUD - application to learn Hibernate


## Tech

JobOffers is developed using following technologies: <br>

Core: <br>
![image](https://img.shields.io/badge/17-Java-orange?style=for-the-badge) &nbsp;
![image](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white) &nbsp;
![image](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring) &nbsp;
![image](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white) &nbsp;
![image](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white) &nbsp;
![image](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white) &nbsp;
- <b>Flyway</b>


## Installation and run

### Requirements:
- Docker

### To run the application:
- Just run following command, and wait for containers to be pulled up and started.

``
docker compose up
``

- Alternatively you can run docker-compose file through you IDE

After everything builds and ready, you can start application and test using [Postman](https://www.postman.com/)
or use <a href="http://localhost:8080/swagger-ui/index.html#/">Swagger</a>.


## Rest-API Endpoints

Service url: http://localhost:8080

| HTTP METHOD | Endpoint           | Action                               |
|-------------|--------------------|--------------------------------------|
| GET         | /movies            | Retrieve all available movies        |
| GET         | /movies/{id}       | Retrieve a movie for a given ID      |
| POST        | /movies            | Add a new movie                      |
| PUT         | /movies            | Update a movie                       |              
| DELETE      | /movies            | Delete a movie                       |

# Spring Boot + GemFire (Apache Geode) Demo

This project demonstrates a **Spring Boot application integrated with Broadcom GemFire (Apache Geode)** for distributed **in-memory data storage**.  
The entire setup runs using **Docker containers**.

---

# Technologies Used

- Java 17
- Spring Boot
- Apache Geode / Broadcom GemFire
- Spring Data GemFire
- Docker
- Maven
- REST APIs

---

# Architecture

Client → Spring Boot REST API → GemFire Client Cache → GemFire Server → Distributed Region

Components:

1. Spring Boot Application
2. GemFire Locator
3. GemFire Server
4. Docker Containers

---

# Features Demonstrated

1. **Distributed In-Memory Data Grid**  
   Data is stored in memory using GemFire regions.

2. **Spring Data GemFire Repository**  
   CRUD operations are performed using Spring repositories.

3. **Containerized Environment**  
   Application, locator, and server run inside Docker containers.

4. **Region-Based Storage**  
   Data is stored in a distributed region called `Users`.

5. **Handling NULL Values**  
   The application handles empty values in payload for:
    - Integer
    - Boolean

Example:
if(user.getAge() == null){
user.setAge(0);
}

if(user.getActive() == null){
user.setActive(false);
}

# Start Docker Containers
docker-compose up --build

# drop Docker Containers
docker compose down -v 
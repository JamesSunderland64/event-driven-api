# Event-Driven API

API REST desarrollada con Spring Boot implementando el patrón Event-Driven.

## Tecnologías
- Java
- Spring Boot
- H2 Database
- Docker
- Kubernetes

## Funcionalidades
- CRUD de productos
- Eventos con ApplicationEventPublisher
- Listeners con @EventListener
- Ejecución asíncrona con @Async

## Ejecución
```bash
docker build -t event-api .
docker run -p 8082:8080 event-api

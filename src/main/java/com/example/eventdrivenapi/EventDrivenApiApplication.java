package com.example.eventdrivenapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;           // ← NUEVO PAQUETE
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;   // este se mantiene igual
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EntityScan("model")                          // Busca las entidades @Entity
@EnableJpaRepositories("repository")          // Busca los repositorios
@ComponentScan({
        "com.example.eventdrivenapi",
        "model", "repository", "service",
        "controller", "event", "listener", "config"
})
public class EventDrivenApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventDrivenApiApplication.class, args);
    }
}
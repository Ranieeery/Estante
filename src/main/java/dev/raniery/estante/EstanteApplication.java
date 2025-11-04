package dev.raniery.estante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class EstanteApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstanteApplication.class, args);
    }

}

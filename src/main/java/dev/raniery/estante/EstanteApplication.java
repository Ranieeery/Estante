package dev.raniery.estante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
Author: Raniery Goulart
Project: Estante Outrossim
*/

//@EnableAspectJAutoProxy

//TODO: parametros Optional??
@SpringBootApplication
@EnableJpaAuditing(dateTimeProviderRef = "offsetDateTimeProvider")
public class EstanteApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstanteApplication.class, args);
    }

}

package org.sid.voituremicroservice;

import org.sid.voituremicroservice.entities.Client;
import org.sid.voituremicroservice.entities.Voiture;
import org.sid.voituremicroservice.repositories.VoitureRepository;
import org.sid.voituremicroservice.services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class VoitureMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoitureMicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner initializerBaseH2(VoitureRepository voitureRepository, ClientService clientService) {
        return args -> {
            Client c1 = clientService.clientById(1L);
            Client c2 = clientService.clientById(2L);


            System.out.println("**********");
            System.out.println("Id est :" + c1.getId());
            System.out.println("Nom est :" + c1.getNom());
            System.out.println("Age est :" + c1.getAge());
            System.out.println("**********");
            System.out.println("**********");
            System.out.println("Id est :" + c2.getId());
            System.out.println("Nom est :" + c2.getNom());
            System.out.println("Age est :" + c2.getAge());
            System.out.println("**********");

            // Saving vehicles with valid clients
            voitureRepository.save(new Voiture(1L, "opel", "11223344", "2005",1L));
            voitureRepository.save(new Voiture(2L, "toyota", "1122334475227", "2007",2L));
        };
    }
}

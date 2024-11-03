package org.sid.clientmicroservice;

import org.sid.clientmicroservice.entities.Client;
import org.sid.clientmicroservice.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientMicroserviceApplication.class, args);
    }
    @Bean
    CommandLineRunner initialiserBaseH2(ClientRepository clientRepository) {
        return args -> {
            clientRepository.save(new Client(Long.parseLong("1"),"Kerdoud" ,Float.parseFloat("23")));
            clientRepository.save(new Client(Long.parseLong("2"),"Mairy",Float.parseFloat("23")));
            clientRepository.save(new Client(Long.parseLong("3"),"Souahi",Float.parseFloat("23")));
            clientRepository.save(new Client(Long.parseLong("4"),"Mamdouh",Float.parseFloat("22")));
        };

    }
}

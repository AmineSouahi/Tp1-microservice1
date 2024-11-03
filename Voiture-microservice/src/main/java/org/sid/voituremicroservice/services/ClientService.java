package org.sid.voituremicroservice.services;

import org.sid.voituremicroservice.entities.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SERVICE-CLIENT")  // Ensure SERVICE-CLIENT is correctly configured
public interface ClientService {

    @GetMapping(path = "/client/{id}")
    Client clientById(@PathVariable Long id);
}

package org.sid.voituremicroservice.controllers;


import org.sid.voituremicroservice.entities.Voiture;
import org.sid.voituremicroservice.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class VoitureController{
    @Autowired
    VoitureRepository voitureRepository ;

    @GetMapping("/voitures")
    public List findAll(){
        return voitureRepository.findAll();
    }
    @GetMapping("/voiture/{id}")
    public Voiture findById (@PathVariable Long id) throws Exception{
        return voitureRepository.findById(id).orElseThrow(()-> new Exception("Voiture inexistante"));
    }
}

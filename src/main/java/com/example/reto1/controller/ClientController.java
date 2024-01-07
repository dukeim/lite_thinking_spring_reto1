package com.example.reto1.controller;

import com.example.reto1.model.Client;
import com.example.reto1.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    ClientService clientService;
    @GetMapping(path = "/{docNumber}")
    ResponseEntity<Client> getClientByDocNumber(@PathVariable String docNumber){
        try {
            Optional<Client> res = clientService.findByDocNumber(docNumber);
            return res.map(client -> ResponseEntity.ok().body(client))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }catch(Exception e){
           return ResponseEntity.internalServerError().build();
        }
    }
}

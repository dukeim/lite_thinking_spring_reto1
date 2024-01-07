package com.example.reto1.service;

import com.example.reto1.model.Client;
import com.example.reto1.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    public Optional<Client> findByDocNumber(String docNumber){
        return clientRepository.findByDocNumber(docNumber);
    }
}

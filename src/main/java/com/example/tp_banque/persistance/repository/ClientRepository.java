package com.example.tp_banque.persistance.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.tp_banque.persistance.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer>
{

}
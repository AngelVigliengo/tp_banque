package com.example.tp_banque.persistance.controller;

import com.example.tp_banque.persistance.model.Client;
import com.example.tp_banque.persistance.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/client/lister")
    public ModelAndView listeClients() {
        return new ModelAndView("listeClients", "clients", clientService.getClients());
    }

    @GetMapping("/client/lister/{id}")
    public ModelAndView detailClient(@PathVariable("id") final Integer id) {
        Optional<Client> client = clientService.getClient(id);
        return new ModelAndView("detailClient", "client", client.orElse(null));
    }

    @GetMapping("/client/creer")
    public ModelAndView creerClient() {
        Client c= new Client();
        return new ModelAndView("creerClient", "client", c);
    }

    @PostMapping("/client/creer")
    public ModelAndView submit(@ModelAttribute("client") Client client, ModelMap model) {
    	model.addAttribute("nom", client.getNom());
        model.addAttribute("prenom", client.getPrenom());
        clientService.saveClient(client);

        return listeClients();
    }
}
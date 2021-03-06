package com.example.tp_banque.persistance.controller;

import com.example.tp_banque.persistance.model.Compte;
import com.example.tp_banque.persistance.service.CompteService;
import com.example.tp_banque.persistance.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController // equivalent a @Controller + @ResponseBody
public class CompteController {
    @Autowired
    private CompteService compteService;

    @GetMapping("/compte/lister")
    public ModelAndView listeComptes() {
        return new ModelAndView("listeComptes", "comptes", compteService.getComptes());
    }

    @GetMapping("/compte/lister/{id}")
    public ModelAndView detailCompte(@PathVariable("id") final Integer id) {
        Optional<Compte> compte = compteService.getCompte(id);
        return new ModelAndView("detailCompte", "compte", compte.orElse(null));
    }

    @GetMapping("/compte/creer")
    public ModelAndView creerCompte() {
        return new ModelAndView("creerCompte", "compte", new Compte());
    }

    @PostMapping("/compte/creer")
    public ModelAndView submit(@ModelAttribute("compte") Compte compte, ModelMap model) {
        model.addAttribute("numero", compte.getNumero());
        model.addAttribute("client", compte.getClient());

        compteService.saveCompte(compte);
        return listeComptes();
    }
}
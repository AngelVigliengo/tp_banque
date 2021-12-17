package com.example.tp_banque.persistance.model;

import javax.persistence.*;

@Entity
@Table(name = "compte")
public class Compte
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero", length = 50)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    @Override
    public String toString() {
        return "Compte [id=" + id + ", numero=" + numero + ", client=" + client + "]";
    }

    public String getNumero() {
        return numero;
    }

    public Client getClient() {
        return client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setClient(Client client) {
        this.client = client;
    }


}
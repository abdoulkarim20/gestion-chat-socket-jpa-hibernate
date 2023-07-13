package org.example.dao;

import org.example.entities.Membre;

public interface IMembre {
    void save(Membre membre);
    Membre getMembreByUsername(String username);
}

package de.mclenburg.br.server.jpa.repository;

import de.mclenburg.br.server.jpa.dataobjects.Benutzer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenutzerRepository extends JpaRepository<Benutzer, Long> {
    public Benutzer findByUsername(String username);
}

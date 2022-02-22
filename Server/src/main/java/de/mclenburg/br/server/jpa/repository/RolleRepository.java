package de.mclenburg.br.server.jpa.repository;

import de.mclenburg.br.server.jpa.catalogues.Rolle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolleRepository extends JpaRepository<Rolle, Long> {
    public Rolle findByBezeichnung(String bezeichnung);
}

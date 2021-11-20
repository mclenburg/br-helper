package de.mclenburg.br.server.repository;

import de.mclenburg.br.server.catalogues.Massnahmeart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MassnahmeartRepository extends JpaRepository<Massnahmeart, Long> {
}
package de.mclenburg.br.server.jpa.repository;

import de.mclenburg.br.server.jpa.dataobjects.Kollege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface KollegeRepository extends JpaRepository<Kollege, Long> {
    List<Kollege> findByNameEqualsIgnoreCaseAndNachnameEqualsIgnoreCaseOrderByNameAscNachnameAsc(@NonNull String name, @NonNull String nachname);
    List<Kollege> findByNachnameEqualsIgnoreCase(@NonNull String name);
}
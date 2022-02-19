package de.mclenburg.br.server.rest;

import de.mclenburg.br.server.jpa.dataobjects.Kollege;
import de.mclenburg.br.server.jpa.repository.KollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KollegeRestController {

    @Autowired
    private KollegeRepository kollegeRepository;

    /**
     * sucht in der Datenbank nach allen Personen mit angegebenem Nachnamen
     * @param name  Nachname des zu suchenden Kollegen
     * @return Liste mit gefundenen Personen
     */
    @GetMapping(path = "/kollege/{name}")
    public List<Kollege> findByName(@PathVariable String name) {
        return kollegeRepository.findByNachnameEqualsIgnoreCase(name);
    }

    /**
     * sucht in der Datenbank nach allen Personen mit angegebenem Nachnamen
     * @param name  Nachname des zu suchenden Kollegen
     * @param vorname Vorname des zu suchenden Kollegen
     * @return Liste mit gefundenen Personen
     */
    @GetMapping(path = "/kollege/{name}/{vorname}")
    public List<Kollege> findByName(@PathVariable String name, @PathVariable String vorname) {
        return kollegeRepository.findByNameEqualsIgnoreCaseAndNachnameEqualsIgnoreCaseOrderByNameAscNachnameAsc(vorname, name);
    }

    @PostMapping(path = "/kollege")
    public Kollege addKollege(@RequestBody Kollege kollege) {
        if(kollege.getNachname() == null) return null;
        if(kollege.getName() == null) return null;
        kollegeRepository.save(kollege);
        return kollegeRepository.findByNameEqualsIgnoreCaseAndNachnameEqualsIgnoreCaseOrderByNameAscNachnameAsc(kollege.getName(), kollege.getNachname())
                .stream().findFirst().orElse(null);
    }
}

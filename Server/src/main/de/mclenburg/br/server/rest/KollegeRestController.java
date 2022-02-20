package de.mclenburg.br.server.rest;

import de.mclenburg.br.server.jpa.repository.KollegeRepository;
import de.mclenburg.br.server.rest.api.Einzelmassnahme;
import de.mclenburg.br.server.rest.api.Kollege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

@RestController
public class KollegeRestController {

    @Autowired
    private KollegeRepository kollegeRepository;

    @Value("${server.port}")
    private int serverPort;

    /**
     * sucht in der Datenbank nach allen Personen mit angegebenem Nachnamen
     * @param name  Nachname des zu suchenden Kollegen
     * @return Liste mit gefundenen Personen
     */
    @GetMapping(path = Kollege.ENDPOINT+"/{name}")
    public List<Kollege> findByName(@PathVariable String name) {
        return mapToApi(kollegeRepository.findByNachnameEqualsIgnoreCase(name));
    }

    private List<Kollege> mapToApi(List<de.mclenburg.br.server.jpa.dataobjects.Kollege> kollegen) {
        String host = InetAddress.getLoopbackAddress().getHostName()+":"+serverPort;
        List<Kollege> kollegeList = new ArrayList<>();
        kollegen.parallelStream().forEach(kollege -> {
            Kollege apiKollege = new Kollege();
            apiKollege.setId(kollege.getId());
            apiKollege.setNachname(kollege.getNachname());
            apiKollege.setVorname(kollege.getName());
            List<String> einzelmassnahmen = new ArrayList<>();
            if(kollege.getEinzelmassnahmen() != null && kollege.getEinzelmassnahmen().size() > 0) {
                kollege.getEinzelmassnahmen().parallelStream().forEach(einzelmassnahme -> {
                    einzelmassnahmen.add("http://"+host+"/"+ Einzelmassnahme.ENDPOINT + "/"+einzelmassnahme.getId());
                });
            }
            apiKollege.setEinzelmassnahmen(einzelmassnahmen);
            kollegeList.add(apiKollege);
        });
        return kollegeList;
    }

    /**
     * sucht in der Datenbank nach allen Personen mit angegebenem Nachnamen
     * @param name  Nachname des zu suchenden Kollegen
     * @param vorname Vorname des zu suchenden Kollegen
     * @return Liste mit gefundenen Personen
     */
    @GetMapping(path = Kollege.ENDPOINT+"/{name}/{vorname}")
    public List<Kollege> findByName(@PathVariable String name, @PathVariable String vorname) {
        return mapToApi(kollegeRepository.findByNameEqualsIgnoreCaseAndNachnameEqualsIgnoreCaseOrderByNameAscNachnameAsc(vorname, name));
    }

    @PostMapping(path = Kollege.ENDPOINT)
    public Kollege addKollege(@RequestBody Kollege kollege) {
        if(kollege.getNachname() == null) return null;
        if(kollege.getVorname() == null) return null;
        kollegeRepository.save(mapToJpa(kollege));
        return mapToApi(kollegeRepository.findByNameEqualsIgnoreCaseAndNachnameEqualsIgnoreCaseOrderByNameAscNachnameAsc(kollege.getVorname(), kollege.getNachname()))
                .stream().findFirst().orElse(null);
    }

    private de.mclenburg.br.server.jpa.dataobjects.Kollege mapToJpa(Kollege kollege) {
        de.mclenburg.br.server.jpa.dataobjects.Kollege koll = new de.mclenburg.br.server.jpa.dataobjects.Kollege();
        koll.setNachname(kollege.getNachname());
        koll.setName(kollege.getVorname());
        return koll;
    }
}
